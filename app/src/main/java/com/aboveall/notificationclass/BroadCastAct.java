package com.aboveall.notificationclass;

import android.app.Notification;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.aboveall.notificationclass.broadcast.BroadcastReceiverExample;
import com.aboveall.notificationclass.createChannel.CreateChannel;

public class BroadCastAct extends AppCompatActivity {
    BroadcastReceiverExample broadcastReceiverExample=new BroadcastReceiverExample(this);
    private NotificationManagerCompat notificationManagerCompat;

    private int id=1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcastReceiverExample,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiverExample);

    }


    private void DisplayNotification(){

        Notification notification=new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)

                .setSmallIcon(R.drawable.ic_signal_wifi_off_black_24dp)
                .setContentTitle("No Connection")
                .setContentText("No Connection, Please Check"+id)
                .setCategory(NotificationCompat.CATEGORY_SYSTEM)
                .build();

        notificationManagerCompat.notify(id,notification);
        id++;

    }


    private void DisplayNotification2(){

        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_2)

                .setSmallIcon(R.drawable.ic_sms_black_24dp)
                 .setContentTitle("Connection")
                .setContentText("Connected, "+id)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(id,notification);
        id++;

    }

}
