package com.example.aplikasipenjurianqcc_ss;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class admin_page extends AppCompatActivity {

    public static String tipe_penjurian;
    public static String tipe_penjurian_1;
    public static String teks_change_tipe_pen;
    TextView teks_tampil_admin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        teks_tampil_admin1=(TextView) findViewById(R.id.teks_admin1);
        teks_tampil_admin1.setText(login_page.nama_juri);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(admin_page.this,login_page.class));
    }

    public void list_qcc(View view) {
        if(login_page.jenis_juri.isEmpty()){
            Toast.makeText(admin_page.this, "Tipe Juri Tidak Terisi", Toast.LENGTH_SHORT).show();
        }else{
            if(login_page.pembagian_juri.equals("lapangan")){
                if(login_page.jenis_juri.equals("qcc")){
                    tipe_penjurian = "qcc";
                    teks_change_tipe_pen = "PENJURIAN QCC";
                    Intent act_option_page = new Intent(admin_page.this,option_tipe_penjurian_page.class);
                    startActivity(act_option_page);
                    finish();
                }else{
                    Toast.makeText(admin_page.this, "Pembagian Juri Tidak Sesuai", Toast.LENGTH_SHORT).show();
                }
            }else if(login_page.pembagian_juri.equals("presentasi")){
                tipe_penjurian = "qcc";
                teks_change_tipe_pen = "PENJURIAN QCC";
                Intent act_option_page = new Intent(admin_page.this,option_tipe_penjurian_page.class);
                startActivity(act_option_page);
                finish();
            }else{}

        }
    }

    public void list_ss(View view) {
        if(login_page.jenis_juri.isEmpty()){
            Toast.makeText(admin_page.this, "Tipe Juri Tidak Terisi", Toast.LENGTH_SHORT).show();
        }else{
            if(login_page.pembagian_juri.equals("lapangan")){
                if(login_page.jenis_juri.equals("ss")){
                    tipe_penjurian = "ss";
                    teks_change_tipe_pen = "PENJURIAN SS";
                    Intent act_option_page = new Intent(admin_page.this,option_tipe_penjurian_page.class);
                    startActivity(act_option_page);
                    finish();
                }else{
                    Toast.makeText(admin_page.this, "Pembagian Juri Tidak Sesuai", Toast.LENGTH_SHORT).show();
                }
            }else if(login_page.pembagian_juri.equals("presentasi")){
                tipe_penjurian = "ss";
                teks_change_tipe_pen = "PENJURIAN SS";
                Intent act_option_page = new Intent(admin_page.this,option_tipe_penjurian_page.class);
                startActivity(act_option_page);
                finish();
            }else{

            }

        }
    }

}