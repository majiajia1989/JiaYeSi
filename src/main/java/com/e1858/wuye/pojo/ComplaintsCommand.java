package com.e1858.wuye.pojo;

import java.util.ArrayList;

public class ComplaintsCommand {

	private long id;
	private String title;
	private String content;
	private String createTime;
	private ArrayList<ComplaintResponseCommand> response;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public ArrayList<ComplaintResponseCommand> getResponse() {
		return response;
	}

	public void setResponse(ArrayList<ComplaintResponseCommand> response) {
		this.response = response;
	}

}
