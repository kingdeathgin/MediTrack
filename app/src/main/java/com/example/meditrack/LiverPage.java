package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meditrack.liver_popups.LiverCancerPopup;
import com.example.meditrack.liver_popups.FattyLiverDiseasePopup;
import com.example.meditrack.liver_popups.HepatitisPopup;


public class LiverPage extends AppCompatActivity implements View.OnClickListener {

    private Button backButton, hepatitisButton,fattyLiverDiseaseButton, liverCancerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.liver_page, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.liver_page));
        }
        setContentView(R.layout.activity_liver_page);

        backButton = (Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(this);

        hepatitisButton = (Button)findViewById(R.id.hepatitisButton);
        hepatitisButton.setOnClickListener(this);

        fattyLiverDiseaseButton = (Button)findViewById(R.id.fattyLiverDiseaseButton);
        fattyLiverDiseaseButton.setOnClickListener(this);

        liverCancerButton = (Button)findViewById(R.id.liverCancerButton);
        liverCancerButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backButton:
                startActivity(new Intent(LiverPage.this, DiseaseMainActivity.class));
                break;
            case R.id.hepatitisButton:
                startActivity(new Intent(LiverPage.this, HepatitisPopup.class));
                break;
            case R.id.fattyLiverDiseaseButton:
                startActivity(new Intent(LiverPage.this, FattyLiverDiseasePopup.class));
                break;
            case R.id.liverCancerButton:
                startActivity(new Intent(LiverPage.this, LiverCancerPopup.class));
                break;
        }
    }
}