package com.example.aplikasipenjurianqcc_ss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class input_komen extends AppCompatActivity {
    EditText teks_input_komen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_komen);
        teks_input_komen = (EditText) findViewById(R.id.teks_komen);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = database.getReference("user").child(login_page.nip_juri).child("komen").child(list_option_page.nama_circle);
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               String data1 = snapshot.getValue(String.class);
               if(data1.equals("")){}else{
                   teks_input_komen.setText(data1);
               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void input_database(View view) {
        if(teks_input_komen .getText().toString().equals("")){
            Toast.makeText(input_komen.this, "Mohon lengkapi data terlebih dahulu!", Toast.LENGTH_SHORT).show();
        }else{
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("user").child(login_page.nip_juri).child("komen").child(list_option_page.nama_circle);
            myRef.setValue(teks_input_komen .getText().toString());

            Toast.makeText(input_komen.this, "Komen Dimasukkan", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(input_komen.this,list_item_penilaian.class));
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(input_komen.this,list_item_penilaian.class));
    }

}