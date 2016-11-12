package com.example.chengd.simplemediaplayer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity  {
    private MediaPlayer mediaPlayer;
    private String path;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Uri uri = intent.getData();
        if(uri!=null)
        {
            path = uri.getPath();
            if (intent.getType().contains("audio"))
            {
                mediaPlayer = new MediaPlayer();
                try
                {
                    mediaPlayer.setDataSource(path);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else if (intent.getType().contains("video"))
            {
                videoView = new VideoView(this);
                videoView.setVideoURI(uri);
                videoView.setMediaController(new MediaController(this));
                videoView.start();
                setContentView(videoView);
            }
        }
    }


}
