package com.team.house.utils.sms;



public class SentMsgUtil {
	
	//用户名
	private static String Uid = "dsl40";
	
	//接口安全秘钥
	private static String Key = "d41d8cd98f00b204e980";



	public static int  sendMsg(String telPhone,String msg) {
		HttpClientUtil client = HttpClientUtil.getInstance();
		//UTF发送
		int result = client.sendMsgUtf8(Uid, Key, msg, telPhone);
		return result;
	}
}
