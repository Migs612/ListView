package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public abstract class Adaptador extends BaseAdapter {
    private ArrayList<MainActivity.Encapsulador> entradas;
    private int layoutIdView;
    private Context contexto;

    public Adaptador(Context contexto, int layoutIdView, ArrayList<MainActivity.Encapsulador> entradas) {
        this.contexto = contexto;
        this.layoutIdView = layoutIdView;
        this.entradas = entradas;
    }

    @Override
    public int getCount() {
        return entradas.size();
    }

    @Override
    public Object getItem(int position) {
        return entradas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(layoutIdView, null);
        }
        onEntrada(entradas.get(position), convertView);
        return convertView;
    }

    public abstract void onEntrada(Object entrada, View view);
}
