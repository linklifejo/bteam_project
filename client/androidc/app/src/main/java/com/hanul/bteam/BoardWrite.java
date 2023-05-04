package com.hanul.bteam;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.hanul.bteam.COMMON.CommonMethod;
import com.hanul.bteam.dto.CourseDTO;
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

public class BoardWrite extends Fragment {
    MainActivity activity;
    File imgFile = null;
    String imgFilePath = null;
    int reqPicCode = 2008;
    EditText title,content,contentr;
    RequestBody fileBody =null;
    MultipartBody.Part filePart =null;
    ImageView filepath;
    boolean isCheck = true;


    Uri uri;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.board_3,
                container, false);
        activity = (MainActivity) getActivity();

        title =view.findViewById(R.id.title);
        content=view.findViewById(R.id.content);
        contentr=view.findViewById(R.id.contentr);
        filepath = view.findViewById(R.id.filepath);

        view.findViewById(R.id.choice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.fragmentControl(new LocalFragment());
            }
        });


        view.findViewById(R.id.btn_upload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonMethod commonMethod = new CommonMethod();
                GoneDTO dto = new GoneDTO();
                Bundle b = activity.bundle;
                CourseDTO dto1= (CourseDTO) b.getSerializable("dto");
                if(imgFilePath != null) {

                    fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(imgFilePath));
                    filePart = MultipartBody.Part.createFormData("file", "test.jpg", fileBody);
                }

                dto.setTitle( title.getText().toString() );
                dto.setContent( content.getText().toString() );
                dto.setContentr( contentr.getText().toString() );
                dto.setMember_id(activity.loginid);
                dto.setLocation_id(dto1.getLocation_id());
                dto.setCourse_id(dto1.getId());
                dto.setLoccode(dto1.getLoccode());
                if(imgFilePath != null) {
                    dto.setFilepath(imgFilePath);
                }


                commonMethod.setParams("param", dto);
                commonMethod.sendFile("gonewrite", filePart, new Callback<String>() {

                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                        activity.fragmentControl(new Board1());

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });

            }
        });
        view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.fragmentControl(new Board1());
            }
        });

        view.findViewById(R.id.btn_cho).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");

                startActivityResult.launch(intent);
            }
        });

        view.findViewById(R.id.filepath).setOnClickListener(new View.OnClickListener() {
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
                            filepath.setImageBitmap(bitmap);
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
        filepath.setImageBitmap(bitmap);
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
