package com.example.restaurantapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restaurantapp.Data.OrderData;
import com.example.restaurantapp.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdapterForList extends BaseAdapter {

    Context context;
    ArrayList<OrderData> orderData;

    public AdapterForList(Context context, ArrayList<OrderData> orderData) {
        this.context = context;
        this.orderData = orderData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                    R.layout.order_summary, parent, false);
        }
        //Assigning id's..
        TextView orderName = listItemView.findViewById(R.id.orderName);
        TextView quantity = listItemView.findViewById(R.id.quantity);
        TextView price = listItemView.findViewById(R.id.price);

        OrderData data = orderData.get(position);

        orderName.setText(data.getOrderName());
        quantity.setText(String.valueOf(data.getQuantity()));
        price.setText(String.valueOf(data.getPrice()));

        return listItemView;
    }

    @Override
    public int getCount() {
        return orderData.size();
    }

    @Override
    public Object getItem(int i) {
        return orderData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
