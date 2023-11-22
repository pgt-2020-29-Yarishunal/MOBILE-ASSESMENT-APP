package com.example.aplikasipenjurianqcc_ss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class grid_adapter extends BaseAdapter {
    Context konteks;
    String[] teks_nama_team_grid;
    String[] teks_dept_grid;
    LayoutInflater inflater;

    public grid_adapter(Context konteks, String[] nama_team,String[] nama_dept) {
        this.konteks = konteks;
        this.teks_nama_team_grid = nama_team;
        this.teks_dept_grid = nama_dept;
    }

    @Override
    public int getCount() {
        return teks_nama_team_grid.length;
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
            convertView = inflater.inflate(R.layout.grid_component,null);
        }

        TextView teks_tim = (TextView)convertView.findViewById(R.id.teks_nama_team_grid);
        TextView teks_dept = (TextView)convertView.findViewById(R.id.teks_nama_dept_grid);

        teks_tim.setText(teks_nama_team_grid[position]);
        teks_dept.setText(teks_dept_grid[position]);

        return convertView;
    }
}
