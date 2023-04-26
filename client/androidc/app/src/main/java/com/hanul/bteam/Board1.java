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
import com.hanul.bteam.adapter.BoardOneAdapter;
import com.hanul.bteam.dto.BoardDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Board1 extends Fragment {
    MainActivity activity;
    RecyclerView recycler;
    BoardOneAdapter adapter;
    ArrayList<BoardDTO> dtos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.board_1,
                container, false);
        activity =(MainActivity)getActivity();
        Bundle b = activity.bundle;
        dtos = new ArrayList<>();

        recycler = view.findViewById(R.id.recycler);

        LinearLayoutManager layoutManager = new
                LinearLayoutManager(
                activity, RecyclerView.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);

        CommonMethod commonMethod = new CommonMethod();

        commonMethod.getData("bolist", new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()){
                    Gson gson = new Gson();
                    dtos =  gson.fromJson(response.body(), new TypeToken<ArrayList<BoardDTO>>(){}.getType());
                    for(BoardDTO dto: dtos){
                        dto.setTitle(dto.getTitle());
                        dto.setMember_id(dto.getMember_id());
                        dto.setGonetime(dto.getGonetime());
                        dto.setContent(dto.getContent());

                    }
                    adapter = new BoardOneAdapter(activity.getApplicationContext(), dtos,activity);
                    recycler.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });


        return view;




    }
}
