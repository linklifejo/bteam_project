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

import com.bumptech.glide.Glide;
import com.hanul.bteam.adapter.BoardtwoAdapter;
import com.hanul.bteam.dto.GoneDTO;

import java.io.Serializable;
import java.util.ArrayList;

public class BoardTwo extends Fragment {
    MainActivity activity;
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
//        Serializable d1 = b.getSerializable("dto");
//        GoneDTO d = (GoneDTO) d1;
//        Log.d("entity : ",""+b.getSerializable("dto"));

        TextView t = view.findViewById(R.id.title);
        t.setText(d.getTitle());
        ImageView i = view.findViewById(R.id.filepath);
        Glide.with(view).load(d.getFilepath()).into(i);

        TextView tt = view.findViewById(R.id.memberid);
        tt.setText(d.getMember_id());

        TextView ttt = view.findViewById(R.id.content);
        ttt.setText(d.getContent());


        view.findViewById(R.id.btn_boardList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.fragmentControl(new Board1());
            }
        });
        return view;
    }
}
