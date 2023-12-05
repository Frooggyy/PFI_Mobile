package com.example.pfijava;

import java.util.HashMap;
import java.util.Map;

public class Panier {
    private static Panier panierInstance;
    private HashMap<String, Integer> articlesDansPanier;

    private HashMap<String, Double> prixArticles;

    private Panier() {
        articlesDansPanier = new HashMap<>();
        prixArticles = new HashMap<>();
    }

    public static Panier getInstance() {
        if (panierInstance == null) {
            panierInstance = new Panier();
        }
        return panierInstance;
    }

    public void ajouterArticle(String nomArticle, Double prixArticle) {
        if (articlesDansPanier.containsKey(nomArticle)) {
            int quantiteActuelle = articlesDansPanier.get(nomArticle);
            articlesDansPanier.put(nomArticle, quantiteActuelle + 1);
            prixArticles.put(nomArticle, prixArticle);
        } else {
            articlesDansPanier.put(nomArticle, 1);
            prixArticles.put(nomArticle, prixArticle);
        }
    }

    public void retirerArticle(String nomArticle) {
        if (articlesDansPanier.containsKey(nomArticle)) {
            int quantiteActuelle = articlesDansPanier.get(nomArticle);
            if (quantiteActuelle > 1) {
                articlesDansPanier.put(nomArticle, quantiteActuelle - 1);
            } else {
                articlesDansPanier.remove(nomArticle);
                prixArticles.remove(nomArticle);
            }
        }
    }

    public double calculerTotal(Map<String, Double> prixArticles) {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : articlesDansPanier.entrySet()) {
            String nomArticle = entry.getKey();
            int quantite = entry.getValue();
            double prixArticle = prixArticles.getOrDefault(nomArticle, 0.0);
            total += prixArticle * quantite;
        }
        return total;
    }

    public int getQuantiteArticle(String nomArticle) {
        return articlesDansPanier.getOrDefault(nomArticle, 0);
    }

    public HashMap<String, Double> getPrixArticles() {
        return prixArticles;
    }

    public HashMap<String, Integer> getArticlesDansPanier() {
        return articlesDansPanier;
    }

    public void viderPanier() {
        articlesDansPanier.clear();
    }

    public double calculerPrixTotal() {
        return calculerTotal(prixArticles);
    }
}
