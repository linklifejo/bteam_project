package com.hanul.bteam.COMMON;

import com.hanul.bteam.dto.CheckDTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class DataCheck  {

    HashMap<String, CheckDTO> data_check;
    public DataCheck(){
        this.data_check = new HashMap<String,CheckDTO>();
    }
    public CheckDTO getData(String key){
        return this.data_check.get(key);

    }
    public void  setData_check(String key,CheckDTO dto) {
        this.data_check.put(key, dto);
    }

    public boolean isSize(String key){
        CheckDTO vo = this.getData(key);
        int min,max;
        min = vo.getMin();
        max = vo.getMax();

        int data_size = 0;
        if(!isNull(key)){
            if(isString(key)){
                data_size = s.length();
                if(data_size >= vo.getMin() && data_size <= vo.getMax()) return true;
            }
        }

    return false;
    }
    public boolean isString(String key){
        CheckDTO vo = this.getData(key);
        if(vo.getType().equals("varchar2")) return true;
        return false;
    }
    
    public boolean isNotNull(String key){
        CheckDTO vo = this.getData(key);
        String s = vo.getNull_();
        if(s.equals("N")) return true;
        return false;
    }
}
