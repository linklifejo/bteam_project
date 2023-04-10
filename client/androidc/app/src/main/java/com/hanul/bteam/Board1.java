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

import com.hanul.bteam.adapter.BoardOneAdapter;
import com.hanul.bteam.adapter.BoardrAdapter;
import com.hanul.bteam.dto.BoardDTO;

import java.util.ArrayList;

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
        return view;




    }
}
