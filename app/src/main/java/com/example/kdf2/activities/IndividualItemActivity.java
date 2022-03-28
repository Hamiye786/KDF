package com.example.kdf2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kdf2.R;

public class IndividualItemActivity extends AppCompatActivity {

    ImageView itemImage;
    TextView itemName, itemPrice, itemRating, peopleRated, itemDesc;
    Button orderButton;
    String nameOfItem;
    int imgOfItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_individual_item);
        getSupportActionBar().hide();

        itemImage = findViewById(R.id.itemImage);
        itemName = findViewById(R.id.itemName);
        itemPrice = findViewById(R.id.itemPrice);
        itemRating = findViewById(R.id.itemRating);
        peopleRated = findViewById(R.id.peopleRated);
        itemDesc = findViewById(R.id.itemDesc);
        orderButton = findViewById(R.id.orderButton);

        nameOfItem = getIntent().getStringExtra("name");
        imgOfItem = getIntent().getIntExtra("image", -1);

        itemName.setText(nameOfItem);
        itemImage.setImageResource(R.drawable.download);

        orderButton.setOnClickListener(view -> {
            Intent intent = new Intent(IndividualItemActivity.this, CheckOutActivity.class);
            intent.putExtra("itemPrice", itemPrice.getText().toString());
            intent.putExtra("itemName", itemName.getText().toString());
            startActivity(intent);
        });
    }
}