package com.example.kdf2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kdf2.MainActivity;
import com.example.kdf2.R;
import com.google.android.material.textfield.TextInputEditText;

public class CheckOutActivity extends AppCompatActivity {

    TextView itemName, itemPrice;
    EditText actualNumOfOrders;
    TextInputEditText clientAddress;
    ImageView itemImage, increaseNumOfOrders, decreaseNumOfOrders;
    Button order;
    String itemPriceData, itemNameData;
    float priceRs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        itemName = findViewById(R.id.itemName);
        itemPrice = findViewById(R.id.itemPrice);
        actualNumOfOrders = findViewById(R.id.actualNumOfOrders);
        clientAddress = findViewById(R.id.clientAddress);
        itemImage = findViewById(R.id.itemImage);
        increaseNumOfOrders = findViewById(R.id.increaseNumOfOrders);
        decreaseNumOfOrders = findViewById(R.id.decreaseNumOfOrders);
        order = findViewById(R.id.orderItem);

        itemPriceData = getIntent().getStringExtra("itemPrice");
        itemNameData = getIntent().getStringExtra("itemName");

        itemName.setText(itemNameData);
        itemPrice.setText(itemPriceData);

        itemImage.setImageResource(R.drawable.download);
        runOnUiThread(() -> {
            String pp = itemPrice.getText().toString().replace("Rs. ", "").trim();
            priceRs = Float.parseFloat(pp);
            float p = Float.parseFloat(actualNumOfOrders.getText().toString());
            float price = priceRs * p;
            itemPrice.setText(String.valueOf(price));
        });


        increaseNumOfOrders.setOnClickListener(view -> runOnUiThread(() -> {
            String orders = actualNumOfOrders.getText().toString().trim();
            int numOfOrders = Integer.parseInt(orders);
            numOfOrders++;
            actualNumOfOrders.setText(String.valueOf(numOfOrders));
        }));

        decreaseNumOfOrders.setOnClickListener(view -> runOnUiThread(() -> {
            String orders = actualNumOfOrders.getText().toString().trim();
            int numOfOrders = Integer.parseInt(orders);
            numOfOrders--;
            actualNumOfOrders.setText(String.valueOf(numOfOrders));
        }));

        order.setOnClickListener(view -> {
            Toast.makeText(CheckOutActivity.this, "Order Placed", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(CheckOutActivity.this, MainActivity.class));
            finish();
        });
    }
}