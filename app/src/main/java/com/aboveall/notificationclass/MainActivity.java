package com.aboveall.notificationclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aboveall.notificationclass.createChannel.CreateChannel;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;
    private Button btnDisplayNotification;
    private Button btnDisplayNotification2;

    private int id=1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManagerCompat=NotificationManagerCompat.from(this);
        CreateChannel channel=new CreateChannel(this);
        channel.createChannel();

        btnDisplayNotification=findViewById(R.id.btnNotification);
        btnDisplayNotification2=findViewById(R.id.btnNotification2);

        btnDisplayNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification();
            }
        });


        btnDisplayNotification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification2();
            }
        });

    }

    private void DisplayNotification(){

        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)

                .setSmallIcon(R.drawable.ic_sms_black_24dp)
                .setContentTitle("First Message")
                .setContentText("First Message Body"+id)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(id,notification);
        id++;

    }


    private void DisplayNotification2(){

        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_2)

                .setSmallIcon(R.drawable.ic_sms_black_24dp)
                .setContentTitle("Second Message")
                .setContentText("Second Message Body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(id,notification);
        id++;

    }
}
