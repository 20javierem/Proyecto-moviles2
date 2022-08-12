package com.example.proyectomoviles2.common;


import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.IOException;

public class Common {

    public static FirebaseDatabase getDatabase(){
        return FirebaseDatabase.getInstance();
    }

}
