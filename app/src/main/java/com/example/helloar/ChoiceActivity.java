package com.example.helloar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChoiceActivity extends AppCompatActivity {

    List<Items> itemsList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemsList = new ArrayList<>();

        itemsList.add(new Items(1, "Sofa", 35.99, "Couch.sfb", R.drawable.couch_product_list, "sofa_card"));
        itemsList.add(new Items(2, "Flower Pot", 19.99, "Orchids.sfb", R.drawable.orchid_product_list, "flower_card"));
        itemsList.add(new Items(3, "Closet", 59.99, "Couch.sfb", R.drawable.armoire_product_list, "closet_card"));
        itemsList.add(new Items(4, "Art Work", 39.99, "Couch.sfb", R.drawable.arcticfox_product_list, "art_card"));

        recyclerViewAdapter adapter = new recyclerViewAdapter(this, itemsList);
        recyclerView.setAdapter(adapter);
    }
}
