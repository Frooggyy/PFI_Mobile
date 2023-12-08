package com.example.pfijava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class AchatValider extends AppCompatActivity {
    private Panier panier;
    VideoView videoView;
    boolean executeThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achat_valider);
//        panier = Panier.getInstance();

        Button btnRetour = (Button) findViewById(R.id.btn_retour);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versLE = new Intent(AchatValider.this, ListeEpicerie.class);
                executeThread = false;
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