package com.hanul.bteam.COMMON;

import com.hanul.bteam.dto.CheckDTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class DataCheck  {

    HashMap<String, CheckDTO> checkField;

    public DataCheck(){
        this.checkField = new HashMap<String,CheckDTO>();
    }

    public CheckDTO getField(String key){
        return this.checkField.get(key);
    }

    public void  setField(String key,CheckDTO dto) {
        this.checkField.put(key, dto);
    }

    public boolean isOkNumber(String key){
        CheckDTO vo = this.getField(key);
        int minValue,maxValue,numberValue;
        minValue = vo.getMinValue();
        maxValue = vo.getMaxValue();
        numberValue = vo.getNumberValue();
        int data_size = 0;
        if(!isNotNull(key)){
            if(!isString(key)){
                if(numberValue >= minValue && numberValue <= maxValue) return true;
            }
        }

        return false;
    }
    public boolean isOkString(String key){
        CheckDTO vo = this.getField(key);
        int min,max;
        min = vo.getMinSize();
        max = vo.getMaxSize();

        int data_size = 0;
        if(!isNotNull(key)){
            if(isString(key)){
                data_size = vo.getStringValue().toString().length();
                if(data_size >= min && data_size <= max) return true;
            }
        }

    return false;
    }
    private  boolean isString(String key){
        CheckDTO vo = this.getField(key);
        if(vo.getType().equals("varchar2")) return true;
        return false;
    }
    
    private  boolean isNotNull(String key){
        CheckDTO vo = this.getField(key);
        String s = vo.getNull_();
        if(s.equals("N")) return true;
        return false;
    }
}
