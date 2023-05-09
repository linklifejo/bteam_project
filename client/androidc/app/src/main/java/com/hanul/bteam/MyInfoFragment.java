package com.hanul.bteam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hanul.bteam.COMMON.CommonMethod;

import com.hanul.bteam.adapter.MemberAdapter;



import com.hanul.bteam.adapter.MyWroteAdapter;
import com.hanul.bteam.adapter.RecentlyAdapter;
import com.hanul.bteam.adapter.WillGoAdapter;
import com.hanul.bteam.dto.GoneDTO;
import com.hanul.bteam.dto.LocationDTO;
import com.hanul.bteam.dto.MemberDTO;
import com.hanul.bteam.dto.WillgoDTO;
import com.hanul.bteam.login.LoginFrist;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyInfoFragment extends Fragment {
    MainActivity activity;
    RecyclerView recycler2,recycler,rra;
    WillGoAdapter adapter;
    ArrayList<MemberDTO> dtoo;
    MemberAdapter adapter_me;
    ArrayList<WillgoDTO> dtos;
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
        Bundle b = activity.bundle;

//        MemberDTO d = (MemberDTO) b.getSerializable("dto");

//        MemberDTO d = (MemberDTO) b.getSerializable("dto");
//        Serializable d1 = b.getSerializable("dto");
//        d2 = (MemberDTO) d1;
//        d = (MemberDTO) b.getSerializable("dto");

        view.findViewById(R.id.btn_write).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemberDTO d = (MemberDTO) b.getSerializable("dto");
                Bundle b = new Bundle();
                b.putSerializable("dto",d);
                activity.bundle = b;
                activity.fragmentControl(new ModifyInfo(),b);
            }
        });
        //처음 회원가입할때 이름 픽스시키고
        TextView t = view.findViewById(R.id.name);
        t.setText(activity.name);

        ImageView i =view.findViewById(R.id.profile);
        if(i !=null) {
            Glide.with(view).load(activity.profile).into(i);
        }

        view.findViewById(R.id.changepw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.fragmentControl(new PwChange());
            }
        });

        view.findViewById(R.id.btn_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.isLogin=false;
                activity.isLogin();
                activity.fragmentControl(new LoginFrist());
            }
        });

//        t.setText(d.getName());

        dtos = new ArrayList<>();
        recycler = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(
                activity, RecyclerView.HORIZONTAL, false);
        recycler.setLayoutManager(layoutManager);

        CommonMethod commonMethod = new CommonMethod();
        commonMethod.setParams("member_id",   activity.loginid);
        commonMethod.getData("willGo", new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()){
                    Gson gson = new Gson();
                    dtos =  gson.fromJson(response.body(), new TypeToken<ArrayList<WillgoDTO>>(){}.getType());
                    for(WillgoDTO dto: dtos){
                        dto.setLocname(dto.getLocname());
                        dto.setFilepath(dto.getFilepath());
                        dto.setRefid(dto.getRefid());
                        dto.setWtype(dto.getWtype());
                        dto.setId(dto.getId());
                    }
                    adapter = new WillGoAdapter(activity.getApplicationContext(), dtos,activity);
                    recycler.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
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
                activity, RecyclerView.VERTICAL, false);
        recycler2.setLayoutManager(layout);
        CommonMethod commonMethod2 = new CommonMethod();
        commonMethod2.setParams("type", "1");
        commonMethod2.setParams("ptype", "1");
        commonMethod2.setParams("member_id",activity.loginid);
        commonMethod2.setParams("num", "6");
        commonMethod2.getData("diary", new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    Gson gson = new Gson();
                    dtos_re =  gson.fromJson(response.body(), new TypeToken<ArrayList<GoneDTO>>(){}.getType());
                    for(GoneDTO dto: dtos_re){
                        dto.setContentr(dto.getContentr());
                        dto.setTitle(dto.getTitle());
                    }

                    adapter_re = new RecentlyAdapter(activity.getApplicationContext(), dtos_re,activity);
                    recycler2.setAdapter(adapter_re);
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });






       dtoo = new ArrayList<>();
        rra = view.findViewById(R.id.rra);
        LinearLayoutManager layout2 = new
                LinearLayoutManager(
                activity, RecyclerView.HORIZONTAL, false);
        rra.setLayoutManager(layout2);
        CommonMethod commonMethod3 = new CommonMethod();
        commonMethod3.setParams("id", activity.loginid);
        commonMethod3.getData("id_check", new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    Gson gson = new Gson();
                    dtoo =  gson.fromJson(response.body(), new TypeToken<ArrayList<MemberDTO>>(){}.getType());
                    for(MemberDTO dto: dtoo){
                        Bundle b = new Bundle();
                        b.putSerializable("dto", dto);
                        activity.bundle = b;
                        dto.setProfile(dto.getProfile());
                    }
                    adapter_me = new MemberAdapter(activity.getApplicationContext(), dtoo,activity);
                    rra.setAdapter(adapter_me);
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });


        return view;
    }
}
