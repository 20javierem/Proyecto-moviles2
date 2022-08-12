package com.example.proyectomoviles2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.proyectomoviles2.adapters.DinerAdapter;
import com.example.proyectomoviles2.fragments.FCalendar;
import com.example.proyectomoviles2.fragments.FDiner;
import com.example.proyectomoviles2.fragments.FFood;
import com.example.proyectomoviles2.fragments.FHome;
import com.example.proyectomoviles2.models.Diner;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private NavigationView nav_view;
    private FHome home;
    private FCalendar calendar;
    private FFood food;
    private FDiner diner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawer_layout);
        nav_view=findViewById(R.id.nav_view);
        init();
    }
    private void init(){
        calendar=new FCalendar();
        diner=new FDiner();
        home=new FHome();
        food=new FFood();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");
        System.out.println("baaaaaaaaaaaaaaaaaaaaaaaa---------------"+myRef.getDatabase().getApp());
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, home).commit();
                        break;
                    case R.id.nav_calendar:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, calendar).commit();
                        break;
                    case R.id.nav_food:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, food).commit();
                        break;
                    case R.id.nav_diner:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, diner).commit();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}