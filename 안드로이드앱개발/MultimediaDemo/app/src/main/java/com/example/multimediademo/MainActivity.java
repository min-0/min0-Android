package com.example.multimediademo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer = new MediaPlayer(); //미디어 재생기 생성
    VideoView videoView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void playAudio(View view) {
        //오디오 재생
        if(mediaPlayer.isPlaying()) {  //오디오가 재생 중일 때
            mediaPlayer.pause(); //일시 중지 시킨다
        }
        else {
            //오디오가 일시 중지 일 때
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.hare);
            mediaPlayer.setLooping(true); //무한 재생 옵션 설정
            mediaPlayer.start(); //재생
        }
    }

    public void playVideo(View view) {
        //비디오 재생
        if(videoView.isPlaying()) { //비디오 재생 중일 때
            videoView.pause();
        }
        else {
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/movie");
            videoView.setVideoURI(uri);
            videoView.start();
            videoView.setVisibility(View.VISIBLE);
            //미디어 컨트롤러 추가
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
        }
    }
}