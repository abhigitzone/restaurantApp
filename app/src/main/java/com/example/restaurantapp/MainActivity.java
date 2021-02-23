package com.example.restaurantapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.restaurantapp.fragments.AccountFragment;
import com.example.restaurantapp.fragments.ExploreFragment;
import com.example.restaurantapp.fragments.HomeFragment;
import com.example.restaurantapp.fragments.OrdersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar..
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        toolbar.setTitle(getString(R.string.app_name));

        //Bottom navigation bar.
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        //Navigation stuffs..
        drawer = findViewById(R.id.drawer_container);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.Navigation_drawer_open, R.string.Navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //Handling Bottom navigation flow..
    private BottomNavigationView.OnNavigationItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.orders:
                    selectedFragment = new OrdersFragment();
                    break;
                case R.id.account:
                    selectedFragment = new AccountFragment();
                    break;
            }
            assert selectedFragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;

        }
    };

    //Handling navigation bar flow..
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.explore:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ExploreFragment()).commit();
                toolbar.setTitle("Home");
                break;
            case R.id.categories:
                //Add fragments here..
                Toast.makeText(this, "Have to build fragment for it..", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tableBook:
                Toast.makeText(this, "We are working upon it..", Toast.LENGTH_LONG).show();
                break;
            case R.id.share:
                Toast.makeText(this, "We are working upon it.", Toast.LENGTH_LONG).show();
                break;
            case R.id.language:
                Toast.makeText(this, "Under Development.", Toast.LENGTH_LONG).show();
                break;
            case R.id.feedback:
                Toast.makeText(this, "under construction", Toast.LENGTH_LONG).show();
                break;
            case R.id.customer:
                Toast.makeText(this, "Will contact you soon.", Toast.LENGTH_LONG).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Creating toolbar menu..
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    //handling toolbar menu options..
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.search_bar: {
                Toast.makeText(this, "under development", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.notification: {
                Toast.makeText(this, "No notification", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.favourite: {
                Toast.makeText(this, "You have a good choice!", Toast.LENGTH_SHORT).show();
            }
            break;
        }
        return true;
    }

    //On Back pressed, navigation bar closes..
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}