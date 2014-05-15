package com.e1858.wuye.common;
import com.e1858.wechat.api.json.base.Access_Token;
public class Wechat
{
	private static Access_Token access_Token;

	public static Access_Token getAccess_Token()
	{
		return access_Token;
	}

	public static void setAccess_Token(Access_Token access_Token)
	{
		Wechat.access_Token = access_Token;
	}
}
