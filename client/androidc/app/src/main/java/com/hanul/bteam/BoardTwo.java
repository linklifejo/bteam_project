package com.hanul.bteam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.adapter.BoardtwoAdapter;
import com.hanul.bteam.dto.GoneDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoardTwo extends Fragment {
    MainActivity activity;
    RecyclerView rro;
    ArrayList<GoneDTO> dtos;
    BoardtwoAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.board_2,
                container, false);
        activity = (MainActivity) getActivity();

        Bundle b = activity.bundle;
        GoneDTO d = (GoneDTO) b.getSerializable("dto");

        TextView t = view.findViewById(R.id.title);
        t.setText(d.getTitle());

        TextView tt = view.findViewById(R.id.memberid);
        tt.setText(d.getMember_id());

        TextView ttt = view.findViewById(R.id.content);
        ttt.setText(d.getContent());




        dtos = new ArrayList<>();
        rro = view.findViewById(R.id.rro);
        LinearLayoutManager layout = new LinearLayoutManager(activity, GridLayoutManager.HORIZONTAL, false);
        rro.setLayoutManager(layout);
        CommonMethod commonMethod2 = new CommonMethod();
        // 어댑터에 생성한 매소드 addDto를 이용하여 dtos에 데이터를 추가한다
        commonMethod2.setParams("type", "1");
        commonMethod2.setParams("ptype", "3");
        commonMethod2.setParams("num", "10");
        commonMethod2.getData("selectmou", new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    Gson gson = new Gson();
                    dtos =  gson.fromJson(response.body(), new TypeToken<ArrayList<GoneDTO>>(){}.getType());
                    for(GoneDTO dto: dtos){
                        dto.setFilepath(dto.getFilepath());
                    }
                    adapter = new BoardtwoAdapter(activity.getApplicationContext(), dtos,activity);
                    rro.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });


        view.findViewById(R.id.btn_boardList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.fragmentControl(new Board1());
            }
        });
        return view;
    }
}
