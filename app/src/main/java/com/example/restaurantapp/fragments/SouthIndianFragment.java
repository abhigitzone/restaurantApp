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
import com.example.restaurantapp.Adapter.SouthIndiaAdapter;
import com.example.restaurantapp.Data.NorthData;
import com.example.restaurantapp.R;

import java.util.ArrayList;
import java.util.List;

public class SouthIndianFragment extends Fragment {
    private List<NorthData> northIndians;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.north_indian, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.northRecycler);
        SouthIndiaAdapter recyclerViewAdapterHome = new SouthIndiaAdapter(getContext(), northIndians);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapterHome);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        northIndians = new ArrayList<>();

        //Add south indian food here..
        northIndians.add(new NorthData("Idli Dosa", getString(R.string.sample_text), "Price : $32", R.drawable.sample));
        northIndians.add(new NorthData("Sakkara pongal", getString(R.string.sample_text), "Price : $12", R.drawable.sample));
        northIndians.add(new NorthData("Bonda", getString(R.string.sample_text), "Price : $22", R.drawable.sample));
        northIndians.add(new NorthData("Kanji", getString(R.string.sample_text), "Price : 45", R.drawable.sample));
        northIndians.add(new NorthData("Koshambri", getString(R.string.sample_text), "Price : $42", R.drawable.sample));
        northIndians.add(new NorthData("Pesarattu", getString(R.string.sample_text), "Price : $52", R.drawable.sample));


    }
}
