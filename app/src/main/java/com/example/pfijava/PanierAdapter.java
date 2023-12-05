package com.example.pfijava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfijava.Article;
import com.example.pfijava.Panier;
import com.example.pfijava.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PanierAdapter extends RecyclerView.Adapter<PanierAdapter.PanierViewHolder> {

    private Context context;
    private List<Map.Entry<String, Integer>> ListArticles;

    public PanierAdapter(Context context) {
        this.context = context;
        this.ListArticles = new ArrayList<>(Panier.getInstance().getArticlesDansPanier().entrySet());
        updateList();
    }

    @NonNull
    @Override
    public PanierViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.ligne_panier, parent, false);
        return new PanierViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PanierViewHolder holder, int position) {
        Map.Entry<String, Integer> entry = ListArticles.get(position);
        String nomArticle = entry.getKey();
        int quantite = entry.getValue();

        double prixArticle = Panier.getInstance().getPrixArticles().getOrDefault(nomArticle, 0.0);

        double total = prixArticle * quantite;
        String totalArrondi = String.format("%.2f", total);

        holder.Nom.setText(nomArticle);
        holder.Qty.setText(String.valueOf(quantite));
        holder.Prix.setText(totalArrondi + " $");

        int imgID = context.getResources().getIdentifier(nomArticle, "drawable", context.getPackageName());

        if (imgID != 0) {
            holder.img.setImageResource(imgID);
        } else {
            holder.img.setImageResource(R.drawable.nondefini);
        }

    }

    @Override
    public int getItemCount() {
        return ListArticles.size();
    }

    public static class PanierViewHolder extends RecyclerView.ViewHolder {
        TextView Nom;
        TextView Qty;
        TextView Prix;
        ImageView img;

        public PanierViewHolder(@NonNull View itemView) {
            super(itemView);
            Nom = itemView.findViewById(R.id.LP_txtNomArticle);
            Qty = itemView.findViewById(R.id.LP_txtQty);
            Prix = itemView.findViewById(R.id.LP_txtPrix);
            img = itemView.findViewById(R.id.LP_imageView);
        }
    }

    public void clearList() {
        ListArticles.clear();
    }

    public void setList(Map<String, Integer> articlesDansPanier) {
        this.ListArticles = new ArrayList<>(articlesDansPanier.entrySet());
    }

    public void updateList() {
        this.ListArticles = new ArrayList<>(Panier.getInstance().getArticlesDansPanier().entrySet());
    }
}
