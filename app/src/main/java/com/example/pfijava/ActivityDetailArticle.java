package com.example.pfijava;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Auteur:Gabriel
 * Cette classe est liée au layout activity_detail_article
 * Lorsque l'utilisateur clique sur un article dans la page précédante,
 * il sera redirigé ici
 * Cette activité montre une image de l'article ainsi que son nom, son prix et sa description
 * et permet d'ajouter un certain nombre d'articles dans le panier de l'utilisateur
 * ce nombre est spécifié par l'utilisateur grâce à un EditText(Number) avec des boutons
 * qui incrémentent cette valeur de +1 ou -1
 *
 */
public class ActivityDetailArticle extends AppCompatActivity {
    private Panier panier;
    int quantite = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_article);
        panier = Panier.getInstance();

        //Prendre tous Extras
        Intent i = getIntent();
        String nom = i.getStringExtra("nom");
        double prix = i.getDoubleExtra("prix",0);
        String desc = i.getStringExtra("desc");
        int img = i.getIntExtra("image", 0);

        //Trouver tous les Views du layout
        TextView txtNom = findViewById(R.id.DA_nomArticle);
        TextView txtPrix = findViewById(R.id.DA_PrixArticle);
        ImageView imgArticle = findViewById(R.id.DA_imgArticle);
        TextView txtDesc = findViewById(R.id.DA_DescArticle);

        //Mettre le texte et les images dans les views
        txtNom.setText(nom);
        txtPrix.setText(String.valueOf(prix));
        txtDesc.setText(desc);
        imgArticle.setImageResource(img);

        //Faire les OnClickListener des boutons dans Details Articles
        Button btnAjouter1 = findViewById(R.id.DA_btnPlus1);
        Button btnRetirer1 = findViewById(R.id.DA_btnMoins1);
        Button btnAjouterPanier = findViewById(R.id.DA_btnAjouterPanier);

        Button btnRetour = findViewById(R.id.DA_btnRetour);
        EditText nbAjouter = findViewById(R.id.DA_nbAjouter);

        btnAjouter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nbArticles;
                if(nbAjouter.getText().toString().equals("")){
                    nbArticles = 0;
                }else{
                   nbArticles = parseInt(nbAjouter.getText().toString());
                }
                nbArticles++;
                quantite = nbArticles;
                nbAjouter.setText(String.valueOf(nbArticles));
            }
        });
        btnRetirer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nbArticles = parseInt(nbAjouter.getText().toString());
                if(nbArticles-1 >= 0){
                    nbArticles--;
                }
                quantite = nbArticles;
                nbAjouter.setText(String.valueOf(nbArticles));
            }
        });

        btnAjouterPanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(quantite > 0){
                    panier.ajouterArticle(nom, quantite, prix);
                    Intent versLE = new Intent(ActivityDetailArticle.this, ListeEpicerie.class);
                    startActivity(versLE);
                } else {
                    Toast.makeText(ActivityDetailArticle.this, getResources().getString(R.string.DA_Toast_quantite), Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnRetour.setOnClickListener(new View.OnClickListener() {
           @Override
          public void onClick(View v) {
               Intent versListe = new Intent(ActivityDetailArticle.this, ListeEpicerie.class);
               startActivity(versListe);
           }
        });
    }


}