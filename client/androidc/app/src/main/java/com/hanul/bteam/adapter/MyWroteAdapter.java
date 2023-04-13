package com.hanul.bteam.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hanul.bteam.BoardTwo;
import com.hanul.bteam.MainActivity;
import com.hanul.bteam.R;
import com.hanul.bteam.dto.BoardDTO;

import java.util.ArrayList;

public class MyWroteAdapter extends
        RecyclerView.Adapter<MyWroteAdapter.ViewHolder> {
    Context context;
    ArrayList<BoardDTO> dtos;
    MainActivity activity;
    LayoutInflater inflater;

    public MyWroteAdapter(Context context, ArrayList<BoardDTO> dtos, MainActivity a) {
        this.context = context;
        this.dtos = dtos;
        this.activity = a;
        inflater = LayoutInflater.from(context);
    }



    @NonNull
    @Override
    public MyWroteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.wroteview,
                parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        BoardDTO dto = dtos.get(position);
        holder.setDto(dto);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putSerializable("dto", dto);
                activity.fragmentControl(new BoardTwo(),b);
                Toast.makeText(context,
                        "산이름 : " + dto.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {return dtos.size();}
    public class ViewHolder extends RecyclerView.ViewHolder {
        // singerview.xml 에서 사용된 모든 위젯을 정의한다
        TextView title;
        ImageView filepath;
        LinearLayout parentLayout;

        // singerview.xml에서 정의한 아이디를 찾아 연결시킨다(생성자)
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parentLayout);
            title = itemView.findViewById(R.id.title);
            filepath = itemView.findViewById(R.id.filepath);
        }

        // singerview에 데이터를 연결시키는 매소드를 만든다
        public void setDto(@NonNull BoardDTO dto) {
            title.setText(dto.getTitle());
            Glide.with(itemView).load(dto.getFilepath()).into(filepath);
        }


    }

}
