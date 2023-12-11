package com.example.pfijava;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.RED;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Auteur:Kéven
 * Cette classe est liée au layout acitivy_main
 * Elle contient une page de connexion ou l'utilisateur
 * doit entrer un nom d'utilisateur et un mot de passe
 * afin de pouvoir accéder au reste de l'application
 */
public class MainActivity extends AppCompatActivity {

    boolean loginValide = false;
    Boolean fini = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextNom = (EditText) findViewById(R.id.AM_txtNom);
        EditText editTextPassword = (EditText) findViewById(R.id.AM_txtPassword);
        Button btnLogin = (Button) findViewById(R.id.AM_btnLogin);

        Thread thChangeCouleur = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("***Thread Change Couleur",
                        "id: " + Thread.currentThread().getId());
                while (!fini) {
                    TextView txtTitre = findViewById(R.id.AM_txtBienvenue);
                    txtTitre.setTextColor(BLUE); //Pris sur https://developer.android.com/reference/android/graphics/Color#BLUE pour trouver la valeur INT de bleu
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    txtTitre.setTextColor(RED); //Pris sur https://developer.android.com/reference/android/graphics/Color#BLUE pour trouver la valeur INT de rouge
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thChangeCouleur.start();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = editTextNom.getText().toString();
                String password = editTextPassword.getText().toString();
                String txtToast = getResources().getString(R.string.errorLogin);

                if(!nom.isEmpty() && !password.isEmpty()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Log.i("***Thread Login",
                                    "id: " + Thread.currentThread().getId());
                            loginValide = true;
                            Intent versLE = new Intent(MainActivity.this, ListeEpicerie.class);
                            fini = true;
                            startActivity(versLE);
                        }
                    }).start();

                }
                else {
                    Toast.makeText(MainActivity.this, txtToast, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}