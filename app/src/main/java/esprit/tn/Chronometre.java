package esprit.tn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class Chronometre extends AppCompatActivity {

    Chronometer chronometer;
    Button btnPlay, btnPause, btnStop;
    long countTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometre);

        chronometer = findViewById(R.id.chronometer);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnStop = findViewById(R.id.btnStop);


        // Start chronometer
        btnPlay.setOnClickListener(v -> {
            chronometer.setBase(SystemClock.elapsedRealtime() - countTime);
            chronometer.start();

            btnPause.setVisibility(View.VISIBLE);
            btnPlay.setVisibility(View.INVISIBLE);
            btnStop.setVisibility(View.INVISIBLE);
        });


        // Pause chronometer
        btnPause.setOnClickListener(v -> {
            chronometer.stop();
            countTime = SystemClock.elapsedRealtime() - chronometer.getBase();

            btnPlay.setVisibility(View.VISIBLE);
            btnPause.setVisibility(View.INVISIBLE);
            btnStop.setVisibility(View.VISIBLE);
        });


        // Reset chronometer
        btnStop.setOnClickListener(v -> {
            chronometer.stop();
            chronometer.setBase(SystemClock.elapsedRealtime());
            countTime = 0;

            btnStop.setVisibility(View.INVISIBLE);
        });
    }
}