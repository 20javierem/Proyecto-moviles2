package com.example.proyectomoviles2.models;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diner {

    private Integer id;
    private String names;
    private String lastNames;
    private boolean male;
    private String dni;
    private String phone;
    private boolean active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public static List<Diner> all(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference=database.getReference("Diner_tbl");
        List<Diner> diners=new ArrayList<>();
        Map<Integer,Diner> dinerMap=new HashMap<>();
        reference.orderByChild("id").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Diner diner=dataSnapshot.getValue(Diner.class);
                diners.add(diner);
                dinerMap.put(diner.getId(),diner);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Diner dinerUpdate=dataSnapshot.getValue(Diner.class);
                Diner diner=dinerMap.get(dinerUpdate.getId());
                diner=diners.get(diners.indexOf(diner));
                diner.setActive(dinerUpdate.isActive());
                diner.setMale(dinerUpdate.isMale());
                diner.setPhone(dinerUpdate.getPhone());
                diner.setNames(dinerUpdate.getNames());
                diner.setLastNames(diner.getLastNames());
                System.out.println("ocurrió un cambio");
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Diner dinerUpdate=dataSnapshot.getValue(Diner.class);
                Diner diner=dinerMap.get(dinerUpdate.getId());
                diners.remove(diner);
                dinerMap.remove(dinerUpdate.getId());
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return diners;
    }
}
