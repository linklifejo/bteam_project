package com.hanul.bteam.dto;

import java.io.Serializable;

public class MemberDTO implements Serializable {
    String id , pw ,name , phone , address,profile,email;
    public MemberDTO() { }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MemberDTO(String id, String name, String phone, String address, String profile,String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.profile = profile;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


}
