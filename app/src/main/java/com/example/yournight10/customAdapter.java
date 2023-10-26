package com.example.yournight10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class customAdapter extends BaseAdapter {

    Context context;
    List<locales> lst;

    public customAdapter(Context context, List<locales> lst) {
        this.context = context;
        this.lst = lst;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageViewlocal;
        TextView textViewNombre;
        TextView textViewValoracion;
        TextView textViewDescripcion;

        locales l =lst.get(i);
        if (view==null)
            view= LayoutInflater.from(context).inflate(R.layout.listview_locales,null);

        imageViewlocal= view.findViewById(R.id.imageViewlocal);
        textViewNombre= view.findViewById(R.id.textViewNombre);
        textViewDescripcion= view.findViewById(R.id.textViewDescripcion);

        imageViewlocal.setImageResource(l.imagen);
        textViewNombre.setText(l.nombreL);
        textViewDescripcion.setText(l.descripcion);


        return view;
    }
}
