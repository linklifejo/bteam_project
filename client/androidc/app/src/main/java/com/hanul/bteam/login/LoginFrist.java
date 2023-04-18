package com.hanul.bteam.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.HomeFragment;
import com.hanul.bteam.MainActivity;
import com.hanul.bteam.R;
import com.hanul.bteam.dto.MemberDTO;
import com.hanul.bteam.dto.WillgoDTO;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFrist extends Fragment {
    MainActivity activity;
    EditText id, pw;


    Button btnLogin, btnJoin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.loginfirst,
                container, false);
        activity =(MainActivity)getActivity();
        activity.checkDangerousPermissions();
        id = view.findViewById(R.id.id);
        pw = view.findViewById(R.id.pw);
        view.findViewById(R.id.btnJoin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.fragmentControl(new JoinLogin());
            }
        });
        view.findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isStart = false;
                // 로그인 로직
//                String id = etID.getText().toString();
//                String pw = etPW.getText().toString();
//                CommonMethod commonMethod = new CommonMethod();
                // 로그인 성공시 아래 실행

//                MemberDTO dto = new MemberDTO();
//                dto.setId( id.getText().toString() );
//                dto.setPw( pw.getText().toString() );



                CommonMethod commonMethod = new CommonMethod();
                commonMethod.setParams("id", id.getText());
                commonMethod.setParams("pw", pw.getText());
                commonMethod.getData("login", new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(!response.body().equals(null)) {
                            MemberDTO loginDto = new Gson().fromJson(response.body(), MemberDTO.class);
                            if (loginDto != null) {
                                Bundle b = new Bundle();
                                b.putSerializable("dto", loginDto);
                                activity.bundle = b;
                                activity.loginid = id.getText().toString();

                                start();
//                                activity.fragmentControl(new HomeFragment());
                            } else {
                                Toast.makeText(activity,
                                        "아이디나 비밀번호가 맞지 않습니다", Toast.LENGTH_SHORT).show();
                            }
                        }
                        }


                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(activity,
                                "아이디나 비밀번호가 맞지 않습니다", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });





        return view;
    }
    private void start(){
        activity.isLogin = true;
        activity.isLogin();
        activity.fragmentControl(new HomeFragment());
    }
}
