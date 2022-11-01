package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MemoryGames extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(MemoryGames.this,R.color.dashboard_item4));
        setContentView(R.layout.activity_memory_games);

        ConstraintLayout tileMatcher = findViewById(R.id.tileMatcher);
        ConstraintLayout imageMaker = findViewById(R.id.imageMaker);

        ImageView back = findViewById(R.id.backGames);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.meditrack.Navigation.class );
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
        tileMatcher.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.meditrack.MainTiles.class );
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        imageMaker.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.meditrack.MainImageActivity.class );
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        });
    }
}