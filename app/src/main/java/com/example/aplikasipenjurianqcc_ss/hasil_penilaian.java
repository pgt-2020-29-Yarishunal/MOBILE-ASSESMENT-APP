package com.example.aplikasipenjurianqcc_ss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class hasil_penilaian extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    adapter_sub_penilaian adapter_recycler_;
    TextView nama_jurinya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_penilaian);
        String[] list_nama_team_QCC = {"PILOT","SEMONGKO","MANISE","MAXIO","EXPANDER","OPTIMUS PRIME","SPION","BEBEK","SATGAS 1","PACAR SEJAM", "SOBAT"};
        String[] jumlah_nilai = {};
        String[] list_nama_team_SS = {"RPW","MS","JPPP","APW","JPPM","BPW"};
        nama_jurinya = (TextView)findViewById(R.id.teks_admin__);
        nama_jurinya.setText(login_page.nama_juri);
        
        recyclerview_data[] data_qcc = new recyclerview_data[]{
                new recyclerview_data("PILOT",""),
                new recyclerview_data("SEMONGKO",""),
                new recyclerview_data("MANISE",""),
                new recyclerview_data("MAXIO",""),
                new recyclerview_data("EXPANDER",""),
                new recyclerview_data("OPTIMUS PRIME",""),
                new recyclerview_data("SPION",""),
                new recyclerview_data("BEBEK",""),
                new recyclerview_data("SATGAS 1",""),
                new recyclerview_data("PACAR SEJAM",""),
                new recyclerview_data("SOBAT","")
        };
        recyclerview_data[] data_ss = new recyclerview_data[]{
                new recyclerview_data("RPW",""),
                new recyclerview_data("MS",""),
                new recyclerview_data("JPPP",""),
                new recyclerview_data("APW",""),
                new recyclerview_data("JPPM",""),
                new recyclerview_data("BPW","")
        };
        

        recyclerView = (RecyclerView) findViewById(R.id.rv_data11);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        if(admin_page.tipe_penjurian == "qcc"){
            adapter_recycler_ = new adapter_sub_penilaian(data_qcc,hasil_penilaian.this);
        }else if(admin_page.tipe_penjurian == "ss"){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss,hasil_penilaian.this);
        }else{}
        recyclerView.setAdapter(adapter_recycler_);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(hasil_penilaian.this,option_action_juri_page.class));
    }
}