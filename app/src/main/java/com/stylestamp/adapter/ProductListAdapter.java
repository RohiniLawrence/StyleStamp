package com.stylestamp.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.stylestamp.R;
import com.stylestamp.model.Product;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder>{


    private Context context;
    private List<Product> products;

    public ProductListAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.product_card, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.productTitle.setText(products.get(position).getName());
        holder.productPrice.setText(String.valueOf(products.get(position).getPrice()));
        //holder.productImage.setImageResource(products.get(position).getImages().get(0));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView productTitle , productPrice;
        ImageView productImage;
        public MyViewHolder(View itemView){
            super(itemView);
            productTitle = (TextView) itemView.findViewById(R.id.productTitle);
            productPrice = (TextView) itemView.findViewById(R.id.productPrice);
            productImage = (ImageView) itemView.findViewById(R.id.productImage);
        }
    }
}