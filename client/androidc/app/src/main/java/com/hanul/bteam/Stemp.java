package com.hanul.bteam;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.adapter.SeaAdapter;
import com.hanul.bteam.adapter.SearchAdapter;
import com.hanul.bteam.dto.LocationDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Stemp extends Fragment {
    RecyclerView recycler;
    SeaAdapter adapter;
    MainActivity activity;
    ArrayList<LocationDTO> dtos;
    EditText search;
    Bundle b;
    Boolean isTrue = false;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stemp,
                container, false);
        activity = (MainActivity) getActivity();
        dtos = null;
        recycler = null;
        dtos = new ArrayList<>();
        recycler = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(
                activity, RecyclerView.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        search = view.findViewById(R.id.search);

        search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    activity.hideBottomNavigation(true);
                }else activity.hideBottomNavigation(false);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.hideBottomNavigation(true);
            }
        });


        view.findViewById(R.id.btnSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity.hideBottomNavigation(true);

                CommonMethod commonMethod = new CommonMethod();
                commonMethod.setParams("search",   search.getText());
                commonMethod.getData("searchLocal", new Callback<String>(){
                    public void onResponse(Call<String> call, Response<String> response) {

                        if(response.isSuccessful()){
                            Gson gson = new Gson();
                            dtos =  gson.fromJson(response.body(), new TypeToken<ArrayList<LocationDTO>>(){}.getType());
                            for(LocationDTO dto: dtos){
                                dto.setLocname(dto.getLocname());
                                dto.setFilepath(dto.getFilepath());
                            }
                            adapter = new SeaAdapter(activity.getApplicationContext(), dtos,activity);
                            recycler.setAdapter(adapter);
                            activity.isContain();
                            activity.hideBottomNavigation(false);
                            adapter.notifyDataSetChanged();

                        }
                    }
                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                    }
                });
//         어댑터 객체 생성
                adapter = new
                        SeaAdapter (activity.getApplicationContext(), dtos,activity);
//        // 만든 어댑터를 리싸이클러뷰에 붙인다
                recycler.setAdapter(adapter);
            }
        });

        return view;
    }
}

