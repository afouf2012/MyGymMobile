package com.example.fitnessapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.fitnessapp.entities.Programme;

import java.util.ArrayList;
import java.util.List;

public class Progadapter extends RecyclerView.Adapter<Progadapter.MyViewHolder> {

    List<Programme> Prog;

    private ArrayList progimage, category, description;
    Context context;

    public Progadapter( ArrayList progimage, ArrayList category, ArrayList description, Context context) {

        this.progimage = progimage;
        this.category = category;
        this.description = description;
        this.context = context;
    }


    public Progadapter(List<Programme> Prog, Context context)
    {
        this.Prog = Prog;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemprog,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Programme b =Prog.get(position) ;

        holder.categorie.setText(String.valueOf(category.get(position)));
        holder.description.setText(String.valueOf(description.get(position)));
        holder.progimage.setImageResource(Integer.parseInt(String.valueOf(progimage.get(position))));
    }

    @Override
    public int getItemCount() {

        return description.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView progimage;
        TextView categorie;
        TextView description;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            progimage=itemView.findViewById(R.id.progimage);
            categorie=itemView.findViewById(R.id.categorie);
            description=itemView.findViewById(R.id.description);

        }
    }



}
