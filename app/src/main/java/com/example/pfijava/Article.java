package com.example.pfijava;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Article {
    private String nom;
    private double prix;
    private int idImage;
    private String description;

    public int getIdImage() {
        return idImage;
    }

    public void setImage(int image) {
        this.idImage = image;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String value){
        nom = value;
    }

    public double getPrix(){
        return prix;
    }

    public void setPrix(double value){
        prix = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Article(String nom, double prix, int idImage, String description) {
        this.nom = nom;
        this.prix = prix;
        this.idImage = idImage;
        this.description = description;
    }
}
