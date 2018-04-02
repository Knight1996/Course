package com.choose.Client;

//删除课程

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

public class Delsub extends JFrame{
	protected static JFrame del = new JFrame("删除课程");
	protected static Access acc = new Access();
	
	protected static String s1;
	protected static JTextField jtf_1 = new JTextField(20);
	
	public Delsub(boolean s){
		//AccessBase getConnection()
		
		acc.getConnection();
		GridBagLayout Grid = new GridBagLayout();
		Container con = del.getContentPane();
		del.setLayout(Grid);
		del.setBounds(550, 250, 500, 200);
		del.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel lab_1 = new JLabel("需要删除的课程编号:");
		
		JButton button_1 = new JButton(" 删      除 ");
		JButton button_2 = new JButton("返回上级");
		
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				s1 = jtf_1.getText();
				String s = s1;
				//AccessBase  delete();
				acc.delete(s1);
			}
		});
		
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				del.setVisible(false);
				Manager a = new Manager(true);
			}
		});
		
		GridBagConstraints GridBag= new GridBagConstraints();
		GridBag.fill = GridBagConstraints.NONE;
		
		GridBag.gridx = 0;
		GridBag.gridy = 0;
		GridBag.gridwidth = 2;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(lab_1, GridBag);
		
		GridBag.gridx = 2;
		GridBag.gridy = 0;
		GridBag.gridwidth = 2;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(jtf_1, GridBag);
		
		GridBag.gridx = 0;
		GridBag.gridy = 1;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(button_1, GridBag);
		
		GridBag.gridx = 2;
		GridBag.gridy = 1;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(button_2, GridBag);
		
		con.add(jtf_1);
		con.add(lab_1);
		con.add(button_1);
		con.add(button_2);
		
		del.setVisible(s);
	}
}
