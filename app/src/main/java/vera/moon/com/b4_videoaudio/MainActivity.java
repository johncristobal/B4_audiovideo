package vera.moon.com.b4_videoaudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    public VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VideoView
        video = (VideoView)findViewById(R.id.videoView);
        //Set path to the video
        video.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);

        //MediaController --- to pause, play, seekbar, etc.
        MediaController media = new MediaController(this);
        media.setAnchorView(video);

        video.setMediaController(media);
    }

    public void audio(View v){

        Intent i = new Intent(this,audioClass.class);
        startActivity(i);
    }

    public void video(View v){
        //Video started
        video.start();
    }
}
