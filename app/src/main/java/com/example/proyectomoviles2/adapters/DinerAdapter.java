package com.example.proyectomoviles2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.proyectomoviles2.R;
import com.example.proyectomoviles2.models.Diner;

import java.util.List;

public class DinerAdapter extends ArrayAdapter<Diner> {
    private List<Diner> diners;
    private Context context;

    public DinerAdapter(Context context, int resource, List<Diner> diners) {
        super(context, resource, diners);
        this.diners=diners;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout= LayoutInflater.from(context).inflate(R.layout.item_diner,parent,false);
        Diner product=diners.get(position);
        TextView name=layout.findViewById(R.id.nameDiner);
        TextView price=layout.findViewById(R.id.phoneDiner);
        name.setText(product.getNames());
        price.setText(product.getPhone());
        return layout;
    }
}
