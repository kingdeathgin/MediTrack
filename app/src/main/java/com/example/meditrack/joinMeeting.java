package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class joinMeeting extends AppCompatActivity {

    EditText enterMeetingID;
    Button createMeeting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(joinMeeting.this,R.color.dashboard_item3));
        setContentView(R.layout.activity_join_meeting);


        ImageView back = findViewById(R.id.joinBack);
        enterMeetingID = findViewById(R.id.enterMeeting);
        createMeeting = findViewById(R.id.createMeeting);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.meditrack.MainCall.class );
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });

        createMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(enterMeetingID.length() != 12){
                    Toast.makeText(joinMeeting.this, "INVALID ID", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(joinMeeting.this, "Joining Meeting", Toast.LENGTH_SHORT).show();
                    try {
                        JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                                .setServerURL(new URL("https://meet.jit.si"))
                                .setRoom(enterMeetingID.getText().toString())
                                .setAudioMuted(false)
                                .setVideoMuted(false)
                                .setAudioOnly(false)
                                .setWelcomePageEnabled(false)

                                .build();
                        JitsiMeetActivity.launch(joinMeeting.this,options);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}