package com.hanul.bteam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hanul.bteam.dto.GoneDTO;
import com.hanul.bteam.dto.LocationDTO;
import com.hanul.bteam.dto.MemberDTO;

public class Myinfodiary extends Fragment{

    MainActivity activity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.myinfodiary,
                container, false);
        activity =(MainActivity)getActivity();
        Bundle b = activity.bundle;
        GoneDTO d = (GoneDTO) b.getSerializable("dto");
        TextView t = view.findViewById(R.id.title);
        t.setText(d.getTitle());
        TextView tt = view.findViewById(R.id.contentr);
        tt.setText(d.getContentr());

        return view;
    }










}