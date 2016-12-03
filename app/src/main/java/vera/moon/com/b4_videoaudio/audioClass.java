package vera.moon.com.b4_videoaudio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

//Some sounds could be downloaded from soundbible.com

public class audioClass extends AppCompatActivity {

    public MediaPlayer media;

    public SeekBar barra,rola;

    public AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_class);

        //get duration to set seekbar
        media = MediaPlayer.create(this,R.raw.elli);
        int duration = media.getDuration();

        barra = (SeekBar)findViewById(R.id.seekBar);
        rola = (SeekBar)findViewById(R.id.seekBar2);
        rola.setMax(duration);

        //audiomanager para manejar volumne y seek
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        //get max volumen
        int maxvol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int corrcol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //set volume to seekbar (max and current volumen)
        barra.setMax(maxvol);
        barra.setProgress(corrcol);

        //changelistener para cambiar volumen
        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                Log.i("Value",i+"");

                //aDUI MAnaget to set volumen
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rola.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("Value rola",i+"");

                media.seekTo(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //timer as a thread
        /*new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //set rola seekbar al momento que se reproduce la rola
                rola.setProgress(media.getCurrentPosition());
            }
        },0,1); */ //0 = inmediato, 1000 = cadasegundo
    }

    public void playAudio(View v){
        media.start();

    }
    public void pauseAudio(View v){

        media.pause();
    }
}
