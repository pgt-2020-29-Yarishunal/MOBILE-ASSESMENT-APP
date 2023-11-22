package com.example.aplikasipenjurianqcc_ss;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class grid_adapter_list_pen extends BaseAdapter {
    Context konteks;
    String[] teks_judul_sub_nilai,sub_database;
    LayoutInflater inflater;

    public grid_adapter_list_pen(Context konteks, String[] judul,String[] data_) {
        this.konteks = konteks;
        this.teks_judul_sub_nilai = judul;
        this.sub_database = data_;
    }

    @Override
    public int getCount() {
        return teks_judul_sub_nilai.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater==null)
            inflater = (LayoutInflater) konteks.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){
            convertView = inflater.inflate(R.layout.grid_component_list_pen,null);
        }

        TextView teks_judul = (TextView)convertView.findViewById(R.id.teks_judul_sub);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = database.getReference("data_nilai").child(admin_page.tipe_penjurian).child(list_option_page.nama_circle).child(login_page.pembagian_juri);
        View finalConvertView = convertView;
        myRef1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data_fetch = snapshot.child(sub_database[position]).getValue(String.class);
                if(data_fetch.contains(login_page.nip_juri)){
                    finalConvertView.setBackground(ContextCompat.getDrawable(konteks,R.drawable.shape_back_grid));
                }else{}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        teks_judul.setText(teks_judul_sub_nilai[position]);

        return convertView;
    }
}
