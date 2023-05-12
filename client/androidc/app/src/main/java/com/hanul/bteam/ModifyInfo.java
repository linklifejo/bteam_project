package com.hanul.bteam;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.COMMON.DataCheck;
import com.hanul.bteam.dto.GoneDTO;
import com.hanul.bteam.dto.MemberDTO;
import com.hanul.bteam.login.LoginFrist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModifyInfo extends Fragment {
    MainActivity activity;
    EditText  name, phone, email;
    ImageView profile;
    File imgFile = null;
    String imgFilePath = null;
    int reqPicCode = 2008;
    RequestBody fileBody =null;
    MultipartBody.Part filePart =null;
    boolean isCheck = true;
    Uri uri;
    MemberDTO d;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {





        View view =  inflater.inflate(R.layout.myinfo_modify_frag_view,
                container, false);

        activity = (MainActivity) getActivity();
        Bundle b = activity.bundle;
//        d = (MemberDTO) b.getSerializable("dto");
        MemberDTO dto = new MemberDTO();
        name =view.findViewById(R.id.name);
        phone =view.findViewById(R.id.phone);
        email =view.findViewById(R.id.email);
        profile = view.findViewById(R.id.profile);

        //조회
        name.setText(activity.name);
        phone.setText(activity.phone);
        email.setText(activity.email);

        Glide.with(view).load(activity.profile).into(profile);
        Drawable defaultImage = getResources().getDrawable(R.drawable.kakao_1);

        if (activity.profile == null) {
            profile.setImageDrawable(defaultImage);
        }



        view.findViewById(R.id.btnupdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(!DataCheck.checkPhoneNumber(phone.getText().toString())){
//                    phone.requestFocus();
//                    isCheck =false;
//                    Toast.makeText(activity,
//                            "휴대폰 안쳣습니당", Toast.LENGTH_SHORT).show();
//                }
//                else if(!DataCheck.checkEmailAddress(address.getText().toString())){
//                    address.requestFocus();
//                    isCheck =false;
//                    Toast.makeText(activity,
//                            "주소를 안쳤습니다", Toast.LENGTH_SHORT).show();
//                }
                CommonMethod commonMethod = new CommonMethod();

                if(imgFile != null) {
                    fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(imgFilePath));
                    filePart = MultipartBody.Part.createFormData("file", "test.jpg", fileBody);
                }


                dto.setId( activity.loginid );
                dto.setName( name.getText().toString() );
                activity.name= name.getText().toString();
                dto.setPhone( phone.getText().toString() );
                activity.phone=phone.getText().toString();
                dto.setEmail( email.getText().toString() );
                activity.email=email.getText().toString();


//                if(imgFilePath!=null){
//                    dto.setProfile(imgFilePath);
//                    activity.profile = dto.getProfile();
//                }

                // 수정화면 들어갈때 사진 조회및 널체크 조회후 profile을 activity에전달
                if(imgFilePath==null){
                    dto.setProfile(activity.profile);
                }else{
                    dto.setProfile(imgFilePath);
                    activity.profile = dto.getProfile();
                }
                if(activity.profile == null){
                    Glide.with(view).load(activity.profile).into(profile);
                }



                commonMethod.setParams("param", dto);

                commonMethod.sendFile("update", filePart, new Callback<String>() {

                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(isCheck) {
                            Bundle b = new Bundle();
                            b.putSerializable("dto", dto);
                            activity.bundle=b;
                            activity.fragmentControl(new MyInfoFragment(),b);
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        isCheck =false;

                    }
                });
            }
        });

        view.findViewById(R.id.profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 암묵적 인텐트 : 사진찍기(카메라창을 불러옴)
                Intent picIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // 일단 이 인텐트가 사용가능한지 체크
                if(picIntent.resolveActivity(activity.getPackageManager()) != null){
                    imgFile = null;
                    // creatFile 매소드를 이용하여 임시파일을 만듬
                    imgFile = creatFile();

                    if(imgFile != null){
                        // API24 이상부터는 FileProvider를 제공해야함
                        Uri imgUri = FileProvider.getUriForFile(activity.getApplicationContext(),
                                activity.getApplicationContext().getPackageName()+".fileprovider",
                                imgFile
                        );
                        // 만약에 API24 이상이면
                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){ // API24
                            picIntent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
                        }else{  // 만약에 24 미만이면
                            picIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                    Uri.fromFile(imgFile));
                        }

                        startActivityForResult(picIntent, reqPicCode);
                    }

                }
            }
        });
        view.findViewById(R.id.modi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");

                startActivityResult.launch(intent);
            }
        });

        view.findViewById(R.id.btn_cel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.fragmentControl(new MyInfoFragment());
            }
        });
        return view;


    }
    private File creatFile() {
        // 파일 이름을 만들기 위해 시간값을 생성함
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());
        String imageFileName = "My" + timestamp;
        // 사진파일을 저장하기 위한 경로
        File storageDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File curFile = null;
        try {
            // 임시파일을 생성함(전체경로),  2번째 suffix 확장자:파일확장자(jpg)
            curFile = File.createTempFile(imageFileName, ".jpg"
                    , storageDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 스트링타입으로 임시파일이 있는 곳의 절대경로를 저장함
        imgFilePath = curFile.getAbsolutePath();


        return curFile;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == reqPicCode && resultCode == RESULT_OK){
            // 저장처리를 함

            setPic();
        }

    }
    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        uri = result.getData().getData();


                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), uri);
                            profile.setImageBitmap(bitmap);
                            File path = new File(".");

                            imgFilePath =  getPathFromUri(uri);


                            Toast.makeText(activity," " + path.getAbsolutePath(), Toast.LENGTH_LONG).show();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
    private void setPic() {
        // 사진의 크기 가져오기
        BitmapFactory.Options options = new BitmapFactory.Options();
        // 사진의 해상도를 1/8로 지정
        options.inSampleSize = 8;
        // 비트맵 이미지를 생성
        Bitmap bitmap = BitmapFactory.decodeFile(imgFilePath);
        // 이미지를 갤러리에 저장
        gelleryAddPic(bitmap);
        // 이미지를 이미지뷰에 세팅


        profile.setImageBitmap(bitmap);
    }
    private void gelleryAddPic(Bitmap bitmap) {
        FileOutputStream fos;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) { // API29
            // 쓰기 객체
            ContentResolver resolver = activity.getContentResolver();
            // 맵구조를 가진 ContentValues : 파일정보를 저장함
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME,
                    "Image_jpg");
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE,
                    "image/jpeg");
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH,
                    Environment.DIRECTORY_PICTURES + File.separator + "TestFolder");

            Uri imageUri = resolver.insert(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    contentValues
            );

            try {
                fos = (FileOutputStream) resolver
                        .openOutputStream(Objects.requireNonNull(imageUri));
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                Objects.requireNonNull(fos);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            // 이미지 파일을 스캔해서 갤러리에 저장하기 위한 인텐트
            Intent msIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            // 처음에 CreateFile에서 생성해둔 이미지경로(imgFilePath)를 이용하여 파일객체를 만든다
            File f = new File(imgFilePath);
            Uri contentUri = Uri.fromFile(f);
            msIntent.setData(contentUri);
            // sendBroadcast를 이용하여 저장
            activity.sendBroadcast(msIntent);
        }

    }

    public String getPathFromUri(Uri uri) {

        Cursor cursor = activity.getContentResolver().query(uri, null, null, null, null);

        cursor.moveToNext();

        @SuppressLint("Range") String path = cursor.getString(cursor.getColumnIndex("_data"));

        cursor.close();

        return path;
    }


}
