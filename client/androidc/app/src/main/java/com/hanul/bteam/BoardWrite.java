package com.hanul.bteam;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.dto.GoneDTO;
import com.hanul.bteam.dto.MemberDTO;
import com.hanul.bteam.login.LoginFrist;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoardWrite extends Fragment {
    MainActivity activity;
    EditText title,content,contentr;
    RequestBody fileBody =null;
    MultipartBody.Part filePart =null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.board_3,
                container, false);
        activity = (MainActivity) getActivity();

        title =view.findViewById(R.id.title);
        content=view.findViewById(R.id.content);
        contentr=view.findViewById(R.id.contentr);

        view.findViewById(R.id.btn_upload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonMethod commonMethod = new CommonMethod();


                GoneDTO dto = new GoneDTO();
                dto.setTitle( title.getText().toString() );
                dto.setContent( content.getText().toString() );
                dto.setContentr( contentr.getText().toString() );

                commonMethod.setParams("param", dto);

                commonMethod.sendFile("gonewrite", filePart, new Callback<String>() {

                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                            activity.fragmentControl(new Board1());

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });

            }
        });
        view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.fragmentControl(new Board1());
            }
        });




        return view;
    }
}
