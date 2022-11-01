package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainCall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainCall.this,R.color.dashboard_item3));
        setContentView(R.layout.activity_main_call);

        ImageView back = findViewById(R.id.callBack);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.meditrack.Navigation.class );
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });

        Button create = findViewById(R.id.createMeeting);
        create.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.meditrack.createMeeting.class );
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        Button join = findViewById(R.id.joinMeeting);
        join.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.meditrack.joinMeeting.class );
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

    }
}