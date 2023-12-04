package com.example.pfijava;

import java.util.HashMap;
import java.util.Map;

public class Panier  {
    private HashMap<Article, Integer> articlesDansPanier;

    public Panier() {
        articlesDansPanier = new HashMap<>();
    }

    public void ajouterArticle(Article article) {
        if (articlesDansPanier.containsKey(article)) {
            int quantiteActuelle = articlesDansPanier.get(article);
            articlesDansPanier.put(article, quantiteActuelle + 1);
        } else {
            articlesDansPanier.put(article, 1);
        }
    }

    public void retirerArticle(Article article) {
        if (articlesDansPanier.containsKey(article)) {
            int quantiteActuelle = articlesDansPanier.get(article);
            if (quantiteActuelle > 1) {
                articlesDansPanier.put(article, quantiteActuelle - 1);
            } else {
                articlesDansPanier.remove(article);
            }
        }
    }

    public double calculerTotal() {
        double total = 0.0;
        for (Map.Entry<Article, Integer> entry : articlesDansPanier.entrySet()) {
            Article article = entry.getKey();
            int quantite = entry.getValue();
            total += article.getPrix() * quantite;
        }
        return total;
    }

    public int getQuantiteArticle(Article article) {
        return articlesDansPanier.getOrDefault(article, 0);
    }

    public HashMap<Article, Integer> getArticlesDansPanier() {
        return articlesDansPanier;
    }

    public void viderPanier() {
        articlesDansPanier.clear();
    }
}
