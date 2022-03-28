package com.example.kdf2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.kdf2.R;
import com.example.kdf2.adapters.AllCatergoriesAdapter;
import com.example.kdf2.adapters.SpecificCategoryAdapter;
import com.example.kdf2.interfaces.CategoriesListener;
import com.example.kdf2.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class SpecificCategoryActivity extends AppCompatActivity implements CategoriesListener {

    RecyclerView specificCatgoriesRV;
    SpecificCategoryAdapter adapter;
    List<CategoryModel> categoryModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_category);

        specificCatgoriesRV = findViewById(R.id.specificCatgoriesRV);
        specificCatgoriesRV.setLayoutManager(new GridLayoutManager(this, 2));

        categoryModelList.clear();

        categoryModelList.add(new CategoryModel(R.drawable.download, "Item 1"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Item 2"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Item 3"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Item 4"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Item 5"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Item 6"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Item 7"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Item 8"));
        categoryModelList.add(new CategoryModel(R.drawable.download, "Item 9"));

        adapter = new SpecificCategoryAdapter(this, categoryModelList, this);
        specificCatgoriesRV.setAdapter(adapter);
    }

    @Override
    public void showCategories(int position) {
        Intent intent = new Intent(this, IndividualItemActivity.class);
        intent.putExtra("name",  categoryModelList.get(position).getName());
//        intent.putExtra("image", categoryModelList.get(position).getImage());
        startActivity(intent);
    }
}