package com.hanul.bteam.dto;

import java.io.Serializable;

// 1. DB에 있는 테이블을 기본으로 하여 DTO를 만든다
public class BoardDTO implements Serializable {
    String title, memo,locname,course_name,filename,filepath,writer,writedate;
    int no, location_no,course_no,resId;
    public BoardDTO(String title, String memo, String locname, String course_name, String filename, String filepath, String writer, String writedate, int no, int location_no, int course_no, int resId) {
        this.title = title;
        this.memo = memo;
        this.locname = locname;
        this.course_name = course_name;
        this.filename = filename;
        this.filepath = filepath;
        this.no = no;
        this.location_no = location_no;
        this.course_no = course_no;
        this.resId = resId;
        this.writer = writer;
        this.writedate = writedate;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getWritedate() {
        return writedate;
    }

    public void setWritedate(String writedate) {
        this.writedate = writedate;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getLocname() {
        return locname;
    }

    public void setLocname(String mountin_name) {
        this.locname = mountin_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
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

    public void setFilepath(String pathname) {
        this.filepath = pathname;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getLocation_no() {
        return location_no;
    }

    public void setLocation_no(int location_no) {
        this.location_no = location_no;
    }

    public int getCourse_no() {
        return course_no;
    }

    public void setCourse_no(int course_no) {
        this.course_no = course_no;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
