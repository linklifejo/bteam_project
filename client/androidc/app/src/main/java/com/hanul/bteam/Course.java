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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.adapter.CourseAdapter;
import com.hanul.bteam.dto.CourseDTO;
import com.hanul.bteam.dto.GoneDTO;
import com.hanul.bteam.dto.LocationDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Course extends Fragment {
    MainActivity activity;
    RecyclerView recycler;
    CourseAdapter adapter;
    ArrayList<CourseDTO> dtos;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.course,
                container, false);
        activity =(MainActivity)getActivity();
        Bundle b = activity.bundle;
        LocationDTO d = (LocationDTO) b.getSerializable("dto");
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







        return view;
    }


}