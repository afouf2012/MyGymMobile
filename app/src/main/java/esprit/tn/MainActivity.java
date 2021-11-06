package esprit.tn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Imcbutton;
    private Button Chrono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Imcbutton=(Button) findViewById(R.id.imcbutton);
        Imcbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImcActivity();
            }
        });

        Chrono=(Button) findViewById(R.id.chrono);
        Chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChronoActivity();
            }
        });


    }

    public void openImcActivity(){
        Intent intent = new Intent(this,ImcActivity.class);
        startActivity(intent);
    }

    public void openChronoActivity(){
        Intent intent2 = new Intent(this,Chronometre.class);
        startActivity(intent2);
    }



}