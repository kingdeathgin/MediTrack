package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsPage extends AppCompatActivity implements View.OnClickListener {

    RadioGroup backgroundRadioGroup;
    RadioButton redRadioButton,yellowRadioButton,greenRadioButton;

    ImageView backArrowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);



        backArrowButton = (ImageView)findViewById(R.id.backArrowButton);
        backArrowButton.setOnClickListener(this);

        backgroundRadioGroup = findViewById(R.id.backgroundRadioGroup);
        backgroundRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch(i){
                    case R.id.redBackgroundRadioButton:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#ff0b64"));
                        break;
                    case R.id.blueBackgroundRadioButton:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#0ac2fa"));
                        break;
                    case R.id.yellowBackgroundRadioButton:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#ffc53f"));
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backArrowButton:
                startActivity(new Intent(SettingsPage.this, Navigation.class));
                break;
        }
    }
}