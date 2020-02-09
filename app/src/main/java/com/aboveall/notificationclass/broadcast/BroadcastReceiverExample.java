package com.aboveall.notificationclass.broadcast;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.aboveall.notificationclass.BroadCastAct;
import com.aboveall.notificationclass.R;
import com.aboveall.notificationclass.createChannel.CreateChannel;

public class BroadcastReceiverExample extends BroadcastReceiver {
    private int id=1;
    private NotificationManagerCompat notificationManagerCompat;
    Context context;

    public BroadcastReceiverExample(Context context) {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean noConnectivity;
    notificationManagerCompat=NotificationManagerCompat.from(context);
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            noConnectivity=intent.getBooleanExtra(
              ConnectivityManager.EXTRA_NO_CONNECTIVITY,
              false
            );
            if (noConnectivity){
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
                DisplayNotification();
            }else{
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
                DisplayNotification2();
            }

        }
    }


    private void DisplayNotification(){

        Notification notification=new NotificationCompat.Builder(context, CreateChannel.CHANNEL_1)

                .setSmallIcon(R.drawable.ic_signal_wifi_off_black_24dp)
                .setContentTitle("No Connection")
                .setContentText("No Connection, Please Check"+id)
                .setCategory(NotificationCompat.CATEGORY_SYSTEM)
                .build();

        notificationManagerCompat.notify(id,notification);
        id++;

    }


    private void DisplayNotification2(){

        Notification notification=new NotificationCompat.Builder(context,CreateChannel.CHANNEL_2)

                .setSmallIcon(R.drawable.ic_sms_black_24dp)
                .setContentTitle("Connection")
                .setContentText("Connected, "+id)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(id,notification);
        id++;

    }
}
