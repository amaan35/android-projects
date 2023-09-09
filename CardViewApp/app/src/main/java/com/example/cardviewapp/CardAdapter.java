package com.example.cardviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder>{

    private List<CardItem> cardItems;

    public CardClickListener clickListener;

    public CardAdapter(List<CardItem> cardItems) {
        this.cardItems = cardItems;
    }

    public void setOnCardClickListener(CardClickListener clickListener){
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardlayout, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem item = cardItems.get(position);
        holder.textView.setText(item.getSportName());
        holder.imageView.setImageResource(item.getSportImage());
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
        ImageView imageView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.id_cardText);
            imageView = itemView.findViewById(R.id.id_cardImage);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(clickListener!=null){
                clickListener.onClickCard(view, getAdapterPosition());
            }
        }
    }
}
