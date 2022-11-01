package com.example.meditrack;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.example.meditrack.adapters.TileAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainTiles extends AppCompatActivity {
    public static int time = 3;
    GridView gridViewShow, gridViewResult;
    TextView tvTime, tvTiles, tvScores;
    TileAdapter adapterResult, adapterShow;
    List<Boolean> results, shows;
    int tiles = 3, wins = 0, loses = 0, mScore = 0;
    public static double widthScreen = 0;
    int highscore = 0;
    Button button;
    LinearLayout tilesBackground;
    TextView congratsTile;
    ConstraintLayout congratsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainTiles.this,R.color.background));
        setContentView(R.layout.activity_main_tiles);

        ImageView back = findViewById(R.id.backTiles);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.meditrack.MemoryGames.class );
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
        // Set status bar color transparent
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        congratsTile = findViewById(R.id.congratsTile);
        congratsLayout = findViewById(R.id.congratsLayout);
        tilesBackground = findViewById(R.id.tilesBackground);
        // Initial
        Init();

        gridViewShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(time == 0) {
                    if (results.get(position)) { // Correct
                        shows.set(position, true);
                        adapterShow.notifyDataSetChanged();
                        // Check Complete
                        if(results.equals(shows)) {
                            Toast.makeText(MainTiles.this, "Correct! Next Round...",
                                    Toast.LENGTH_LONG).show();
                            wins++;
                            loses = 0;
                            // Calculator point
                            mScore++;


                            // Check chain wins
                            if(wins == 3 && tiles < 12) {
                                tiles++;
                                wins = 0;
                            }


                            // Restart game
                            RestartGame();
                        }
                    }else { // Incorrect
                        // Restart Game
                        Toast.makeText(MainTiles.this, "Wrong answer, play again!",
                                Toast.LENGTH_LONG).show();

                        loses++;
                        wins = 0;
                        // Calculator point
                        if(mScore != 0 || mScore== 0)
                        {

                            congratsLayout.setVisibility(View.VISIBLE);
                            congratsTile.setText("Congrats you got a score of: " + mScore);
                            tilesBackground.setBackgroundColor(Color.parseColor("#f5bfcb"));
                            mScore = 0;

                        }


                        if(tiles != 3)
                        {tiles=3;}

                        // Check chain loses

                        // Restart game
                        RestartGame();
                    }
                }
            }
        });
    }

    private void Init() {
        // Get device screen
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        widthScreen = size.x;
        gridViewShow = findViewById(R.id.myGridView);
        gridViewResult = findViewById(R.id.myGridViewResult);
        tvTime = findViewById(R.id.mTime);
        tvTiles = findViewById(R.id.mLevel);
        button =findViewById(R.id.button);
        tvScores = findViewById(R.id.mScore);
        results = new ArrayList<>();
        shows = new ArrayList<>();

        // Make a random tiles
        CreateRandomList();
        ChangedTextView();
        adapterResult = new TileAdapter(this, results);
        adapterShow = new TileAdapter(this, shows);
        gridViewShow.setAdapter(adapterShow);
        gridViewResult.setAdapter(adapterResult);
        StartTimer();
    }

    private void RestartGame() {
        try {
            ChangedTextView();
            CreateRandomList();
            gridViewResult.setVisibility(View.VISIBLE);
            adapterShow.notifyDataSetChanged();
            adapterResult.notifyDataSetChanged();
            StartTimer();
        } catch (Exception e) {
            Log.d("ERROR", e.toString());
        }
    }

    private void CreateRandomList() {
        Random random = new Random();
        int bound = 36;
        results.clear();
        shows.clear();
        if (tiles >= 10) {
            results.addAll(Collections.nCopies(100, false));
            shows.addAll(results);
            gridViewShow.setNumColumns(10);
            gridViewResult.setNumColumns(10);
            bound = 100;
        }else if (tiles >= 5) {
            results.addAll(Collections.nCopies(64, false));
            shows.addAll(results);
            gridViewShow.setNumColumns(8);
            gridViewResult.setNumColumns(8);
            bound = 64;
        } else {
            results.addAll(Collections.nCopies(36, false));
            shows.addAll(results);
            gridViewShow.setNumColumns(6);
            gridViewResult.setNumColumns(6);
            bound = 36;
        }
        for (int i = 0; i < tiles; i++) {
            int ranNum = random.nextInt(bound);
            while (results.get(ranNum)) {
                ranNum = random.nextInt(bound);
            }
            results.set(ranNum, true);
        }
    }

    private void StartTimer() {
        Timer timer = new Timer();
        time = 3;
        tvTime.setVisibility(View.VISIBLE);
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (time == 0) {
                    timer.cancel();
                    timer.purge();
                    tvTime.setVisibility(View.INVISIBLE);
                    gridViewResult.setVisibility(View.INVISIBLE);
                } else {
                    time--;
                    tvTime.setText(String.valueOf(time));
                }
            }
        }, 1000, 1000);
    }

    private void ChangedTextView() {
        tvTiles.setText("Tiles: " + tiles);
        tvScores.setText("Score: " + mScore);
    }

    public void hide(View view){
        congratsLayout.setVisibility(View.INVISIBLE);
        RestartGame();
        tilesBackground.setBackgroundColor(Color.parseColor("#F7F7FA"));
    }
    public void leave(View view){
        Intent intent = new Intent(this, com.example.meditrack.MemoryGames.class );
        startActivity(intent);
    }
}