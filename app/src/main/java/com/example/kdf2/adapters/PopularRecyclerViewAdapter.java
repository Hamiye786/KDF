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
import com.example.kdf2.interfaces.PopularListener;
import com.example.kdf2.models.PopularModel;

import java.util.List;

public class PopularRecyclerViewAdapter extends RecyclerView.Adapter<PopularRecyclerViewAdapter.PopularViewHolder> {

    private final Context context;
    private final List<PopularModel> modelData;
    private final PopularListener listener;

    public PopularRecyclerViewAdapter(Context context, List<PopularModel> modelData, PopularListener listener) {
        this.context = context;
        this.modelData = modelData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PopularViewHolder(LayoutInflater.from(context).inflate(R.layout.popular_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
        PopularModel model = modelData.get(position);
        holder.popularCategoryName.setText(model.getName());
        holder.image.setBackgroundResource(model.getImage());
        holder.itemView.setOnClickListener(view -> listener.showPopulars(position));
    }

    @Override
    public int getItemCount() {
        return modelData.size();
    }


    static class PopularViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView popularCategoryName;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.popularImageView);
            popularCategoryName = itemView.findViewById(R.id.popularCategoryName);
        }
    }
}
