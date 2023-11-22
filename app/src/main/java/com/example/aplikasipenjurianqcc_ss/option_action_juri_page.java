package com.example.aplikasipenjurianqcc_ss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class option_action_juri_page extends AppCompatActivity {

    TextView teks_jenis_penjurian2,teks_tampil_admin4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_action_juri_page);

        teks_jenis_penjurian2 = (TextView) findViewById(R.id.teks_change_jenis_penilaian2);
        teks_jenis_penjurian2.setText(option_tipe_penjurian_page.teks_change_tipe_pen1);
        teks_tampil_admin4=(TextView) findViewById(R.id.teks_admin4);
        teks_tampil_admin4.setText(login_page.nama_juri);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(option_action_juri_page.this,option_tipe_penjurian_page.class));
    }

    public void pilih_penjurian_page(View view) {
        Intent list_tim = new Intent(option_action_juri_page.this,list_option_page.class);
        startActivity(list_tim);
        finish();
    }

    public void hasil_page(View view) {
        Intent list_hasil = new Intent(option_action_juri_page.this,hasil_penilaian.class);
        startActivity(list_hasil);
        finish();
    }
}