package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meditrack.stomach_popups.CeliacDiseasePopup;
import com.example.meditrack.stomach_popups.ChronsDiseasePopup;
import com.example.meditrack.stomach_popups.MalabsorptionPopup;


public class StomachPage extends AppCompatActivity implements View.OnClickListener {

    private Button backButton, celiacButton,chronsButton, malabButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.stomach_page, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.stomach_page));
        }
        setContentView(R.layout.activity_stomach_page);

        backButton = (Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(this);

        celiacButton = (Button)findViewById(R.id.celiacButton);
        celiacButton.setOnClickListener(this);

        chronsButton = (Button)findViewById(R.id.chronsButton);
        chronsButton.setOnClickListener(this);

        malabButton = (Button)findViewById(R.id.malabButton);
        malabButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backButton:
                startActivity(new Intent(StomachPage.this, DiseaseMainActivity.class));
                break;
            case R.id.chronsButton:
                startActivity(new Intent(StomachPage.this, ChronsDiseasePopup.class));
                break;
            case R.id.celiacButton:
                startActivity(new Intent(StomachPage.this, CeliacDiseasePopup.class));
                break;
            case R.id.malabButton:
                startActivity(new Intent(StomachPage.this, MalabsorptionPopup.class));
                break;
        }
    }
}