package com.example.aplikasipenjurianqcc_ss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class point_m extends AppCompatActivity {
    AutoCompleteTextView auto_1,auto_2,auto_3;
    String data1,data2,data3;
    String data1_split,data2_split,data3_split;
    ArrayAdapter<String> adapter_1,adapter_2,adapter_3;
    String sub_database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_m);
        auto_1 = (AutoCompleteTextView)findViewById(R.id.isi_spinner_m1);
        if(admin_page.tipe_penjurian.equals("qcc")){
            sub_database = "m1";
            adapter_1 = new ArrayAdapter<>(
                    this,R.layout.drop_down_menu,list_item_penilaian.value_1
            );
        }else if(admin_page.tipe_penjurian.equals("ss")){
            sub_database = "i1";
            adapter_1 = new ArrayAdapter<>(
                    this,R.layout.drop_down_menu,list_item_penilaian.value_1
            );
        }else{}

        auto_1.setAdapter(adapter_1);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = database.getReference("data_nilai").child(login_page.jenis_juri).child(list_option_page.nama_circle).child(login_page.pembagian_juri);
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                data1 = dataSnapshot.child(sub_database).getValue(String.class);
                if(data1.equals("")){}else{
                    if(data1.contains(login_page.nip_juri)){
                        if(data1.contains(",")){
                            String[] split_1 = data1.split(",");
                            for (int i=0;i< split_1.length;i++) {
                                if (split_1[i].contains(login_page.nip_juri)) {
                                    data1_split = split_1[i];
                                    auto_1.setText(split_1[i].split(":")[1].toString(),false);
                                    break;
                                }
                            }
                        }else{
                            auto_1.setText(data1.split(":")[1].toString(),false);
                            data1_split = data1;
                        }

                    }else{}

                }

            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(point_m.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void input_database(View view) {
        if(auto_1.getText().toString().equals("")){
            Toast.makeText(point_m.this, "Mohon lengkapi data terlebih dahulu!", Toast.LENGTH_SHORT).show();
        }else{
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("data_nilai").child(login_page.jenis_juri).child(list_option_page.nama_circle).child(login_page.pembagian_juri);
            if(data1.equals("")){
                myRef.child(sub_database).setValue(login_page.nip_juri +":"+auto_1.getText().toString());
            }else{
                if(data1.contains(login_page.nip_juri)){
                    myRef.child(sub_database).setValue(data1.replace(data1_split,login_page.nip_juri +":"+auto_1.getText().toString()));
                }else{
                    myRef.child(sub_database).setValue(data1 +","+ login_page.nip_juri +":"+auto_1.getText().toString());
                }
            }

            Toast.makeText(point_m.this, "Nilai Dimasukkan", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(point_m.this,list_item_penilaian.class));
        }
    }
}