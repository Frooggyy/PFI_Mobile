package com.example.pfijava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class ListeEpicerie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_epicerie);
        ArrayList<Article> arrArticles = new ArrayList<Article>();
    }
}