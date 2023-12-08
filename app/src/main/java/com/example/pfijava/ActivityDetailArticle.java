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

import org.w3c.dom.Text;

public class ActivityDetailArticle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_article);

        //Prendre tous Extras
        Intent i = getIntent();
        String nom = i.getStringExtra("nom");
        String prix = i.getStringExtra("prix");
        String desc = i.getStringExtra("desc");
        Drawable img = (Drawable) i.getSerializableExtra("image");

        //Trouver tous les Views du layout
        TextView txtNom = findViewById(R.id.DA_nomArticle);
        TextView txtPrix = findViewById(R.id.DA_PrixArticle);
        ImageView imgArticle = findViewById(R.id.DA_imgArticle);
        TextView txtDesc = findViewById(R.id.DA_DescArticle);

        //Mettre le texte et les images dans les views
        txtNom.setText(nom);
        txtPrix.setText(prix);
        txtDesc.setText(desc);
        imgArticle.setImageDrawable(img);

        //Faire les OnClickListener des boutons dans Details Articles
        Button btnAjouter1 = findViewById(R.id.DA_btnPlus1);
        Button btnRetirer1 = findViewById(R.id.DA_btnMoins1);
        Button btnAjouterPanier = findViewById(R.id.DA_btnAjouterPanier);
        EditText nbAjouter = findViewById(R.id.DA_nbAjouter);

        btnAjouter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nbArticles = parseInt(nbAjouter.getText().toString());
                nbArticles++;
                nbAjouter.setText(nbArticles);
            }
        });
        btnRetirer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nbArticles = parseInt(nbAjouter.getText().toString());
                if(nbArticles-1 > 0){
                    nbArticles--;
                }
                nbAjouter.setText(nbArticles);
            }
        });
    }
}