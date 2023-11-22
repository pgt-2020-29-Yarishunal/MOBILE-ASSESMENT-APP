package com.example.aplikasipenjurianqcc_ss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class penilaian_ppt_ss_1 extends AppCompatActivity {
    TextView teks1,teks2,teks3;
    RadioButton rad1,rad2,rad3;
    String data1_split;
    String data1;
    String value1 = "7.0";
    String value2 = "14.0";
    String value3 = "21.0";
    String sub_sec = "a";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penilaian_ppt_ss1);
        teks1 = (TextView) findViewById(R.id.teks1);
        teks2 = (TextView) findViewById(R.id.teks2);
        teks3 = (TextView) findViewById(R.id.teks3);
        rad1 = (RadioButton) findViewById(R.id.radioButton1);
        rad2 = (RadioButton) findViewById(R.id.radioButton2);
        rad3 = (RadioButton) findViewById(R.id.radioButton3);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = database.getReference("data_nilai").child(admin_page.tipe_penjurian).child(list_option_page.nama_circle).child(login_page.pembagian_juri);
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                data1 = dataSnapshot.child(sub_sec).getValue(String.class);

                if(data1.equals("")){}else{
                    if(data1.contains(login_page.nip_juri)){
                        if(data1.contains(",")){
                            String[] split_1 = data1.split(",");
                            for (int i=0;i< split_1.length;i++) {
                                if (split_1[i].contains(login_page.nip_juri)) {
                                    data1_split = split_1[i];
                                    if (data1_split.contains(value1)){
                                        rad1.setChecked(true);
                                    }else if(data1_split.contains(value2)){
                                        rad2.setChecked(true);
                                    }else if(data1_split.contains(value3)){
                                        rad3.setChecked(true);
                                    }else{}
                                    break;
                                }
                            }
                        }else{
                            data1_split = data1;
                            if (data1.contains(value1)){
                                rad1.setChecked(true);
                            }else if(data1.contains(value2)){
                                rad2.setChecked(true);
                            }else if(data1.contains(value3)){
                                rad3.setChecked(true);
                            }else{}
                        }

                    }else{}

                }

            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(penilaian_ppt_ss_1.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void input_database(View view) {
        if(!rad1.isChecked() && !rad2.isChecked() && !rad3.isChecked()){
            Toast.makeText(penilaian_ppt_ss_1.this, "Mohon Lengkapi Data!!", Toast.LENGTH_SHORT).show();
        }else{
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("data_nilai").child(admin_page.tipe_penjurian).child(list_option_page.nama_circle).child(login_page.pembagian_juri);
            if(data1.equals("")){
                if (rad1.isChecked()){
                    myRef.child(sub_sec).setValue(login_page.nip_juri +":"+value1);
                }else if(rad2.isChecked()){
                    myRef.child(sub_sec).setValue(login_page.nip_juri +":"+value2);
                }else if(rad3.isChecked()){
                    myRef.child(sub_sec).setValue(login_page.nip_juri +":"+value3);
                }else{}
            }else{
                if(data1.contains(login_page.nip_juri)){
                    if (rad1.isChecked()){
                        myRef.child(sub_sec).setValue(data1.replace(data1_split,login_page.nip_juri +":"+value1));
                    }else if(rad2.isChecked()){
                        myRef.child(sub_sec).setValue(data1.replace(data1_split,login_page.nip_juri +":"+value2));
                    }else if(rad3.isChecked()){
                        myRef.child(sub_sec).setValue(data1.replace(data1_split,login_page.nip_juri +":"+value3));
                    }
                    else{}
                }else{
                    if (rad1.isChecked()){
                        myRef.child(sub_sec).setValue(data1 +","+ login_page.nip_juri +":"+value1);
                    }else if(rad2.isChecked()){
                        myRef.child(sub_sec).setValue(data1 +","+ login_page.nip_juri +":"+value2);
                    }else if(rad3.isChecked()){
                        myRef.child(sub_sec).setValue(data1 +","+ login_page.nip_juri +":"+value3);
                    }else{}
                }
            }
            Toast.makeText(penilaian_ppt_ss_1.this, "Nilai Dimasukkan", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(penilaian_ppt_ss_1.this,list_item_penilaian.class));
        }
    }

    public void radio1(View view) {
        if(rad1.isChecked()){
            rad2.setChecked(false);
            rad3.setChecked(false);
            teks1.setTextColor(Color.parseColor("#000000"));
            teks2.setTextColor(Color.parseColor("#3D3D3D"));
            teks3.setTextColor(Color.parseColor("#3D3D3D"));
        }else{
            rad1.setChecked(true);
            rad2.setChecked(false);
            rad3.setChecked(false);
            teks1.setTextColor(Color.parseColor("#000000"));
            teks2.setTextColor(Color.parseColor("#3D3D3D"));
            teks3.setTextColor(Color.parseColor("#3D3D3D"));
        }
    }

    public void radio2(View view) {
        if(rad2.isChecked()){
            rad1.setChecked(false);
            rad3.setChecked(false);
            teks1.setTextColor(Color.parseColor("#3D3D3D"));
            teks2.setTextColor(Color.parseColor("#000000"));
            teks3.setTextColor(Color.parseColor("#3D3D3D"));
        }else{
            rad1.setChecked(false);
            rad2.setChecked(true);
            rad3.setChecked(false);
            teks1.setTextColor(Color.parseColor("#3D3D3D"));
            teks2.setTextColor(Color.parseColor("#000000"));
            teks3.setTextColor(Color.parseColor("#3D3D3D"));
        }
    }

    public void radio3(View view) {
        if(rad3.isChecked()){
            rad1.setChecked(false);
            rad2.setChecked(false);
            teks1.setTextColor(Color.parseColor("#3D3D3D"));
            teks2.setTextColor(Color.parseColor("#3D3D3D"));
            teks3.setTextColor(Color.parseColor("#000000"));
        }else{
            rad1.setChecked(false);
            rad2.setChecked(false);
            rad3.setChecked(true);
            teks1.setTextColor(Color.parseColor("#3D3D3D"));
            teks2.setTextColor(Color.parseColor("#3D3D3D"));
            teks3.setTextColor(Color.parseColor("#000000"));
        }
    }

}