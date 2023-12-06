package com.example.pfijava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityDetailArticle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_article);
        Intent i = getIntent();
        String nom = i.getStringExtra("nom");
        String prix = i.getStringExtra("prix");
        String desc = i.getStringExtra("desc");
        TextView txtNom = findViewById(R.id.DA_nomArticle);
        txtNom.setText(nom);
    }
}