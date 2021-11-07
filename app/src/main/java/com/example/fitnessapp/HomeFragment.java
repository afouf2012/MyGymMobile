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

import com.example.fitnessapp.entities.Programme;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    List<Programme> prog = new ArrayList<>();
    RecyclerView recyclerView;
    Progadapter adap;
    Button btn;


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
        recyclerView = view.findViewById(R.id.prog);
        adap = new Progadapter(prog,context);
        recyclerView.setAdapter(adap);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL,false));
        btn.setOnClickListener(view1 -> {
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.homeframe, new searchFragment()).commit();
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
        prog.add(new Programme( "h","drama","ttttttttttttt",R.drawable._fb1b8586491f9c91a6db0f83863950b));
        prog.add(new Programme( "f","drama","ttttttttttttt",R.drawable._fb1b8586491f9c91a6db0f83863950b));
    }

}