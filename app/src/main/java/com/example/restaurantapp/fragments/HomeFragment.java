package com.example.restaurantapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.restaurantapp.Adapter.HomeListAdapter;
import com.example.restaurantapp.Data.homedata;
import com.example.restaurantapp.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private List<homedata> lstItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.recycler_container);
        HomeListAdapter recyclerViewAdapterHome = new HomeListAdapter(getContext(), lstItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(recyclerViewAdapterHome);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstItem = new ArrayList<>();
        //Add as many categories you want..
        lstItem.add(new homedata(R.drawable.north_india, "North\n Indian "));
        lstItem.add(new homedata(R.drawable.chinese, "Chinese"));
        lstItem.add(new homedata(R.drawable.mexican, "Mexican"));
        lstItem.add(new homedata(R.drawable.south_india, "South\n Indian"));
        lstItem.add(new homedata(R.drawable.french, "French"));
        lstItem.add(new homedata(R.drawable.drinks, "Drinks"));
        lstItem.add(new homedata(R.drawable.dessert, "Desserts"));
        lstItem.add(new homedata(R.drawable.cuisine, "Cuisine"));

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Image slider..
        ImageSlider imageSlider = view.findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://lh3.googleusercontent.com/wdUvmhmr-UZy0dZ6M4Bzvz0C8EwCYlJniT3eBxauBVpV-TVFEu_1kgfag0hCFimizdg2jLm1yuqz8rJBub4GaeS9XCQ=w800", "North India"));
        slideModels.add(new SlideModel("https://mlscottsdale.com/get/files/image/galleries/lunch-spread-2.jpg", "French Cuisine"));
        slideModels.add(new SlideModel("https://www.scripps.org/sparkle-assets/images/mexican_food_1200x750-14c09ee840f1824937cabd4c79bf86b8.jpg", "Mexican Food"));
        slideModels.add(new SlideModel("https://i0.wp.com/www.society19.com/wp-content/uploads/2019/07/dessert-pfp.jpg?fit=1024%2C768&ssl=1", "Desserts"));
        slideModels.add(new SlideModel("https://www.watscooking.com/images/dish/normal/11390345_1664954410404259_2107366005025409165_n.jpg", "South Indian Food"));
        slideModels.add(new SlideModel("https://www.englishclub.com/images/vocabulary/food/chinese/chinese-food.jpg", "Chinese Food"));
        slideModels.add(new SlideModel("https://cdn-a.william-reed.com/var/wrbm_gb_food_pharma/storage/images/publications/food-beverage-nutrition/beveragedaily.com/article/2020/01/02/2020-trends-to-watch-in-us-beverage/10484034-2-eng-GB/2020-trends-to-watch-in-US-beverage_wrbm_large.jpg", "Drinks"));

        imageSlider.setImageList(slideModels, true);

        //Assigning id's of home's stuff.
        CardView noodles = view.findViewById(R.id.noodles_home);
        CardView burger = view.findViewById(R.id.burger_home);
        CardView pizza = view.findViewById(R.id.pizza_home);
        CardView juice = view.findViewById(R.id.juice_home);
        CardView thali = view.findViewById(R.id.thali_home);
        CardView briyani = view.findViewById(R.id.briyani_home);
        CardView sweets = view.findViewById(R.id.sweets_home);
        CardView fastFood = view.findViewById(R.id.fastFood_home);

        //Handling click events for home's stuff.
        noodles.setOnClickListener(this);
        burger.setOnClickListener(this);
        pizza.setOnClickListener(this);
        juice.setOnClickListener(this);
        thali.setOnClickListener(this);
        briyani.setOnClickListener(this);
        sweets.setOnClickListener(this);
        fastFood.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.noodles_home:
            case R.id.pizza_home:
            case R.id.juice_home:
            case R.id.thali_home:
            case R.id.briyani_home:
            case R.id.sweets_home:
            case R.id.fastFood_home:
            case R.id.burger_home: {
                Toast.makeText(getContext(), "Under Development", Toast.LENGTH_SHORT).show();
            }
            break;
        }

    }
}

