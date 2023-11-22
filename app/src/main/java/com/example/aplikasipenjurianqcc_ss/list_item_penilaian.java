package com.example.aplikasipenjurianqcc_ss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class list_item_penilaian extends AppCompatActivity {

    GridView grid_test_1;
    TextView teks_tampil_nama_circle,teks_tampil_admin2;
    public static String kode_sub_penilaian;
    public static String[] value_1 = new String[]{"10","7.5","5","3"};
    public static String[] value_2 = new String[]{"5","3.75","2.5","1.5"};
    public static String[] value_3 = new String[]{"3.33","2.5","1.67","1"};
    public static String[] value_4 = new String[]{"1","0.75","0.5","0.3"};
    public static String[] value_5 = new String[]{"1.50","1.13","0.75","0.5"};
    public static String[] value_6 = new String[]{"2","1.5","1","0.5"};
    public static String[] value_7 = new String[]{"0.75","0.56","0.38","0.23"};
    public static String[] value_8 = new String[]{"2","1.5","1","0.6"};
    public static String[] value_10 = new String[]{"1.25","0.94","0.63","0.38"};
    public static String[] value_11 = new String[]{"1.75","1.31","0.88","0.53"};
    public static String[] value_12 = new String[]{"1.50","1.13","0.75","0.45"};
    public static String[] value_13 = new String[]{"3","2.25","1.5","0.9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item_penilaian);

        grid_test_1 = (GridView)findViewById(R.id.grid_list_mobil);
        teks_tampil_nama_circle = (TextView) findViewById(R.id.teks_change_nama_circle);
        teks_tampil_nama_circle.setText(list_option_page.nama_circle);
        teks_tampil_admin2=(TextView) findViewById(R.id.teks_admin2);
        teks_tampil_admin2.setText(login_page.nama_juri);

        String[] list_nama_penilaian_qcc = {"A.Menjelaskan methode, quality tools dan data dalam memilih suatu project","B.Tema terkait dengan tujuan & strategi bisnis perusahaan",
                "C.Stakeholders Involvement (Keterlibatan Stakeholders)","D.Target sesuai dengan tema","E.Target jelas dan menantang","F.Prediksi manfaat dan masalah potensial","G.Verifikasi stakeholders yang terkait dengan proyek perbaikan","H.Pendekatan/proses yang digunakan untuk mengidentifikasi potensi akar penyebab masalah",
                "I.Aktualisasi dan keterlibatan team dan stakeholders dalam mengembangkan pola hubungan sebab akibat","J.Menjelaskan metode dan quality tools yang digunakan dalam pengembangan solusi","K.Kualitas ide solusi"
                ,"L.Menjelaskan pendekatan yang digunakan untuk menerapkan tindakan solusi dan memastikan hasil yang ingin dicapai","M.Semua anggota tim memahami perubahan-perubahan yang terjadi di dalam improvement terhadap kondisi sebelumnya",
                "N.Tingkat pencapaian perbaikan dibandingkan dengan target","O.Kuantifikasi dampak solusi/imporvement action","P.Proyek perbaikan memberikan kontribusi/dampak nyata terhadap tujuan perusahaan","Q.Standarisasi","R.Menjamin pelaksanaan standar baru","S.Identifikasi & penetapan rencana berikutnya","Komentar"};
        String[] list_nama_penilaian_ss = {"A.Menjelaskan methode, quality tools dan data dalam memilih suatu project","B.Tema terkait dengan permasalahan  di area tempat kerja","C.Stakeholders Involvement (Keterlibatan Stakeholders)","D.Pendekatan/proses yang digunakan untuk mengidentifikasi potensi akar penyebab masalah","E.Aktualisasi dan keterlibatan peserta & stakeholders dalam mengembangkan pola hubungan sebab akibat",
                "F.Menjelaskan metode dan quality tools yang digunakan yang digunakan","G.Kualitas ide/solusi","H.Menjelaskan pendekatan yang digunakan untuk menerapkan tindakan solusi dan memastikan hasil yang ingin dicapai","I.Peserta memahami perubahan-perubahan yang terjadi di dalam improvement terhadap kondisi sebelumnya","J.Tingkat pencapaian perbaikan dibandingkan dengan target","K.Kuantifikasi dampak solusi/imporvement actions",
                "L.Proyek perbaikan memberikan kontribusi/dampak nyata terhadap tujuan perusahaan","M.Standarisasi","N.Menjamin pelaksanaan standar baru","O.Identifikasi & penetapan rencana berikutnya","Komentar"};
        String[] list_nama_penilaian_qcc_ppt = {"Korelasi dengan stretegi atau tingkat urgensi atau tingkat kepentingan permasalahan dalam company view \n (25%)","Metode  dan tools yang digunakan dalam pengembangan solusi dan inovasi/improvement actions \n (25%)","Standarisasi \n (15%)","Teknik Penyampaian / Kejelasan Presentasi \n (20%)","Kerjasama team dalam presentasi (Pengelolaan presentasi) \n (10%)","Ketepatan waktu presentasi (Score by timekeeper)\n (5%)"};
        String[] list_nama_penilaian_ss_ppt = {"Korelasi dengan stretegi atau tingkat urgensi atau tingkat kepentingan permasalahan dalam company view \n (20%)","Metode  dan tools yang digunakan dalam pengembangan solusi dan inovasi/improvement actions \n (30%)","Standarisasi \n (20%)","Teknik Penyampaian / Kejelasan Presentasi \n (20%)","Kerjasama team dalam presentasi (Pengelolaan presentasi)\n (5%)","Ketepatan waktu presentasi (Score by timekeeper)\n (5%)"};
        String[] lap_qcc = {"a1","b1","c1","d1","e1","f1","g1","h1","i1","j1","k1","l1","m1","n1","o1","p1","q1","r1","s1"};
        String[] lap_ss = {"a1","b1","c1","d1","e1","f1","g1","h1","i1","j1","k1","l1","m1","n1","o1"};
        String[] presentasi = {"a","b","c","d","e","f"};
        if(admin_page.tipe_penjurian == "qcc"){
            if(login_page.pembagian_juri.equals("lapangan")){
                grid_adapter_list_pen adapter_grid_1 = new grid_adapter_list_pen(list_item_penilaian.this,list_nama_penilaian_qcc,lap_qcc);
                grid_test_1.setAdapter(adapter_grid_1);
            }else if(login_page.pembagian_juri.equals("presentasi")){
                grid_adapter_list_pen adapter_grid_1 = new grid_adapter_list_pen(list_item_penilaian.this,list_nama_penilaian_qcc_ppt,presentasi);
                grid_test_1.setAdapter(adapter_grid_1);
            }else{}

        }else if(admin_page.tipe_penjurian == "ss"){
            if(login_page.pembagian_juri.equals("lapangan")){
                grid_adapter_list_pen adapter_grid_1 = new grid_adapter_list_pen(list_item_penilaian.this,list_nama_penilaian_ss,lap_ss);
                grid_test_1.setAdapter(adapter_grid_1);
            }else if(login_page.pembagian_juri.equals("presentasi")){
                grid_adapter_list_pen adapter_grid_1 = new grid_adapter_list_pen(list_item_penilaian.this,list_nama_penilaian_ss_ppt,presentasi);
                grid_test_1.setAdapter(adapter_grid_1);
            }else{}
        }else{}

        grid_test_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(admin_page.tipe_penjurian == "qcc"){
                    if(login_page.pembagian_juri.equals("lapangan")){
                        if(position == 0){
                            kode_sub_penilaian = "qcc_a";
                            startActivity(new Intent(list_item_penilaian.this,point_a.class));
                        }else if(position==1){
                            kode_sub_penilaian = "qcc_b";
                            startActivity(new Intent(list_item_penilaian.this,point_b.class));
                        }else if(position==2){
                            kode_sub_penilaian = "qcc_c";
                            startActivity(new Intent(list_item_penilaian.this,point_c.class));
                        }else if(position==3){
                            kode_sub_penilaian = "qcc_d";
                            startActivity(new Intent(list_item_penilaian.this,point_d.class));
                        }else if(position==4){
                            kode_sub_penilaian = "qcc_e";
                            startActivity(new Intent(list_item_penilaian.this,point_e.class));
                        }else if(position==5){
                            kode_sub_penilaian = "qcc_f";
                            startActivity(new Intent(list_item_penilaian.this,point_f.class));
                        }else if(position==6){
                            kode_sub_penilaian = "qcc_g";
                            startActivity(new Intent(list_item_penilaian.this,point_g.class));
                        }else if(position==7){
                            kode_sub_penilaian = "qcc_h";
                            startActivity(new Intent(list_item_penilaian.this,point_h.class));
                        }else if(position==8){
                            kode_sub_penilaian = "qcc_i";
                            startActivity(new Intent(list_item_penilaian.this,point_i.class));
                        }else if(position==9){
                            kode_sub_penilaian = "qcc_j";
                            startActivity(new Intent(list_item_penilaian.this,point_j.class));
                        }else if(position==10){
                            kode_sub_penilaian = "qcc_k";
                            startActivity(new Intent(list_item_penilaian.this,point_k.class));
                        }else if(position==11){
                            kode_sub_penilaian = "qcc_l";
                            startActivity(new Intent(list_item_penilaian.this,point_l.class));
                        }else if(position==12){
                            kode_sub_penilaian = "qcc_m";
                            startActivity(new Intent(list_item_penilaian.this,point_m.class));
                        }else if(position==13){
                            kode_sub_penilaian = "qcc_n";
                            startActivity(new Intent(list_item_penilaian.this,point_n.class));
                        }else if(position==14){
                            kode_sub_penilaian = "qcc_o";
                            startActivity(new Intent(list_item_penilaian.this,point_o.class));
                        }else if(position==15){
                            kode_sub_penilaian = "qcc_p";
                            startActivity(new Intent(list_item_penilaian.this,poin_p.class));
                        }else if(position==16){
                            kode_sub_penilaian = "qcc_q";
                            startActivity(new Intent(list_item_penilaian.this,point_q.class));
                        }else if(position==17){
                            kode_sub_penilaian = "qcc_r";
                            startActivity(new Intent(list_item_penilaian.this,point_r.class));
                        }else if(position==18){
                            kode_sub_penilaian = "qcc_s";
                            startActivity(new Intent(list_item_penilaian.this,point_s.class));
                        }else if(position==19){
                            kode_sub_penilaian = "qcc_komen";
                            startActivity(new Intent(list_item_penilaian.this,input_komen.class));
                        }else{}
                    }else if(login_page.pembagian_juri.equals("presentasi")){
                        if(position == 0){
                            startActivity(new Intent(list_item_penilaian.this,penilaian_ppt_qcc_1.class));
                        }else if(position==1){
                            startActivity(new Intent(list_item_penilaian.this,penilaian_ppt_qcc_2.class));
                        }else if(position==2){
                            startActivity(new Intent(list_item_penilaian.this,penilaian_ppt_qcc_3.class));
                        }else if(position==3){
                            startActivity(new Intent(list_item_penilaian.this,penilaian_ppt_qcc_4.class));
                        }else if(position==4){
                            startActivity(new Intent(list_item_penilaian.this,penilaian_ppt_qcc_5.class));
                        }else if(position==5){
                            startActivity(new Intent(list_item_penilaian.this,penilaian_ppt_qcc_6.class));
                        }else{}
                    }else{}

                }else if(admin_page.tipe_penjurian == "ss"){
                    if(login_page.pembagian_juri.equals("lapangan")){
                        if(position == 0){
                            kode_sub_penilaian = "ss_a";
                            startActivity(new Intent(list_item_penilaian.this,point_a.class));
                        }else if(position==1){
                            kode_sub_penilaian = "ss_b";
                            startActivity(new Intent(list_item_penilaian.this,point_b.class));
                        }else if(position==2){
                            kode_sub_penilaian = "ss_c";
                            startActivity(new Intent(list_item_penilaian.this,point_c.class));
                        }else if(position==3){
                            kode_sub_penilaian = "ss_d";
                            startActivity(new Intent(list_item_penilaian.this,point_ss_d.class));
                        }else if(position==4){
                            kode_sub_penilaian = "ss_e";
                            startActivity(new Intent(list_item_penilaian.this,point_ss_e.class));
                        }else if(position==5){
                            kode_sub_penilaian = "ss_f";
                            startActivity(new Intent(list_item_penilaian.this,point_ss_f.class));
                        }else if(position==6){
                            kode_sub_penilaian = "ss_g";
                            startActivity(new Intent(list_item_penilaian.this,point_ss_g.class));
                        }else if(position==7){
                            kode_sub_penilaian = "ss_h";
                            startActivity(new Intent(list_item_penilaian.this,point_ss_h.class));
                        }else if(position==8){
                            kode_sub_penilaian = "ss_i";
                            startActivity(new Intent(list_item_penilaian.this,point_m.class));
                        }else if(position==9){
                            kode_sub_penilaian = "ss_j";
                            startActivity(new Intent(list_item_penilaian.this,point_n.class));
                        }else if(position==10){
                            kode_sub_penilaian = "ss_k";
                            startActivity(new Intent(list_item_penilaian.this,point_o.class));
                        }else if(position==11){
                            kode_sub_penilaian = "ss_l";
                            startActivity(new Intent(list_item_penilaian.this,poin_p.class));
                        }else if(position==12){
                            kode_sub_penilaian = "ss_m";
                            startActivity(new Intent(list_item_penilaian.this,point_q.class));
                        }else if(position==13){
                            kode_sub_penilaian = "ss_n";
                            startActivity(new Intent(list_item_penilaian.this,point_r.class));
                        }else if(position==14){
                            kode_sub_penilaian = "ss_o";
                            startActivity(new Intent(list_item_penilaian.this,point_s.class));
                        }else if(position==15){
                            kode_sub_penilaian = "ss_komen";
                            startActivity(new Intent(list_item_penilaian.this,input_komen.class));
                        }else{}
                    }else if(login_page.pembagian_juri.equals("presentasi")){
                        if(position == 0){
                            kode_sub_penilaian = "ss_a";
                            startActivity(new Intent(list_item_penilaian.this,penilaian_ppt_ss_1.class));
                        }else if(position==1){
                            kode_sub_penilaian = "ss_b";
                            startActivity(new Intent(list_item_penilaian.this,penilaian_ppt_ss_2.class));
                        }else if(position==2){
                            kode_sub_penilaian = "ss_c";
                            startActivity(new Intent(list_item_penilaian.this,penilaian_ppt_ss_3.class));
                        }else if(position==3){
                            kode_sub_penilaian = "ss_d";
                            startActivity(new Intent(list_item_penilaian.this,penilaian_ppt_ss_4.class));
                        }else if(position==4){
                            kode_sub_penilaian = "ss_e";
                            startActivity(new Intent(list_item_penilaian.this,penilaian_ppt_ss_5.class));
                        }else if(position==5){
                            kode_sub_penilaian = "ss_f";
                            startActivity(new Intent(list_item_penilaian.this,penilaian_ppt_ss_6.class));
                        }else{}
                    }else{}
                }else{}
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(list_item_penilaian.this,list_option_page.class));
    }
}