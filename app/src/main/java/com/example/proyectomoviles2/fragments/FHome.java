package com.example.proyectomoviles2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectomoviles2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FHome extends Fragment {

    public static FHome newInstance() {
        FHome fragment = new FHome();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f_home, container, false);
    }
}