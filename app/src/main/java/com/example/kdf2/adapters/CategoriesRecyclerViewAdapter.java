package com.example.kdf2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kdf2.R;
import com.example.kdf2.interfaces.CategoriesListener;
import com.example.kdf2.models.CategoryModel;

import java.util.List;

public class CategoriesRecyclerViewAdapter extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.CategoriesViewHolder> {

    private final Context context;
    private final List<CategoryModel> modelData;
    private final CategoriesListener listener;

    public CategoriesRecyclerViewAdapter(Context context, List<CategoryModel> modelData, CategoriesListener listener) {
        this.context = context;
        this.modelData = modelData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoriesRecyclerViewAdapter.CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoriesRecyclerViewAdapter.CategoriesViewHolder(LayoutInflater.from(context).inflate(R.layout.popular_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesRecyclerViewAdapter.CategoriesViewHolder holder, int position) {
        CategoryModel model = modelData.get(position);
        holder.popularCategoryName.setText(model.getName());
        holder.image.setBackgroundResource(model.getImage());
        holder.itemView.setOnClickListener(view -> listener.showCategories(position));
    }

    @Override
    public int getItemCount() {
        return modelData.size();
    }


    static class CategoriesViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView popularCategoryName;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.popularImageView);
            popularCategoryName = itemView.findViewById(R.id.popularCategoryName);
        }
    }
}
