package com.hanul.bteam;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hanul.bteam.dto.LocationDTO;

import java.util.ArrayList;

public class LocalFragment extends Fragment {
    MainActivity activity;
    ArrayList<LocationDTO> dtos;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.local_frag,
                container, false);
        activity =(MainActivity)getActivity();

//        dtos = new ArrayList<>();
//        CommonMethod commonMethod = new CommonMethod();
//       // commonMethod.setParams("loccode", d.getLoccode());
//        commonMethod.getData("localImage", new Callback<String>(){
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//
//                if(response.isSuccessful()){
//                    Gson gson = new Gson();
//                    dtos =  gson.fromJson(response.body(), new TypeToken<ArrayList<LocationDTO>>(){}.getType());
//
//                }
//            }
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//            }
//        });
       //
        view.findViewById(R.id.btnSeoul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();

                b.putString("localcode","L01");
                activity.bundle = b;

                activity.fragmentControl(new LocalDFragment());
            }
        });
        view.findViewById(R.id.btnGwangwon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();

                b.putString("localcode","L02");
                activity.bundle = b;
                activity.fragmentControl(new LocalDFragment());
            }
        });
        view.findViewById(R.id.btnJeonlado).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();

                b.putString("localcode","L03");
                activity.bundle = b;
                activity.fragmentControl(new LocalDFragment());
            }
        });
        view.findViewById(R.id. btnKeong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();

                b.putString("localcode","L04");
                activity.bundle = b;
                activity.fragmentControl(new LocalDFragment());
            }
        });

        view.findViewById(R.id.btnChung).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();

                b.putString("localcode","L05");
                activity.bundle = b;
                activity.fragmentControl(new LocalDFragment());
            }
        });
        view.findViewById(R.id. btnJeju).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();

                b.putString("localcode","L06");
                activity.bundle = b;
                activity.fragmentControl(new LocalDFragment());
            }
        });

        return view;
    }
}
