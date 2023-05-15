package com.hanul.bteam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.dto.GoneDTO;
import com.hanul.bteam.dto.LocationDTO;
import com.hanul.bteam.dto.MemberDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Myinfodiary extends Fragment{

    MainActivity activity;
    Button btn_modify, btn_delete;
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




        return view;
    }










}