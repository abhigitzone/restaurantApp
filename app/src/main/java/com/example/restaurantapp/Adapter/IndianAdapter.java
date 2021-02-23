package com.example.restaurantapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.Data.NorthData;
import com.example.restaurantapp.Database.DatabaseOrders;
import com.example.restaurantapp.R;

import java.util.List;

public class IndianAdapter extends RecyclerView.Adapter<IndianAdapter.MyViewHolder> {
    public Context mContext;
    List<NorthData> northData;

    public IndianAdapter(Context mContext, List<NorthData> northData) {
        this.mContext = mContext;
        this.northData = northData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.north_india_sample, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.northTitle.setText(northData.get(position).getNorthTitle());
        holder.northDesc.setText(northData.get(position).getNorthDesc());
        holder.northImg.setImageResource(northData.get(position).getNorthImg());
        holder.price.setText(northData.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return northData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Context context;
        TextView northTitle;
        TextView northDesc;
        ImageView northImg;
        TextView price;
        Button orderNow;

        //Handling item counter here..
        Button decrementCounter;
        Button incrementCounter;
        TextView itemCount;

        //Lowest item must be 1.
        int item = 1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //Assigning id's..
            northDesc = itemView.findViewById(R.id.north_food_desc);
            northTitle = itemView.findViewById(R.id.north_food_name);
            northImg = itemView.findViewById(R.id.north_food_img);
            price = itemView.findViewById(R.id.price);
            orderNow = itemView.findViewById(R.id.orderNow);
            incrementCounter = itemView.findViewById(R.id.incrementCounter);
            decrementCounter = itemView.findViewById(R.id.decrementCounter);
            itemCount = itemView.findViewById(R.id.itemCount);

            context = itemView.getContext();
            orderNow.setOnClickListener(this);

            //on clicking + button..
            incrementCounter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (item == 50 || item >= 50) {
                        Toast.makeText(context, "You can max have 50 orders at a time", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    item++;
                    displayQuantity(item);
                }
            });

            //On clicking - button..
            decrementCounter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (item == 1 || item <= 1) {
                        Toast.makeText(context, "You at least have one order", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    item--;
                    displayQuantity(item);
                }
            });
        }

        //Calling this method to display item count to users.
        @SuppressLint("SetTextI18n")
        private void displayQuantity(int number) {
            itemCount.setText("" + number);
        }

        //Handling click event on button.
        @Override
        public void onClick(View view) {
            int id = getLayoutPosition();
            switch (id) {
                case 0: {
                    //Base price of food is set to $32..
                    int basePrice = 32;
                    int totalPrice = basePrice * item;
                    String orderName = northTitle.getText().toString();
                    insertIntoDatabase(context, orderName, item, totalPrice);
                }
                break;

                case 1: {
                    int basePrice = 29;
                    int totalPrice = basePrice * item;
                    String orderName = northTitle.getText().toString();
                    insertIntoDatabase(context, orderName, item, totalPrice);
                }
                break;

                case 2: {
                    int basePrice = 120;
                    int totalPrice = basePrice * item;
                    String orderName = northTitle.getText().toString();
                    insertIntoDatabase(context, orderName, item, totalPrice);
                }
                break;
                case 3: {
                    int basePrice = 43;
                    int totalPrice = basePrice * item;
                    String orderName = northTitle.getText().toString();
                    insertIntoDatabase(context, orderName, item, totalPrice);
                }
                break;
                case 4: {
                    int basePrice = 9;
                    int totalPrice = basePrice * item;
                    String orderName = northTitle.getText().toString();
                    insertIntoDatabase(context, orderName, item, totalPrice);
                }
                break;
                case 5: {
                    int basePrice = 15;
                    int totalPrice = basePrice * item;
                    String orderName = northTitle.getText().toString();
                    insertIntoDatabase(context, orderName, item, totalPrice);
                }
                break;
            }
        }

        //Calling this function every time when order button is clicked..
        public static void insertIntoDatabase(Context context, String name, int item, int totalPrice) {
            //Inserting Data in Database.
            DatabaseOrders myDataBase = new DatabaseOrders(context);
            //converting integer to string.
            myDataBase.insertValues(name, item, totalPrice);
        }
    }
}

