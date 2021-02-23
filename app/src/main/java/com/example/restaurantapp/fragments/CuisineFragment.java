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

import com.example.restaurantapp.Adapter.CuisineAdapter;
import com.example.restaurantapp.Adapter.IndianAdapter;
import com.example.restaurantapp.Data.NorthData;
import com.example.restaurantapp.R;

import java.util.ArrayList;
import java.util.List;

public class CuisineFragment extends Fragment {
    private List<NorthData> northIndians;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.north_indian, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.northRecycler);
        CuisineAdapter recyclerViewAdapterHome = new CuisineAdapter(getContext(), northIndians);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapterHome);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        northIndians = new ArrayList<>();

        northIndians.add(new NorthData("Bottarga", getString(R.string.sample_text), "Price : $8", R.drawable.sample));
        northIndians.add(new NorthData("Lasagna", getString(R.string.sample_text), "Price : $15", R.drawable.sample));
        northIndians.add(new NorthData("Fiorentina Steak", getString(R.string.sample_text), "Price : $32", R.drawable.sample));
        northIndians.add(new NorthData("Ribollita", getString(R.string.sample_text), "Price : $16", R.drawable.sample));
        northIndians.add(new NorthData("Ossobuco", getString(R.string.sample_text), "Price : $28", R.drawable.sample));
        northIndians.add(new NorthData("Risotto", getString(R.string.sample_text), "Price : $26", R.drawable.sample));

    }
}

