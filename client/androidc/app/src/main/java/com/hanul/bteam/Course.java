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
import android.widget.TextView;

import com.hanul.bteam.adapter.CourseAdapter;
import com.hanul.bteam.adapter.GoneAdapter;
import com.hanul.bteam.adapter.HuAdapter;
import com.hanul.bteam.dto.CourseDTO;
import com.hanul.bteam.dto.GoneDTO;
import com.hanul.bteam.dto.HuDTO;

import java.util.ArrayList;


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
        dtos = new ArrayList<>();
        recycler = view.findViewById(R.id.recycler);
        // recyclerView에서 반드시 아래와 같이 초기화를 해줘야 함
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(
                activity, RecyclerView.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        adapter = new
                CourseAdapter(activity.getApplicationContext(), dtos,activity);
        // 만든 어댑터를 리싸이클러뷰에 붙인다
        adapter.addDto(new CourseDTO("코스코스"));
        recycler.setAdapter(adapter);


        //테스트
        dtos_re = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerView);
        // recyclerView에서 반드시 아래와 같이 초기화를 해줘야 함
        LinearLayoutManager layoutManager2 = new
                LinearLayoutManager(
                activity, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager2);
        adapter_re = new
                HuAdapter(activity.getApplicationContext(), dtos_re,activity);
        // 만든 어댑터를 리싸이클러뷰에 붙인다
        adapter_re.addDto(new HuDTO("후기후기"));
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