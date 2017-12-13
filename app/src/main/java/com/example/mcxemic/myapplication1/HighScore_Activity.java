package com.example.mcxemic.myapplication1;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.NotificationCompat;
import android.app.Notification;
import android.app.NotificationManager;

public class HighScore_Activity extends AppCompatActivity{


    TextView tv_score;

    int lastScore;
    int best1,best2,best3,best4,best5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        tv_score = (TextView) findViewById(R.id.tv_score);

        SharedPreferences preferences = getSharedPreferences("PREFS",0);
        lastScore = preferences.getInt("lastScore",0);
        best1 = preferences.getInt("best1",0);
        best2 = preferences.getInt("best2",0);
        best3 = preferences.getInt("best3",0);
        best4 = preferences.getInt("best4",0);
        best5 = preferences.getInt("best5",0);



        if(lastScore>best5){
            best5=lastScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best5", best5);
            editor.apply();
        }
        if(lastScore>best4){
            int tmp= best4;
            best4=lastScore;
            best5=tmp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best5", best5);
            editor.putInt("best4", best4);
            editor.apply();
        }
        if(lastScore>best3){
            int tmp= best3;
            best3=lastScore;
            best4=tmp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best4", best4);
            editor.putInt("best3", best3);
            editor.apply();
        }
        if(lastScore>best2){
            int tmp= best2;
            best2=lastScore;
            best3=tmp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3);
            editor.putInt("best2", best2);
            editor.apply();
        }
        if(lastScore>best1){
            int tmp= best1;
            best1=lastScore;
            best2=tmp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2", best2);
            editor.putInt("best1", best1);
            editor.apply();
        }


        tv_score.setText("Last score: " + lastScore + "\n"
                + "1: "+ best1 +"\n"
                + "2: "+ best2 +"\n"
                + "3: "+ best3 +"\n"
                + "4: "+ best4 +"\n"
                + "5: "+ best5);

        lastScore = 0;

    }

    public void b_score_game_click(View view) {
        Intent Intent = new Intent(this, MainActivity.class);
        startActivity(Intent);
    }

    public void b_score_score_click(View view) {
        Intent Intent = new Intent(this, HighScore_Activity.class);
        startActivity(Intent);
    }

    public void b_score_about_click(View view){
        Intent Intent = new Intent(this, AboutActivity.class);
        startActivity(Intent);
    }

    public void send_notification() {

    }



}
