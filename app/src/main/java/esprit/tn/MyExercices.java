package esprit.tn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MyExercices extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    MyExercicesDB myDB;
    ArrayList<String> exercice_id, exercice_title, exercice_category, exercice_duration;
    CustomAdapter customAdapter;
    ImageView empty_imageview;
    TextView no_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_exercices);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyExercices.this, AddExercices.class);
                startActivity(intent);
            }
        });

        myDB = new MyExercicesDB(MyExercices.this);
        exercice_id = new ArrayList<>();
        exercice_title = new ArrayList<>();
        exercice_category = new ArrayList<>();
        exercice_duration = new ArrayList<>();
        storeDataInArrays();

        customAdapter = new CustomAdapter(MyExercices.this,this, exercice_id, exercice_title, exercice_category,
                exercice_duration);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyExercices.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }
    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                exercice_id.add(cursor.getString(0));
                exercice_title.add(cursor.getString(1));
                exercice_category.add(cursor.getString(2));
                exercice_duration.add(cursor.getString(3));
            }


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.delete_all){
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure you want to delete all Data?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyExercicesDB myDB = new MyExercicesDB(MyExercices.this);
                myDB.deleteAllData();
                //Refresh Activity
                Intent intent = new Intent(MyExercices.this, MyExercices.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }


}