package com.e1858.wuye.pojo;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.e1858.wuye.common.CommonConstant;

public class ComplaintCommand
{
	private boolean anonymous;
	@NotEmpty(message = CommonConstant.ValidMessage.NotBlank)
	@NotBlank(message = CommonConstant.ValidMessage.NotBlank)
	private String content;
	public boolean isAnonymous() {
		return anonymous;
	}
	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
