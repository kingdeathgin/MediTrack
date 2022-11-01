package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DiseaseMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button headButton,armsButton,skinButton, heartButton,lungsButton,liverButton,stomachButton,anrecButton,intestinesButton,legsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(DiseaseMainActivity.this,R.color.disease_page));
        setContentView(R.layout.disease_activity_main);

        headButton = (Button) findViewById(R.id.headButton);
        headButton.setOnClickListener(this);

        armsButton = (Button) findViewById(R.id.armButton);
        armsButton.setOnClickListener(this);

        skinButton = (Button) findViewById(R.id.skinButton);
        skinButton.setOnClickListener(this);

        heartButton = (Button)findViewById(R.id.heartButton);
        heartButton.setOnClickListener(this);

        lungsButton = (Button)findViewById(R.id.lungButton);
        lungsButton.setOnClickListener(this);

        liverButton= (Button)findViewById(R.id.liverButton);
        liverButton.setOnClickListener(this);

        stomachButton = (Button)findViewById(R.id.stomachButton);
        stomachButton.setOnClickListener(this);

        anrecButton = (Button)findViewById(R.id.anrecButton);
        anrecButton.setOnClickListener(this);

        intestinesButton = (Button) findViewById(R.id.intestineButton);
        intestinesButton.setOnClickListener(this);

        legsButton = (Button)findViewById(R.id.legsButton);
        legsButton.setOnClickListener(this);

        ImageView back = findViewById(R.id.backDisease);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.meditrack.Navigation.class );
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.headButton:
                startActivity(new Intent(DiseaseMainActivity.this, HeadPage.class));
                break;
            case R.id.armButton:
                startActivity(new Intent(DiseaseMainActivity.this, ArmsPage.class));
                break;
            case R.id.skinButton:
                startActivity(new Intent(DiseaseMainActivity.this, SkinPage.class));
                break;

            case R.id.heartButton:
                startActivity(new Intent(DiseaseMainActivity.this, HeartPage.class));
                break;

            case R.id.lungButton:
                startActivity(new Intent(DiseaseMainActivity.this, LungsPage.class));
                break;

            case R.id.liverButton:
                startActivity(new Intent(DiseaseMainActivity.this, LiverPage.class));
                break;
            case R.id.stomachButton:
                startActivity(new Intent(DiseaseMainActivity.this, StomachPage.class));
                break;
            case R.id.anrecButton:
                startActivity(new Intent(DiseaseMainActivity.this, AnRecPage.class));
                break;
            case R.id.intestineButton:
                startActivity(new Intent(DiseaseMainActivity.this, IntestinesPage.class));
                break;
            case R.id.legsButton:
                startActivity(new Intent(DiseaseMainActivity.this, LegsPage.class));
                break;
        }
    }
}