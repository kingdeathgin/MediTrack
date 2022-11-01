package com.example.meditrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Home extends AppCompatActivity {

    public static final String EXTRA_NUMBER = "com.example.application.myapplication.EXTRA_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(Home.this,R.color.mainBlue));

        setContentView(R.layout.activity_home);




        EditText editText = findViewById(R.id.edittext1);
        Button button = (Button) findViewById(R.id.button);
        ImageView back = findViewById(R.id.backHome);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.meditrack.Navigation.class );
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
        button.setOnClickListener(v -> {
            if (editText.getText().toString().isEmpty()){
                Toast.makeText(this,"Fill the required field", Toast.LENGTH_SHORT).show();
            } else {
                openActivity2();
            }
        });
    }
    public void openActivity2() {
        EditText editText1 = (EditText) findViewById(R.id.edittext1);
        int number = Integer.parseInt(editText1.getText().toString());


        Intent intent = new Intent(this, com.example.meditrack.MainSteps.class );
        intent.putExtra(EXTRA_NUMBER, number);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


}
