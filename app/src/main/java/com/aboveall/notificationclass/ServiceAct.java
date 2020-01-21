package com.aboveall.notificationclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.aboveall.notificationclass.service.MyService;

public class ServiceAct extends AppCompatActivity {
private Button btnStart,btnStop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);


        btnStart=findViewById(R.id.btnStart);
        btnStop=findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMyService();
            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMyService();
            }
        });
    }

    private void startMyService(){
        startService(new Intent(this, MyService.class));

    }

    private void stopMyService(){
        stopService(new Intent(this, MyService.class));
    }




}
