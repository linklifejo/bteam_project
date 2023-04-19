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
import com.hanul.bteam.adapter.SearchAdapter;
import com.hanul.bteam.dto.LocationDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocalDFragment extends Fragment {
    RecyclerView recycler;
    SearchAdapter adapter;
    MainActivity activity;
    ArrayList<LocationDTO> dtos;
    Bundle b;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.locald_frag,
                container, false);
        dtos = null;
        recycler = null;
        activity =(MainActivity)getActivity();
        dtos = new ArrayList<>();
        recycler = view.findViewById(R.id.recycler);

        // recycler에서 반드시 아래와 같이 초기화를 해줘야 함
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(
                activity, RecyclerView.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        CommonMethod commonMethod = new CommonMethod();

        b = activity.bundle;
      //  ArrayList<GoneDTO> d = ( ArrayList<GoneDTO>) b.getSerializable("dtos");

        commonMethod.setParams("loccode",   b.getString("localcode"));
        commonMethod.getData("selectLocal", new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()){
                    Gson gson = new Gson();
                    dtos =  gson.fromJson(response.body(), new TypeToken<ArrayList<LocationDTO>>(){}.getType());
                    for(LocationDTO dto: dtos){
                        dto.setLocname(dto.getLocname());
                        dto.setFilepath(dto.getFilepath());
                        dto.setId(dto.getId());

                    }
                    adapter = new SearchAdapter(activity.getApplicationContext(), dtos,activity);
                    recycler.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
//         어댑터 객체 생성
        adapter = new
                SearchAdapter(activity.getApplicationContext(), dtos,activity);
//        // 만든 어댑터를 리싸이클러뷰에 붙인다
        recycler.setAdapter(adapter);
        return view;
    }
}
