package com.example.meditrack;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Timer;
import java.util.TimerTask;


public class MainSteps extends AppCompatActivity implements SensorEventListener {
    private TextView textViewStepCounter, textViewStepDetector, txt3, txt2;
    private SensorManager sensorManager;
    private Sensor mStepCounter, mStepDetector;
    private boolean isCounterSensorPresent, isDetectorSensorPresent;
    int stepCount = 0, stepDetect = 0;
    boolean isRunning = false;
    boolean resetCount = false;
    private ProgressBar progressBar;
    private Button button;
    private float sayi = 0;
    private TextView textView;
    Dialog dialog;
    ImageView stopSteps;
    Button startSteps;
    TextView timerText;

    boolean timerStarted = false;
    Timer timer;
    TimerTask timerTask;
    Double time = 0.0;
    TextView text;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainSteps.this,R.color.mainBlue));
        setContentView(R.layout.activity_main_steps);
 dialog = new Dialog(this);


if(isRunning == false){
    openLoseDialog();
}

        ImageView back = findViewById(R.id.stepBack);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.meditrack.Home.class );
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
        Intent intent = getIntent();
        int number = intent.getIntExtra(Home.EXTRA_NUMBER, 0);
         stopSteps = findViewById(R.id.stop);
         startSteps = findViewById(R.id.start);

         timerText = (TextView) findViewById(R.id.timerText);
         timer = new Timer();
         text = findViewById(R.id.text);




        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){ //ask for permission
            requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 0);
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        textViewStepCounter = findViewById(R.id.textViewStepCounter);
        textViewStepDetector = findViewById(R.id.textViewStepDetector);
        txt3 =  findViewById(R.id.txt3);
        txt2 = findViewById(R.id.txt2);
        progressBar= findViewById(R.id.progress);

        textView = findViewById(R.id.text);

        progressBar.setMax(100);



        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
            mStepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isCounterSensorPresent = true;
        } else {
            textViewStepCounter.setText("Step Counter N/A");
            isCounterSensorPresent = false;
        }

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null) {
            mStepDetector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
            isDetectorSensorPresent = true;
        } else{
            textViewStepDetector.setText("Detector Sensor \n N/A");
            isDetectorSensorPresent = false;
        }
    }

    private void openLoseDialog() {
        dialog.setContentView(R.layout.lose_layout_dialog);
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

    public void start (View view) {
        isRunning =true;
        stopSteps.setVisibility(View.VISIBLE);
        startSteps.setVisibility(View.INVISIBLE);
        if(timerStarted == false){
            timerStarted = true;

            startTimer();
        }


    }

    private void startTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        timerText.setText(getTimerText());
                    }
                });

            }
        };
        timer.scheduleAtFixedRate(timerTask, 0,1000);
    }

    private String getTimerText() {
        int rounded = (int) Math.round(time);

        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);
        
        return formatTime(seconds, minutes, hours);
    }

    private String formatTime(int seconds, int minutes, int hours) {
        return String.format("%02d",hours) + " : " +  String.format("%02d",minutes) + " : " + String.format("%02d",seconds);
    }

    public void stop (View view) {
        isRunning =false;
        startSteps.setVisibility(View.VISIBLE);
        stopSteps.setVisibility(View.INVISIBLE);

        if(timerStarted != false) {
            timerStarted = false;
            timerTask.cancel();
        }
    }
    public void reset (View view) {
        AlertDialog.Builder resetAlert = new AlertDialog.Builder(this);
        resetAlert.setTitle("Reset Progress");
        resetAlert.setMessage("Are you sure you want to reset all your progress?");
        resetAlert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(timerTask != null){
                    timerTask.cancel();
                    time = 0.0;
                    startSteps.setVisibility(View.VISIBLE);
                    stopSteps.setVisibility(View.INVISIBLE);
                    timerStarted = false;
                    timerText.setText(formatTime(0,0,0));
                    txt2.setText("0.0");
                    txt3.setText("0.0");
                    text.setText("%");
                    textViewStepDetector.setText("0 Steps");
                    progressBar.setProgress(0);
                }
            }
        });
        resetAlert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });


        resetAlert.show();
        isRunning =false;
        resetCount = true;

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {


        Intent intent = getIntent();
        int number = intent.getIntExtra(Home.EXTRA_NUMBER, 0);
        if (stepDetect == number){
            openCongratulationsDialog();
        }
        if(sensorEvent.sensor == mStepCounter) {
            stepCount = (int) sensorEvent.values[0];
            textViewStepCounter.setText(String.valueOf(stepCount) + " Combined Steps");

        } else if (sensorEvent.sensor == mStepDetector) {
            if (isRunning == true) {
                stepDetect = (int) (stepDetect + sensorEvent.values[0]);
                textViewStepDetector.setText(String.valueOf(stepDetect) + " of " + number + " Steps");
                txt3.setText((((float)stepDetect/1000)*100) + "");
                txt2.setText((((float)stepDetect * 2.2)/5280) + "");
                sayi =  ((stepDetect/(int)number)*100);
                progressBar.setProgress((int) (((float)stepDetect/number)*100));
                textView.setText((((float)stepDetect/number)*100)+"%");
                if(sayi >=100){
                    textView.setText(100+"%");
                }

            } else if (isRunning == false && resetCount == true) {
                stepDetect = 0;
                textViewStepDetector.setText(String.valueOf(stepDetect) + " / " + number + " App is reset");

            }


        }
        }

    private void openCongratulationsDialog() {
        dialog.setContentView(R.layout.congratulations_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);
        Button button = dialog.findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) !=null)
            sensorManager.registerListener(this, mStepCounter, SensorManager.SENSOR_DELAY_NORMAL);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR )!= null)
            sensorManager.registerListener(this, mStepDetector, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) !=null)
            sensorManager.unregisterListener(this, mStepCounter);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR )!= null)
            sensorManager.unregisterListener(this, mStepDetector);
    }

}