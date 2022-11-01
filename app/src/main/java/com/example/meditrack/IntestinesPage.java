package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meditrack.intestines_popup.InguinalHerniaPopup;
import com.example.meditrack.intestines_popup.PerianalAbscessPopup;


public class IntestinesPage extends AppCompatActivity implements View.OnClickListener {

    private Button backButton, periAbButton,inguinalHerniaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.intestines_page, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.intestines_page));
        }
        setContentView(R.layout.activity_intestines_page);

        backButton = (Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(this);

        periAbButton = (Button)findViewById(R.id.periAbButton);
        periAbButton.setOnClickListener(this);

        inguinalHerniaButton = (Button)findViewById(R.id.inguinalHerniaButton);
        inguinalHerniaButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backButton:
                startActivity(new Intent(IntestinesPage.this, DiseaseMainActivity.class));
                break;
            case R.id.periAbButton:
                startActivity(new Intent(IntestinesPage.this, PerianalAbscessPopup.class));
                break;
            case R.id.inguinalHerniaButton:
                startActivity(new Intent(IntestinesPage.this, InguinalHerniaPopup.class));
                break;

        }
    }
}