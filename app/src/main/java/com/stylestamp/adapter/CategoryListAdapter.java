package com.stylestamp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stylestamp.R;
import com.stylestamp.model.Category;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {


    List<Category> categoryList;
    List<Category> subCategoryList;
    SubCategoryListAdapter subCategoryListAdapter;

    Context context;
    public CategoryListAdapter(Context context, List<Category> categories , List<Category> subCategories ) {
        this.categoryList = categories;
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
        holder.textView.setText(categoryList.get(position).getCategoryName());
        boolean isExpanded = categoryList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded?View.VISIBLE:View.GONE);






    }

    @Override
    public int getItemCount() {
        return categoryList.size();
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
}
