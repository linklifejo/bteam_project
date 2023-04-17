package com.hanul.bteam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.login.JoinLogin;
import com.hanul.bteam.login.LoginFrist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // 나의주석
//    홈 :       HomeFragment      =>   home_frag
//    검색 :     SearchFragment      =>  search_frag
//    찜 :       WillHaveFragment  =>   willhave_frag
//    나의정보 :  MyInfoFragment =>   myinfo_frag

    //    용성 텍스트 추가 // 나도 추가 //동환추가2 // 나도 또 추가 //한번더추가 //광추가
    //    용성 텍스트 추가 // 나도 추가 //동환추가2 // 나도 또 추가 //한번더추가 // 인기산추가
    // 크흠 // 메롱

    public String loginid;
    public String loccode = null;
    public String location = null;
    public Bundle bundle;
    Toolbar toolbar;
    public boolean isLogin = false;
    BottomNavigationView bNaviView;
    Location myLoc, markerLoc;
    MarkerOptions myMarker;
    GoogleMap map;
    BottomNavigationView bv;
    String imgFilePath = null;
    FrameLayout contain;

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        return CommonMethod.keyDisappear(this, this.getCurrentFocus());
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isLogin();
        //   checkDangerousPermissions();
//        sc = findViewById(R.id.sc);
//        sc.fullScroll(View.FOCUS_DOWN);
        // 액션바가 보이지 않게 하기 위하여
        // 먼저 theme에 가서 NoActionBar로 수정한다
        // 내가 만든 툴바를 액션바로 지정한다
        contain=findViewById(R.id.contain);
        contain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(contain.getWindowToken(), 0);
//                editText.clearFocus();
            }
        });
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // 기존 타이틀 글자가 안보이게 한다
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        // 처음 화면 초기화 : Fragment1로 초기화
        //  fragmentControl(new LoginFrist());
        // 네비게이션뷰를 찾아서 클릭이벤트를 달아준다
        bNaviView = findViewById(R.id.bottom_navi);
        bNaviView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.tab1:
                        fragmentControl(new HomeFragment());
                        break;
                    case R.id.tab2:
                        fragmentControl(new SearchFragment());
                        break;
                    case R.id.tab3:
                        fragmentControl(new WillGoFragment());
                        break;
                    case R.id.tab4:
                        fragmentControl(new MyInfoFragment());
                        break;
                }
                return true;
            }
        });
    }

    public int fieldCheck() {
        HashMap<String, String> info = new HashMap<String, String>();
        return 0;
    }

    public void isLogin() {
        bv = findViewById(R.id.bottom_navi);
        //     isLogin=false;
        if (isLogin) {
            bv.setVisibility(View.VISIBLE);
            fragmentControl(new HomeFragment());
        } else {
            bv.setVisibility(View.GONE);
            fragmentControl(new LoginFrist());
        }
    }

    public String getPathFromUri(Uri uri) {

        Cursor cursor = getContentResolver().query(uri, null, null, null, null);

        cursor.moveToNext();

        @SuppressLint("Range") String path = cursor.getString(cursor.getColumnIndex("_data"));

        cursor.close();

        return path;
    }


    @Override
    protected void onResume() {
        super.onResume();
        //  checkDangerousPermissions();

    }

    //Path(파일경로) -> Uri
    public Uri getUirFromPath(String filePath) {
        Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, "_data = '" + filePath + "'", null, null);

        cursor.moveToNext();
        @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("_id"));
        Uri uri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);

        return uri;
    }

    public void fragmentControl(Fragment f) {

        getSupportFragmentManager().beginTransaction().replace(R.id.contain, f).commit();
    }

    public void fragmentControl(Fragment f, Bundle b) {
        bundle = b;
        getSupportFragmentManager().beginTransaction().replace(R.id.contain, f).commit();
    }

    // 위험권한
    public void checkDangerousPermissions() {
        String[] permissions = {
                android.Manifest.permission.CAMERA,
                android.Manifest.permission.ACCESS_MEDIA_LOCATION,
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION

        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, permissions[i] + " 권한이 승인됨.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, permissions[i] + " 권한이 승인되지 않음.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


    public File creatFile() {
        // 파일 이름을 만들기 위해 시간값을 생성함
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());
        String imageFileName = "My" + timestamp;
        // 사진파일을 저장하기 위한 경로
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File curFile = null;
        try {
            // 임시파일을 생성함      1:파일이름,2:확장자이름,3:경로
            curFile = File.createTempFile(imageFileName,
                    ".jpg", storageDir);
        } catch (Exception e) {
            e.getMessage();
        }
        // 스트링타입으로 임시파일이 있는 곳의 절대경로를 저장함
        imgFilePath = curFile.getAbsolutePath();

        return curFile;
    }


    public void BitmapConvertFile(Bitmap bitmap, String strFilePath) {
        // 파일 선언 -> 경로는 파라미터에서 받는다
        File file = new File(strFilePath);

        // OutputStream 선언 -> bitmap데이터를 OutputStream에 받아 File에 넣어주는 용도
        OutputStream out = null;
        try {
            // 파일 초기화
            file.createNewFile();

            // OutputStream에 출력될 Stream에 파일을 넣어준다
            out = new FileOutputStream(file);

            // bitmap 압축
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // 구글맵 메소드
    // 한글 주소를 받아서 Location 형태로 변경시켜서 보내주는 매소드
    public Location getLocationFromAddress(Context context, String address) {
        Geocoder geocoder = new Geocoder(context);
        List<Address> addresses;
        Location resLocation = new Location("");

        try {                                 //    한글주소 ,  최대반환주소갯수
            addresses = geocoder.getFromLocationName(address, 5);
            if ((addresses == null) || (addresses.size() == 0)) {
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

    public void requestMyLocation() {
        LocationManager manager =
                (LocationManager) getSystemService(LOCATION_SERVICE);

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
            // 만약 터널 같은곳에 들어가면 신호를 받지 못하므로
            // 마지막 수신된곳을 알려주게 한다
            Location lastLocation =
                    manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastLocation != null) {
                // 마지막에 수신된 장소를 지도에 표시한다
                showCurrentLocation(lastLocation);
            }

        } catch (SecurityException e) {
            e.getMessage();
        }

    }

    public void showCurrentLocation(@NonNull Location location) {
        // 현재 내 위치 전역변수에 넣음
        myLoc = location;

        // 지도에 위치를 찍을때는 LatLng타입을 사용함
        // Location => LatLng 타입으로 변환시켜줌
        if (map != null) {
            LatLng curPoint = new
                    LatLng(location.getLatitude(), location.getLongitude());
            // 지도에 현재위치 표시하기
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 18));
        }
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

    // location 받아서 마커 생성하여 지도에 표시하기
    public void showMyLocationMarker(Location location,
                                     String name, String phone) {
        // 마커위치를 전역변수에 담음
        markerLoc = location;
        // 마커와 내 위치까지의 거리를 구한다
        int distance = getDistance(myLoc, markerLoc);

        if (myMarker != null) {
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

    public int getDistance(@NonNull Location myLoc, Location markerLoc) {
        double distance = 0;
        // 거리를 구할때는 Location 타입 사용
        distance = myLoc.distanceTo(markerLoc);

        return (int) distance;
    }

    public void hideBottomNavigation(boolean bool) {
        BottomNavigationView bottomNavigation = bNaviView.findViewById(R.id.bottom_navi);
        if (bool == true)
            bottomNavigation.setVisibility(View.GONE);
        else
            bottomNavigation.setVisibility(View.VISIBLE);

    }
}