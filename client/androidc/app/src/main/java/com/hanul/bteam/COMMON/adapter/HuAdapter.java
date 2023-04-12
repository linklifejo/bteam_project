package com.hanul.bteam.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hanul.bteam.Detailmo;
import com.hanul.bteam.MainActivity;
import com.hanul.bteam.R;
import com.hanul.bteam.dto.CourseDTO;
import com.hanul.bteam.dto.HuDTO;

import java.util.ArrayList;

public class HuAdapter extends
        RecyclerView.Adapter<HuAdapter.ViewHolder> {
    Context context;
    ArrayList<HuDTO> dtos;
    MainActivity activity;
    // 화면을 붙이기 위한 객체 생성
    LayoutInflater inflater;

    public HuAdapter(Context context, ArrayList<HuDTO> dtos, MainActivity a) {
        this.activity = a;
        this.context = context;
        this.dtos = dtos;
        // 화면 붙이는 객체를 생성
        inflater = LayoutInflater.from(context);
    }
    public void addDto(HuDTO dto){dtos.add(dto);}

    @NonNull
    @Override
    public HuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.hulist,
                parent, false);

        return new HuAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HuAdapter.ViewHolder holder, int position) {
        HuDTO dto = dtos.get(position);
        // 불러온 데이터를 ViewHolder에 만들어 놓은 setDto를
        // 사용하여 데이터를 셋팅시킨다
        holder.setDto(dto);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putSerializable("dto",dto);
                activity.fragmentControl(new Detailmo(),b);
                Toast.makeText(context,
                        "산이름 : " + dto.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dtos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        LinearLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parentLayout);
            title = itemView.findViewById(R.id.title);
        }

        public void setDto(@NonNull HuDTO dto) {
            title.setText(dto.getTitle());
//            filepath.setImageResource(dto.getFilepath());
//        Glide.with(itemView).load(dto.getFilepath())
//                .into(filepath);
        }
    }
}