package com.example.proyectomoviles2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.proyectomoviles2.R;
import com.example.proyectomoviles2.adapters.DinerAdapter;
import com.example.proyectomoviles2.models.Diner;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.LinkedList;
import java.util.List;

public class FDiner extends Fragment {
    private ListView listView;

    public FDiner(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_f_diner, container, false);
        listView=view.findViewById(R.id.listView);
        List<Diner> dinerList=Diner.all();
        ArrayAdapter<Diner> adapter=new DinerAdapter(view.getContext(),0,dinerList);
        listView.setAdapter(adapter);
        return view;
    }
}