package com.hanul.bteam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.adapter.LocalAdapter;
import com.hanul.bteam.dto.GoneDTO;
import com.hanul.bteam.dto.LocationDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocalDDFragment extends Fragment {
    RecyclerView recycler;
    MainActivity activity;
    TextView locname;
    TextView name_desc;
    TextView heigh;
    TextView address;
    ImageButton btnWillGo;
    LocationDTO dto;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.localdd_frag,
                container, false);
        activity = (MainActivity)getActivity();

        dto = (LocationDTO) activity.bundle.getSerializable("dto");
        activity.location = Integer.toString(dto.getId());
        locname =view.findViewById(R.id.tvLocname);
        btnWillGo = view.findViewById(R.id.btnWillGo);
        locname.setText(dto.getLocname() );
        name_desc =view.findViewById(R.id.tvName_desc);
        name_desc.setText(dto.getName_desc());
        heigh =view.findViewById(R.id.tvHeigh);
        heigh.setText(dto.getHeigh());
        address =view.findViewById(R.id.tvAddress);
        address.setText(dto.getAddress());
        btnWillGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Bundle  b = activity.bundle;
                CommonMethod commonMethod = new CommonMethod();
                commonMethod.setParams("type", "2");
                commonMethod.setParams("title", "찜한산");
                commonMethod.setParams("content", "찜한산");
                commonMethod.setParams("member_id", activity.loginid);
                commonMethod.setParams("loccode",b.getString("localcode"));
                commonMethod.setParams("location_id",activity.location);
                commonMethod.getData("willGo", new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(response.isSuccessful()){

//                            Log.d(TAG, "onResponse: " + response.body());
//                            //서버에서 넘어온 데이터를 받는다
                            Gson gson = new Gson();
                            String d = gson.fromJson(response.body(), String.class);

                            Toast.makeText(activity,
                                    d + "찜입니다!!!",Toast.LENGTH_SHORT).show();
//                            //로그인 후 메인 화면을 보여준다


                        }else {
                            Toast.makeText(activity,
                                    "이미 존재합니다;;",Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(activity,
                                "실패했네요~;;",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return view;
    }
}
