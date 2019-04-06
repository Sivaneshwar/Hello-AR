package com.example.helloar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Purchase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        Intent intent = getIntent();
        int type = intent.getIntExtra("type", -1);
        Items item = getItem(type);

        if(item == null){
            Intent returnToChoice = new Intent(Purchase.this, ChoiceActivity.class);
            startActivity(returnToChoice);
        }
        else {
            ImageView itemImage = (ImageView) findViewById(R.id.itemImage);
            TextView itemName = (TextView) findViewById(R.id.itemName);
            TextView itemPrice = (TextView) findViewById(R.id.itemPrice);
            TextView itemManufacturer = (TextView) findViewById(R.id.itemManufacturer);
            TextView itemRating = (TextView) findViewById(R.id.itemRating);
            TextView itemAddress = (TextView) findViewById(R.id.itemAddress);

            itemImage.setImageDrawable(this.getResources().getDrawable(item.getItemImage()));
            itemName.setText("Product Name: " + item.getItemName());
            itemPrice.setText("$" + item.getItemPrice());
            itemManufacturer.setText("Manufactured by " + item.getManufacture());
            itemRating.setText("Rating: " + item.getRating() + "/5");
            itemAddress.setText("Made in " + item.getAddress());

            Button placeOrder = (Button) findViewById(R.id.placeOrder);
            placeOrder.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent intent1 = new Intent(Purchase.this, LoginActivity.class);
                    startActivity(intent1);
                }
            });
        }

    }

    private Items getItem(int type){
        Items item = null;

        switch (type){
            case 1: item = new Items(1, "Sofa", 35.99, "Couch.sfb", R.drawable.couch_product_list, "sofa_card", "ABC Furnitures", 3.8,  "USA");
                    break;
            case 2: item = new Items(2, "Flower Pot", 19.99, "Orchids.sfb", R.drawable.orchid_product_list, "flower_card","Beautiful Bouquet", 4.3,  "France");
                    break;
            case 3: item = new Items(3, "Closet", 59.99, "Couch.sfb", R.drawable.armoire_product_list, "closet_card", "Material Furnitures", 3.9,  "Germany");
                    break;
            case 4: item = new Items(4, "Art Work", 39.99, "Couch.sfb", R.drawable.arcticfox_product_list, "art_card", "Aesthetic Art", 4.3,  "Poland");
                    break;
        }
        return item;
    }
}
