package com.example.pfijava;

public class Article {
    private String nom;
    private double prix;
    private String image;
    private String description;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Article(String nom, double prix, String image, String description) {
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.description = description;
    }
}
