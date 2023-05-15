package com.hanul.bteam.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
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
import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.Detailmo;
import com.hanul.bteam.HomeFragment;
import com.hanul.bteam.MainActivity;
import com.hanul.bteam.R;
import com.hanul.bteam.dto.GoneDTO;
import com.hanul.bteam.dto.LocationDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GoneAdapter extends
        RecyclerView.Adapter<GoneAdapter.ViewHolder> {
    private static final String TAG = "main:SingerAdapter";

    // 메인에게 넘겨받는것 -> 반드시 : Context, ArrayList<DTO>
    Context context;
    ArrayList<GoneDTO> dtos;
    MainActivity activity;
    LayoutInflater inflater;



    // 생성자로 메인에서 넘겨받은것들을 연결
    public GoneAdapter(Context context, ArrayList<GoneDTO> dtos, MainActivity a) {
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
    public void addDto(GoneDTO dto) {
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
        View itemView = inflater.inflate(R.layout.goneview,
                parent, false);

        return new ViewHolder(itemView);
    }

    // 인플레이트 시킨 화면에 데이터를 셋팅시킨다
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: " + position);
        GoneDTO dto = dtos.get(position);

        holder.setDto(dto);

        // 리싸이클러뷰에 항목을 선택했을때 그 항목을 가져오는 리스너
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putSerializable("dto",dto);
                activity.bundle = b;
                activity.fragmentControl(new BoardTwo(),b);
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
        ImageButton btnWill,btndel;
        TextView title;
        ImageView filepath;
        LinearLayout parentLayout;

        String jjim_check = activity.jjim_check;



//        String jjim_check ="0";


        // singerview.xml에서 정의한 아이디를 찾아 연결시킨다(생성자)
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parentLayout = itemView.findViewById(R.id.parentLayout);
            title = itemView.findViewById(R.id.title);
            btnWill = itemView.findViewById(R.id.btnWillGo);
            filepath = itemView.findViewById(R.id.filepath);
            btndel =itemView.findViewById(R.id.btndel);
            jjim_check=title.getText().toString();


            itemView.findViewById(R.id.btndel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CommonMethod commonMethod = new CommonMethod();
                    commonMethod.setParams("wtype", "1");
                    commonMethod.setParams("refid", btndel.getTransitionName());
                    commonMethod.setParams("member_id", activity.loginid);
                    jjim_check ="0";
                    commonMethod.setParams("jjim", jjim_check);
                    commonMethod.getData("willGoIn", new Callback<String>() {

                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            if(response.isSuccessful()){
                                Gson gson = new Gson();
                                GoneDTO dto = gson.fromJson(response.body(), GoneDTO.class);
                              //  jjim_check ="0";
                                btnWill.setVisibility(View.VISIBLE);
                                btndel.setVisibility(View.GONE);


                            }else {
                                Toast.makeText(activity,
                                        "실패;;",Toast.LENGTH_SHORT).show();

                            }
                        }
                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(activity,
                                    "실패했네요~;;",Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            });




            itemView.findViewById(R.id.btnWillGo).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                    Bundle  b = activity.bundle;
//                    GoneDTO dto =(GoneDTO) b.getSerializable("dto");
//                    Integer id = dto.getId();
                    CommonMethod commonMethod = new CommonMethod();
                    commonMethod.setParams("wtype", "1");
//                    commonMethod.setParams("refid", id.toString());
                    commonMethod.setParams("refid", btnWill.getTransitionName());
                    commonMethod.setParams("member_id", activity.loginid);
                    jjim_check ="1";
                    commonMethod.setParams("jjim", jjim_check);


                    commonMethod.getData("willGoIn", new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            if(response.isSuccessful()){
                                Gson gson = new Gson();
                                GoneDTO dto = gson.fromJson(response.body(), GoneDTO.class);
                                btnWill.setVisibility(View.GONE);
                                btndel.setVisibility(View.VISIBLE);

                            }else {
                                Toast.makeText(activity,
                                        "실패;;",Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(activity,
                                    "실패했네요~;;",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        }







        // singerview에 데이터를 연결시키는 매소드를 만든다
        public void setDto(@NonNull GoneDTO dto) {
            title.setText(dto.getTitle());
            Glide.with(itemView).load(dto.getFilepath())
                    .into(filepath);
            Integer id = dto.getId();
            btnWill.setTransitionName( id.toString());
            btndel.setTransitionName(id.toString());

            jjim_check = dto.getJjim().toString();
            if(jjim_check.equals("0")) {
                btnWill.setVisibility(View.VISIBLE);
                btndel.setVisibility(View.GONE);

            }else {
                btnWill.setVisibility(View.GONE);
                btndel.setVisibility(View.VISIBLE);
            }
        }

//        private void showMessage(int position) {
//            AlertDialog.Builder builder = new
//                    AlertDialog.Builder(context);
//            builder.setTitle("안내");
//            builder.setMessage("삭제하시겠습니까?");
//            builder.setIcon(android.R.drawable.ic_dialog_alert);
//
//            // 예 버튼
//            builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    // dtos.remove(position);
//                    delDto(position);
//                    // 지우거나 추가하면 반드시 화면을 갱신시켜야 한다
//                    notifyDataSetChanged();
//                }
//            });
//
//            // 아니요 버튼
//            builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//
//                }
//            });
//
//            AlertDialog dialog = builder.create();
//            dialog.show();
//        }

    }
}
