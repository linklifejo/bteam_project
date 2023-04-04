package com.hanul.bteam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hanul.bteam.dto.GoneDTO;


public class Danger extends Fragment {
    MainActivity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.danger,
                container, false);
        activity =(MainActivity)getActivity();
        Bundle b = activity.bundle;
        GoneDTO d = (GoneDTO) b.getSerializable("dto");
        TextView t = viewGroup.findViewById(R.id.locname);
        t.setText(d.getLocname());
        return viewGroup;

    }
}