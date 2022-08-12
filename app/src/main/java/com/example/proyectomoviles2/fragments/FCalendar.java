package com.example.proyectomoviles2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectomoviles2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FCalendar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FCalendar extends Fragment {

    public FCalendar(){

    }
    public static FCalendar newInstance() {
        return new FCalendar();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_f_calendar, container, false);
    }
}