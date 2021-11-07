package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Menu extends AppCompatActivity {
TabItem home , calculator , exercice ;
TabLayout tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        home=findViewById(R.id.home);
        calculator=findViewById(R.id.calculator);
        exercice=findViewById(R.id.exercices);
        tab=findViewById(R.id.lay);
        getSupportFragmentManager().beginTransaction().replace(R.id.homeframe,HomeFragment.newInstance()).commit();
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.homeframe, HomeFragment.newInstance()).commit();
                }
                if (tab.getPosition() == 1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.homeframe, searchFragment.newInstance()).commit();
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}