package com.hanul.bteam.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hanul.bteam.BoardTwo;
import com.hanul.bteam.MainActivity;
import com.hanul.bteam.R;
import com.hanul.bteam.dto.GoneDTO;

import java.util.ArrayList;

public class BoardOneAdapter extends
        RecyclerView.Adapter<BoardOneAdapter.ViewHolder>{
    Context context;
    ArrayList<GoneDTO> dtos;
    MainActivity activity;
    // 화면을 붙이기 위한 객체 생성
    LayoutInflater inflater;


    public BoardOneAdapter(Context context, ArrayList<GoneDTO> dtos, MainActivity a) {
        this.activity = a;
        this.context = context;
        this.dtos = dtos;
        // 화면 붙이는 객체를 생성
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.board_1_view,
                parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GoneDTO dto = dtos.get(position);
        holder.setDto(dto);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putSerializable("dto", dto);
                activity.bundle = b;

                activity.fragmentControl(new BoardTwo(),b);
            }
        });
    }

    @Override
    public int getItemCount() {return dtos.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        // singerview.xml 에서 사용된 모든 위젯을 정의한다
        TextView title,member_id,gonetime,content;
        LinearLayout parentLayout;

        // singerview.xml에서 정의한 아이디를 찾아 연결시킨다(생성자)
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parentLayout);
            member_id = itemView.findViewById(R.id.memberid);
            gonetime = itemView.findViewById(R.id.gonetime);
            title = itemView.findViewById(R.id.title);
        }

        // singerview에 데이터를 연결시키는 매소드를 만든다
        public void setDto(@NonNull GoneDTO dto) {
            title.setText(dto.getTitle());
            member_id.setText(dto.getMember_id());
            gonetime.setText(dto.getGonetime());
        }
    }
}
