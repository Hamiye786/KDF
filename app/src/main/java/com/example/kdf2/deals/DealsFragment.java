package com.example.kdf2.deals;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kdf2.R;
import com.example.kdf2.activities.CategoriesActivity;
import com.example.kdf2.activities.IndividualItemActivity;
import com.example.kdf2.adapters.CategoriesRecyclerViewAdapter;
import com.example.kdf2.adapters.PopularRecyclerViewAdapter;
import com.example.kdf2.interfaces.CategoriesListener;
import com.example.kdf2.interfaces.PopularListener;
import com.example.kdf2.models.CategoryModel;
import com.example.kdf2.models.PopularModel;

import java.util.ArrayList;
import java.util.List;

public class DealsFragment extends Fragment implements CategoriesListener, PopularListener {

    RecyclerView popularRecyclerView, categoriesRecyclerView;
    PopularRecyclerViewAdapter popularRecyclerViewAdapter;
    CategoriesRecyclerViewAdapter categoriesRecyclerViewAdapter;
    List<CategoryModel> categoryModelList = new ArrayList<>();
    List<PopularModel> popularModelList = new ArrayList<>();
    CardView dealOfTheDayCV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deals, container, false);
        popularRecyclerView = view.findViewById(R.id.popularRecyclerView);
        categoriesRecyclerView = view.findViewById(R.id.categoriesRecyclerView);
        dealOfTheDayCV = view.findViewById(R.id.dealOfTheDayCV);
        popularRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        setAdapters();

        dealOfTheDayCV.setOnClickListener(v ->{
            Intent intent = new Intent(requireContext(), IndividualItemActivity.class);
            intent.putExtra("name",  "Best Deal");
//        intent.putExtra("image", categoryModelList.get(position).getImage());
            startActivity(intent);
        });
        return view;
    }
    
    private void setAdapters() {
        categoryModelList.clear();
        popularModelList.clear();
        
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 1"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 2"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 3"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 4"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 5"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 6"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 7"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 8"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 9"));

        popularModelList.add(new PopularModel(R.drawable.download, "Category 1"));
        popularModelList.add(new PopularModel(R.drawable.download, "Category 2"));
        popularModelList.add(new PopularModel(R.drawable.download, "Category 3"));
        popularModelList.add(new PopularModel(R.drawable.download, "Category 4"));
        popularModelList.add(new PopularModel(R.drawable.download, "Category 5"));
        popularModelList.add(new PopularModel(R.drawable.download, "Category 6"));
        popularModelList.add(new PopularModel(R.drawable.download, "Category 7"));
        popularModelList.add(new PopularModel(R.drawable.download, "Category 8"));
        popularModelList.add(new PopularModel(R.drawable.download, "Category 9"));

        categoriesRecyclerViewAdapter = new CategoriesRecyclerViewAdapter(requireContext(),categoryModelList, this);
        popularRecyclerViewAdapter = new PopularRecyclerViewAdapter(requireContext(),popularModelList, this);

        categoriesRecyclerView.setAdapter(categoriesRecyclerViewAdapter);
        popularRecyclerView.setAdapter(popularRecyclerViewAdapter);
    }

    @Override
    public void showCategories(int position) {
        Intent intent = new Intent(requireContext(), CategoriesActivity.class);
        startActivity(intent);
    }

    @Override
    public void showPopulars(int position) {
        Intent intent = new Intent(requireContext(), IndividualItemActivity.class);
        intent.putExtra("name", popularModelList.get(position).getName());
        intent.putExtra("image", popularModelList.get(position).getImage());
        startActivity(intent);
    }
}