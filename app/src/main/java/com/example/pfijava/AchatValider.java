package com.example.pfijava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AchatValider extends AppCompatActivity {
    private Panier panier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achat_valider);
        panier = Panier.getInstance();

    }
}