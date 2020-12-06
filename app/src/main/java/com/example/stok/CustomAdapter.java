package com.example.stok;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Siparis> siparisList;

    public CustomAdapter(Activity activity,List<Siparis> listSiparis){
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.siparisList = listSiparis;
    }

    @Override
    public int getCount() {
        return siparisList.size();
    }

    @Override
    public Object getItem(int position) {
        return siparisList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View lineView;
        lineView = layoutInflater.inflate(R.layout.custom_layout,null);
        TextView textViewUrunAd = (TextView) lineView.findViewById(R.id.textViewUrunAd);
        TextView textViewUrunFiyat = (TextView) lineView.findViewById(R.id.textViewFiyat);
        TextView textViewUrunAdet = (TextView) lineView.findViewById(R.id.textViewAdet);

        Siparis siparis = siparisList.get(position);
        textViewUrunAd.setText(siparis.getUrunAdi());
        textViewUrunFiyat.setText(siparis.getUrunFiyat());
        textViewUrunAdet.setText(siparis.getUrunAdet());


        return lineView;
    }
}
