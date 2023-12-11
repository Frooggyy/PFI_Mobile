package com.example.pfijava;


import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;


public class Musique {
    private static Musique musiqueInstance;
    private MediaPlayer mediaPlayer;
    private Boolean isPlaying = false;


    private Musique(Context context, Uri uri) {
        mediaPlayer = MediaPlayer.create(context, uri);

    }

    public static Musique getInstance(Context context) {
        if(musiqueInstance != null)
            return musiqueInstance;
        else{
            musiqueInstance = new Musique(context, Uri.parse("android.resource://com.example.pfijava/"+R.raw.musique));
            return musiqueInstance;
        }
    }

    public  void jouer(){
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        isPlaying = true;
    }

    public void pause(){
        mediaPlayer.pause();
        isPlaying = false;
    }

    public void stop(){
        mediaPlayer.stop();
    }

    public void detruire(){
        mediaPlayer.pause();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }
    public Boolean isPlaying(){
        return isPlaying;
    }
}
