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



}
