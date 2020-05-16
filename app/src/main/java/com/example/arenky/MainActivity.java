package com.example.arenky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.arenky.fragments.FlightsListFragment;
import com.example.arenky.fragments.FlyFragment;
import com.example.arenky.fragments.HomeFragment;
import com.example.arenky.fragments.MapFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements FlyFragment.FlyFragmentListener{

    BottomNavigationView bottomNavigationView;
    public static final String BASE_URL = "http://api.travelpayouts.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.menu_home:
                        showSelectedFragment(new HomeFragment());
                        break;
                    case R.id.menu_map:
                        showSelectedFragment(new MapFragment());
                        break;
                    case R.id.menu_fly:
                        showSelectedFragment(new FlyFragment());
                        break;

                }

                return true;
            }
        });
    }

    private void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }

    @Override
    public void onClicked(String origin, String destination) {
        FlightsListFragment flightsListFragment = new FlightsListFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        flightsListFragment.setOrigin(origin);
        flightsListFragment.setDestination(destination);
        ft.replace(R.id.container, flightsListFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

    }
}
