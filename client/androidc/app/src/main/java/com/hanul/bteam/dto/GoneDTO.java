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
    private int id,readcnt, no, filecnt,location_id,course_id,resId,location_no,course_no;
    private String title,memo,writer,writedate, content, type,member_id,name,locname,couname,gone_time,out_time,loccode,filename,filepath,name_desc;
  //  private Date gone_date;
 //   private List<GoneFileDTO> fileInfo;
    public GoneDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
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

    public String getGonetime() {
        return gone_time;
    }

    public void setGonetime(String gonetime) {
        this.gone_time = gonetime;
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

    public String getName_desc() {
        return name_desc;
    }

    public void setName_desc(String name_desc) {
        this.name_desc = name_desc;
    }
}
