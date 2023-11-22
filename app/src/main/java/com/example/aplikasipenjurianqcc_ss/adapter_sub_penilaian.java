package com.example.aplikasipenjurianqcc_ss;

import static java.lang.Integer.valueOf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class adapter_sub_penilaian extends RecyclerView.Adapter<adapter_sub_penilaian.ViewHolder> {
    public static String nama_cricle_;
    Context konteks;
    recyclerview_data[] data_recycler;
    Double jumlah_awal;

    public adapter_sub_penilaian(recyclerview_data[] data_recycler_, hasil_penilaian design_recycler){
        this.konteks = design_recycler;
        this.data_recycler = data_recycler_;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_penilaian_component,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final recyclerview_data my_data_list = data_recycler[position];
        holder.desk.setText(my_data_list.getTeks_desk());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("data_nilai").child(admin_page.tipe_penjurian).child(my_data_list.getTeks_desk()).child(login_page.pembagian_juri);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                jumlah_awal = 0.00;
                for (DataSnapshot i:dataSnapshot.getChildren()) {
                    String data_awal = i.getValue().toString();
                    if(data_awal.equals("")){jumlah_awal = jumlah_awal + 0;}else{
                        if(data_awal.contains(login_page.nip_juri)){
                            if(data_awal.contains(",")){
                                String[] split_1 = data_awal.split(",");
                                for (int j=0;j< split_1.length;j++) {
                                    if (split_1[j].contains(login_page.nip_juri)) {
                                        jumlah_awal = jumlah_awal+ Double.parseDouble(split_1[j].split(":")[1]);
                                        break;
                                    }
                                }
                            }else{
                                jumlah_awal = jumlah_awal + Double.parseDouble(data_awal.split(":")[1]);
                            }

                        }else{jumlah_awal = jumlah_awal + 0;}

                    }
                }
                holder.nilai.setText(String.valueOf(jumlah_awal));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(konteks, "Gagal Mengambil Data", Toast.LENGTH_SHORT).show();

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama_cricle_ = my_data_list.getTeks_desk();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data_recycler.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView desk,nilai;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            desk = itemView.findViewById(R.id.nama_tim);
            nilai = itemView.findViewById(R.id.jmlh_score);
        }

    }

}
