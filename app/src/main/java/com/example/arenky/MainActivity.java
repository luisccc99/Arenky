package com.example.arenky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.arenky.flight.FlightData;
import com.example.arenky.fragments.FlightDetailFragment;
import com.example.arenky.fragments.FlightsListFragment;
import com.example.arenky.fragments.FlyFragment;
import com.example.arenky.fragments.HomeFragment;
import com.example.arenky.fragments.MapFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements FlyFragment.FlyFragmentListener,
    FlightAdapter.OnFlightListener{

    BottomNavigationView bottomNavigationView;
    public static final String BASE_URL = "http://api.travelpayouts.com/";


    
    private BroadcastReceiver networkStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = manager.getActiveNetworkInfo();
            onNetworkChange(ni);
        }
    };
    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }
    @Override
    protected void onPause() {
        unregisterReceiver(networkStateReceiver);
        super.onPause();
    }
    private void onNetworkChange(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                Log.d("MenuActivity", "CONNECTED");
                Toast.makeText(this, "Conectado prro", Toast.LENGTH_SHORT).show();
            } else {
                Log.d("MenuActivity", "DISCONNECTED");
                Toast.makeText(this, "No hay conexión", Toast.LENGTH_SHORT).show();

            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

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

    // TODO: CAMBIAR DE NOMBRE A ESTE METODO, PARA NO CONFUNDIRLO CON EL CLICKED DEL RECYCLER VIEW
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

    @Override
    public void onFlightClick(FlightData flightData) {
        FlightDetailFragment detailFragment = new FlightDetailFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        detailFragment.setFlightData(flightData);
        ft.replace(R.id.container, detailFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

}
