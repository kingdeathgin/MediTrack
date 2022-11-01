package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meditrack.anrec_popups.ColitisPopup;
import com.example.meditrack.anrec_popups.AnalFissuresPopup;
import com.example.meditrack.anrec_popups.HemorrhoidsPopup;


public class AnRecPage extends AppCompatActivity implements View.OnClickListener {

    private Button backButton, analFissuresButton,hemorrhoidsButton, colitisButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.anrec_page, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.anrec_page));
        }
        setContentView(R.layout.activity_an_rec_page);

        backButton = (Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(this);

        analFissuresButton = (Button)findViewById(R.id.analFissuresButton);
        analFissuresButton.setOnClickListener(this);

        hemorrhoidsButton = (Button)findViewById(R.id.hemorrhoidsButton);
        hemorrhoidsButton.setOnClickListener(this);

        colitisButton = (Button)findViewById(R.id.colitisButton);
        colitisButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backButton:
                startActivity(new Intent(AnRecPage.this, DiseaseMainActivity.class));
                break;
            case R.id.colitisButton:
                startActivity(new Intent(AnRecPage.this, ColitisPopup.class));
                break;
            case R.id.hemorrhoidsButton:
                startActivity(new Intent(AnRecPage.this, HemorrhoidsPopup.class));
                break;
            case R.id.analFissuresButton:
                startActivity(new Intent(AnRecPage.this, AnalFissuresPopup.class));
                break;
        }
    }
}