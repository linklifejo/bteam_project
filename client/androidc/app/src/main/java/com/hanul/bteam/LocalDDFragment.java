package com.hanul.bteam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.adapter.CourseAdapter;
import com.hanul.bteam.dto.CourseDTO;
import com.hanul.bteam.dto.LocationDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocalDDFragment extends Fragment {

    MainActivity activity;
    TextView locname;
    TextView name_desc;
    LocationDTO dto;
    RecyclerView recycler;
    CourseAdapter adapter;
    ArrayList<CourseDTO> dtos;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.localdd_frag,
                container, false);
        activity = (MainActivity)getActivity();
        Bundle b = activity.bundle;
        dto = (LocationDTO) activity.bundle.getSerializable("dto");


        Integer id = dto.getId();
        activity.location = id.toString();
        locname =view.findViewById(R.id.tvLocname);
        locname.setText(dto.getLocname() );
        name_desc =view.findViewById(R.id.tvName_desc);
        name_desc.setText(dto.getName_desc());

        ImageView i = view.findViewById(R.id.filepath);
        Glide.with(view).load(dto.getFilepath()).into(i);


        dtos = new ArrayList<>();
        recycler = view.findViewById(R.id.recycler);
        // recyclerView에서 반드시 아래와 같이 초기화를 해줘야 함
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(
                activity, RecyclerView.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);

        // 만든 어댑터를 리싸이클러뷰에 붙인다
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


        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btn1 = view.findViewById(R.id.danger);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.fragmentControl(new Danger());
            }
        });
    }
}
