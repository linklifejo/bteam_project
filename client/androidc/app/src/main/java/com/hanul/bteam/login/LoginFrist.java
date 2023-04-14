package com.hanul.bteam.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.HomeFragment;
import com.hanul.bteam.MainActivity;
import com.hanul.bteam.R;

public class LoginFrist extends Fragment {
    MainActivity activity;
    EditText etID, etPW;
    Fragment JoinLogin;
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
        view.findViewById(R.id.etID);
        view.findViewById(R.id.etPW);
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
                isStart = true;
                if (isStart) start();
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
