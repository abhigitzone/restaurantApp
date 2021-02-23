package com.example.restaurantapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.Adapter.DrinksAdapter;
import com.example.restaurantapp.Adapter.IndianAdapter;
import com.example.restaurantapp.Data.NorthData;
import com.example.restaurantapp.R;

import java.util.ArrayList;
import java.util.List;

public class DrinksFragment extends Fragment {
    private List<NorthData> northIndians;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.north_indian, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.northRecycler);
        DrinksAdapter recyclerViewAdapterHome = new DrinksAdapter(getContext(), northIndians);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapterHome);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        northIndians = new ArrayList<>();

        //Add drinks here..
        northIndians.add(new NorthData("Spirit", getString(R.string.sample_text),"Price : $45", R.drawable.sample));
        northIndians.add(new NorthData("Coca cola", getString(R.string.sample_text),"Price : $25", R.drawable.sample));
        northIndians.add(new NorthData("RedBull", getString(R.string.sample_text),"Price : $15", R.drawable.sample));
        northIndians.add(new NorthData("Mountain Dew", getString(R.string.sample_text),"Price : $65", R.drawable.sample));
        northIndians.add(new NorthData("Orange juice", getString(R.string.sample_text),"Price : $75", R.drawable.sample));
        northIndians.add(new NorthData("Apple cider", getString(R.string.sample_text),"Price : $90", R.drawable.sample));



    }
}
