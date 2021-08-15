package com.bets.testnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.bets.testnotification.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private static final String CHANNEL_ID = "Cat channel";
    private static final int NOTIFY_ID = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        createNotificationChannel();

        binding.btnShow.setOnClickListener(view -> {

            Intent resultIntent = new Intent(this, MainActivity2.class);
            PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle("Sokolov")
                    .setContentText("Новая коллекция изделий Аниматрон")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(resultPendingIntent)
                    .setAutoCancel(true);


            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

            // notificationId is a unique int for each notification that you must define
            notificationManager.notify(NOTIFY_ID, builder.build());

        });
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "my_channel";
            String description = "This is my channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}