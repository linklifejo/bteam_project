package com.hanul.bteam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.adapter.CouAdapter;
import com.hanul.bteam.adapter.CourseAdapter;
import com.hanul.bteam.dto.CourseDTO;
import com.hanul.bteam.dto.LocationDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Couu extends Fragment {

    MainActivity activity;
    LocationDTO dto;
    RecyclerView recycler;
    CouAdapter adapter;
    ArrayList<CourseDTO> dtos;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.couuse,
                container, false);
        activity = (MainActivity)getActivity();
        Bundle b = activity.bundle;
        dto = (LocationDTO) activity.bundle.getSerializable("dto");
        Integer id = dto.getId();
        activity.location = id.toString();


        dtos = new ArrayList<>();
        recycler = view.findViewById(R.id.recycler);
        // recyclerView에서 반드시 아래와 같이 초기화를 해줘야 함
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(
                activity, RecyclerView.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);

        CommonMethod commonMethod = new CommonMethod();
        commonMethod.setParams("location_id", activity.location );
        commonMethod.getData("list", new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()){
                    Gson gson = new Gson();
                    dtos =  gson.fromJson(response.body(), new TypeToken<ArrayList<CourseDTO>>(){}.getType());
                    for(CourseDTO dto1: dtos){
                        dto1.setLoccode(dto.getLoccode());
                        dto1.setCouname(dto1.getCouname());
                    }
                    adapter = new CouAdapter(activity.getApplicationContext(), dtos,activity);
                    recycler.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
        adapter = new
                CouAdapter(activity.getApplicationContext(), dtos,activity);

        recycler.setAdapter(adapter);







        return view;
    }
}