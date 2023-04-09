package com.hanul.bteam.dto;

import java.io.Serializable;

/*1. DB에 있는 테이블을 기본으로 하여 DTO를 만든다
 *   가정 : 1. DB 에 singerDTO라는 테이블이 있다
 *         2. singerDTO라는 테이블에 name, mobile, age,
 *             resId(이미지경로)의 칼럼이 있다
 */
public class LocationDTO implements Serializable {
    private int id;
    private String type, locname, name_desc, post,address,latitude,longitude,filename,filepath,loccode,heigh;
    public LocationDTO(int id, String type, String locname, String name_desc, String post, String address, String latitude, String longitude, String filename, String filepath, String loccode,String heigh) {
        this.id = id;
        this.type = type;
        this.locname = locname;
        this.name_desc = name_desc;
        this.post = post;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.filename = filename;
        this.filepath = filepath;
        this.loccode = loccode;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocname() {
        return locname;
    }

    public void setLocname(String locname) {
        this.locname = locname;
    }

    public String getName_desc() {
        return name_desc;
    }

    public void setName_desc(String name_desc) {
        this.name_desc = name_desc;
    }

    public String getHeigh() {
        return heigh;
    }

    public void setHeigh(String heigh) {
        this.heigh = heigh;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getLoccode() {
        return loccode;
    }

    public void setLoccode(String loccode) {
        this.loccode = loccode;
    }


}
