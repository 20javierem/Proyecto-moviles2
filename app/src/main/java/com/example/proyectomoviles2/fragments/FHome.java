package com.example.proyectomoviles2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.proyectomoviles2.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Duration;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FHome extends Fragment {
    private View view;
    public static FHome newInstance() {
        return new FHome();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void sendData() {
        System.out.println("enviar");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");
        Toast.makeText(view.getContext().getApplicationContext(),"enviado",Toast.LENGTH_LONG).show();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view=inflater.inflate(R.layout.fragment_f_home, container, false);
         Button buton= view.findViewById(R.id.btnSend);
         buton.setOnClickListener(v -> sendData());
        return view;
    }
}