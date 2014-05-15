package com.e1858.wuye.exception;

public class OAuth2Exception  extends Exception 
{
	String uri;
	public OAuth2Exception(String uri)
	{
		this.uri = uri;
	}
	public String getUri()
	{
		return uri;
	}
	public void setUri(String uri)
	{
		this.uri = uri;
	}
}
