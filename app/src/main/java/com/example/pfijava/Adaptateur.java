package com.example.pfijava;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptateur extends RecyclerView.Adapter<Adaptateur.MyViewHolder> {

    Context context;
    ArrayList<Article> articles;
    OnClickListener onClickListener;    // TOUTE LA SECTION DE ONLCICKLISTENER DU RECYCLER VIEW
                                        // PRIS DE https://www.geeksforgeeks.org/how-to-apply-onclicklistener-to-recyclerview-items-in-android/

    public Adaptateur(Context con, ArrayList<Article> arrArticle) {
        this.context = con;
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

        int img = articles.get(position).getIdImage();


        holder.articleNom.setText(nom);
        holder.articlePrix.setText(prix);
        holder.articleImage.setImageResource(img);


        holder.articleLigne.setOnClickListener(new View.OnClickListener() { // TOUTE LA SECTION DE ONLCICKLISTENER DU RECYCLER VIEW
                                                                            // PRIS DE https://www.geeksforgeeks.org/how-to-apply-onclicklistener-to-recyclerview-items-in-android/
            @Override
            public void onClick(View v) {
                if(onClickListener != null){
                    onClickListener.onClick(articles.get(position));
                }
            }
        });



    }
    public void setOnClickListener(OnClickListener onClickListener) {// TOUTE LA SECTION DE ONLCICKLISTENER DU RECYCLER VIEW
                                                                    // PRIS DE https://www.geeksforgeeks.org/how-to-apply-onclicklistener-to-recyclerview-items-in-android/
        this.onClickListener = onClickListener;
    }
    public interface OnClickListener {                              // TOUTE LA SECTION DE ONLCICKLISTENER DU RECYCLER VIEW
                                                                    // PRIS DE https://www.geeksforgeeks.org/how-to-apply-onclicklistener-to-recyclerview-items-in-android/
        void onClick(Article article);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout articleLigne;
        TextView articleNom;
        TextView articlePrix;
        ImageView articleImage;
        View uneLigne;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            articleLigne = itemView.findViewById(R.id.LA_LinearLayout);
            articleImage = (ImageView) itemView.findViewById(R.id.LA_img);
            articleNom = (TextView) itemView.findViewById(R.id.LA_txtNomArticle);
            articlePrix = (TextView) itemView.findViewById(R.id.LA_txtPrix);
            uneLigne = (View) itemView.findViewById(R.id.LA_constraint);
        }


    }

}
