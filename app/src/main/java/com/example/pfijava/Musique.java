package com.example.pfijava;


import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

/**
 * Auteur: Gabriel
 * Similaire à la classe Panier dans son fonctionnement
 * cette classe permet d'avoir une seule instance de Musique
 * afin de jouer de la musique de fond dans l'application
 */
public class Musique {
    private static Musique musiqueInstance;
    private MediaPlayer mediaPlayer;
    private Boolean isPlaying = false;


    private Musique(Context context, Uri uri) {
        mediaPlayer = MediaPlayer.create(context, uri);

    }

    /**
     * Auteur : Kéven dans Panier, modifiée par Gabriel
     * Cette méthode statique regarde s'il existe une instance de Musique existante
     * puis la retourne, sinon elle en crée une nouvelle avec le contexte reçu
     * @param context contexte de l'activité
     * @return une nouvelle instance si il n'y en a pas
     */
    public static Musique getInstance(Context context) {
        if(musiqueInstance != null)
            return musiqueInstance;
        else{
            musiqueInstance = new Musique(context, Uri.parse("android.resource://com.example.pfijava/"+R.raw.musique));
            return musiqueInstance;
        }
    }

    /**
     * Auteur : Gabriel
     * Cette méthode permet de faire jouer la musique de mediaPlayer partout ou
     * l'instance de Musique a été demandée
     */
    public  void jouer(){
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        isPlaying = true;
    }

    /**
     * Auteur:Gabriel
     * Cette méthode permet de mettre à pause la musique partout ou
     * l'instance de Musique a été demandée
     */
    public void pause(){
        mediaPlayer.pause();
        isPlaying = false;
    }

    /**
     * Auteur:Gabriel
     * Cette méthode permet d'arrêter la musique partout ou
     * l'instance de Musique a été demandée
     */
    public void stop(){
        mediaPlayer.stop();
    }

    /**
     * Auteur:Gabriel
     * Cette méthode permet de détruire l'élément mediaPlayer afin de libérer les ressources
     */
    public void detruire(){
        mediaPlayer.pause();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    /**
     * Auteur:Gabriel
     * @return true si le MediaPlayer joue un son et false si le contraire
     */
    public Boolean isPlaying(){
        return isPlaying;
    }
}
