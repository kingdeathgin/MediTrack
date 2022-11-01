package com.example.meditrack;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

public class NearMe extends AppCompatActivity {

    AppCompatButton hospitalButton, doctorsButton, pharmacyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.near_me);
        getWindow().setStatusBarColor(ContextCompat.getColor(NearMe.this,R.color.dashboard_item1));


        ImageView back = findViewById(R.id.backNearMe);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.meditrack.Navigation.class );
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });

        hospitalButton = findViewById(R.id.hospitalsButton);
        hospitalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.google.com/maps/search/hospitals+near+me/");
            }
        });
        doctorsButton = findViewById(R.id.doctorsOfficeButton);
        doctorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.google.com/maps/search/doctors+offices+near+me/");
            }
        });
        pharmacyButton = findViewById(R.id.pharmacyButton);
        pharmacyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.google.com/maps/search/pharmacy+near+me/");
            }
        });



    }

    private void goToUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
}