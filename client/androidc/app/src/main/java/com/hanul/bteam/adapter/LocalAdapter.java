package com.hanul.bteam.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hanul.bteam.LocalDDFragment;
import com.hanul.bteam.MainActivity;
import com.hanul.bteam.R;
import com.hanul.bteam.dto.LocationDTO;

import java.util.ArrayList;


public class LocalAdapter extends
        RecyclerView.Adapter<LocalAdapter.ViewHolder> {
    private static final String TAG = "main:SingerAdapter";

    // 메인에게 넘겨받는것 -> 반드시 : Context, ArrayList<DTO>
    Context context;
    ArrayList<LocationDTO> dtos;
    MainActivity activity;
    LayoutInflater inflater;

    // 생성자로 메인에서 넘겨받은것들을 연결
    public LocalAdapter(Context context, ArrayList<LocationDTO> dtos, MainActivity a) {
        this.activity = a;
        this.context = context;
        this.dtos = dtos;
        // 화면 붙이는 객체를 생성
        inflater = LayoutInflater.from(context);
    }

    ////////////////////////////////////////////////////
    // 매소드는 여기에 만든다
    // dtos에 dto를 추가하는 매소드
    //테스트
    public void addDto(LocationDTO dto) {
        dtos.add(dto);
    }

    // dtos의 특정 위치에 있는 dto를 삭제하는 매소드
    public void delDto(int position) {
        dtos.remove(position);
    }

    ////////////////////////////////////////////////////

    // 화면을 인플레이트 시킨다 (붙인다)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.localview,
                parent, false);

        return new ViewHolder(itemView);
    }

    // 인플레이트 시킨 화면에 데이터를 셋팅시킨다
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: " + position);
        // dtos에 있는 데이터를 각각 불러온다
        LocationDTO dto = dtos.get(position);
        // 불러온 데이터를 ViewHolder에 만들어 놓은 setDto를
        // 사용하여 데이터를 셋팅시킨다
        holder.setDto(dto);

        // 리싸이클러뷰에 항목을 선택했을때 그 항목을 가져오는 리스너
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity.bundle.putSerializable("dto",dto);
                activity.fragmentControl(new LocalDDFragment());

            }
        });


    }

    // dtos에 저장된 dto 갯수
    @Override
    public int getItemCount() {
        return dtos.size();
    }

    // 3. xml 파일에서 사용된 모든 변수를 adapter에서 클래스로 선언한다
    public class ViewHolder extends RecyclerView.ViewHolder {
        // singerview.xml 에서 사용된 모든 위젯을 정의한다
        TextView locname;
        ImageView filepath;
        LinearLayout parentLayout;

        // singerview.xml에서 정의한 아이디를 찾아 연결시킨다(생성자)
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parentLayout = itemView.findViewById(R.id.parentLayout);
            locname = itemView.findViewById(R.id.locname);

            filepath = itemView.findViewById(R.id.filepath);

        }

        // singerview에 데이터를 연결시키는 매소드를 만든다
        public void setDto(@NonNull LocationDTO dto) {
            locname.setText(dto.getLocname());


            Glide.with(itemView).load(dto.getFilepath()).into(filepath);

        }

        private void showMessage(int position) {
            AlertDialog.Builder builder = new
                    AlertDialog.Builder(context);
            builder.setTitle("안내");
            builder.setMessage("삭제하시겠습니까?");
            builder.setIcon(android.R.drawable.ic_dialog_alert);

            // 예 버튼
            builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // dtos.remove(position);
                    delDto(position);
                    // 지우거나 추가하면 반드시 화면을 갱신시켜야 한다
                    notifyDataSetChanged();
                }
            });

            // 아니요 버튼
            builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }
}
