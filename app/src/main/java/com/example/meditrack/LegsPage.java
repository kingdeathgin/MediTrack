package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meditrack.legs_popups.BuergersDiseasePopup;
import com.example.meditrack.legs_popups.HSPPopup;
import com.example.meditrack.legs_popups.PTTDPopup;


public class LegsPage extends AppCompatActivity implements View.OnClickListener {

    private Button backButton, bDiseaseButton,hspButton, pttdButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.leg_page, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.leg_page));
        }
        setContentView(R.layout.activity_legs_page);

        backButton = (Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(this);

        bDiseaseButton = (Button)findViewById(R.id.bgDiseaseButton);
        bDiseaseButton.setOnClickListener(this);

        hspButton = (Button)findViewById(R.id.hspButton);
        hspButton.setOnClickListener(this);

        pttdButton = (Button)findViewById(R.id.pttdButton);
        pttdButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backButton:
                startActivity(new Intent(LegsPage.this, DiseaseMainActivity.class));
                break;
            case R.id.pttdButton:
                startActivity(new Intent(LegsPage.this, PTTDPopup.class));
                break;
            case R.id.bgDiseaseButton:
                startActivity(new Intent(LegsPage.this, BuergersDiseasePopup.class));
                break;
            case R.id.hspButton:
                startActivity(new Intent(LegsPage.this, HSPPopup.class));
                break;
        }
    }
}