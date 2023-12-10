package com.example.pfijava;


import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;


public class Musique {
    private static Musique musiqueInstance;
    private MediaPlayer mediaPlayer;


    public Musique(Context context, Uri uri) {
        mediaPlayer.create(context, uri);

    }

    public static Musique getInstance() {
        return musiqueInstance;
    }
}
