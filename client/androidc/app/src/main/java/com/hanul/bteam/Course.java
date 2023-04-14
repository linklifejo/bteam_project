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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.COMMON.adapter.CourseAdapter;
import com.hanul.bteam.COMMON.adapter.HuAdapter;
import com.hanul.bteam.dto.CourseDTO;
import com.hanul.bteam.dto.GoneDTO;
import com.hanul.bteam.dto.HuDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Course extends Fragment {
    MainActivity activity;
    RecyclerView recyclerView,recycler;
    CourseAdapter adapter;
    ArrayList<CourseDTO> dtos;
    ArrayList<HuDTO> dtos_re;
    HuAdapter adapter_re;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.course,
                container, false);
        activity =(MainActivity)getActivity();
        Bundle b = activity.bundle;
        GoneDTO d = (GoneDTO) b.getSerializable("dto");
        TextView t = view.findViewById(R.id.locname);
        t.setText(d.getLocname());
        ImageView i = view.findViewById(R.id.filepath);
        Glide.with(view).load(d.getFilepath()).into(i);
        dtos = new ArrayList<>();

        recycler = view.findViewById(R.id.recycler);
        // recyclerView에서 반드시 아래와 같이 초기화를 해줘야 함
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(
                activity, RecyclerView.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);

        // 만든 어댑터를 리싸이클러뷰에 붙인다
        CommonMethod commonMethod = new CommonMethod();
        commonMethod.getData("list", new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()){
                    Gson gson = new Gson();
                    dtos =  gson.fromJson(response.body(), new TypeToken<ArrayList<CourseDTO>>(){}.getType());
                    for(CourseDTO dto: dtos){
                        dto.setCouname(dto.getCouname());
                    }
                    adapter = new CourseAdapter(activity.getApplicationContext(), dtos,activity);
                    recycler.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
        adapter = new
                CourseAdapter(activity.getApplicationContext(), dtos,activity);

        recycler.setAdapter(adapter);


        //테스트
        dtos_re = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerView);
        // recyclerView에서 반드시 아래와 같이 초기화를 해줘야 함
        LinearLayoutManager layoutManager2 = new
                LinearLayoutManager(
                activity, RecyclerView.VERTICAL, false);
        commonMethod.getData("list", new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()){
                    Gson gson = new Gson();
                    dtos =  gson.fromJson(response.body(), new TypeToken<ArrayList<CourseDTO>>(){}.getType());
                    for(CourseDTO dto: dtos){
                        dto.setCouname(dto.getCouname());
                    }
                    adapter = new CourseAdapter(activity.getApplicationContext(), dtos,activity);
                    recycler.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
        recyclerView.setLayoutManager(layoutManager2);
        adapter_re = new
                HuAdapter(activity.getApplicationContext(), dtos_re,activity);
        // 만든 어댑터를 리싸이클러뷰에 붙인다

        recyclerView.setAdapter(adapter_re);






        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.tutu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hulist fragment = new Hulist();
                activity.fragmentControl(fragment);
            }
        });
    }

}