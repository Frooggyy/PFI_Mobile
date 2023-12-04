package com.example.pfijava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean loginValide = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextNom = (EditText) findViewById(R.id.AM_txtNom);
        EditText editTextPassword = (EditText) findViewById(R.id.AM_txtPassword);
        Button btnLogin = (Button) findViewById(R.id.AM_btnLogin);

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