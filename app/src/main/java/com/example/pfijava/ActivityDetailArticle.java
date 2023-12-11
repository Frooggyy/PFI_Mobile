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

        Button btnAnnuler = findViewById(R.id.btn_annuler);
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

//         btnAnnuler.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 Intent versLE = new Intent(ActivityDetailArticle.this, ListeEpicerie.class);
//                 startActivity(versLE);
// =======
//                 Panier panier = Panier.getInstance();
//                 int nbArticles;
//                 if(nbAjouter.getText().toString().equals("")){
//                     nbArticles = 0;
//                 }else{
//                     nbArticles = parseInt(nbAjouter.getText().toString());
//                     for(int i=1; i<= nbArticles;i++){
//                         panier.ajouterArticle(nom, prix);
//                     }
//                 }
//                 nbAjouter.setText("0");
//             }
//         });

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versListe = new Intent(ActivityDetailArticle.this, ListeEpicerie.class);
                startActivity(versListe);

            }
        });
    }


}