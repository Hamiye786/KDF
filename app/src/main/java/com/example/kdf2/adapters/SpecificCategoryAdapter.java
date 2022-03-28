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

public class SpecificCategoryAdapter extends RecyclerView.Adapter<SpecificCategoryAdapter.SpecificCategoryViewHolder> {

    private final Context context;
    private final List<CategoryModel> modelData;
    private final CategoriesListener listener;

    public SpecificCategoryAdapter(Context context, List<CategoryModel> modelData, CategoriesListener listener) {
        this.context = context;
        this.modelData = modelData;
        this.listener = listener;
    }


    @NonNull
    @Override
    public SpecificCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SpecificCategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.specific_category_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SpecificCategoryViewHolder holder, int position) {
        CategoryModel model = modelData.get(position);
        holder.itemName.setText(model.getName());
        holder.itemImage.setImageResource(model.getImage());
        holder.itemView.setOnClickListener(v -> listener.showCategories(position));
    }

    @Override
    public int getItemCount() {
        return modelData.size();
    }

    static class SpecificCategoryViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        ImageView itemImage;

        public SpecificCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemImage = itemView.findViewById(R.id.itemImage);
        }
    }
}
