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

public class point_q extends AppCompatActivity {
    AutoCompleteTextView auto_1,auto_2,auto_3,auto_4,auto_5;
    String data1,data2,data3,data4,data5;
    String data1_split,data2_split,data3_split,data4_split,data5_split;
    String sub_database_1,sub_database_2,sub_database_3,sub_database_4,sub_database_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_q);
        auto_1 = (AutoCompleteTextView)findViewById(R.id.isi_spinner_q1);
        auto_2 = (AutoCompleteTextView)findViewById(R.id.isi_spinner_q2);
        auto_3 = (AutoCompleteTextView)findViewById(R.id.isi_spinner_q3);
        auto_4 = (AutoCompleteTextView)findViewById(R.id.isi_spinner_q4);
        auto_5 = (AutoCompleteTextView)findViewById(R.id.isi_spinner_q5);
        ArrayAdapter<String> adapter_1 = new ArrayAdapter<>(
                this,R.layout.drop_down_menu,list_item_penilaian.value_4
        );
        ArrayAdapter<String> adapter_2 = new ArrayAdapter<>(
                this,R.layout.drop_down_menu,list_item_penilaian.value_4
        );
        ArrayAdapter<String> adapter_3 = new ArrayAdapter<>(
                this,R.layout.drop_down_menu,list_item_penilaian.value_4
        );
        ArrayAdapter<String> adapter_4 = new ArrayAdapter<>(
                this,R.layout.drop_down_menu,list_item_penilaian.value_4
        );
        ArrayAdapter<String> adapter_5 = new ArrayAdapter<>(
                this,R.layout.drop_down_menu,list_item_penilaian.value_4
        );
        auto_1.setAdapter(adapter_1);
        auto_2.setAdapter(adapter_2);
        auto_3.setAdapter(adapter_3);
        auto_4.setAdapter(adapter_4);
        auto_4.setAdapter(adapter_5);
        if(admin_page.tipe_penjurian.equals("qcc")){
            sub_database_1 = "q1";
            sub_database_2 = "q2";
            sub_database_3 = "q3";
            sub_database_4 = "q4";
            sub_database_5 = "q5";
        }else if(admin_page.tipe_penjurian.equals("ss")){
            sub_database_1 = "m1";
            sub_database_2 = "m2";
            sub_database_3 = "m3";
            sub_database_4 = "m4";
            sub_database_5 = "m5";
        }else{}

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = database.getReference("data_nilai").child(login_page.jenis_juri).child(list_option_page.nama_circle).child(login_page.pembagian_juri);
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                data1 = dataSnapshot.child(sub_database_1).getValue(String.class);
                data2 = dataSnapshot.child(sub_database_2).getValue(String.class);
                data3 = dataSnapshot.child(sub_database_3).getValue(String.class);
                data4 = dataSnapshot.child(sub_database_4).getValue(String.class);
                data5 = dataSnapshot.child(sub_database_5).getValue(String.class);

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

                if(data2.equals("")){}else{
                    if(data2.contains(login_page.nip_juri)){
                        if(data2.contains(",")){
                            String[] split_2 = data2.split(",");
                            for (int i=0;i< split_2.length;i++) {
                                if (split_2[i].contains(login_page.nip_juri)) {
                                    data2_split = split_2[i];
                                    auto_2.setText(split_2[i].split(":")[1].toString(),false);
                                    break;
                                }
                            }
                        }else{
                            auto_2.setText(data2.split(":")[1].toString(),false);
                            data2_split = data2;
                        }

                    }else{}

                }

                if(data3.equals("")){}else{
                    if(data3.contains(login_page.nip_juri)){
                        if(data3.contains(",")){
                            String[] split_1 = data3.split(",");
                            for (int i=0;i< split_1.length;i++) {
                                if (split_1[i].contains(login_page.nip_juri)) {
                                    data3_split =split_1[i];
                                    auto_3.setText(split_1[i].split(":")[1].toString(),false);
                                    break;
                                }
                            }
                        }else{
                            auto_3.setText(data3.split(":")[1].toString(),false);
                            data3_split = data3;
                        }

                    }else{}

                }

                if(data4.equals("")){}else{
                    if(data4.contains(login_page.nip_juri)){
                        if(data4.contains(",")){
                            String[] split_1 = data4.split(",");
                            for (int i=0;i< split_1.length;i++) {
                                if (split_1[i].contains(login_page.nip_juri)) {
                                    data4_split = split_1[i];
                                    auto_4.setText(split_1[i].split(":")[1].toString(),false);
                                    break;
                                }
                            }
                        }else{
                            auto_4.setText(data4.split(":")[1].toString(),false);
                            data4_split = data4;
                        }

                    }else{}

                }

                if(data5.equals("")){}else{
                    if(data5.contains(login_page.nip_juri)){
                        if(data5.contains(",")){
                            String[] split_1 = data5.split(",");
                            for (int i=0;i< split_1.length;i++) {
                                if (split_1[i].contains(login_page.nip_juri)) {
                                    data5_split = split_1[i];
                                    auto_5.setText(split_1[i].split(":")[1].toString(),false);
                                    break;
                                }
                            }
                        }else{
                            auto_5.setText(data5.split(":")[1].toString(),false);
                            data5_split = data5;
                        }

                    }else{}

                }

            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(point_q.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void input_database(View view) {
        if(auto_1.getText().toString().equals("") || auto_2.getText().toString().equals("")||auto_3.getText().toString().equals("")||auto_4.getText().toString().equals("")||auto_5.getText().toString().equals("")){
            Toast.makeText(point_q.this, "Mohon lengkapi data terlebih dahulu!", Toast.LENGTH_SHORT).show();
        }else{
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("data_nilai").child(login_page.jenis_juri).child(list_option_page.nama_circle).child(login_page.pembagian_juri);
            if(data1.equals("")){
                myRef.child(sub_database_1).setValue(login_page.nip_juri +":"+auto_1.getText().toString());
            }else{
                if(data1.contains(login_page.nip_juri)){
                    myRef.child(sub_database_1).setValue(data1.replace(data1_split,login_page.nip_juri +":"+auto_1.getText().toString()));
                }else{
                    myRef.child(sub_database_1).setValue(data1 +","+ login_page.nip_juri +":"+auto_1.getText().toString());
                }
            }
            if(data2.equals("")){
                myRef.child(sub_database_2).setValue(login_page.nip_juri +":"+auto_2.getText().toString());
            }else{
                if(data2.contains(login_page.nip_juri)){
                    myRef.child(sub_database_2).setValue(data2.replace(data2_split,login_page.nip_juri +":"+auto_2.getText().toString()));
                }else{
                    myRef.child(sub_database_2).setValue(data2 +","+ login_page.nip_juri +":"+auto_2.getText().toString());
                }
            }
            if(data3.equals("")){
                myRef.child(sub_database_3).setValue(login_page.nip_juri +":"+auto_3.getText().toString());
            }else{
                if(data3.contains(login_page.nip_juri)){
                    myRef.child(sub_database_3).setValue(data3.replace(data3_split,login_page.nip_juri +":"+auto_3.getText().toString()));
                }else{
                    myRef.child(sub_database_3).setValue(data3 +","+ login_page.nip_juri +":"+auto_3.getText().toString());
                }
            }
            if(data4.equals("")){
                myRef.child(sub_database_4).setValue(login_page.nip_juri +":"+auto_4.getText().toString());
            }else{
                if(data4.contains(login_page.nip_juri)){
                    myRef.child(sub_database_4).setValue(data4.replace(data4_split,login_page.nip_juri +":"+auto_4.getText().toString()));
                }else{
                    myRef.child(sub_database_4).setValue(data4 +","+ login_page.nip_juri +":"+auto_4.getText().toString());
                }
            }
            if(data5.equals("")){
                myRef.child(sub_database_5).setValue(login_page.nip_juri +":"+auto_5.getText().toString());
            }else{
                if(data5.contains(login_page.nip_juri)){
                    myRef.child(sub_database_5).setValue(data5.replace(data5_split,login_page.nip_juri +":"+auto_5.getText().toString()));
                }else{
                    myRef.child(sub_database_5).setValue(data5 +","+ login_page.nip_juri +":"+auto_5.getText().toString());
                }
            }

            Toast.makeText(point_q.this, "Nilai Dimasukkan", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(point_q.this,list_item_penilaian.class));
        }

    }
}