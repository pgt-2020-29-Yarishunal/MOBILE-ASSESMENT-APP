package com.example.aplikasipenjurianqcc_ss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class option_tipe_penjurian_page extends AppCompatActivity {

    TextView teks_atas_jenis_pen,teks_tampil_admin5;
    public static String teks_change_tipe_pen1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_tipe_penjurian_page);

        teks_atas_jenis_pen = (TextView) findViewById(R.id.teks_change_jenis_penilaian1);
        teks_atas_jenis_pen.setText(admin_page.teks_change_tipe_pen);
        teks_tampil_admin5=(TextView) findViewById(R.id.teks_admin5);
        teks_tampil_admin5.setText(login_page.nama_juri);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(option_tipe_penjurian_page.this,admin_page.class));
    }

    public void act_presentasi(View view) {

        if(login_page.pembagian_juri.isEmpty()){
            Toast.makeText(option_tipe_penjurian_page.this, "Tipe Juri Tidak Terisi", Toast.LENGTH_SHORT).show();
        }else{
            if(login_page.pembagian_juri.equals("presentasi")){
                admin_page.tipe_penjurian_1 = "presentasi";
                teks_change_tipe_pen1 = "PENJURIAN PRESENTASI";
                Intent act_option_page = new Intent(option_tipe_penjurian_page.this,option_action_juri_page.class);
                startActivity(act_option_page);
                finish();
            }else{
                Toast.makeText(option_tipe_penjurian_page.this, "Pembagian Juri Tidak Sesuai", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void act_lapangan(View view) {
        if(login_page.pembagian_juri.isEmpty()){
            Toast.makeText(option_tipe_penjurian_page.this, "Tipe Juri Tidak Terisi", Toast.LENGTH_SHORT).show();
        }else{
            if(login_page.pembagian_juri.equals("lapangan")){
                admin_page.tipe_penjurian_1 = "lapangan";
                teks_change_tipe_pen1 = "PENJURIAN LAPANGAN";
                Intent act_option_page = new Intent(option_tipe_penjurian_page.this,option_action_juri_page.class);
                startActivity(act_option_page);
                finish();
            }else{
                Toast.makeText(option_tipe_penjurian_page.this, "Pembagian Juri Tidak Sesuai", Toast.LENGTH_SHORT).show();
            }
        }
    }
}