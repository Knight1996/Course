package com.choose.Client;

//数据库部分

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Access {
	static Connection con;
	static PreparedStatement sta;
	static ResultSet res;
	static String sql;
	protected static Access acc = new Access();
	
	//连接数据库
	public Connection getConnection(){
		try{
			Class.forName("com.hxtt.sql.access.AccessDriver").newInstance();
			String url = "jdbc:Access:///f:/Choose/Choose.accdb";
			con = DriverManager.getConnection(url, "", "");
			//System.out.println("数据库加载成功！");
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	
	//Choose表删除数据 根据Subid
	public void delete(String str1){
		try{
			/*int num = 0;
 			sta = con.prepareStatement("select * from Choose");
 			res = res = sta.executeQuery();
 			while(res.next()){
 				num ++;
 			}*/
			sta = con.prepareStatement("delete from Choose where Subid = ?");
			sta.setString(1, str1);
			sta.executeUpdate();
			sta.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Choose表插入数据
	public void insert(String str1, String str2, String str3, String str4, String str5, String str6, String str7, String str8){
		try{
			sta = con.prepareStatement("insert into Choose (Subid, Choname, Choteacher, Choplace, Chonum, Chocredit, Chotime, Teacher) values "
					+ "(?, ?, ?, ?, ?, ?, ?, ?)");
			int b5 = Integer.parseInt(str5);
			int b6 = Integer.parseInt(str6);
			sta.setString(1, str1);	
			sta.setString(2, str2);
			sta.setString(3, str3);
			sta.setString(4, str4);
			sta.setInt(5, b5);
			sta.setInt(6, b6);
			sta.setString(7, str7);
			sta.setString(8, str8);
			sta.executeUpdate();
			sta.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Choose表获取行数
	public String getmax(){
		String a = null;
		try{
			int num = 0;
			sta = con.prepareStatement("select * from Choose");
			res = res = sta.executeQuery();
			while(res.next()){
				num ++;
			}
			a = Integer.toString(num);
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	
	//Choose表获取数据库
	public ArrayList<String> Subject(int b){
	//b为行
		ArrayList<String> a = new ArrayList<String>();
		try{
			int num = 0;
			sta = con.prepareStatement("select * from Choose");
			res = res = sta.executeQuery();
			while(res.next()){
				num ++;
				if(num == b){
					String id = res.getString(1);
					String subid = res.getString("Subid");	
					String name = res.getString("Choname");
					String teacher = res.getString("Choteacher");
					String place = res.getString("Choplace");	
					String number = res.getString("Chonum");
					String credit = res.getString("Chocredit");
					String time = res.getString("Chotime");
					String Teacher = res.getString("Teacher");	
					a.add(0, id);
					a.add(1, subid);
					a.add(2, name);
					a.add(3, teacher);
					a.add(4, place);
					a.add(5, number);
					a.add(6, credit);
					a.add(7, time);
					a.add(8, Teacher);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}

	//Choose表通过课程号获取课程名
	public String getSubname(String str1){
		String name = null;
		try{
			sta = con.prepareStatement("select * from Choose where Subid = ?");
			sta.setString(1, str1);
			res = sta.executeQuery();
			while(res.next()){
				name = res.getString("Choname");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return name;
	}
	
	//Choose表根据行号获取课程号,b为行号
	public String getSubid(int b){
		String a = null;
		try{
			int num = 0;
			sta = con.prepareStatement("select * from Choose");
			res = res = sta.executeQuery();
			while(res.next()){
				num ++;
				if(num == b){
					a = res.getString("Subid");	
					}
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	
	//Selected表查询是否已选课 str1为学号 str2为课程号
	public int search(String str1, String str2){
		int num = 0;
		try{
			sta = con.prepareStatement("select * from Selected where Studentid = ? and Subid = ?");
			sta.setString(1, str1);
			sta.setString(2, str2);
			res = res = sta.executeQuery();
			while(res.next()){
				num ++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}
	
	//Selected表添加 str1为学号  str2为已选课程号
	public void addSelected(String str1, String str2){
		try{
			sta = con.prepareStatement("insert into Selected (Studentid, Subid) values (?, ?) ");
			sta.setString(1, str1);	
			sta.setString(2, str2);	
			sta.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Selected表删除
	public void delSelected(String str1, String str2){
		try{
			sta = con.prepareStatement("delete from Selected where Studentid = ? and Subid = ?");
			sta.setString(1, str1);
			sta.setString(2, str2);
			sta.executeUpdate();
			sta.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//Selected表获取行数     str1为学号
	public String getSelidmax(String str1){
		String a = null;
		try{
			int num = 0;
			sta = con.prepareStatement("select * from Selected where Studentid = ?");
			sta.setString(1, str1);
			res = res = sta.executeQuery();
			while(res.next()){
				num ++;
			}
			a = Integer.toString(num);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	
	//根据id获取Selected表的课程编号
	public String getSelectedid(String str1, int b){
			String a = null;
			try{
				int num = 0;
				sta = con.prepareStatement("select * from Selected where Studentid = ?");
				sta.setString(1, str1);
				res = res = sta.executeQuery();
				while(res.next()){
					num ++;
					if(num == b){
						a = res.getString("Subid");	
						}
					}
			}catch(Exception e){
				e.printStackTrace();
			}
			return a;
		}
	

}
