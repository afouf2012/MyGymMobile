package com.example.fitnessapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitnessapp.entities.Programme;

import java.util.ArrayList;
import java.util.List;


public class searchFragment extends Fragment {
    TextView text;
    Button btnserach;
    List<Programme> prog = new ArrayList<>();
    RecyclerView recyclerView;
    Progadapter adap;


    public searchFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static searchFragment newInstance() {
        searchFragment fragment = new searchFragment();
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
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        btnserach = view.findViewById(R.id.btnrechercher);
        text =view.findViewById(R.id.rechercher);

        btnserach.setOnClickListener(view1 -> {
            String test = text.getText().toString();
            Context context = view.getContext();

            prog= reshprogs(test);
            recyclerView = view.findViewById(R.id.prog);
            adap = new Progadapter(prog,context);
            recyclerView.setAdapter(adap);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL,false));
            setprogs();
        });
        return view;

    }
    private void setprogs()
    {
        prog.add(new Programme( "book","action hhhhhhhhhhhhhhhhhdfqqqq",R.drawable._fb1b8586491f9c91a6db0f83863950b ));
        prog.add(new Programme( "book","dramahhhhhhhhhhhhhhhhhdfqqqq",R.drawable._fb1b8586491f9c91a6db0f83863950b ));
        prog.add(new Programme( "book","actiohhhhhhhhhhhhhhhhhdfqqqqn",R.drawable._fb1b8586491f9c91a6db0f83863950b ));
        prog.add(new Programme( "book4","dramhhhhhhhhhhhhhhhhhdfqqqqa",R.drawable._fb1b8586491f9c91a6db0f83863950b ));
        prog.add(new Programme( "book5","actihhhhhhhhhhhhhhhhhdfqqqqon",R.drawable._fb1b8586491f9c91a6db0f83863950b ));
        prog.add(new Programme( "book6","dramhhhhhhhhhhhhhhhhhdfqqqqa",R.drawable._fb1b8586491f9c91a6db0f83863950b ));
        prog.add(new Programme( "book1","acthhhhhhhhhhhhhhhhhdfqqqqhhhhhhhhhhhhhhhhhdfqqqqion",R.drawable._fb1b8586491f9c91a6db0f83863950b ));
        prog.add(new Programme( "book2","drama",R.drawable._fb1b8586491f9c91a6db0f83863950b));
        prog.add(new Programme( "book3","action",R.drawable._fb1b8586491f9c91a6db0f83863950b));
        prog.add(new Programme( "book4","drama",R.drawable._fb1b8586491f9c91a6db0f83863950b ));
        prog.add(new Programme( "book5","action",R.drawable._fb1b8586491f9c91a6db0f83863950b ));
        prog.add(new Programme( "book6","drama",R.drawable._fb1b8586491f9c91a6db0f83863950b ));
    }
    private  List<Programme> reshprogs(String find)
    {
        List<Programme> prog1 = new ArrayList<>();
        for (Programme b :prog)
        {
            if(b.getCategorie().equals(find))
            {
                prog1.add(b);
            }
        }
        return prog1;
    }
}