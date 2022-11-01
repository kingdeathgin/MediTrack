package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meditrack.lungs_popups.AsthmaPopup;
import com.example.meditrack.lungs_popups.BronchitisPopup;
import com.example.meditrack.lungs_popups.PneumoniaPopup;
import com.example.meditrack.lungs_popups.PulmonaryEdemaPopup;

public class LungsPage extends AppCompatActivity implements View.OnClickListener {

    private Button backButton, asthmaButton,bronchitisButton, pneumoniaButton,pulmonaryEdemaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.lung_page, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.lung_page));
        }
        setContentView(R.layout.activity_lungs_page);

        backButton = (Button)findViewById(R.id.backButtonHead);
        backButton.setOnClickListener(this);

        asthmaButton = (Button)findViewById(R.id.asthmaButton);
        asthmaButton.setOnClickListener(this);

        bronchitisButton = (Button)findViewById(R.id.bronchitisButton);
        bronchitisButton.setOnClickListener(this);

        pneumoniaButton = (Button)findViewById(R.id.pneumoniaButton);
        pneumoniaButton.setOnClickListener(this);

        pulmonaryEdemaButton = (Button)findViewById(R.id.pulmonaryEdemaButton);
        pulmonaryEdemaButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backButtonHead:
                startActivity(new Intent(LungsPage.this, DiseaseMainActivity.class));
                break;
            case R.id.asthmaButton:
                startActivity(new Intent(LungsPage.this, AsthmaPopup.class));
                break;
            case R.id.bronchitisButton:
                startActivity(new Intent(LungsPage.this, BronchitisPopup.class));
                break;
            case R.id.pneumoniaButton:
                startActivity(new Intent(LungsPage.this, PneumoniaPopup.class));
                break;
            case R.id.pulmonaryEdemaButton:
                startActivity(new Intent(LungsPage.this, PulmonaryEdemaPopup.class));
                break;
        }
    }
}