package com.example.aplikasipenjurianqcc_ss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class sub_penilaian extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AutoCompleteTextView autoCompleteTextView,autoCompleteTextView1,autoCompleteTextView2;
    ArrayAdapter<String> adapter,adapter1,adapter2;
    Button tmbl;
    adapter_sub_penilaian adapter_recycler_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_penilaian);
        tmbl = (Button)findViewById(R.id.tmbl_input);
        recyclerView = (RecyclerView) findViewById(R.id.rv_data1);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //DATA PENILAIAN QCC
        /*
        recyclerview_data[] data_rec_A = new recyclerview_data[]{
                new recyclerview_data("Melakukan identifikasi dan membuat stratifikasi masalah",value_4),
                new recyclerview_data("Memilih project improvement/inovasi berdasarkan data & fakta melalui penggunaan quality methode dan tools secara maksimal ( baik & benar )",value_4),
                new recyclerview_data("Menjelaskan alasan kenapa proyek perbaikan tersebut dipilih",value_4)
        };

        recyclerview_data[] data_rec_B = new recyclerview_data[]{
                new recyclerview_data("Menjelaskan proyek perbaikan yang terseleksi mempunyai potensi pengaruh positif terhadap tujuan perusahaan",value_4),
                new recyclerview_data("Teridentifikasi tingkat kesulitan masalah/pelaksanaan perbaikan dari proyek yang terseleksi",value_4),
                new recyclerview_data("Tercermin harapan customer dan/atau stakeholders terhadap proyek perbaikan yang akan dilaksanakan",value_4)
        };

        recyclerview_data[] data_rec_C = new recyclerview_data[]{
                new recyclerview_data("Mengidentifikasi stakeholders yang bisa involve maupun yang dapat memberikan support dalam proyek perbaikan",value_4),
                new recyclerview_data("Mengidentifikasi stakeholders yang resisten (menghambat), sehingga menjadikan tantangan terhadap proyek perbaikan",value_7),
                new recyclerview_data("Menjelaskan bagaimana mereka (stakeholders) akan bisa memberikan dampak positif terhadap proyek perbaikan (Improvement/inovasi)",value_4)
        };

        recyclerview_data[] data_rec_D = new recyclerview_data[]{
                new recyclerview_data("Target (sasaran) yang ditetapkan mencakup QCDSMP",value_4),
                new recyclerview_data("Penetapan sasaran jangka pendek, dan sasaran tersebut menjadi bagian dari tujuan perbaikan",value_4)
        };

        recyclerview_data[] data_rec_E = new recyclerview_data[]{
                new recyclerview_data("Target (sasaran) jelas dan menantang",value_8)
        };

        recyclerview_data[] data_rec_F = new recyclerview_data[]{
                new recyclerview_data("Prediksi manfaat dan masalah potensial",value_8)
        };

        recyclerview_data[] data_rec_G = new recyclerview_data[]{
                new recyclerview_data("Verifikasi stakeholders yang terkait dengan proyek perbaikan",value_8)
        };

        recyclerview_data[] data_rec_H = new recyclerview_data[]{
                new recyclerview_data("Akar masalah teridentifikasi dengan jelas dan dapat dibuktikan",value_4),
                new recyclerview_data("Munculnya akar penyebab dari akar masalah pada suatu faktor yang telah dikembangkan",value_4),
                new recyclerview_data("Identifikasi dan validasi (memiliki akurasi penentuan) faktor penyebab dominan (akar penyebab masalah utama)",value_4),
                new recyclerview_data("Kesesuaian masalah dengan prioritas penanganan faktor penyebab dominan",value_4)
        };

        recyclerview_data[] data_rec_I = new recyclerview_data[]{
                new recyclerview_data("Aktualisasi dan keterlibatan team & stakeholders dalam mengembangkan pola hubungan sebab akibat",value_8)
        };

        recyclerview_data[] data_rec_J = new recyclerview_data[]{
                new recyclerview_data("Menjelaskan metode dan quality tools yang digunakan untuk mencari dan memilih ide perbaikan serta menentukan penanggulangan",value_4),
                new recyclerview_data("Menjelaskan kreatifitas team & stakeholders dalam menemukan alternatif solusi (improvement actions) dan parameter kelebihan serta analisa resiko (kekurangannya)",value_4),
                new recyclerview_data("Menjelaskan keterlibatan team & stakeholders dalam menemukan alternatif solusi (improvement actions) dan parameter kelebihan serta analisa resiko (kekurangannya)",value_4)
        };

        recyclerview_data[] data_rec_K = new recyclerview_data[]{
                new recyclerview_data("Menjelaskan tentang final solutions/improvement actions, validasi dan benefit/kemampuan dalam menjawab kebutuhan yang diharapkan terhadap inovasi/improvement actions yang akan dilakukan",value_8),
                new recyclerview_data("Menguraikan detail rencana project (5W2H), termasuk distribusi peranan dan keterlibatan stakeholders dalam melakukan perbaikan ",value_8)
        };

        recyclerview_data[] data_rec_L = new recyclerview_data[]{
                new recyclerview_data("Memiliki sistem pantau (monitoring) atas proses pelaksanaan tindakan perbaikan yang dilakukan",value_1),
                new recyclerview_data("Menjelaskan bagaimana mengidentifikasikan serta mengalokasikan hambatan-hambatan (baik yang nyata atau potensial) yang muncul, serta memastikan keterlibatan team & stakeholders untuk meyepakati (buy-in) atas corrective action yang telah ditentukan serta dampaknya",value_1)
        };

        recyclerview_data[] data_rec_M = new recyclerview_data[]{
                new recyclerview_data("Semua anggota Tim memahami perubahan-perubahan yang terjadi di dalam improvement yang dibuat terhadap kondisi sebelumnya (kondisi awal)",value_1)
        };

        recyclerview_data[] data_rec_N = new recyclerview_data[]{
                new recyclerview_data("Ada analisis komparasi yg valid & tepat serta kesimpulan analisis/faktor penyebab yg belum teratasi",value_2),
                new recyclerview_data("Tools yang dipakai, alasan penggunaan & hasilnya",value_2)
        };

        recyclerview_data[] data_rec_O = new recyclerview_data[]{
                new recyclerview_data("Manfaat tangible & intangible",value_3),
                new recyclerview_data("Ada hasil-hasil positif lain yang timbul, tapi bukan sasaran penanggulangan/perbaikan yang telah dilaksanakan",value_3),
                new recyclerview_data("Ada analisis dampak terhadap hasil-hasil lain (apakah hasil perbaikan menimbulkan efek samping?) Bila ada, bagaimana tindakan untuk eliminasi hal tersebut? Hasilnya efisien?",value_3)
        };

        recyclerview_data[] data_rec_P = new recyclerview_data[]{
                new recyclerview_data("Proyek perbaikan memberikan kontribusi/ dampak nyata terhadap tujuan perusahaan/plant/divisi/departement  dan stakeholders",value_1)
        };

        recyclerview_data[] data_rec_Q = new recyclerview_data[]{
                new recyclerview_data("Pendekatan sistem atas standar baru Meliputi standar masukan, proses dan hasil. Dan standar baru tersebut mudah dipahami (informatif)",value_4),
                new recyclerview_data("Kualitas standar pengendalian dan pencegahan terhadap timbulnya masalah (lama atau baru)",value_4),
                new recyclerview_data("Standar baru lebih efektif dan aplikatif dari pada sebelumnya",value_4),
                new recyclerview_data("Standar baru telah dikomunikasikan, sudah diserah terimakan dan dapat diterapkan di tempat lain",value_4),
                new recyclerview_data("Bila terjadi non-conformance (ada peringatan otomatis/tidak otomatis/tidak ada peringatan)",value_4)
        };

        recyclerview_data[] data_rec_R = new recyclerview_data[]{
                new recyclerview_data("Memiliki kegiatan/tahapan/aktifitas yang menjamin pelaksanaan standar baru secara efektif",value_5),
                new recyclerview_data("Memiliki cara melakukan monitoring dan mengevaluasi standar baru",value_5)
        };

        recyclerview_data[] data_rec_S = new recyclerview_data[]{
                new recyclerview_data("Identifikasi & Penetapan Rencana Berikutnya ",value_6)
        };


        //DATA PENILAIAN SS

        recyclerview_data[] data_ss_A = new recyclerview_data[]{
                new recyclerview_data("Melakukan identifikasi dan membuat stratifikasi masalah",value_12),
                new recyclerview_data("Memilih project improvement/inovasi berdasarkan data & fakta melalui penggunaan quality methode dan tools secara maksimal ( baik & benar )",value_12),
                new recyclerview_data("Menjelaskan alasan kenapa proyek perbaikan tersebut dipilih",value_12)
        };

        recyclerview_data[] data_ss_B = new recyclerview_data[]{
                new recyclerview_data("Menjelaskan proyek perbaikan yang terseleksi mempunyai potensi pengaruh positif terhadap permasalahan di tempat kerja",value_10),
                new recyclerview_data("Teridentifikasi tingkat kesulitan masalah/pelaksanaan perbaikan dari proyek yang terseleksi",value_10),
                new recyclerview_data("Tercermin harapan customer dan/atau stakeholders terhadap proyek perbaikan yang akan dilaksanakan",value_4)
        };

        recyclerview_data[] data_ss_C = new recyclerview_data[]{
                new recyclerview_data("Mengidentifikasi stakeholders yang bisa involve maupun yang dapat memberikan support dalam proyek perbaikan",value_4),
                new recyclerview_data("Mengidentifikasi stakeholders yang resisten (menghambat), sehingga menjadikan tantangan terhadap proyek perbaikan",value_4),
                new recyclerview_data("Menjelaskan bagaimana mereka (stakeholders) akan bisa memberikan dampak positif terhadap proyek perbaikan (Improvement/inovasi)",value_4)
        };

        recyclerview_data[] data_ss_D = new recyclerview_data[]{
                new recyclerview_data("Akar masalah teridentifikasi dengan jelas dan dapat dibuktikan",value_8),
                new recyclerview_data("Munculnya akar penyebab dari akar masalah pada suatu faktor yang telah dikembangkan",value_11),
                new recyclerview_data("Identifikasi dan validasi (memiliki akurasi penentuan) faktor penyebab dominan (akar penyebab masalah utama)",value_10),
                new recyclerview_data("Kesesuaian masalah dengan prioritas penanganan faktor penyebab dominan",value_12)
        };

        recyclerview_data[] data_ss_E = new recyclerview_data[]{
                new recyclerview_data("Aktualisasi dan keterlibatan peserta & stakeholders dalam mengembangkan pola hubungan sebab akibat",value_8)
        };

        recyclerview_data[] data_ss_F = new recyclerview_data[]{
                new recyclerview_data("Menjelaskan metode dan quality tools yang digunakan untuk mencari dan memilih ide perbaikan serta menentukan penanggulangan",value_12),
                new recyclerview_data("Menjelaskan kreatifitas peserta & stakeholders dalam menemukan alternatif solusi (improvement actions) dan parameter kelebihan serta analisa resiko (kekurangannya)",value_12),
                new recyclerview_data("Menjelaskan keterlibatan peserta & stakeholders dalam menemukan alternatif solusi (improvement actions) dan parameter kelebihan serta analisa resiko (kekurangannya)",value_12)
        };

        recyclerview_data[] data_ss_G = new recyclerview_data[]{
                new recyclerview_data("Menjelaskan tentang final solutions/improvement actions, validasi dan benefit/kemampuan dalam menjawab kebutuhan yang diharapkan terhadap inovasi/improvement actions yang akan dilakukan",value_13),
                new recyclerview_data("Menguraikan detail rencana project (5W2H), termasuk distribusi peranan dan keterlibatan stakeholders dalam melakukan perbaikan ",value_13)
        };

        recyclerview_data[] data_ss_H = new recyclerview_data[]{
                new recyclerview_data("Memiliki sistem pantau (monitoring) atas proses pelaksanaan tindakan perbaikan yang dilakukan",value_1),
                new recyclerview_data("Menjelaskan bagaimana mengidentifikasikan serta mengalokasikan hambatan-hambatan (baik yang nyata atau potensial) yang muncul, serta memastikan keterlibatan team & stakeholders untuk meyepakati (buy-in) atas corrective action yang telah ditentukan serta dampaknya",value_1)
        };

        recyclerview_data[] data_ss_I = new recyclerview_data[]{
                new recyclerview_data("Peserta memahami perubahan-perubahan yang terjadi di dalam improvement yang dibuat terhadap kondisi sebelumnya (kondisi awal)",value_1)
        };

        recyclerview_data[] data_ss_J = new recyclerview_data[]{
                new recyclerview_data("Ada analisis komparasi yg valid & tepat serta kesimpulan analisis/faktor penyebab yg belum teratasi",value_2),
                new recyclerview_data("Tools yang dipakai, alasan penggunaan & hasilnya",value_2)
        };

        recyclerview_data[] data_ss_K = new recyclerview_data[]{
                new recyclerview_data("Manfaat tangible & intangible",value_3),
                new recyclerview_data("Ada hasil-hasil positif lain yang timbul, tapi bukan sasaran penanggulangan/perbaikan yang telah dilaksanakan",value_3),
                new recyclerview_data("Ada analisis dampak terhadap hasil-hasil lain (apakah hasil perbaikan menimbulkan efek samping?) Bila ada, bagaimana tindakan untuk eliminasi hal tersebut? Hasilnya efisien?",value_3)
        };

        recyclerview_data[] data_ss_L = new recyclerview_data[]{
                new recyclerview_data("Proyek perbaikan memberikan kontribusi/ dampak nyata terhadap tujuan perusahaan/plant/divisi/departement  dan stakeholders",value_1)
        };

        recyclerview_data[] data_ss_M = new recyclerview_data[]{
                new recyclerview_data("Pendekatan sistem atas standar baru Meliputi standar masukan, proses dan hasil. Dan standar baru tersebut mudah dipahami (informatif)",value_4),
                new recyclerview_data("Kualitas standar pengendalian dan pencegahan terhadap timbulnya masalah (lama atau baru)",value_4),
                new recyclerview_data("Standar baru lebih efektif dan aplikatif dari pada sebelumnya",value_4),
                new recyclerview_data("Standar baru telah dikomunikasikan, sudah diserah terimakan dan dapat diterapkan di tempat lain",value_4),
                new recyclerview_data("Bila terjadi non-conformance (ada peringatan otomatis/tidak otomatis/tidak ada peringatan)",value_4)
        };

        recyclerview_data[] data_ss_N = new recyclerview_data[]{
                new recyclerview_data("Memiliki kegiatan/tahapan/aktifitas yang menjamin pelaksanaan standar baru secara efektif",value_5),
                new recyclerview_data("Memiliki cara melakukan monitoring dan mengevaluasi standar baru",value_5)
        };

        recyclerview_data[] data_ss_O = new recyclerview_data[]{
                new recyclerview_data("Identifikasi & Penetapan Rencana Berikutnya ",value_6)
        };

        if (list_item_penilaian.kode_sub_penilaian.equals("qcc_a")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_A,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_b")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_B,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_c")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_C,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_d")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_D,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_e")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_E,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_f")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_F,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_g")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_G,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_h")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_H,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_i")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_I,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_j")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_J,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_k")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_K,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_l")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_L,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_m")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_M,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_n")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_N,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_o")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_O,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_p")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_P,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_q")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_Q,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_r")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_R,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("qcc_s")){
            adapter_recycler_ = new adapter_sub_penilaian(data_rec_S,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_a")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_A,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_b")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_B,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_c")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_C,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_d")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_D,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_e")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_E,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_f")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_F,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_g")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_G,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_h")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_H,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_i")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_I,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_j")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_J,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_k")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_K,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_l")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_L,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_m")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_M,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_n")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_N,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else if(list_item_penilaian.kode_sub_penilaian.equals("ss_o")){
            adapter_recycler_ = new adapter_sub_penilaian(data_ss_O,sub_penilaian.this);
            recyclerView.setAdapter(adapter_recycler_);
        }else{}
        */

        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = database.getReference("data_nilai").child(login_page.jenis_juri).child(list_option_page.nama_circle).child(login_page.pembagian_juri);
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String data1 = dataSnapshot.child("a1").getValue(String.class);
                String data2 = dataSnapshot.child("a2").getValue(String.class);
                String data3 = dataSnapshot.child("a3").getValue(String.class);
                if(data1.equals("")){

                }else{
                    autoCompleteTextView.setText(data1,false);
                    autoCompleteTextView1.setText(data2,false);
                    autoCompleteTextView2.setText(data3,false);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(sub_penilaian.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(sub_penilaian.this,list_item_penilaian.class));
    }
    public void input_database(View view) {

        Toast.makeText(sub_penilaian.this,recyclerView.getChildAdapterPosition(view), Toast.LENGTH_SHORT).show();

        /*if(autoCompleteTextView.getText().toString().equals("") || autoCompleteTextView1.getText().toString().equals("")||autoCompleteTextView2.getText().toString().equals("")){
            Toast.makeText(sub_penilaian.this, "Mohon lengkapi data terlebih dahulu!", Toast.LENGTH_SHORT).show();
        }else{
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("data_nilai").child(login_page.jenis_juri).child(list_option_page.nama_circle).child(login_page.pembagian_juri);
            myRef.child("a1").setValue(autoCompleteTextView.getText().toString());
            myRef.child("a2").setValue(autoCompleteTextView1.getText().toString());
            myRef.child("a3").setValue(autoCompleteTextView2.getText().toString());
            Toast.makeText(sub_penilaian.this, "Nilai Dimasukkan", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(sub_penilaian.this,list_item_penilaian.class));
        }*/
    }
}