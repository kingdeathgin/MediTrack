package com.example.meditrack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    String title, desc,date,time,event;
    @Override
    public void onReceive(Context context, Intent intent) {
        title = intent.getStringExtra("TITLE");
        desc = intent.getStringExtra("DESC");
        date = intent.getStringExtra("DATE");
        time = intent.getStringExtra("TIME");
        event = intent.getStringExtra("EVENT");

        //        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
//            // Set the alarm here.
//            Toast.makeText(context, "Alarm just rang...", Toast.LENGTH_SHORT).show();
//        }

//        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, "123")
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle("Name")
//                .setContentText("Name")
//                .setPriority(NotificationCompat.PRIORITY_HIGH);
//
//        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
//        notificationManagerCompat.notify(200, notification.build());
//        Toast.makeText(context, "Broadcast receiver called", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(context, AlarmActivity.class);
        i.putExtra("TITLE",title);
        i.putExtra("DESC",desc);
        i.putExtra("DATE",date);
        i.putExtra("TIME",time);
        i.putExtra("EVENT",event);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
