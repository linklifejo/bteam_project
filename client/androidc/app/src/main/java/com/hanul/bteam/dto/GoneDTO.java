package com.hanul.bteam.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*1. DB에 있는 테이블을 기본으로 하여 DTO를 만든다
 *   가정 : 1. DB 에 singerDTO라는 테이블이 있다
 *         2. singerDTO라는 테이블에 name, mobile, age,
 *             resId(이미지경로)의 칼럼이 있다
 */
public class GoneDTO implements Serializable {
    private int readcnt, no, filecnt,location_id,course_id;
    private String title, content, type,member_id,name,locname,couname,gone_time,out_time,loccode,filename,filepath;
    private Date gone_date;
    private List<GoneFileDTO> fileInfo;
    public GoneDTO() {
    }

    public GoneDTO( int readcnt, int no, int filecnt, int location_id, int course_id, String title, String content, String type, String member_id, String name, String locname, String couname, String gone_time, String out_time, String loccode, Date gone_date, List<GoneFileDTO> fileInfo) {

        this.readcnt = readcnt;
        this.no = no;
        this.filecnt = filecnt;
        this.location_id = location_id;
        this.course_id = course_id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.member_id = member_id;
        this.name = name;
        this.locname = locname;
        this.couname = couname;
        this.gone_time = gone_time;
        this.out_time = out_time;
        this.loccode = loccode;
        this.gone_date = gone_date;
        this.fileInfo = fileInfo;
    }



    public int getReadcnt() {
        return readcnt;
    }

    public void setReadcnt(int readcnt) {
        this.readcnt = readcnt;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getFilecnt() {
        return filecnt;
    }

    public void setFilecnt(int filecnt) {
        this.filecnt = filecnt;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocname() {
        return locname;
    }

    public void setLocname(String locname) {
        this.locname = locname;
    }

    public String getCouname() {
        return couname;
    }

    public void setCouname(String couname) {
        this.couname = couname;
    }

    public String getGone_time() {
        return gone_time;
    }

    public void setGone_time(String gone_time) {
        this.gone_time = gone_time;
    }

    public String getOut_time() {
        return out_time;
    }

    public void setOut_time(String out_time) {
        this.out_time = out_time;
    }

    public String getLoccode() {
        return loccode;
    }

    public void setLoccode(String loccode) {
        this.loccode = loccode;
    }

    public Date getGone_date() {
        return gone_date;
    }

    public void setGone_date(Date gone_date) {
        this.gone_date = gone_date;
    }

    public List<GoneFileDTO> getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(List<GoneFileDTO> fileInfo) {
        this.fileInfo = fileInfo;
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

}
