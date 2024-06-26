package com.example.app_fooddelivery.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_fooddelivery.Adapter.CategoryAdapter;
import com.example.app_fooddelivery.Adapter.PopularAdapter;
import com.example.app_fooddelivery.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2 ;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    private Object LinearLayoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();

    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }

        });
    }
    private void recyclerViewCategory(){

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,false);
            recyclerViewCategoryList = findViewById(R.id.recyclerView);
            recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza", "cat_1"));
            category.add(new CategoryDomain("Burger", "cat_2"));
            category.add(new CategoryDomain("Hotdog", "cat_3"));
            category.add(new CategoryDomain("Drink", "cat_4"));
            category.add(new CategoryDomain("Dounut","cat_5"));
            
            adapter = new CategoryAdapter(category);
            recyclerViewCategoryList.setAdapter(adapter);

    }
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain>  foodList= new ArrayList<>();
        foodList.add(new FoodDomain("Pepparoni pizza", "pizza1","slices pepperoni, mozzerelle cheese, fresh oregano, ground black pepper. pizza sauce", 9.76));
        foodList.add(new FoodDomain("Cheese Burger", "burger", "beef, Gouda Cheese, Special Sauce, Lettuce, Tomato", 8.79 ));
        foodList.add(new FoodDomain("Vegetable pizza", "pizza2", "olive oil, Vegetable oil, oitted kalamate, cherry tomato, freshoregano, basil ", 8.50));

        adapter2 = new PopularAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }



}
