package com.choose.Client;

//查看学生课表

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class Curriculum extends JFrame{
	protected static Access acc = new Access();
	protected static Object[][] a;
	protected static JFrame curr = new JFrame("学生课表");
	
	public Curriculum (boolean s){
		//用到 AccessBase getmax() getConnection()
		acc.getConnection();
		String str = acc.getmax();
		int b = Integer.parseInt(str);
		a = new Object[b][7];
		
		Container con = curr.getContentPane();
		con.setLayout(new BorderLayout());
		curr.setBounds(300, 200, 800, 600);
		curr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		DefaultTableModel dm = new DefaultTableModel();
		 
		for(int i = 0; i < b; i ++){
			for(int j = 0; j < 7; j ++){
				a[i][j] = acc.Subject(i+1).get(j+1);
			}
		}
		
		dm.setDataVector(a,
				new Object[]{"课程代码", "课程名称", "任课老师", "上课地点", "学时数", "学分", "上课时间",});
		final JTable tab_1 = new JTable(dm){
				 public boolean isCellEditable(int row, int column) { 
					 return false; 
					 }
				};
		JScrollPane scro_1 = new JScrollPane(tab_1);
		
		con.add(scro_1,"Center");
		curr.setVisible(s);
	}
}
