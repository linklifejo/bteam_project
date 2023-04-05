package com.hanul.bteam.dto;

import java.io.Serializable;

public class CourseDTO implements Serializable {

    String couname,course_id;


    public CourseDTO(String couname){
        this.couname=couname;
//        this.course_id=course_id;
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
}
