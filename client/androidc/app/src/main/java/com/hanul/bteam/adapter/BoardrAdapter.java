package com.hanul.bteam.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import com.google.gson.Gson;
import com.hanul.bteam.BoardTwo;

import com.google.gson.Gson;
import com.hanul.bteam.BoardTwo;
import com.hanul.bteam.COMMON.CommonMethod;
<<<<<<< HEAD
=======
import com.hanul.bteam.Detailmo;
import com.hanul.bteam.BoardTwo;
>>>>>>> dde553957bd1da110faf5252c8f3bc901c4fa65d

import com.hanul.bteam.MainActivity;
import com.hanul.bteam.R;
import com.hanul.bteam.dto.GoneDTO;

import java.util.ArrayList;

// 4. 선언한 클래스와 xml 파일을 이용하여 화면을 adapter에서 생성한다
public class BoardrAdapter extends
        RecyclerView.Adapter<BoardrAdapter.ViewHolder> {
    private static final String TAG = "main:SingerAdapter";
    // 메인에서 넘겨받을것 -> 생성자를 만든다.
    Context context;
    ArrayList<GoneDTO> dtos;
    MainActivity activity;
    // 화면을 붙이기 위한 객체 생성
    LayoutInflater inflater;
    AlertDialog dialog;

    public BoardrAdapter(Context context, ArrayList<GoneDTO> dtos, MainActivity a) {
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
        View itemView = inflater.inflate(R.layout.boardview,
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
                activity.bundle = b;


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
        TextView title,content;
        ImageView filepath;
        LinearLayout parentLayout;
        ImageButton btnWill;

        // singerview.xml에서 정의한 아이디를 찾아 연결시킨다(생성자)
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parentLayout);
            title = itemView.findViewById(R.id.title);
            filepath = itemView.findViewById(R.id.filepath);
            content = itemView.findViewById(R.id.content);
//            itemView.findViewById(R.id.btnWillGo).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
////                    Bundle  b = activity.bundle;
////                    GoneDTO dto =(GoneDTO) b.getSerializable("dto");
////                    Integer id = dto.getId();
//                    CommonMethod commonMethod = new CommonMethod();
//                    commonMethod.setParams("wtype", "3");
//                    //    commonMethod.setParams("refid", id.toString());
//
//                    commonMethod.setParams("refid", btnWill.getTransitionName());
//                    commonMethod.setParams("member_id", activity.loginid);
//                    commonMethod.getData("willGoIn", new Callback<String>() {
//                        @Override
//                        public void onResponse(Call<String> call, Response<String> response) {
//                            if(response.isSuccessful()){
//
////                            Log.d(TAG, "onResponse: " + response.body());
////                            //서버에서 넘어온 데이터를 받는다
//                                Gson gson = new Gson();
//                                String d = gson.fromJson(response.body(), String.class);
//
//                                Toast.makeText(activity,
//                                        "" + d ,Toast.LENGTH_SHORT).show();
////                            //로그인 후 메인 화면을 보여준다
//
//
//                            }else {
//                                Toast.makeText(activity,
//                                        "실패;;",Toast.LENGTH_SHORT).show();
//
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<String> call, Throwable t) {
//                            Toast.makeText(activity,
//                                    "실패했네요~;;",Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }
//            });
        }

        // singerview에 데이터를 연결시키는 매소드를 만든다
        public void setDto(@NonNull GoneDTO dto) {
//            content.setText(dto.getContent());
            title.setText(dto.getTitle());
            Glide.with(itemView).load(dto.getFilepath()).into(filepath);
            Integer id = dto.getId();
            btnWill.setTransitionName( id.toString());
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


//        private void popUpImgXml(BoardDTO dto) {
//            // 1. res에 xml파일을 만든다
//            // 2. 그 xml파일을 inflate 시켜 setView 한다
//            // 팝업창에 xml 붙이기
//            LayoutInflater inflater = LayoutInflater.from(context); //(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View view = inflater.inflate(R.layout.popupimg, null);
//            // xml에 있는 리소스 찾기
//            ImageView imageView = view.findViewById(R.id.imageView);
//
//
//            // xml에 데이터 연결하기
//            imageView.setImageResource(dto.getResId());
//            AlertDialog.Builder builder = new AlertDialog.Builder(context);
//            builder.setTitle("이미지 띄우기").setView(view);
//
//            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    if (dialog != null) {
//                        dialog.dismiss();
//                    }
//                }
//            });
//            dialog = builder.create();
//            dialog.show();
//        }

        private void popUpImg(int resId) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(resId);

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("이미지 띄우기").setView(imageView);

            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                }
            });
            dialog = builder.create();
            dialog.show();
        }


    }
}