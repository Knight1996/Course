package com.choose.service;

public class AccessBean {
	protected static String Subid;
	protected static String Choname;
	protected static String Choteacher;
	protected static String Choplace;
	protected static String Chonum;
	protected static String Chocredit;
	protected static String Chotime;
	protected static String Teacher;
	
	public AccessBean(String str1, String str2, String str3, String str4, String str5, String str6, String str7, String str8){
		SetSubid(str1);
		SetChoname(str2);
		SetChoteacher(str3);
		SetChoplace(str4);
		SetChonum(str5);
		SetChocredit(str6);
		SetChotime(str7);
		SetTeacher(str8);
	}
	
	public void SetSubid(String str1){
		Subid = str1;
	}
	
	public void SetChoname(String str1){
		Choname = str1;
	}
	
	public void SetChoteacher(String str1){
		Choteacher = str1;
	}
	
	public void SetChoplace(String str1){
		Choplace = str1;
	}
	
	public void SetChonum(String str1){
		Chonum = str1;
	}
	
	public void SetChocredit(String str1){
		Chocredit = str1;
	}
	
	public void SetChotime(String str1){
		Chotime = str1;
	}
	
	public void SetTeacher(String str1){
		Teacher = str1;
	}
	
	
	
}
