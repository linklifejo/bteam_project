package com.hanul.bteam.dto;

import java.sql.Date;



public class WillgoDTO {
	private int id,refid;
	private String wtype, member_id, locname,filepath;

public WillgoDTO(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRefid() {
		return refid;
	}

	public void setRefid(int refid) {
		this.refid = refid;
	}

	public String getWtype() {
		return wtype;
	}

	public void setWtype(String wtype) {
		this.wtype = wtype;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getLocname() {
		return locname;
	}

	public void setLocname(String locname) {
		this.locname = locname;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
}
