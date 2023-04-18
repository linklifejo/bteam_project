package com.hanul.bteam.COMMON;

import com.hanul.bteam.dto.CheckDTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.regex.*;

// 정규식 : import java.util.regex.*;
//    // 전화번호 체크 예시
//    String phoneNumber = "010-1234-5678";
//    boolean isPhoneNumberValid = checkPhoneNumber(phoneNumber);
//        System.out.println("전화번호 체크 결과: " + isPhoneNumberValid);
//
//    // 이메일 주소 체크 예시
//    String emailAddress = "example@example.com";
//    boolean isEmailAddressValid = checkEmailAddress(emailAddress);
//        System.out.println("이메일 주소 체크 결과: " + isEmailAddressValid);
//
//    // 영어 문자와 숫자만 허용하며 자리수는 6에서 20자리 체크 예시
//    String input = "Abc1234";
//    boolean isInputValid = checkAlphaNumericLength(input);
//        System.out.println("입력값 체크 결과: " + isInputValid);

public class DataCheck  {
    String tableName = null;
    HashMap<String, Object> checkField;

    public DataCheck(){
        this.checkField = new HashMap<String,Object>();
    }

    public Object getField(String key){
        return this.checkField.get(key);
    }

    public void  setField(String key,Object value) {
        this.checkField.put(key, value);
    }

    public void setTableName(String name) {
        this.tableName = name;
    }

    public String getTableName(){
        return this.tableName;
    }

//    public boolean isOkNumber(String key){
//        Integer value = (Integer) this.getField(key);
//        int minValue,maxValue,numberValue;
////        minValue = value.getMinValue();
////        maxValue = value.getMaxValue();
////        numberValue = value.getNumberValue();
//        int data_size = 0;
//        if(!isNotNull(key)){
//            if(!isString(key)){
//                if(numberValue >= minValue && numberValue <= maxValue) return true;
//            }
//        }
//
//        return false;
//    }
//
//    public boolean isOkString(String key){
//        CheckDTO vo = this.getField(key);
//        int min,max;
//        min = vo.getMinSize();
//        max = vo.getMaxSize();
//
//        int data_size = 0;
//        if(!isNotNull(key)){
//            if(isString(key)){
//                data_size = vo.getStringValue().toString().length();
//                if(data_size >= min && data_size <= max) return true;
//            }
//        }
//
//    return false;
//    }
//    private  boolean isString(String key){
//        CheckDTO vo = this.getField(key);
//        if(vo.getType().equals("varchar2")) return true;
//        return false;
//    }
    
//    private  boolean isNotNull(String key){
//        CheckDTO vo = this.getField(key);
//        String s = vo.getNull_();
//        if(s.equals("N")) return true;
//        return false;
//    }
public static boolean id_check(String id) {
    // 아이디체크 5~19 영소문자 +숫자
    if (id.length() > 4 && id.length() < 20 &&Pattern.matches("[a-z]+", id)) {
        return true;
    }
    return false;
}
    public static boolean pw_check(String pw) {
        // 비밀번호체크 5~19 영대소문자 +숫자
        if (pw.length() > 4 && pw.length() < 20 &&Pattern.matches("[a-zA-Z0-9]+", pw)) {
            return true;
        }
        return false;
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        // 13자리인지 체크
        if (phoneNumber.length() != 11) {
            return false;
        }

        // 숫자인지 체크
        if (!phoneNumber.matches("[0-9]+")) {
            return false;
        }

        return true;
    }

    // 이메일 주소 체크 메소드
    public static boolean checkEmailAddress(String emailAddress) {
        // 이메일 형식인지 체크
        if (!Pattern.matches("[a-z]+@[a-z]+\\.[a-z]+", emailAddress)) {
            return false;
        }

        return true;
    }

    // 영어 문자와 숫자만 허용하며 자리수는 6에서 20자리 체크 메소드
    public static boolean checkAlphaNumericLength(String input) {
        // 길이가 6에서 20자리인지 체크
        if (input.length() < 6 || input.length() > 20) {
            return false;
        }

        // 영어 문자와 숫자로만 이루어졌는지 체크
        if (!Pattern.matches("[a-zA-Z0-9]+", input)) {
            return false;
        }

        return true;
    }
}
