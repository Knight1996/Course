/*
 * Created on 2016-9-9
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.choose.Client;

//管理课程

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 * @author C4450
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ManagerFrame extends JFrame{
	protected static JFrame mana = new JFrame("添加课程");
	protected static Access acc = new Access();
	
	protected static String s1;
	protected static String s2;
	protected static String s3;
	protected static String s4;
	protected static String s5;
	protected static String s6;
	protected static String s7;
	protected static String s8;
	
	protected static JTextField jtf_1 = new JTextField(20);
	protected static JTextField jtf_2 = new JTextField(20);
	protected static JTextField jtf_3 = new JTextField(20);
	protected static JTextField jtf_4 = new JTextField(20);
	protected static JTextField jtf_5 = new JTextField(20);
	protected static JTextField jtf_6 = new JTextField(20);
	protected static JTextField jtf_7 = new JTextField(20);
	protected static JTextField jtf_8 = new JTextField(20);
	
	public ManagerFrame(boolean s){
		//AccessBase getConnection(), 
		acc.getConnection();
		GridBagLayout Grid = new GridBagLayout();
		Container con = mana.getContentPane();
		mana.setLayout(Grid);
		mana.setBounds(550, 250, 350, 500);
		mana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel lab_1 = new JLabel("课程编号:");
		JLabel lab_2 = new JLabel("课程名称:");
		JLabel lab_3 = new JLabel("任课教师:");
		JLabel lab_4 = new JLabel("上课地点:");
		JLabel lab_5 = new JLabel(" 学  时 :");
		JLabel lab_6 = new JLabel(" 学  分 :");
		JLabel lab_7 = new JLabel("上课时间:");
		JLabel lab_8 = new JLabel("教师信息:");
		
		
		
		
	
		JButton button_1 = new JButton(" 提  交 ");
		JButton button_2 = new JButton("重新输入");
		JButton button_3 = new JButton("退出管理");
		
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				s1 = jtf_1.getText();
				s2 = jtf_2.getText();
				s3 = jtf_3.getText();
				s4 = jtf_4.getText();
				s5 = jtf_5.getText();
				s6 = jtf_6.getText();
				s7 = jtf_7.getText();
				s8 = jtf_8.getText();
				String s = s1+"#"+s2+"#"+s3+"#"+s4+"#"+s5+"#"+s6+"#"+s7+"#"+s8;
				//AccessBase insert()
				acc.insert(s1, s2, s3, s4, s5, s6, s7, s8);
			}
		});
		
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				jtf_1.setText("");
				jtf_2.setText("");
				jtf_3.setText("");
				jtf_4.setText("");
				jtf_5.setText("");
				jtf_6.setText("");
				jtf_7.setText("");
				jtf_8.setText("");
			}
		});
		
		button_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Manager a = new Manager(true);
				mana.setVisible(false);
			}
		});
		
		
		GridBagConstraints GridBag= new GridBagConstraints();
		GridBag.fill = GridBagConstraints.NONE;
		
		GridBag.gridx = 0;
		GridBag.gridy = 0;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(lab_1, GridBag);
		
		GridBag.gridx = 1;
		GridBag.gridy = 0;
		GridBag.gridwidth = 3;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(jtf_1, GridBag);
		
		GridBag.gridx = 0;
		GridBag.gridy = 1;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(lab_2, GridBag);
		
		GridBag.gridx = 1;
		GridBag.gridy = 1;
		GridBag.gridwidth = 3;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(jtf_2, GridBag);
		
		GridBag.gridx = 0;
		GridBag.gridy = 2;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(lab_3, GridBag);
		
		GridBag.gridx = 1;
		GridBag.gridy = 2;
		GridBag.gridwidth = 3;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(jtf_3, GridBag);
		
		GridBag.gridx = 0;
		GridBag.gridy = 3;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(lab_4, GridBag);
		
		GridBag.gridx = 1;
		GridBag.gridy = 3;
		GridBag.gridwidth = 3;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(jtf_4, GridBag);
		
		GridBag.gridx = 0;
		GridBag.gridy = 4;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(lab_5, GridBag);
		
		GridBag.gridx = 1;
		GridBag.gridy = 4;
		GridBag.gridwidth = 3;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(jtf_5, GridBag);
		
		GridBag.gridx = 0;
		GridBag.gridy = 5;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(lab_6, GridBag);
		
		GridBag.gridx = 1;
		GridBag.gridy = 5;
		GridBag.gridwidth = 3;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(jtf_6, GridBag);
		
		GridBag.gridx = 0;
		GridBag.gridy = 6;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(lab_7, GridBag);
		
		GridBag.gridx = 1;
		GridBag.gridy = 6;
		GridBag.gridwidth = 3;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(jtf_7, GridBag);
		
		GridBag.gridx = 0;
		GridBag.gridy = 7;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(lab_8, GridBag);
		
		GridBag.gridx = 1;
		GridBag.gridy = 7;
		GridBag.gridwidth = 3;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(jtf_8, GridBag);
		
		GridBag.gridx = 0;
		GridBag.gridy = 8;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(button_1, GridBag);
		
		GridBag.gridx = 1;
		GridBag.gridy = 8;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(button_2, GridBag);
		
		GridBag.gridx = 2;
		GridBag.gridy = 8;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(button_3, GridBag);
		
	
		con.add(jtf_1);
		con.add(lab_1);
		con.add(jtf_2);
		con.add(lab_2);
		con.add(jtf_3);
		con.add(lab_3);
		con.add(jtf_4);
		con.add(lab_4);
		con.add(jtf_5);
		con.add(lab_5);
		con.add(jtf_6);
		con.add(lab_6);
		con.add(jtf_7);
		con.add(lab_7);
		con.add(jtf_8);
		con.add(lab_8);
		con.add(button_1);
		con.add(button_2);
		con.add(button_3);
	
		mana.setVisible(s);
		
		
		
	}
}
