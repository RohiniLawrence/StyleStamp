package com.stylestamp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.stylestamp.R;
import com.stylestamp.controller.ProductDetail;
import com.stylestamp.model.Product;

import java.util.List;

public class OrderDetailListAdapter extends RecyclerView.Adapter<OrderDetailListAdapter.MyViewHolder> {


    private Context context;
    private List<Product> products;

    public OrderDetailListAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.ordered_product_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.productTitle.setText(products.get(position).getProductName());
        holder.productPrice.setText(String.valueOf(products.get(position).getPrice()));
        holder.productID.setText("Not Available");
        holder.quantity.setText("Not Available");
        holder.size.setText("Not Available");
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) context;
                ProductDetail productDetailFragment = new ProductDetail(products.get(position).getProductId());
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, productDetailFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView productID, productTitle, productPrice, quantity, size, totalPrice;
        ImageView productImage;
        CardView card;

        public MyViewHolder(View itemView) {
            super(itemView);
            productID = (TextView) itemView.findViewById(R.id.productId_orderDetail);
            productTitle = (TextView) itemView.findViewById(R.id.title_orderDetail);
            productPrice = (TextView) itemView.findViewById(R.id.price_orderDetail);
            productImage = (ImageView) itemView.findViewById(R.id.productImage_orderDetail);
            quantity = (TextView) itemView.findViewById(R.id.quantity_orderDetail);
            size = (TextView) itemView.findViewById(R.id.size_orderDetail);
            card = (CardView) itemView.findViewById(R.id.orderedProductCard);
        }
    }
}
