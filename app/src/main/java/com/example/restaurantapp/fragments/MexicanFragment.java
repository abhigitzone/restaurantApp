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

import com.example.restaurantapp.Adapter.IndianAdapter;
import com.example.restaurantapp.Adapter.MexicanAdapter;
import com.example.restaurantapp.Data.NorthData;
import com.example.restaurantapp.R;

import java.util.ArrayList;
import java.util.List;

public class MexicanFragment extends Fragment {
    private List<NorthData> northIndians;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.north_indian, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.northRecycler);
        MexicanAdapter recyclerViewAdapterHome = new MexicanAdapter(getContext(), northIndians);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapterHome);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        northIndians = new ArrayList<>();

        northIndians.add(new NorthData("Chicken Quesadillas", getString(R.string.sample_text),"Price : $22", R.drawable.sample));
        northIndians.add(new NorthData("Guacamole", getString(R.string.sample_text),"Price : $26", R.drawable.sample));
        northIndians.add(new NorthData("Tomato Salsa", getString(R.string.sample_text),"Price : $28", R.drawable.sample));
        northIndians.add(new NorthData("Guilt-Free Chilli", getString(R.string.sample_text),"Price : $12", R.drawable.sample));
        northIndians.add(new NorthData("Burritos", getString(R.string.sample_text),"Price : $50", R.drawable.sample));
        northIndians.add(new NorthData("Taco", getString(R.string.sample_text),"Price : $60", R.drawable.sample));

    }
}

