package com.stylestamp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stylestamp.R;
import com.stylestamp.model.Category;
import com.stylestamp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> implements Filterable {


    ArrayList<Category> categoryList;
    ArrayList<Category> arrCategoryListFiltered;
    ArrayList<Category> subCategoryList;
    SubCategoryListAdapter subCategoryListAdapter;

    Context context;
    public CategoryListAdapter(Context context, ArrayList<Category> categories , ArrayList<Category> subCategories ) {
        this.categoryList = categories;
        this.arrCategoryListFiltered = categories;
        this.subCategoryList = subCategories;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.category_row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.textView.setText(arrCategoryListFiltered.get(position).getCategoryName());
        boolean isExpanded = arrCategoryListFiltered.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded?View.VISIBLE:View.GONE);

    }

    @Override
    public int getItemCount() {
        return arrCategoryListFiltered.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        RecyclerView subCategoryRV;
        LinearLayout expandableLayout;
        TextView textView ;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.rowTextView);
            itemView.setOnClickListener(this);
            expandableLayout = itemView.findViewById(R.id.expandable);
            subCategoryRV =  (RecyclerView)  itemView.findViewById(R.id.subcategory_recycler_view);
            subCategoryListAdapter = new SubCategoryListAdapter(context, subCategoryList );
            subCategoryRV.setAdapter(subCategoryListAdapter);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
//                    subCategoryRV.addItemDecoration(dividerItemDecoration);
                    Category category =categoryList.get(getAdapterPosition());
                    category.setExpanded(!category.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                Log.i("Adapter","character String" + charString);
                if (charString.isEmpty()) {
                    arrCategoryListFiltered = categoryList;
                } else {
                    ArrayList<Category> filteredList = new ArrayList<>();
                    for (Category row : categoryList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getCategoryName().toLowerCase().contains(charString.toLowerCase()) || row.getCategoryName().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    arrCategoryListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = arrCategoryListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                arrCategoryListFiltered = (ArrayList<Category>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
