package com.example.level.musicplayerapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Initializing button variables.
    private Button play, pause, jumpToStart;

    //Initializing MediaPlayer variable.
    private MediaPlayer mediaPlayer;

    private double startTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connecting the button variables with the Buttons in the layout xml.
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        jumpToStart = (Button) findViewById(R.id.jumpToStart);

        //Creating a MediaPlayer for playing the sample song.
        mediaPlayer = MediaPlayer.create(this, R.raw.bensound_happyrock);

        //Clicking on the Play Button the music starts.
        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });

        //Clicking on the Pause Button, the music is paused. Then clicking on the Play Button again,
        // it continues where it was stopped.
        pause.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });

        //Increasing volume.
        jumpToStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Back to start", Toast.LENGTH_SHORT).show();
                mediaPlayer.seekTo((int) startTime);
            }
        });

    }
}
