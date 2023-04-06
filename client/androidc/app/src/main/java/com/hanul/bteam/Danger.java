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
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
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


public class Danger extends Fragment{
    MainActivity activity;
    GoogleMap map;
    EditText etAddress;
    MarkerOptions myMarker;
    Location myLoc, markerLoc;
    SupportMapFragment mapFragment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.danger,
                container, false);
        activity = (MainActivity) getActivity();
        Bundle b = activity.bundle;
//        GoneDTO d = (GoneDTO) b.getSerializable("dto");
//        TextView t = view.findViewById(R.id.locname);
//        t.setText(d.getLocname());
        etAddress = view.findViewById(R.id.etAddress);
        mapFragment = (SupportMapFragment) activity.getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                map = googleMap;

                try {
                    // 내 위치를 볼수 있게 해준다
                    map.setMyLocationEnabled(true);
                }catch (SecurityException e){
                    e.getMessage();}}});
        MapsInitializer.initialize(activity);

        view.findViewById(R.id.btnLoc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestMyLocation();
            }
        });

        view.findViewById(R.id.btnClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etAddress.getText().toString().length() > 0){
                    Location location = getLocationFromAddress
                            (activity, etAddress.getText().toString());

                    // 한글주소에서 location으로 변환한것을 지도에서 보여준다
                    showCurrentLocation(location);
                }
            }
        });
        public Location getLocationFromAddress(Context context, String address) {
            Geocoder geocoder = new Geocoder(context);
            List<Address> addresses;
            Location resLocation = new Location("");

            try {                                 //    한글주소 ,  최대반환주소갯수
                addresses = geocoder.getFromLocationName(address, 5);
                if((addresses == null) || (addresses.size() == 0)){
                    return null;
                }

                // 넘겨받은 주소리스트에서 가장 주소에 가까운 0번째 값을 사용한다
                Address addressLoc = addresses.get(0);
                resLocation.setLatitude(addressLoc.getLatitude());
                resLocation.setLongitude(addressLoc.getLongitude());

            } catch (IOException e) {
                e.printStackTrace();
            }

            return resLocation;
        }



        return view;


    }
    private Location getLocationFromAddress(Context context, String address) {
        Geocoder geocoder = new Geocoder(context);
        List<Address> addresses;
        Location resLocation = new Location("");

        try {                                 //    한글주소 ,  최대반환주소갯수
            addresses = geocoder.getFromLocationName(address, 5);
            if((addresses == null) || (addresses.size() == 0)){
                return null;
            }

            // 넘겨받은 주소리스트에서 가장 주소에 가까운 0번째 값을 사용한다
            Address addressLoc = addresses.get(0);
            resLocation.setLatitude(addressLoc.getLatitude());
            resLocation.setLongitude(addressLoc.getLongitude());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resLocation;
    }
    private void requestMyLocation() {
        LocationManager manager =
                (LocationManager) activity.getSystemService(LOCATION_SERVICE);

        try {
            long minTime = 10000;
            float minDistance = 0;

            manager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    minTime,
                    minDistance,
                    new LocationListener() {
                        @Override
                        public void onLocationChanged(@NonNull Location location) {
                            // 위치를 지도에 표시
                            showCurrentLocation(location);
                        }
                    }
            );
            Location lastLocation =
                    manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(lastLocation != null){
                // 마지막에 수신된 장소를 지도에 표시한다
                showCurrentLocation(lastLocation);
            }

        }catch (SecurityException e){
            e.getMessage();
        }

    }
    private void showCurrentLocation(Location location) {
        // 현재 내 위치 전역변수에 넣음
        myLoc = location;

        // 지도에 위치를 찍을때는 LatLng타입을 사용함
        // Location => LatLng 타입으로 변환시켜줌
        LatLng curPoint = new
                LatLng(location.getLatitude(), location.getLongitude());
        // 지도에 현재위치 표시하기
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 18));

        // 마커 찍기 : Location 생성 : 나중에는 DB나 API에서 가져옴
        Location location1 = new Location("");
        location1.setLatitude(35.153817);
        location1.setLongitude(126.8889);
        String name = "똥강아지";
        String phone = "010-1111-1111";
        showMyLocationMarker(location1, name, phone);

        Location location2 = new Location("");
        location2.setLatitude(35.153825);
        location2.setLongitude(126.8885);
        showMyLocationMarker(location2, "초복", "010-1111-4444");

    }
    private void showMyLocationMarker(Location location,
                                      String name, String phone){
        // 마커위치를 전역변수에 담음
        markerLoc = location;
        // 마커와 내 위치까지의 거리를 구한다
        int distance = getDistance(myLoc, markerLoc);

        if(myMarker == null){
            myMarker = new MarkerOptions();
            myMarker.position(new
                    LatLng(location.getLatitude(), location.getLongitude()));
            myMarker.title("◎ " + name);
            myMarker.snippet(phone + "\n거리 => " + distance + " M");
            myMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.mylocation));
            map.addMarker(myMarker);
            myMarker = null;
        }
    }
    private int getDistance(Location myLoc, Location markerLoc) {
        double distance = 0;
        // 거리를 구할때는 Location 타입 사용
        distance = myLoc.distanceTo(markerLoc);
        return (int)distance;
    }

}