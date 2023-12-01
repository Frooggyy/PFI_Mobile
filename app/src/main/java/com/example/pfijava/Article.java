package com.example.pfijava;

public class Article {
    private String nom;
    private double prix;
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

    public Article(String nomArticle, double prixArticle){
        setNom(nomArticle);
        setPrix(prixArticle);
    }

}
