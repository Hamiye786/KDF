
package com.example.kdf2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.kdf2.R;
import com.example.kdf2.adapters.AllCatergoriesAdapter;
import com.example.kdf2.interfaces.CategoriesListener;
import com.example.kdf2.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity implements CategoriesListener {

    RecyclerView categoriesRecyclerViewCA;
    List<CategoryModel> categoryModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catergories);

        categoriesRecyclerViewCA = findViewById(R.id.categoriesRecyclerViewCA);
        categoriesRecyclerViewCA.setLayoutManager(new LinearLayoutManager(this));

        categoryModelList.clear();

        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 1"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 2"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 3"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 4"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 5"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 6"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 7"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 8"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Category 9"));

        categoriesRecyclerViewCA.setAdapter(new AllCatergoriesAdapter(this, categoryModelList, this));
    }

    @Override
    public void showCategories(int position) {
        String name = categoryModelList.get(position).getName();
        Intent intent = new Intent(this, SpecificCategoryActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}