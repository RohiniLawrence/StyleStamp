package com.stylestamp.adapter;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.stylestamp.R;
import com.stylestamp.api.ApiClient;
import com.stylestamp.api.ApiInterface;
import com.stylestamp.model.Category;
import com.stylestamp.model.Product;
import com.stylestamp.response.SubCategoryResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> implements Filterable {


    List<Category> categoryList = new ArrayList<>();
    List<Category> arrCategoryListFiltered  = new ArrayList<>();
    List<Category> subCategories  ;
    SubCategoryListAdapter subCategoryListAdapter;

    Context context;
    public CategoryListAdapter(Context context, List<Category> categories  ) {
        this.categoryList = categories;
        this.arrCategoryListFiltered = categories;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.textView.setText(arrCategoryListFiltered.get(position).getCategoryName());
        final boolean isExpanded = arrCategoryListFiltered.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        subCategories =new ArrayList<>();
        holder.subCategoryRV.setAdapter(subCategoryListAdapter);
        final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        String unm = "admin";
        String pwd = "1234";
        String base = unm + ":" + pwd;
        final String keyHeader = "stylestamp@123";
        final String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);




        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Log.e("parent category", categoryList.get(position).getCategoryId());
                Call<SubCategoryResponse> call = apiInterface.getSubCategoriesById(authHeader, keyHeader, categoryList.get(position).getCategoryId());
                call.enqueue(new Callback<SubCategoryResponse>() {
                    @Override
                    public void onResponse(Call<SubCategoryResponse> call, Response<SubCategoryResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            if (!subCategories.isEmpty()) {
                                subCategories.clear();
                            }
                            Log.e("subcat-res-msg",response.body().getMessage());
                            Log.e("subcat-res-status",response.body().getStatus());

                           if(response.body().getStatus() == "0"){
                               subCategories.clear();

                                subCategories.add(new Category("NA", "View All" , null, null));
                            }
                           else if(response.body().getStatus().equals("1")){
                               Log.e("cats",String.valueOf(response.body().getSubcategories().size()));
                               subCategories = response.body().getSubcategories();
                               subCategoryListAdapter = new SubCategoryListAdapter(context, subCategories);
                           }


                        } else {
                            Log.e("attaching", "nothing-shop-subcat");

                        }
                    }
                    @Override
                    public void onFailure(Call<SubCategoryResponse> call2, Throwable t) {
                        Log.e("subcat fail", t.toString());
                    }
                });



                //expanding categories
                for(Category category: categoryList){
                    if(categoryList.indexOf(category) == position) {
                        category.setExpanded(!category.isExpanded());
                        notifyItemChanged(position);
                    }else{
                        category.setExpanded(false);
                        notifyItemChanged(categoryList.indexOf(category));
                    }
                }

            }
        });
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
