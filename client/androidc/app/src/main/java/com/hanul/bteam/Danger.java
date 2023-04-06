package com.hanul.bteam;

import static android.content.Context.LOCATION_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hanul.bteam.dto.GoneDTO;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Danger extends Fragment implements OnMapReadyCallback{
    MainActivity activity;
    GoogleMap map;
    EditText etAddress;
    SupportMapFragment mapFragment;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.danger,
                container, false);

        activity = (MainActivity) getActivity();

        activity.checkDangerousPermissions();
        etAddress = view.findViewById(R.id.etAddress);
        mapFragment = (SupportMapFragment) activity.getSupportFragmentManager()
                .findFragmentById(R.id.map);

        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.map, mapFragment).commit();
        }

        mapFragment.getMapAsync(this);


        MapsInitializer.initialize(activity);

        view.findViewById(R.id.btnLoc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.requestMyLocation();
            }
        });

        // 한글주소를 위도와 경도로 변환하여 위치 찾기
        view.findViewById(R.id.btnClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = (MainActivity) getActivity();
                if (etAddress.getText().toString().length() > 0) {
                    Location location = activity.getLocationFromAddress
                            (activity, etAddress.getText().toString());

                    // 한글주소에서 location으로 변환한것을 지도에서 보여준다
                    activity.showCurrentLocation(location);
                    LatLng newLocation = new LatLng(location.getLatitude(), location.getLongitude());
                    CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(newLocation, 15);
                    map.moveCamera(cameraUpdate);
                }
            }
        });

        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        try {
            // 내 위치를 볼수 있게 해준다
            map.setMyLocationEnabled(true);
        } catch (SecurityException e) {
            e.getMessage();
        }
    }

}

