package com.example.pfijava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ListeEpicerie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_epicerie);


        ArrayList<Article> arrArticle = new ArrayList<Article>();
        RecyclerView recycleArticle = (RecyclerView) findViewById(R.id.LE_RecyclerView);
        RemplirArticle(arrArticle);

        Adaptateur adaptateur = new Adaptateur(getApplicationContext(),arrArticle);
        recycleArticle.setAdapter(adaptateur);

        recycleArticle.setLayoutManager(new LinearLayoutManager(this));

        recycleArticle.setItemAnimator(new DefaultItemAnimator());
        recycleArticle.setHasFixedSize(true);

        Button btnVersPanier = (Button) findViewById(R.id.LE_btnVersPanier);

        btnVersPanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versPanier = new Intent(ListeEpicerie.this, ListeAchat.class);
                startActivity(versPanier);
            }
        });


    }

    void RemplirArticle(ArrayList<Article> listeArticles) {
        listeArticles.add(new Article("banane",1.02,getResources().getDrawable(R.drawable.banane, null),getResources().getString(R.string.articleDesc_banane)));
        listeArticles.add(new Article("cerise",4.99,getResources().getDrawable(R.drawable.cerise, null),getResources().getString(R.string.articleDesc_cerise)));
        listeArticles.add(new Article("chou",2.48,getResources().getDrawable(R.drawable.chou, null),"chou"));
        listeArticles.add(new Article("Champignon",2.48,getResources().getDrawable(R.drawable.champignon, null),getResources().getString(R.string.articleDesc_champignon)));
        listeArticles.add(new Article("courgette",1.50,getResources().getDrawable(R.drawable.courgette, null),getResources().getString(R.string.articleDesc_courgette)));
        listeArticles.add(new Article("épinard",3.99,getResources().getDrawable(R.drawable.epinard, null),getResources().getString(R.string.articleDesc_epinard)));
        listeArticles.add(new Article("Maïs",5.60,getResources().getDrawable(R.drawable.mais, null),getResources().getString(R.string.articleDesc_mais)));
        listeArticles.add(new Article("orange",0.99,getResources().getDrawable(R.drawable.orange, null),getResources().getString(R.string.articleDesc_orange)));
        listeArticles.add(new Article("pois",2.99,getResources().getDrawable(R.drawable.pois, null),getResources().getString(R.string.articleDesc_pois)));
        listeArticles.add(new Article("raisin",3.50,getResources().getDrawable(R.drawable.raisin, null),getResources().getString(R.string.articleDesc_raisin)));
    }
}