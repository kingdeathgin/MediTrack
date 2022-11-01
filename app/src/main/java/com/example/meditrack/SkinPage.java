package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meditrack.skin_popups.AcnePopup;
import com.example.meditrack.skin_popups.HivesPopup;
import com.example.meditrack.skin_popups.ShinglesPopup;
import com.example.meditrack.skin_popups.ContactDermPopup;

public class SkinPage extends AppCompatActivity implements View.OnClickListener {

    private Button backButton,acneButton,shinglesButton,contactDermButton,hivesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.skin_page, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.skin_page));
        }
        setContentView(R.layout.activity_skin_page);

        backButton = (Button) findViewById(R.id.backButtonHead);
        backButton.setOnClickListener(this);

        acneButton = (Button) findViewById(R.id.acneButton);
        acneButton.setOnClickListener(this);

        shinglesButton = (Button) findViewById(R.id.shinglesButton);
        shinglesButton.setOnClickListener(this);

        contactDermButton = (Button) findViewById(R.id.contactDermButton);
        contactDermButton.setOnClickListener(this);

        hivesButton = (Button) findViewById(R.id.hivesButton);
        hivesButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backButtonHead:
                startActivity(new Intent(SkinPage.this, DiseaseMainActivity.class));
                break;

            case R.id.shinglesButton:
                startActivity(new Intent(SkinPage.this, ShinglesPopup.class));
                break;

            case R.id.acneButton:
                startActivity(new Intent(SkinPage.this, AcnePopup.class));
                break;

            case R.id.contactDermButton:
                startActivity(new Intent(SkinPage.this, ContactDermPopup.class));
                break;

            case R.id.hivesButton:
                startActivity(new Intent(SkinPage.this, HivesPopup.class));
                break;
        }
    }
}