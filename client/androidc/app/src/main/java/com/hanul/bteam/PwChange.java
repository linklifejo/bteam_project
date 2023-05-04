package com.hanul.bteam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hanul.bteam.COMMON.CommonMethod;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PwChange extends Fragment {
    MainActivity activity;
    EditText pw_check, pw;
    String pc,pa;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.pwchange,
                container, false);
        activity = (MainActivity) getActivity();
        pw = view.findViewById(R.id.pw);
        pw_check = view.findViewById(R.id.pw_check);

        view.findViewById(R.id.changepw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CommonMethod commonMethod = new CommonMethod();


                commonMethod.setParams("id", activity.loginid);
                commonMethod.setParams("pw", pw.getText().toString().trim());
                pc=pw_check.getText().toString();
                pa=pw.getText().toString();
                if(pa.equals(pc)) {
                    commonMethod.getData("pwchange", new Callback<String>() {

                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            activity.fragmentControl(new MyInfoFragment());
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
//                            Toast.makeText(activity,
//                                    "아이디나 비밀번호가 맞지 않습니다", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(activity, "비밀번호가다릅니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        view.findViewById(R.id.btnCanc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.fragmentControl(new MyInfoFragment());
            }
        });

        return view;
    }
}