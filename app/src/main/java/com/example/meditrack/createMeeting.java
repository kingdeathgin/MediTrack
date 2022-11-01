package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class createMeeting extends AppCompatActivity {


    Button randomBtn2;
    TextView textView;
    ImageView copy;
    Button join;
    Button share;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(createMeeting.this,R.color.dashboard_item3));
        setContentView(R.layout.activity_create_meeting);


        randomBtn2 = findViewById(R.id.Button2);
        textView = findViewById(R.id.textView);
        copy = findViewById(R.id.copy);
        join = findViewById(R.id.join);
        share = findViewById(R.id.share);
        back = findViewById(R.id.backCreate);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.meditrack.MainCall.class );
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
                shareIntent.setType("text/plain");
                shareIntent = Intent.createChooser(shareIntent, "Share Via: ");
                startActivity(shareIntent);
            }
        });

        randomBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RandomString randomString = new RandomString();
                String result = randomString.generateAlphabetNumber(12);
                textView.setText(result);
                generate();

            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Copy", textView.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(createMeeting.this, "Copied", Toast.LENGTH_SHORT).show();

            }
        });

        join.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textView.getText().toString().isEmpty()){
                    Toast.makeText(createMeeting.this, "Please enter a room id", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                                .setServerURL(new URL("https://meet.jit.si"))
                                .setRoom(textView.getText().toString())
                                .setAudioMuted(false)
                                .setVideoMuted(true)
                                .setAudioOnly(false)
                                .setWelcomePageEnabled(false)
                                .build();
                        JitsiMeetActivity.launch(createMeeting.this,options);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void generate() {
        join.setVisibility(View.VISIBLE);
        share.setVisibility(View.VISIBLE);
    }
}