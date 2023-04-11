package com.hanul.bteam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hanul.bteam.dto.BoardDTO;
import com.hanul.bteam.dto.GoneDTO;

public class BoardTwo extends Fragment {
    MainActivity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.board_2,
                container, false);
        activity = (MainActivity) getActivity();

        Bundle b = activity.bundle;
        BoardDTO d = (BoardDTO) b.getSerializable("dto");
        TextView t = view.findViewById(R.id.title);
        t.setText(d.getTitle());





        view.findViewById(R.id.btn_boardList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.fragmentControl(new Board1());
            }
        });
        return view;
    }
}
