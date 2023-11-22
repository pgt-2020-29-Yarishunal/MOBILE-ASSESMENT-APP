package com.example.aplikasipenjurianqcc_ss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login_page extends AppCompatActivity {

        TextView teks_input_username,teks_input_password;
        public static String nama_juri;
        public static String jenis_juri;
        public static String pembagian_juri;
        public static String nip_juri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        teks_input_username = (TextView) findViewById(R.id.username_text);
        teks_input_password = (TextView) findViewById(R.id.password_text);

    }

    public void login(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user").child(teks_input_username.getText().toString());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String password_database = dataSnapshot.child("password").getValue(String.class);
                if(!dataSnapshot.child("password").exists()){
                    Toast.makeText(login_page.this, "Data Tidak sesuai!", Toast.LENGTH_SHORT).show();
                }else{
                    if(password_database.equals(teks_input_password.getText().toString())){
                        nama_juri = dataSnapshot.child("nama").getValue(String.class);
                        jenis_juri = dataSnapshot.child("jenis").getValue(String.class);
                        pembagian_juri = dataSnapshot.child("lokasi").getValue(String.class);
                        nip_juri = dataSnapshot.child("password").getValue(String.class);
                        Intent admin_page = new Intent(login_page.this, admin_page.class);
                        startActivity(admin_page);
                        Toast.makeText(login_page.this, "Selamat Datang "+ nama_juri+"!", Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(login_page.this, "Data Tidak sesuai!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(login_page.this, "Data tidak sesuai!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onBackPressed() {
        finish();
    }


}