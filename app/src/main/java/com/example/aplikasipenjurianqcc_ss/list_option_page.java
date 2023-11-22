package com.example.aplikasipenjurianqcc_ss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class list_option_page extends AppCompatActivity {

    GridView grid_test;
    public static String nama_circle;
    TextView teks_tampil_admin3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_option_page);

        grid_test = (GridView)findViewById(R.id.grid_list_mobil);
        teks_tampil_admin3=(TextView) findViewById(R.id.teks_admin3);
        teks_tampil_admin3.setText(login_page.nama_juri);

        String[] list_nama_team_QCC = {"PILOT","SEMONGKO","MANISE","MAXIO","EXPANDER","OPTIMUS PRIME","SPION","BEBEK","SATGAS 1","PACAR SEJAM", "SOBAT"};
        String[] list_dept_QCC = {"(RPW)","(RPW)","(BPW)","(BPW)","(JXP)","(JMW)","(APW)","(JMW)","(DPW)","(APW)", "(DPW)"};
        String[] list_nama_team_SS = {"RPW","MS","JPPP","APW","JPPM","BPW"};
        String[] list_dept_SS = {"","","","","",""};

        if(admin_page.tipe_penjurian == "qcc"){
            grid_adapter adapter_grid = new grid_adapter(list_option_page.this,list_nama_team_QCC,list_dept_QCC);
            grid_test.setAdapter(adapter_grid);
        }else if(admin_page.tipe_penjurian == "ss"){
            grid_adapter adapter_grid = new grid_adapter(list_option_page.this,list_nama_team_SS,list_dept_SS);
            grid_test.setAdapter(adapter_grid);
        }else{}

        grid_test.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    startActivity(new Intent(list_option_page.this,list_item_penilaian.class));
                if(admin_page.tipe_penjurian == "qcc"){
                    nama_circle = list_nama_team_QCC[position];
                }else if(admin_page.tipe_penjurian == "ss"){
                    nama_circle = list_nama_team_SS[position];
                }else{}

            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(list_option_page.this,option_action_juri_page.class));
    }
}