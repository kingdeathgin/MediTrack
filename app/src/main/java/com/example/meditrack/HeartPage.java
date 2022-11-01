package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meditrack.heart_popups.CHDPopup;
import com.example.meditrack.heart_popups.CADPopup;
import com.example.meditrack.heart_popups.HeartArrhythmiaPopup;
import com.example.meditrack.heart_popups.DilatedCardiomyopathyPopup;
import com.example.meditrack.heart_popups.PulmonaryStenosisPopup;

public class HeartPage extends AppCompatActivity implements View.OnClickListener {

    private Button backButton,CHDButton,CADButton,heartArrhythmiaButton,dilatedCardiomyopathyButton,pulmonaryStenosisButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.heart_page, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.heart_page));
        }
        setContentView(R.layout.activity_heart_page);

        backButton = (Button) findViewById(R.id.backButtonHead);
        backButton.setOnClickListener(this);

        CHDButton = (Button) findViewById(R.id.chdButton);
        CHDButton.setOnClickListener(this);

        CADButton = (Button) findViewById(R.id.cadButton);
        CADButton.setOnClickListener(this);

        heartArrhythmiaButton = (Button) findViewById(R.id.heartarrhythButton);
        heartArrhythmiaButton.setOnClickListener(this);

        dilatedCardiomyopathyButton = (Button) findViewById(R.id.dilatedCardioButton);
        dilatedCardiomyopathyButton.setOnClickListener(this);

        pulmonaryStenosisButton = (Button)findViewById(R.id.pulmonaryStenosisButton);
        pulmonaryStenosisButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backButtonHead:
                startActivity(new Intent(HeartPage.this, DiseaseMainActivity.class));
                break;

            case R.id.cadButton:
                startActivity(new Intent(HeartPage.this, CADPopup.class));
                break;

            case R.id.chdButton:
                startActivity(new Intent(HeartPage.this, CHDPopup.class));
                break;

            case R.id.heartarrhythButton:
                startActivity(new Intent(HeartPage.this, HeartArrhythmiaPopup.class));
                break;

            case R.id.dilatedCardioButton:
                startActivity(new Intent(HeartPage.this, DilatedCardiomyopathyPopup.class));
                break;
            case R.id.pulmonaryStenosisButton:
                startActivity(new Intent(HeartPage.this, PulmonaryStenosisPopup.class));
                break;
        }
    }
}