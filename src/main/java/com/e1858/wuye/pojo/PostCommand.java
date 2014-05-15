package com.e1858.wuye.pojo;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import com.e1858.wuye.common.CommonConstant;

public class PostCommand
{
	@NotBlank(message= CommonConstant.ValidMessage.NotBlank)
	@NotEmpty(message= CommonConstant.ValidMessage.NotBlank)
	@Digits(integer=65535,fraction=0, message= CommonConstant.ValidMessage.Digits)
	private String topic;
	@NotBlank(message= CommonConstant.ValidMessage.NotBlank)
	@NotEmpty(message= CommonConstant.ValidMessage.NotBlank)
	@Length(min=3,max=100) 
	private String title;
	@NotBlank(message= CommonConstant.ValidMessage.NotBlank)
	@NotEmpty(message= CommonConstant.ValidMessage.NotBlank)
	@Length(min=3) 
	private String content;
	public String getTopic()
	{
		return topic;
	}
	public void setTopic(String board)
	{
		this.topic = board;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	
	
}
