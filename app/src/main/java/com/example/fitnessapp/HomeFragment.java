package com.example.fitnessapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.fitnessapp.entities.Programme;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    //List<Programme> prog = new ArrayList<>();
    RecyclerView recyclerView;
    Progadapter adap;
    Button btn;
    MyExercicesDB myDB;
    private ArrayList<String> progimage, category, description;
    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btn = view.findViewById(R.id.bttnprog);
        Context context = view.getContext();



        setprogs();
        myDB = new MyExercicesDB(HomeFragment.this.getContext());
        progimage= new ArrayList<>();
        category = new ArrayList<>();
        description = new ArrayList<>();
        storeDataInArrays();
        recyclerView = view.findViewById(R.id.prog);
        adap = new Progadapter(progimage,category,description,context);
        recyclerView.setAdapter(adap);
        recyclerView.setLayoutManager(new LinearLayoutManager(HomeFragment.this.getContext()));
        btn.setOnClickListener(view1 -> {
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.homeframe, new searchFragment()).commit();
        });
            return view;
    }

    private void setprogs()
    {

        MyExercicesDB myDB = new MyExercicesDB(HomeFragment.this.getContext());
        myDB.addExercices("Muscle deax ","abdo",R.drawable._fb1b8586491f9c91a6db0f83863950b );
        myDB.addExercices("Bras absorbante ","tette",R.drawable._fb1b8586491f9c91a6db0f83863950b );
        myDB.addExercices("Jambes bilateral kioshinkay","tette",R.drawable._fb1b8586491f9c91a6db0f83863950b );

        System.out.println("I added items ");


      //  prog.add()


    }


    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData2();


            while (cursor.moveToNext()){

                description.add(cursor.getString(1));
                category.add(cursor.getString(2));
                progimage.add(cursor.getString(3));
            }

    }


}