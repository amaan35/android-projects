package com.example.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemLayoutViewHolder> {

    private List<Item> itemList;
    public ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener listener){
        this.itemClickListener = listener;
    }

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemLayoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ItemLayoutViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLayoutViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.title.setText(item.getItemTitle());
        holder.desc.setText(item.getItemDesc());
        holder.image.setImageResource(item.getItemImage());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemLayoutViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView title, desc;
        public ItemLayoutViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.id_imageView);
            title = itemView.findViewById(R.id.id_titleText);
            desc = itemView.findViewById(R.id.id_description);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemClickListener!=null){
                itemClickListener.onClick(view, getAdapterPosition());
            }
        }
    }
}
