package com.hanul.bteam.dto;




public class GoneFileDTO {
	private int id, gone_id;
	private String filename, filepath;

	public GoneFileDTO(int id, int gone_id, String filename, String filepath) {
		this.id = id;
		this.gone_id = gone_id;
		this.filename = filename;
		this.filepath = filepath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGone_id() {
		return gone_id;
	}

	public void setGone_id(int gone_id) {
		this.gone_id = gone_id;
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
