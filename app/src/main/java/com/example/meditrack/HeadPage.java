package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meditrack.head_popups.ConcussionPopup;
import com.example.meditrack.head_popups.ContusionPopup;
import com.example.meditrack.head_popups.ICHPopup;
import com.example.meditrack.head_popups.SkullfPopup;

public class HeadPage extends AppCompatActivity implements View.OnClickListener {

    private Button backButton,concussionButton,contusionButton,ichButton,skullfButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.head_page, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.head_page));
        }
        setContentView(R.layout.head_page);

        backButton = (Button) findViewById(R.id.backButtonHead);
        backButton.setOnClickListener(this);

        concussionButton = (Button) findViewById(R.id.concussionButton);
        concussionButton.setOnClickListener(this);

        contusionButton = (Button) findViewById(R.id.contusionButton);
        contusionButton.setOnClickListener(this);

        ichButton = (Button) findViewById(R.id.ichButton);
        ichButton.setOnClickListener(this);

        skullfButton = (Button) findViewById(R.id.skullfButton);
        skullfButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backButtonHead:
                startActivity(new Intent(HeadPage.this, DiseaseMainActivity.class));
                break;

            case R.id.concussionButton:
                startActivity(new Intent(HeadPage.this, ConcussionPopup.class));
                break;

            case R.id.contusionButton:
                startActivity(new Intent(HeadPage.this, ContusionPopup.class));
                break;

            case R.id.ichButton:
                startActivity(new Intent(HeadPage.this, ICHPopup.class));
                break;

            case R.id.skullfButton:
                startActivity(new Intent(HeadPage.this, SkullfPopup.class));
                break;
        }
    }
}