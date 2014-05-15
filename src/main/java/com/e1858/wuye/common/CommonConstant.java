package com.e1858.wuye.common;

import org.apache.log4j.Logger;

public class CommonConstant
{
	public final static String CONTEXT_ACCESS_TOKEN = "CONTEXT_ACCESS_TOKEN";
	public final static String CONTEXT_APP = "CONTEXT_APP";
	public final static String CONTEXT_CORP = "CONTEXT_CORP";
	public final static String CONTEXT_COMMUNITY = "CONTEXT_COMMUNITY";
	public final static String CONTEXT_SUBSCRIBER = "CONTEXT_SUBSCRIBER";
	public final static String CONTEXT_USER_INFO = "CONTEXT_USER_INFO";
	public final static String CONTEXT_HOUSE = "CONTEXT_HOUSE";
	public final static String CONTEXT_CACHE = "CONTEXT_CACHE";
	public final static String CONTEXT_SUBSCRIBER_INFO = "CONTEXT_SUBSCRIBER_INFO";
	public final static String CONTEXT_BOARD = "CONTEXT_BOARD";
	public final static String CONTEXT_BOARDS = "CONTEXT_BOARDS";
	public final static String CONTEXT_TOPIC = "CONTEXT_TOPIC";
	public final static String CONTEXT_TOPICS = "CONTEXT_TOPICS";
	public final static String CONTEXT_POST= "CONTEXT_POST";
	public final static String CONTEXT_POSTS = "CONTEXT_POSTS";
	public final static String PAGE_CURRENT = "PAGE_CURRENT";
	public final static String PAGE_NEXT = "PAGE_NEXT";
	public final static String PAGE_PREVIOUS = "PAGE_PREVIOUS";
	public final static int PAGE_SIZE = 10;
	public final static String REDIRECT_URI = "REDIRECT_URI";
	public final static String COMMUNITY_HOUSE = "COMMUNITY_HOUSE";
	public final static String COMMUNITY_HOUSEUNIT = "COMMUNITY_HOUSEUNIT";
	public final static String COMMUNITY_HOUSEFLOOR = "COMMUNITY_HOUSEFLOOR";
	public final static String COMMUNITY_HOUSEROOM = "COMMUNITY_HOUSEROOM";
	public final static String UPLOAD_PATH = "";
	public final static String ENCODING = "UTF-8";
	public final static String KEYWORD_SEPARATOR = " ";
	public final static String SERVICE_PHONE = "SERVICE_PHONE";
	public final static String CONSUME_TYPE = "CONSUME_TYPE";
	public final static String CONSUME_INFO = "CONSUME_INFO";
	public final static String NOTICE_INFO = "NOTICE_INFO";
	public final static String NOTICE_RECEIVERS = "NOTICE_RECEIVERS";
	public final static String NOTICE_RETURN_URL = "NOTICE_RETURN_URL";
	public final static String COMMUNITY_IMAGE = "COMMUNITY_IMAGE";
	public final static String WELCOME_IMAGE = "WELCOME_IMAGE";
	public final static String WEIXIN_USERINFO = "WEIXIN_USERINFO";
	public final static String MSG_ERROR = "MSG_ERROR";
	public final static String MSG_SUCCESS = "MSG_SUCCESS";
	public final static String URL_BACK= "URL_BACK";
	public final static String URL_FORWARD= "URL_FORWARD";
	public final static String ANONYMOUS_SUBCRIBER_OPENID = "-1";
	

	public static final class MsgType
	{
		public static final String Article = "article";
		public static final String Text = "text";
	}

	public static final class DefaultMsgType
	{
		public static final int AttentionReply = 0;
		public static final int NoMatchReply = 1;
	}

	public static final class NoticeType
	{
		public static final byte Public = 0;
		public static final byte Private = 1;
	}
	
	public static final class NoticeReadStatus
	{
		public static final byte UnRead = 0;
		public static final byte Readed = 1;
	}
	
	public static final class ValidMessage
	{
		public static final String NotBlank = "此内容为必填(必选)项";
		public static final String NotEmpty = "此内容为必填(必选)项";
		public static final String EMAIL = "请输入正确格式的电子邮件";
		public static final String URL = "请输入合法的网址";
		public static final String Digits = "只能输入整数";
		public static final String CreditCardNumber = "请输入合法的信用卡号";
		public static final String MobilePhone = "请输入正确的手机号码";
		public static final String LicencePlate = "请输入正确的车牌号码";
		public static final String TelePhone = "请输入正确的电话号码";
		public static final String QQ = "请输入正确的QQ号码";
		public static final String MIN = "请输入一个最小为{0}的值";
		public static final String MAX = "请输入一个最大为{0}的值";
		public static final String CARNUMBER = "车牌号码格式错误!";
		public static final String RANGE = "请输入一个范围为{min}到{max}的值";
	}
}
