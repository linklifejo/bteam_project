package com.hanul.bteam.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hanul.bteam.BoardTwo;
import com.hanul.bteam.MainActivity;
import com.hanul.bteam.R;
import com.hanul.bteam.dto.GoneDTO;

import java.util.ArrayList;

// 4. 선언한 클래스와 xml 파일을 이용하여 화면을 adapter에서 생성한다
public class BoardtwoAdapter extends
        RecyclerView.Adapter<BoardtwoAdapter.ViewHolder> {
    private static final String TAG = "main:SingerAdapter";
    // 메인에서 넘겨받을것 -> 생성자를 만든다.
    Context context;
    ArrayList<GoneDTO> dtos;
    MainActivity activity;
    // 화면을 붙이기 위한 객체 생성
    LayoutInflater inflater;
    AlertDialog dialog;

    public BoardtwoAdapter(Context context, ArrayList<GoneDTO> dtos, MainActivity a) {
        this.context = context;
        this.dtos = dtos;
        this.activity = a;
        inflater = LayoutInflater.from(context);
    }

    //////////////////////////////////////////////////
    // 매소드를 만들때는 무조건 여기에 생성한다(adapter)
    // 하나의 dto 추가하기 (SingerDTO)


    // dtos의 모든 내용 지우기
    public void removeDtos() {
        dtos.clear();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.bbview,
                parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: " + position);
        GoneDTO dto = dtos.get(position);
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
    public int getItemCount() {
        return dtos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // singerview.xml 에서 사용된 모든 위젯을 정의한다
        ImageView filepath;
        LinearLayout parentLayout;

        // singerview.xml에서 정의한 아이디를 찾아 연결시킨다(생성자)
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parentLayout);
            filepath = itemView.findViewById(R.id.filepath);

        }

        // singerview에 데이터를 연결시키는 매소드를 만든다
        public void setDto(@NonNull GoneDTO dto) {
            Glide.with(itemView).load(dto.getFilepath()).into(filepath);
        }


        // 가장 중요함 : 화면을 생성하고 특정뷰에 대한 클릭이벤트를 만들수 있다
        // 만약 화면 5개를 생성한다면 getView가 5번 실행된다
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        Log.d(TAG, "getView: " + position);
//
//        BoardViewHolder viewHolder;
//
//        // 캐시된 뷰가 없을 경우 새로 뷰홀더를 생성하고
//        // 있으면 그 뷰를 재활용한다
//        if(convertView == null){
//            // 화면을 붙인다
//            convertView = inflater.inflate(R.layout.boardview,
//                    parent, false);
//
//            viewHolder = new BoardViewHolder();
//            // 붙인 화면과 아래에 생성한 뷰홀더를 연결한다
//            viewHolder.ivImage = convertView.findViewById(R.id.filepath);
//
//
//            convertView.setTag(viewHolder);
//        }else { // 캐시된 뷰가 있을 경우 이미 생성된 뷰홀더를 사용한다
//            viewHolder = (BoardViewHolder) convertView.getTag();
//        }
//
//        // 선택한 dto 데이터 가져오기
//        BoardDTO dto = dtos.get(position);
//        int resImage = dto.getResId();
//
//        // 화면에 데이터 연결하기
//        viewHolder.filepath.setImageResource(resImage);
//
//        // 이미지 클릭시 이벤트 걸어주기
//        viewHolder.ivImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,  "선택 : " + position
//                        + "\n이름 : " + dtos.get(position).getMountin_name(), Toast.LENGTH_SHORT).show();
//
//                // 이미지뷰를 동적으로 생성해서 해당 이미지 보여줌
//                //popUpImg(dtos.get(position).getResId());
//               // popUpImgXml(dtos.get(position));
//            }
//        });
//
//
//
//        // 만들어진 뷰를 반환
//        return convertView;
//    }




    }
}