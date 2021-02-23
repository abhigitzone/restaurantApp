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

import com.example.restaurantapp.Adapter.HomeListAdapter;
import com.example.restaurantapp.Adapter.IndianAdapter;
import com.example.restaurantapp.Data.NorthData;
import com.example.restaurantapp.Data.homedata;
import com.example.restaurantapp.R;

import java.util.ArrayList;
import java.util.List;

public class NorthFragment extends Fragment {
    private List<NorthData> northIndians;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.north_indian, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.northRecycler);
        IndianAdapter recyclerViewAdapterHome = new IndianAdapter(getContext(), northIndians);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapterHome);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        northIndians = new ArrayList<>();

        //Add north indian food here
        northIndians.add(new NorthData("Chole Bhature", getString(R.string.sample_text), "Price : $32", R.drawable.chole));
        northIndians.add(new NorthData("Thali Special", getString(R.string.sample_text), "Price : $29", R.drawable.thali));
        northIndians.add(new NorthData("Kashmiri Dum Aloo", getString(R.string.sample_text), "Price : $120", R.drawable.kashmiri));
        northIndians.add(new NorthData("Chicken Butter Masala", getString(R.string.sample_text), "Price : $43", R.drawable.chicken));
        northIndians.add(new NorthData("Litti Chokha", getString(R.string.sample_text), "Price : $9", R.drawable.litti));
        northIndians.add(new NorthData("Parathe", getString(R.string.sample_text), "Price : $15", R.drawable.pratha));

    }

}
