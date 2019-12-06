package com.santimusic.myplaymusicsanti;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaramos
    MediaPlayer music;
    Button pause_music;
    Button plays_music;
    int pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pause_music = (Button)findViewById(R.id.pause);
        plays_music = (Button)findViewById(R.id.playmusic);

    }

    public void plays(View view) {
        //si es igual a null que reproduzca
        if(music == null) {
            music = MediaPlayer.create(this, R.raw.ricardomilos);
            music.start();
            pause_music.setVisibility(view.VISIBLE);
            plays_music.setVisibility(view.INVISIBLE);
            //si no esta reproduciendo que reproduzca con la variable pause que contiene la posicion actual del pausado y reproduzca
        }else if(!music.isPlaying())
        {
            music.seekTo(pause);
            music.start();
            pause_music.setVisibility(view.VISIBLE);
            plays_music.setVisibility(view.INVISIBLE);
        }

    }

    public void pauses(View view) {
        //si no es nulo
        if(music !=null)
        {
            music.pause();
            //capturar posicion de la pausa del audio
            pause = music.getCurrentPosition();
            plays_music.setVisibility(view.VISIBLE);
            pause_music.setVisibility(view.INVISIBLE);
        }
    }

    public void stop(View view) {
        try {
        music.stop();
        plays_music.setVisibility(view.VISIBLE);
        pause_music.setVisibility(view.INVISIBLE);
        music = null;
        }catch (Exception ex)
        {}
    }


}
