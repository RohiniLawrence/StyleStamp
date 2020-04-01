package com.stylestamp.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.stylestamp.R;
import com.stylestamp.model.CartItem;

import java.util.List;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.MyViewHolder> {
    private Context context;
    private List<CartItem> cartItems;
    Dialog dialog;

    public CartListAdapter(Context context, List<CartItem> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.cart_item_card, parent, false);
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.edit_cart_item_card);
        Button  saveEdit, cancelEdit;
        saveEdit = (Button) dialog.findViewById(R.id.saveEditCartItem);
        cancelEdit = (Button) dialog.findViewById(R.id.cancelEditCartItem);

        saveEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        cancelEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.productTitle.setText("adssada");
        holder.productPrice.setText("26.97");
        holder.productID.setText("23231");
        holder.quantity.setText("Not Available");
        holder.size.setText("Not Available");


        holder.removeCartItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //write more code here afterwards *#*#
              }
        });

        holder.editCartItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView productID, productTitle, productPrice, quantity, size, totalPrice;
        ImageView productImage;

        Button editCartItem, removeCartItem ;
        public MyViewHolder(View itemView) {
            super(itemView);

            productID = (TextView) itemView.findViewById(R.id.productId_cartItem);
            productTitle = (TextView) itemView.findViewById(R.id.title_cartItem);
            productPrice = (TextView) itemView.findViewById(R.id.price_cartItem);
            productImage = (ImageView) itemView.findViewById(R.id.productImage_cartItem);
            quantity = (TextView) itemView.findViewById(R.id.quantity_cartItem);
            size = (TextView) itemView.findViewById(R.id.size_cartItem);
            editCartItem = (Button) itemView.findViewById(R.id.editCartItem);
            removeCartItem = (Button) itemView.findViewById(R.id.removeCartItem);

        }
    }
}
