package com.example.esicc.a20170711listview;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ESicc on 2017/7/11.
 */

public class ViewAdapter extends BaseAdapter {

    private String[][] Elementdata;
    private LayoutInflater inflater;

    private static class ViewHolder {
        LinearLayout rlBorder;
        TextView name;
        TextView local;
    }

    public ViewAdapter(String[][] data, LayoutInflater inflater) {
        this.Elementdata = data;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return Elementdata.length;
    }

    @Override
    public Object getItem(int position) {
        return Elementdata[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            holder.local = (TextView) view.findViewById(R.id.textView2);
            holder.name = (TextView) view.findViewById(R.id.textView);
            holder.rlBorder = (LinearLayout) view.findViewById(R.id.llBorder);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if (Elementdata[position][0].equals("1")) {
            holder.local.setText("★");
            holder.name.setText(Elementdata[position][1]);
            holder.rlBorder.setBackgroundColor(Color.parseColor("#FFDBC9"));
        } else {
            holder.local.setText("");
            holder.name.setText("     " + Elementdata[position][1]);
        }
        return view;
    }
}
