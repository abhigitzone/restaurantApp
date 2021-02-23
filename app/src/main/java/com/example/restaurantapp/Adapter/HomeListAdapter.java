package com.example.restaurantapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.Data.homedata;
import com.example.restaurantapp.R;
import com.example.restaurantapp.fragments.ChineseFragment;
import com.example.restaurantapp.fragments.CuisineFragment;
import com.example.restaurantapp.fragments.DessertFragment;
import com.example.restaurantapp.fragments.DrinksFragment;
import com.example.restaurantapp.fragments.FrenchFoodFragment;
import com.example.restaurantapp.fragments.MexicanFragment;
import com.example.restaurantapp.fragments.NorthFragment;
import com.example.restaurantapp.fragments.SouthIndianFragment;

import java.util.List;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.MyViewHolder> {

    public Context mContext;
    List<homedata> homeData;

    public HomeListAdapter(Context mContext, List<homedata> homeData) {
        this.mContext = mContext;
        this.homeData = homeData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_list_sample, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.homeImg.setImageResource(homeData.get(position).getImage());
        holder.homeTxt.setText(homeData.get(position).getListName());
    }

    @Override
    public int getItemCount() {
        return homeData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final Context mContext;
        ImageView homeImg;
        TextView homeTxt;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            homeImg = itemView.findViewById(R.id.img);
            homeTxt = itemView.findViewById(R.id.title);
            cardView = itemView.findViewById(R.id.card);

            cardView.setOnClickListener(this);
            mContext = itemView.getContext();
        }

        @Override
        public void onClick(View view) {
            int id = getLayoutPosition();
            switch (id) {
                case 0: {
                    Fragment fragment = new NorthFragment();
                    FragmentManager fragmentManager = ((FragmentActivity) mContext).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }
                break;
                case 1: {
                    //do something...chinese
                    Fragment fragment = new ChineseFragment();
                    FragmentManager fragmentManager = ((FragmentActivity) mContext).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                break;
                case 2: {
                    //do something..mexican
                    Fragment fragment = new MexicanFragment();
                    FragmentManager fragmentManager = ((FragmentActivity) mContext).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                break;
                case 3: {
                    //do something....south india
                    Fragment fragment = new SouthIndianFragment();
                    FragmentManager fragmentManager = ((FragmentActivity) mContext).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                break;

                case 4: {
                    //do something../ french
                    Fragment fragment = new FrenchFoodFragment();
                    FragmentManager fragmentManager = ((FragmentActivity) mContext).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                break;
                case 5: {
                    //do something../ drinks
                    Fragment fragment = new DrinksFragment();
                    FragmentManager fragmentManager = ((FragmentActivity) mContext).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                break;
                case 6: {
                    //do something../ dessert
                    Fragment fragment = new DessertFragment();
                    FragmentManager fragmentManager = ((FragmentActivity) mContext).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                break;
                case 7: {
                    //do something../ Cuisine
                    Fragment fragment = new CuisineFragment();
                    FragmentManager fragmentManager = ((FragmentActivity) mContext).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                break;
            }
        }
    }
}
