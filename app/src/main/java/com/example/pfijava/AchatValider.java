package com.example.pfijava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.VideoView;

public class AchatValider extends AppCompatActivity {
    private Panier panier;
    VideoView videoView;
    boolean executeThread;
    boolean fini = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achat_valider);
//        panier = Panier.getInstance();

        Button btnRetour = (Button) findViewById(R.id.btn_retour);
        Animation fadein = AnimationUtils.loadAnimation(AchatValider.this, R.anim.fadein);
        Animation fadeOut = AnimationUtils.loadAnimation(AchatValider.this, R.anim.fadeout);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(!fini){
                        btnRetour.startAnimation(fadein);
                        while(!fadein.hasEnded()){}
                        btnRetour.startAnimation(fadeOut);
                        while(!fadein.hasEnded()){}
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versLE = new Intent(AchatValider.this, ListeEpicerie.class);
                executeThread = false;
                fini = true;
                startActivity(versLE);
            }
        });

        videoView = (VideoView) findViewById(R.id.AV_videoView_valider);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.valider);
        videoView.setVideoURI(uri);
        videoView.requestFocus();

        new Thread(new Runnable() {
            @Override
            public void run() {
                executeThread = true;
                while (executeThread) {
                    videoView.start();
                }
            }
        }).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        executeThread = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        executeThread = false;
    }

}