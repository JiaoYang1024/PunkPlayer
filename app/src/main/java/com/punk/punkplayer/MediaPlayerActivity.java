package com.punk.punkplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


public class MediaPlayerActivity extends AppCompatActivity {

    private VideoView videoPlayer;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(this))
            return;
        setContentView(R.layout.activity_media_player);

        Intent intent = getIntent();
       String url = intent.getStringExtra("videoUrl");

         videoPlayer = (VideoView) findViewById(R.id.video_player);
        Uri uri = Uri.parse(url);

        videoPlayer.setVideoURI(uri);
        mediaController = new MediaController(this);
        mediaController.show(5000);
        videoPlayer.setMediaController(mediaController);
        videoPlayer.requestFocus();
       // videoPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoPlayer != null){
            videoPlayer.suspend();
        }
    }
}
