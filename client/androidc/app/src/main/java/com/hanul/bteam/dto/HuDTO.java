package com.hanul.bteam.dto;

import java.io.Serializable;

public class HuDTO implements Serializable {

    String title;


    public HuDTO(String title){
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}