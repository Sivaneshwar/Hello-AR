package com.example.helloar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.MyViewHolder>  {
    private List <Items> itemList;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        ImageView productImage;
        CardView productCard;

        public MyViewHolder(View v) {
            super(v);
            productCard = v.findViewById(R.id.cardView);
            productName = v.findViewById(R.id.productName);
            productImage = v.findViewById(R.id.productImage);
        }
    }

    public recyclerViewAdapter(Context context, List <Items> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public recyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.products, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Items item = itemList.get(position);

        holder.productImage.setImageDrawable(context.getResources().getDrawable(item.getItemImage()));
        holder.productName.setText(item.getItemName());

        holder.productCard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("type", item.getItemNo());
                context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return itemList.size();
    }
}
