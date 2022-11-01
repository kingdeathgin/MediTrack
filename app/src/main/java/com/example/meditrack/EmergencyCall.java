package com.example.meditrack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EmergencyCall extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    private TextView callText, callText2, callText3, callText4, callText5;
    Dialog dialog;
    boolean isRunning = false;
    Button callBtn;
    Button callBtn2;
    Button callBtn3;
    Button callBtn4;
    Button callBtn5;
    Button cancelCall;
    Button save;
    Button saveTwo;

ConstraintLayout backgroundLayout;
ConstraintLayout backgroundLayoutCall;
LinearLayout emptyInputOneBackground;
    LinearLayout emptyInputTwoBackground;

    public void showDialog(View view){
        callBtn.setVisibility(View.VISIBLE);
        callBtn2.setVisibility(View.INVISIBLE);
        callBtn3.setVisibility(View.INVISIBLE);
        callBtn4.setVisibility(View.INVISIBLE);
        callBtn5.setVisibility(View.INVISIBLE);
        backgroundLayout.setVisibility(View.INVISIBLE);
        backgroundLayoutCall.setVisibility(View.VISIBLE);
    }

    public void showDialog2(View view){
        callBtn.setVisibility(View.INVISIBLE);
        callBtn2.setVisibility(View.VISIBLE);
        callBtn3.setVisibility(View.INVISIBLE);
        callBtn4.setVisibility(View.INVISIBLE);
        callBtn5.setVisibility(View.INVISIBLE);
        backgroundLayout.setVisibility(View.INVISIBLE);
        backgroundLayoutCall.setVisibility(View.VISIBLE);
    }
    public void showDialog3(View view){
        callBtn.setVisibility(View.INVISIBLE);
        callBtn2.setVisibility(View.INVISIBLE);
        callBtn3.setVisibility(View.VISIBLE);
        callBtn4.setVisibility(View.INVISIBLE);
        callBtn5.setVisibility(View.INVISIBLE);
        backgroundLayout.setVisibility(View.INVISIBLE);
        backgroundLayoutCall.setVisibility(View.VISIBLE);

    }
    public void showDialog4(View view){
        callBtn.setVisibility(View.INVISIBLE);
        callBtn2.setVisibility(View.INVISIBLE);
        callBtn3.setVisibility(View.INVISIBLE);
        callBtn4.setVisibility(View.VISIBLE);
        callBtn5.setVisibility(View.INVISIBLE);
        backgroundLayout.setVisibility(View.INVISIBLE);
        backgroundLayoutCall.setVisibility(View.VISIBLE);
    }
    public void showDialog5(View view){

        callBtn.setVisibility(View.INVISIBLE);
        callBtn2.setVisibility(View.INVISIBLE);
        callBtn3.setVisibility(View.INVISIBLE);
        callBtn4.setVisibility(View.INVISIBLE);
        callBtn5.setVisibility(View.VISIBLE);
        backgroundLayout.setVisibility(View.INVISIBLE);

        backgroundLayoutCall.setVisibility(View.VISIBLE);

    }
public void show (View view){
   backgroundLayout.setVisibility(View.VISIBLE);
   backgroundLayoutCall.setVisibility(View.INVISIBLE);
   saveTwo.setVisibility(View.INVISIBLE);
   save.setVisibility(View.VISIBLE);
}
    public void show2 (View view){
        save.setVisibility(View.INVISIBLE);
        saveTwo.setVisibility(View.VISIBLE);
        backgroundLayout.setVisibility(View.VISIBLE);

        backgroundLayoutCall.setVisibility(View.INVISIBLE);
    }

public void hide (View view){
    backgroundLayout.setVisibility(View.INVISIBLE);
    backgroundLayoutCall.setVisibility(View.INVISIBLE);
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(EmergencyCall.this,R.color.red));

        setContentView(R.layout.activity_emergency_call);
        dialog = new Dialog(this);
        if(isRunning == false ){
        openEmergencyDialog();
        }
        backgroundLayoutCall = findViewById(R.id.backgroundLayoutCall);
        backgroundLayout = findViewById(R.id.backgroundLayout);
        emptyInputOneBackground = findViewById(R.id.emptyInputOneBackground);
        emptyInputTwoBackground = findViewById(R.id.emptyInputTwoBackground);
        cancelCall = findViewById(R.id.cancelCall);

        callBtn = findViewById(R.id.callButton);
        callText = findViewById(R.id.callText);

        callBtn2 = findViewById(R.id.callButton2);
        callText2 = findViewById(R.id.callText2);

        callBtn3 = findViewById(R.id.callButton3);
        callText3 = findViewById(R.id.callText3);

        callBtn4 = findViewById(R.id.callButton4);
        callText4 = findViewById(R.id.callText4);

        callBtn5 = findViewById(R.id.callButton5);
        callText5 = findViewById(R.id.callText5);

        cancelCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backgroundLayoutCall.setVisibility(View.INVISIBLE);
            }
        });
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CallButton();
                backgroundLayoutCall.setVisibility(View.INVISIBLE);
            }


        });

        callBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton2();
                backgroundLayoutCall.setVisibility(View.INVISIBLE);
            }


        });

        callBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton3();
                backgroundLayoutCall.setVisibility(View.INVISIBLE);
            }


        });

        callBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton4();
                backgroundLayoutCall.setVisibility(View.INVISIBLE);
            }


        });

        callBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton5();
                backgroundLayoutCall.setVisibility(View.INVISIBLE);
            }


        });

        TextView callTxtName = findViewById(R.id.callTxtName);
        TextView callTxtNameTwo = findViewById(R.id.callTxtNameTwo);
        EditText nameInput = findViewById(R.id.nameInput);


        TextView phoneNumberInput = findViewById(R.id.phoneNumberInput);
        TextView phoneNumberInputTwo = findViewById(R.id.phoneNumberInputTwo);
        EditText phoneInput = findViewById(R.id.phoneInput);
         save = findViewById(R.id.save);
         saveTwo = findViewById(R.id.saveTwo);

        save.setOnClickListener(v -> {
            if (nameInput.getText().toString().isEmpty() || phoneInput.getText().toString().isEmpty()){
                callTxtName.setText("Empty Input #1");
                callText4.setText("Please input a number");
                Toast.makeText(this,"Fill the required field", Toast.LENGTH_SHORT).show();
            }
            else {

                callText4.setText(phoneInput.getText().toString());
                callTxtName.setText(nameInput.getText().toString());
                phoneNumberInput.setText("Phone Number: ");
                backgroundLayout.setVisibility(View.INVISIBLE);
                emptyInputOneBackground.setBackgroundResource(R.drawable.enter_input_one);
            }
        });

        saveTwo.setOnClickListener(v -> {
            if (nameInput.getText().toString().isEmpty() || phoneInput.getText().toString().isEmpty()){
                callTxtNameTwo.setText("Empty Input #2");
                callText5.setText("Please input a number");
                Toast.makeText(this,"Fill the required field", Toast.LENGTH_SHORT).show();
            }
            else {
                callText5.setText(phoneInput.getText().toString());
                callTxtNameTwo.setText(nameInput.getText().toString());
                phoneNumberInputTwo.setText("Phone Number: ");
                backgroundLayout.setVisibility(View.INVISIBLE);
                emptyInputTwoBackground.setBackgroundResource(R.drawable.enter_input_two);

            }
        });



        ImageView back = findViewById(R.id.backEmergency);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.meditrack.Navigation.class );
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
    }


    private void CallButton() {
        String number = callText.getText().toString();
        if(number.trim().length() > 0){
            if(ContextCompat.checkSelfPermission(EmergencyCall.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(EmergencyCall.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void CallButton2() {
        String number = callText2.getText().toString();
        if(number.trim().length() > 0){
            if(ContextCompat.checkSelfPermission(EmergencyCall.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(EmergencyCall.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void CallButton3() {
        String number = callText3.getText().toString();
        if(number.trim().length() > 0){
            if(ContextCompat.checkSelfPermission(EmergencyCall.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(EmergencyCall.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    private void CallButton4() {
        String number = callText4.getText().toString();
        if(number.trim().length() > 0){
            if(ContextCompat.checkSelfPermission(EmergencyCall.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(EmergencyCall.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    private void CallButton5() {
        String number = callText5.getText().toString();
        if(number.trim().length() > 0){
            if(ContextCompat.checkSelfPermission(EmergencyCall.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(EmergencyCall.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                CallButton();
                CallButton2();
                CallButton3();
                CallButton4();
                CallButton5();

            }else {
                Toast.makeText(this, "permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openEmergencyDialog() {
        dialog.setContentView(R.layout.emergency_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);


        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}