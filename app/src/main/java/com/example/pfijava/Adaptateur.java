package com.example.pfijava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptateur extends RecyclerView.Adapter<Adaptateur.MyViewHolder> {

    Context context;
    ArrayList<Article> articles;

    public Adaptateur(Context context, ArrayList<Article> arrArticle) {
        this.context = context;
        this.articles = arrArticle;
    }

    @NonNull
    @Override
    public Adaptateur.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(context);
        View itemView = inflator.inflate(R.layout.ligne_article, parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptateur.MyViewHolder holder, int position) {
        String nom = articles.get(position).getNom();
        String prix = articles.get(position).getPrix() + " $";
        holder.articleNom.setText(nom);
        holder.articlePrix.setText(prix);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView articleNom;
        TextView articlePrix;
        View uneLigne;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            articleNom = (TextView) itemView.findViewById(R.id.LA_txtNomArticle);
            articlePrix = (TextView) itemView.findViewById(R.id.LA_txtPrix);
            uneLigne = (View) itemView.findViewById(R.id.LA_constraint);
        }


    }

}
