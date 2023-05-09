package com.hanul.bteam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.adapter.BoardtwoAdapter;
import com.hanul.bteam.adapter.CourseAdapter;
import com.hanul.bteam.dto.CourseDTO;
import com.hanul.bteam.dto.GoneDTO;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoardTwo extends Fragment {
    MainActivity activity;
    ArrayList<GoneDTO> dtos;
    Button btn_modify, btn_delete;
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

//        GoneDTO d = (GoneDTO) b.getSerializable("dto");
//        b.putSerializable("dto", d);

        Serializable d1 = b.getSerializable("dto");
        GoneDTO d = (GoneDTO) d1;
//        Log.d("entity : ",""+b.getSerializable("dto"));

        TextView t = view.findViewById(R.id.title);
        t.setText(d.getTitle());
        ImageView i = view.findViewById(R.id.filepath);
        Glide.with(view).load(d.getFilepath()).into(i);

        TextView tt = view.findViewById(R.id.memberid);
        tt.setText(d.getMember_id());

        TextView ttt = view.findViewById(R.id.content);
        ttt.setText(d.getContent());
        btn_modify = view.findViewById(R.id.btn_modify);
        btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putSerializable("dto", d);
                activity.bundle = b;
                activity.fragmentControl(new WriteMo());
            }
        });
        btn_delete = view.findViewById(R.id.btn_delete);
        String currentUserId = activity.loginid;

        if (!currentUserId.equals(d.getMember_id())) {
            btn_modify.setVisibility(View.GONE);
            btn_delete.setVisibility(View.GONE);
        }
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage("삭제하시겠습니까").setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CommonMethod commonMethod = new CommonMethod();
                        commonMethod.setParams("id", d.getId());
                        commonMethod.getData("delete", new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                if (response.isSuccessful()) {
                                    Toast.makeText(activity, "삭제됬어요", Toast.LENGTH_SHORT).show();
                                    activity.fragmentControl(new Board1());

                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                            }
                        });
                    }
                }).setNegativeButton("취소", null).show();
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
