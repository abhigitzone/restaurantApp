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

import com.example.restaurantapp.Adapter.FrenchAdapter;
import com.example.restaurantapp.Adapter.IndianAdapter;
import com.example.restaurantapp.Data.NorthData;
import com.example.restaurantapp.R;

import java.util.ArrayList;
import java.util.List;

public class FrenchFoodFragment extends Fragment {
    private List<NorthData> northIndians;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.north_indian, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.northRecycler);
        FrenchAdapter recyclerViewAdapterHome = new FrenchAdapter(getContext(), northIndians);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapterHome);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        northIndians = new ArrayList<>();

        //Add french food here..
        northIndians.add(new NorthData("Soupe à l’oignon", getString(R.string.sample_text), "Price : $12", R.drawable.sample));
        northIndians.add(new NorthData("Coq au vin", getString(R.string.sample_text), "Price : $62", R.drawable.sample));
        northIndians.add(new NorthData("Cassoulet", getString(R.string.sample_text), "Price : $72", R.drawable.sample));
        northIndians.add(new NorthData("Chocolate soufflé", getString(R.string.sample_text), "Price : $38", R.drawable.sample));
        northIndians.add(new NorthData("Flamiche", getString(R.string.sample_text), "Price : $84", R.drawable.sample));
        northIndians.add(new NorthData("Confit de canard", getString(R.string.sample_text), "Price : $80", R.drawable.sample));

    }
}
