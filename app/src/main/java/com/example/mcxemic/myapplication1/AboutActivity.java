package com.example.mcxemic.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v4.app.NotificationCompat;
import android.app.Notification;
import android.app.NotificationManager;


public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


    }

    public void b_about_game_click(View view) {
        Intent Intent = new Intent(this, MainActivity.class);
        startActivity(Intent);
    }

    public void b_about_score_click(View view) {
        Intent Intent = new Intent(this, HighScore_Activity.class);
        startActivity(Intent);
    }

    public void b_about_about_click(View view){
        Intent Intent = new Intent(this, AboutActivity.class);
        startActivity(Intent);
    }
}
