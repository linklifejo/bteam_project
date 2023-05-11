package com.hanul.bteam;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hanul.bteam.COMMON.CommonMethod;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Photo extends Fragment {
    MainActivity activity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.photo,
                container, false);
        activity = (MainActivity) getActivity();

        Bundle b = activity.bundle;
        ImageView i = view.findViewById(R.id.profile);
        Glide.with(view).load(activity.profile).into(i);

        Drawable defaultImage = getResources().getDrawable(R.drawable.kakao_1);

        if (activity.profile == null) {
            i.setImageDrawable(defaultImage);
        }

        view.findViewById(R.id.delpr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonMethod commonMethod = new CommonMethod();

                commonMethod.setParams("id", activity.loginid);
                commonMethod.getData("del", new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful()) {
                            activity.profile =null;

                            activity.fragmentControl(new MyInfoFragment());

                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });


            }
        });





        return view;
    }
}