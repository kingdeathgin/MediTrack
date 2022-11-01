package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meditrack.arm_popups.BursitisPopup;
import com.example.meditrack.arm_popups.TendinitisPopup;
import com.example.meditrack.arm_popups.armSprainPopup;
import com.example.meditrack.arm_popups.osteoarthritisPopup;

public class ArmsPage extends AppCompatActivity implements View.OnClickListener {

    private Button backButton,tendinitisButton,bursitisButton,armSprainButton,osteoarthritisButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.arm_page, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.arm_page));
        }
        setContentView(R.layout.activity_arms_page);

        backButton = (Button) findViewById(R.id.backButtonHead);
        backButton.setOnClickListener(this);

        tendinitisButton = (Button) findViewById(R.id.tendinitisButton);
        tendinitisButton.setOnClickListener(this);

        bursitisButton = (Button) findViewById(R.id.bursitisButton);
        bursitisButton.setOnClickListener(this);

        armSprainButton = (Button) findViewById(R.id.armSprainButton);
        armSprainButton.setOnClickListener(this);

        osteoarthritisButton = (Button) findViewById(R.id.osteoarthritisButton);
        osteoarthritisButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backButtonHead:
                startActivity(new Intent(ArmsPage.this, DiseaseMainActivity.class));
                finish();
                break;

            case R.id.tendinitisButton:
                startActivity(new Intent(ArmsPage.this, TendinitisPopup.class));
                break;

            case R.id.bursitisButton:
                startActivity(new Intent(ArmsPage.this, BursitisPopup.class));
                break;

            case R.id.armSprainButton:
                startActivity(new Intent(ArmsPage.this, armSprainPopup.class));
                break;

            case R.id.osteoarthritisButton:
                startActivity(new Intent(ArmsPage.this, osteoarthritisPopup.class));
                break;
        }
    }
}