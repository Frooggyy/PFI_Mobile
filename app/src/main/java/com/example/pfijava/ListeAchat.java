package com.example.pfijava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;

import android.widget.Toast;

import android.widget.VideoView;


import java.io.IOException;
import java.util.ArrayList;

public class ListeAchat extends AppCompatActivity {
    private Panier panier;
    private PanierAdapter adaptateur;
    private Boolean stopAnimation = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_achat);
        panier = Panier.getInstance();

        ArrayList<Article> arrArticle = new ArrayList<Article>();
        RecyclerView recycleAchat = (RecyclerView) findViewById(R.id.achat_RecyclerView);

        adaptateur = new PanierAdapter(getApplicationContext(), this);
        recycleAchat.setAdapter(adaptateur);

        recycleAchat.setLayoutManager(new LinearLayoutManager(this));

        recycleAchat.setItemAnimator(new DefaultItemAnimator());
        recycleAchat.setHasFixedSize(true);

        Button btnVersListe = (Button) findViewById(R.id.achat_btnVersListe);
        Button btnAnnuler = (Button) findViewById(R.id.achat_btnViderPanier);
        Button btnValider = (Button) findViewById(R.id.achat_btnAchatPanier);

        VideoView vid = findViewById(R.id.achat_videoView);

        //Mettre video dans la page du panier
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(vid);

        Uri uriVid = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.panier);
        vid.setMediaController(mediaController);
        vid.setVideoURI(uriVid);
        vid.requestFocus();
        vid.start();
        //Pour loop la vidéo
        vid.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                vid.start();
            }
        });

        MettreAJourTotal();

        Animation animation = AnimationUtils.loadAnimation(ListeAchat.this, R.anim.rotate);
        new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    while(!stopAnimation){
                        btnValider.startAnimation(animation);
                        while(!animation.hasEnded()){}
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();

        btnVersListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versLE = new Intent(ListeAchat.this, ListeEpicerie.class);
                startActivity(versLE);
            }
        });

        btnAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panier.viderPanier();
                adaptateur.clearList();
                Intent versLE = new Intent(ListeAchat.this, ListeEpicerie.class);
                startActivity(versLE);
            }
        });

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(panier.ArticleDansPanier()){
                     new Thread(new Runnable() {
                         @Override
                         public void run() {
                             MediaPlayer mp;
                             mp = MediaPlayer.create(ListeAchat.this, Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kaching));

                             mp.start();
                             while(mp.isPlaying()){}
                             mp.stop();
                             mp.release();
                             mp = null;
                         }
                     }).start();

                     Intent versAchatValider = new Intent(ListeAchat.this, AchatValider.class);
                     vid.stopPlayback();
                     stopAnimation = true;
                     startActivity(versAchatValider);

                 } else {
                     Toast.makeText(ListeAchat.this, getResources().getString(R.string.PA_toast_paniervide), Toast.LENGTH_SHORT).show();
                 }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adaptateur.notifyDataSetChanged();
        MettreAJourTotal();
    }

    public void MettreAJourTotal(){
        TextView totalPrix = (TextView) findViewById(R.id.achat_txtCalculTotal);
        double total = panier.calculerPrixTotal();
        String totalArrondi = String.format("%.2f", total);
        totalPrix.setText(totalArrondi + " $");
    }

}