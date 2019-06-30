package com.example.govconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private RecyclerView postlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=( DrawerLayout) findViewById( R.id.draw_layout );
        navigationView=(NavigationView)findViewById( R.id.nav_view );
        View navView=navigationView.inflateHeaderView( R.layout.nav_header );

        navigationView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                MenuItem item=null;
                UserMenuSelector(item);
                return false;
            }
        } );

    }
    private void UserMenuSelector(MenuItem item){

    }
    //This is a cmnt.
}