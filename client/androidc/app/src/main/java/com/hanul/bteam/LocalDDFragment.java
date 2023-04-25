package com.hanul.bteam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.dto.LocationDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocalDDFragment extends Fragment {

    MainActivity activity;
    TextView locname;
    TextView name_desc;
    TextView heigh;
    TextView address;
    LocationDTO dto;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.localdd_frag,
                container, false);
        activity = (MainActivity)getActivity();
        Bundle b = activity.bundle;
        dto = (LocationDTO) activity.bundle.getSerializable("dto");

        Integer id = dto.getId();
        activity.location = id.toString();
        locname =view.findViewById(R.id.tvLocname);
        locname.setText(dto.getLocname() );
        name_desc =view.findViewById(R.id.tvName_desc);
        name_desc.setText(dto.getName_desc());

        ImageView i = view.findViewById(R.id.filepath);
        Glide.with(view).load(dto.getFilepath()).into(i);





        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.course);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               activity.fragmentControl(new Course());
            }
        });

        Button btn1 = view.findViewById(R.id.danger);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.fragmentControl(new Danger());
            }
        });
    }
}
