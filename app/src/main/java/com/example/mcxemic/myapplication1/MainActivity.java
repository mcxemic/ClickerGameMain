package com.example.mcxemic.myapplication1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NotificationCompat;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;


public class MainActivity extends AppCompatActivity {

    TextView tv_time, tv_clicks;
    Button b_click, b_start;
    Button b_game,b_score,b_about;

    CountDownTimer timer;
    int time = 30;
    int clicks = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_clicks = (TextView) findViewById(R.id.tv_clicks);

        b_click = (Button) findViewById(R.id.b_click);
        b_start = (Button) findViewById(R.id.b_start);
        b_game = (Button) findViewById(R.id.b_main_game);
        b_score = (Button) findViewById(R.id.b_main_game);
        b_about = (Button) findViewById(R.id.b_main_game);

        b_start.setEnabled(true);
        b_click.setEnabled(false);
        b_game.setEnabled(true);
        b_score.setEnabled(true);
        b_about.setEnabled(true);

        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Clicker game")
                .setContentText("Beat your record!!!" )
                .setContentIntent(resultPendingIntent)
                .setAutoCancel(true);

        Notification notification = builder.build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);



        timer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {
                time--;
                tv_time.setText("Time: " + time);
            }

            @Override
            public void onFinish() {
                b_start.setEnabled(true);
                b_click.setEnabled(false);
                tv_time.setText("Time: 0");
                SharedPreferences preferences = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("lastScore", clicks);
                editor.apply();


                Intent intent = new Intent(getApplicationContext(),HighScore_Activity.class);
                startActivity(intent);
                finish();
            }
        };


        b_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicks++;
                tv_clicks.setText("Clicks: " + clicks);
            }
        });

        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
                b_click.setEnabled(true);
                b_start.setEnabled(false);
                clicks = 0;
                time = 30;
                tv_time.setText("Time: " + time);
                tv_clicks.setText("Clicks: " + clicks);
            }
        });
    }

    public void b_main_game_click(View view) {
        Intent Intent = new Intent(this, MainActivity.class);
        startActivity(Intent);
    }

    public void b_main_score_click(View view) {
        Intent Intent = new Intent(this, HighScore_Activity.class);
        startActivity(Intent);
    }

    public void b_main_about_click(View view){
        Intent Intent = new Intent(this, AboutActivity.class);
        startActivity(Intent);
    }
}