package com.hanul.bteam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hanul.bteam.COMMON.CommonMethod;

import com.hanul.bteam.adapter.MyWroteAdapter;
import com.hanul.bteam.adapter.RecentlyAdapter;
import com.hanul.bteam.dto.BoardDTO;
import com.hanul.bteam.dto.CourseDTO;
import com.hanul.bteam.dto.GoneDTO;
import com.hanul.bteam.dto.HuDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyInfoFragment extends Fragment {

    MainActivity activity;
    RecyclerView recycler2,recycler;
    MyWroteAdapter adapter;
    ArrayList<BoardDTO> dtos;
    ArrayList<GoneDTO> dtos_re;
    RecentlyAdapter adapter_re;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = (ViewGroup) inflater.inflate(R.layout.myinfo_frag,
                container, false);
        activity = (MainActivity) getActivity();
//        view.findViewById(R.id.btn_write).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                activity.fragmentControl(new LocalFragment());
//            }
//        });
        dtos = new ArrayList<>();
        recycler = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(
                activity, RecyclerView.HORIZONTAL, false);
        recycler.setLayoutManager(layoutManager);

        CommonMethod commonMethod = new CommonMethod();
        commonMethod.setParams("type", "1");
        commonMethod.setParams("ptype", "3");
        commonMethod.setParams("num", "6");
        commonMethod.getData("selectHome", new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()){
                    Gson gson = new Gson();
                    dtos =  gson.fromJson(response.body(), new TypeToken<ArrayList<BoardDTO>>(){}.getType());
                    for(BoardDTO dto: dtos){
                        dto.setTitle(dto.getTitle());
                        dto.setFilepath(dto.getFilepath());
                    }
                    adapter = new MyWroteAdapter(activity.getApplicationContext(), dtos,activity);
                    recycler.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });

        dtos_re = new ArrayList<>();
        recycler2 = view.findViewById(R.id.recycler2);
        LinearLayoutManager layout = new
                LinearLayoutManager(
                activity, RecyclerView.HORIZONTAL, false);
        recycler2.setLayoutManager(layout);
        CommonMethod commonMethod2 = new CommonMethod();
        commonMethod2.setParams("type", "1");
        commonMethod2.setParams("ptype", "1");
        commonMethod2.setParams("num", "6");
        commonMethod2.getData("selectHome", new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    Gson gson = new Gson();
                    dtos_re =  gson.fromJson(response.body(), new TypeToken<ArrayList<GoneDTO>>(){}.getType());
                    for(GoneDTO dto: dtos_re){
                        dto.setTitle(dto.getTitle());
                        dto.setFilepath(dto.getFilepath());
                    }
                    adapter_re = new RecentlyAdapter(activity.getApplicationContext(), dtos_re,activity);
                    recycler2.setAdapter(adapter_re);
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });


        return view;
    }
}
