package com.example.restaurantapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.restaurantapp.Adapter.AdapterForList;
import com.example.restaurantapp.Data.OrderData;
import com.example.restaurantapp.Database.DatabaseOrders;
import com.example.restaurantapp.R;

import java.util.ArrayList;

public class OrdersFragment extends Fragment {
    ArrayList<OrderData> orderData;
    ListView listView;
    DatabaseOrders databaseOrders;
    AdapterForList adapterForList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.order_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listView);
        TextView emptyText = view.findViewById(R.id.empty);
        listView.setEmptyView(emptyText);
        orderData = new ArrayList<>();
        databaseOrders = new DatabaseOrders(getContext());
        dataLoadInListView();
    }

    private void dataLoadInListView() {
        orderData = databaseOrders.getAllData();
        adapterForList = new AdapterForList(getActivity(), orderData);
        listView.setAdapter(adapterForList);
        adapterForList.notifyDataSetChanged();
    }

}
