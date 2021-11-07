package esprit.tn;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList exercice_id, exercice_title, exercice_category, exercice_duration;

    CustomAdapter(Activity activity, Context context, ArrayList exercice_id, ArrayList exercice_title, ArrayList exercice_category,
                  ArrayList exercice_duration){
        this.activity = activity;
        this.context = context;
        this.exercice_id = exercice_id;
        this.exercice_title = exercice_title;
        this.exercice_category = exercice_category;
        this.exercice_duration = exercice_duration;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.exercice_id_txt.setText(String.valueOf(exercice_id.get(position)));
        holder.exercice_title_txt.setText(String.valueOf(exercice_title.get(position)));
        holder.exercice_category_txt.setText(String.valueOf(exercice_category.get(position)));
        holder.exercice_duration_txt.setText(String.valueOf(exercice_duration.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateExercices.class);
                intent.putExtra("id", String.valueOf(exercice_id.get(position)));
                intent.putExtra("title", String.valueOf(exercice_title.get(position)));
                intent.putExtra("author", String.valueOf(exercice_category.get(position)));
                intent.putExtra("pages", String.valueOf(exercice_duration.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {

        return exercice_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView exercice_id_txt, exercice_title_txt, exercice_category_txt, exercice_duration_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            exercice_id_txt = itemView.findViewById(R.id.exercice_id_txt);
            exercice_title_txt = itemView.findViewById(R.id.exercice_title_txt);
            exercice_category_txt = itemView.findViewById(R.id.exercice_category_txt);
            exercice_duration_txt = itemView.findViewById(R.id.exercice_duration_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            //Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            //mainLayout.setAnimation(translate_anim);
        }

    }

}
