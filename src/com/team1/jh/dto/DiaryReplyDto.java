package com.team1.jh.dto;

import java.util.Date;

public class DiaryReplyDto {
	private int idx_fk;
	private String userid_fk;
	private int num;
	private String content;
	private Date writedate;
	private String username;
	
	public DiaryReplyDto() {}

	public DiaryReplyDto(int idx_fk, String userid_fk, int num, String content, Date writedate, String username) {
		super();
		this.idx_fk = idx_fk;
		this.userid_fk = userid_fk;
		this.num = num;
		this.content = content;
		this.writedate = writedate;
		this.username = username;
	}

	public int getIdx_fk() {
		return idx_fk;
	}

	public void setIdx_fk(int idx_fk) {
		this.idx_fk = idx_fk;
	}

	public String getUserid_fk() {
		return userid_fk;
	}

	public void setUserid_fk(String userid_fk) {
		this.userid_fk = userid_fk;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	
}
