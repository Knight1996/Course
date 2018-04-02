package com.choose.Client;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class Main extends JFrame{
	protected static Access acc = new Access();
	protected static JFrame main = new JFrame("ѡ��ϵͳ");
	
	public Main(boolean s){
		//AccessBase getConnection()
		acc.getConnection();
		main.setVisible(s);
		GridBagLayout Grid = new GridBagLayout();
		Container con = main.getContentPane();
		con.setLayout(Grid);
		main.setBounds(300, 200, 300, 400);
		main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JButton button_1 = new JButton("����ѡ��");
		JButton button_2 = new JButton(" ����Ա ");
		
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				ChooseFrame c = new ChooseFrame(true);
				main.setVisible(false);
			}
		});
		
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Manager a = new Manager(true);
				main.setVisible(false);
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
		
		con.add(button_1);
		con.add(button_2);
	}
	
	public static void main(String[] args) {
		Main a = new Main(true);
	}
}