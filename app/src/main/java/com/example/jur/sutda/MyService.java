package com.example.jur.sutda;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.jur.sutda.R;


public class MyService extends Service {

    MediaPlayer mediaPlayer = new MediaPlayer();

    public MyService() { }

    @Override
    public void onCreate() {
        super.onCreate();

        mediaPlayer.reset();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);


    }

    @Override
    public int onStartCommand(Intent intent, final int flags, int startId) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default");
        Log.d ("onStartCommand","Start!!");

        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this, R.raw.bgm);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(
                    new NotificationChannel("default", "기본 채널", NotificationManager.IMPORTANCE_DEFAULT)
            );
        }
        startForeground(1, builder.build());

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;

        Log.d("onDestroy()", "Stop!!");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
