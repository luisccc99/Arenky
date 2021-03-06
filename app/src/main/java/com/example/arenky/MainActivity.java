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
import com.example.arenky.fragments.HotelsFragment;
import com.example.arenky.fragments.HotelsListFragment;
import com.example.arenky.fragments.HotelsQueryListSuggestions;
import com.example.arenky.fragments.MapFragment;
import com.example.arenky.fragments.MusicDetailFragment;
import com.example.arenky.fragments.MusicListFragment;
import com.example.arenky.music.TrackData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements FlyFragment.FlyFragmentListener,
        FlightToMain, HomeFragment.MusicFragmentListener, MusicToMain,
        QueryToMain, HotelToMain {

    private static final String TAG = MainActivity.class.getSimpleName();

    private BottomNavigationView bottomNavigationView;

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
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                Log.d(TAG, "CONNECTED");
                Toast.makeText(this, "Hay conexión", Toast.LENGTH_SHORT).show();

                //si esta conectado a wifi, muestra a que red esta conectdo
                if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                    Toast.makeText(this, "Conectado a " + networkInfo.getExtraInfo(),
                            Toast.LENGTH_SHORT).show();
                    // Estas conectado a un Wi-Fi
                    Log.d("MIAPP", "Nombre red Wi-Fi: " + networkInfo.getExtraInfo());
                }
                //muestra que esta conectado con datos
                if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    Toast.makeText(this, "Conectado con datos móviles",
                            Toast.LENGTH_SHORT).show();
                    // Estas conectado con datos
                    Log.d("MIAPP", " conectado con datos " + networkInfo.getExtraInfo());
                }

            }


        } else {
            Log.d(TAG, "DISCONNECTED");
            Toast.makeText(this, "No hay conexión", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        showFragment(new HotelsFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        showFragment(new HomeFragment());
                        break;
                    case R.id.menu_map:
                        showFragment(new MapFragment());
                        break;
                    case R.id.menu_fly:
                        showFragment(new FlyFragment());
                        break;
                    default:
                        showFragment(new HotelsFragment());
                        break;
                }
                return true;
            }
        });
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    private void showFragmentWithBackStack(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

    }

    //TODO: CAMBIAR EL NOMBRE A ESTE METODO
    @Override
    public void onClicked(String origin, String destination) {
        FlightsListFragment flightsListFragment = new FlightsListFragment();
        flightsListFragment.setOrigin(origin);
        flightsListFragment.setDestination(destination);
        showFragmentWithBackStack(flightsListFragment);
    }

    @Override
    public void sendFlightData(FlightData flightData) {
        FlightDetailFragment flightDetail = new FlightDetailFragment();
        // objeto bundle para enviar informacion
        Bundle bundleFlightData = new Bundle();
        bundleFlightData.putSerializable("flightData", flightData);
        flightDetail.setArguments(bundleFlightData);
        showFragmentWithBackStack(flightDetail);
    }

    @Override
    public void onButtonSearchTrackListener(String country) {
        MusicListFragment musicListFragment = new MusicListFragment();
        musicListFragment.setCountry(country);
        showFragmentWithBackStack(musicListFragment);
    }

    @Override
    public void sendTrackData(TrackData trackData) {
        MusicDetailFragment musicDetail = new MusicDetailFragment();
        Bundle bundleMusicData = new Bundle();
        bundleMusicData.putSerializable("trackData", trackData);
        musicDetail.setArguments(bundleMusicData);
        showFragmentWithBackStack(musicDetail);

    }

    @Override
    public void setQuery(String city) {
        HotelsQueryListSuggestions responseList = new HotelsQueryListSuggestions();
        responseList.setQuery(city);
        showFragmentWithBackStack(responseList);
    }

    @Override
    public void getDestinationEntity(Integer destinationEntity) {
        showFragmentWithBackStack(HotelsListFragment.newInstance(destinationEntity));
    }
}
