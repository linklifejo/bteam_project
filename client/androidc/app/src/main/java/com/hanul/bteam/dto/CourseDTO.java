package com.hanul.bteam.dto;

import java.io.Serializable;

public class CourseDTO implements Serializable {

    String couname,course_id,loccode;
            int location_id,id;

    public String getLoccode() {
        return loccode;
    }

    public void setLoccode(String loccode) {
        this.loccode = loccode;
    }

    public String getCouname() {
        return couname;
    }

    public void setCouname(String couname) {
        this.couname = couname;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
