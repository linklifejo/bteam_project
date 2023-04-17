package com.hanul.bteam.dto;

import java.io.Serializable;

public class CheckDTO implements Serializable {

    String table,field,type,value,null_;
    int max,min;

    public CheckDTO(String table, String field, String type, String value, String null_, int max, int min) {
        this.table = table;
        this.field = field;
        this.type = type;
        this.value = value;
        this.null_ = null_;
        this.max = max;
        this.min = min;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNull_() {
        return null_;
    }

    public void setNull_(String null_) {
        this.null_ = null_;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
