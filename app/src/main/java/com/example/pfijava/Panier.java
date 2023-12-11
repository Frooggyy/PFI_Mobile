package com.example.pfijava;

import java.util.HashMap;
import java.util.Map;

/**
 * Auteur: Kéven
 * Cette classe permet d'instancier un panier et de pouvoir
 * y accéder partout dans l'application en appelant getInstance()
 * puisque le panierInstance est static il reste le même entres les
 * changement d'activités
 */
public class Panier {
    private static Panier panierInstance;
    private HashMap<String, Integer> articlesDansPanier;

    private HashMap<String, Double> prixArticles;

    private Panier() {
        articlesDansPanier = new HashMap<>();
        prixArticles = new HashMap<>();
    }

    /**
     * Cette classe permet de retourner l'instace du panier
     * si elle existe, sinon elle en crée une nouvelle
     * @return l'instance du panier
     */
    public static Panier getInstance() {
        if (panierInstance == null) {
            panierInstance = new Panier();
        }
        return panierInstance;
    }

    /**
     * Permet d'ajouter un article à la liste des articles du panier
     * @param nomArticle nom de l'article
     * @param quantite  quantité à ajouter dans le panier
     * @param prixArticle Prix de l'article
     */
    public void ajouterArticle(String nomArticle, int quantite, Double prixArticle) {
        if (articlesDansPanier.containsKey(nomArticle)) {
            int quantiteActuelle = articlesDansPanier.get(nomArticle);
            articlesDansPanier.put(nomArticle, quantiteActuelle + quantite);
            prixArticles.put(nomArticle, prixArticle);
        } else {
            articlesDansPanier.put(nomArticle, quantite);
            prixArticles.put(nomArticle, prixArticle);
        }
    }

    /**
     * Permet de retirer un article du panier
     * @param nomArticle nom de l'article à retirer
     * @param quantite  quatité à retirer
     */
    public void retirerArticle(String nomArticle, int quantite) {
        if (articlesDansPanier.containsKey(nomArticle)) {
            int quantiteActuelle = articlesDansPanier.get(nomArticle);
            if (quantiteActuelle - quantite > 0) {
                articlesDansPanier.put(nomArticle, quantiteActuelle - quantite);
            } else {
                articlesDansPanier.remove(nomArticle);
                prixArticles.remove(nomArticle);
            }
        }
    }

    /**
     * Permet de calculer le prix total du panier
     * @param prixArticles  prix de chaque article
     * @return le total du prix du panier
     */
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

    /**
     * permet de savoir la quantité d'un certain article dans le panier
     * @param nomArticle nom de l'article
     * @return  le nombre de cet article dans le panier
     */
    public int getQuantiteArticle(String nomArticle) {
        return articlesDansPanier.getOrDefault(nomArticle, 0);
    }

    /**
     * @return  le total du prix d'un article lié avec son nom
     */
    public HashMap<String, Double> getPrixArticles() {
        return prixArticles;
    }

    /**
     * Permet de savoir quels articles sont dans le panier
     * @return le nom de l'article ainsi que sa quantité dans le panier
     */
    public HashMap<String, Integer> getArticlesDansPanier() {
        return articlesDansPanier;
    }

    /**
     * vide l'entièreté du panier
     */
    public void viderPanier() {
        articlesDansPanier.clear();
    }

    /**
     * Calcule le prix total du panier
     * @return le prix total du panier
     */
    public double calculerPrixTotal() {
        return calculerTotal(prixArticles);
    }

    /**
     * check si un certain article est dans le panier
     * @param nomArticle nom de l'article
     * @return true si l'article est dans le panier, false si le contraire
     */
    public boolean ArticleDansPanier(String nomArticle) {
        if (articlesDansPanier.containsKey(nomArticle)) {
            return true;
        }
        return false;
    }

    /**
     * regarde s'il y a un item dans le panier
     * @return true si le panier n'est pas vide
     */
    public boolean ArticleDansPanier() {
        if (articlesDansPanier.size() > 0) {
            return true;
        }
        return false;
    }
}
