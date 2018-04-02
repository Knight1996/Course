package com.choose.Client;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Manager extends JFrame{
	protected static Access acc = new Access();
	protected static JFrame mana = new JFrame("管理员");
	
	public Manager(boolean s){
		//AccessBase getConnection(), 

		acc.getConnection();
		mana.setVisible(s);
		GridBagLayout Grid = new GridBagLayout();
		Container con = mana.getContentPane();
		con.setLayout(Grid);
		mana.setBounds(300, 200, 300, 400);
		mana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JButton button_1 = new JButton("  添加课程   ");
		JButton button_2 = new JButton("  删除课程   ");
		JButton button_3 = new JButton("查看已有课程");
		
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				ManagerFrame a = new ManagerFrame(true);
				mana.setVisible(false);
			}
		});
		
		
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Delsub b = new Delsub(true);
				mana.setVisible(false);
			}
		});
		
		button_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Curriculum d = new Curriculum(true);
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
		Grid.setConstraints(button_1, GridBag);
		
		GridBag.gridx = 0;
		GridBag.gridy = 1;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(button_2, GridBag);
		
		GridBag.gridx = 0;
		GridBag.gridy = 2;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 1;
		Grid.setConstraints(button_3, GridBag);
		
		con.add(button_1);
		con.add(button_2);
		con.add(button_3);
	}
		
}
