/*
 * Created on 2016-8-30
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

//ѡ�ν���
package com.choose.Client;

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
 * @author C3127
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ChooseFrame extends JFrame{
	protected static int row = 0;
	protected static int col = 0;
	protected static Access acc = new Access();
	protected static ArrayList<String> Subid = new ArrayList<String>();
	protected static Object[][] a;
	protected static JFrame cho = new JFrame("ѡ��ϵͳ");
	protected static String s1 = null;
	
	public ChooseFrame(boolean s){
		//�õ�AccessBase��getmax(), Subject(), getConnection()
		acc.getConnection();
		String str = acc.getmax();
		int b = Integer.parseInt(str);
		a = new Object[b][7];
		GridBagLayout Grid = new GridBagLayout();
		Container con = cho.getContentPane();
		con.setLayout(Grid);
		cho.setBounds(300, 200, 800, 600);
		cho.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		DefaultTableModel dm = new DefaultTableModel();
		 
		for(int i = 0; i < b; i ++){
			for(int j = 0; j < 7; j ++){
				a[i][j] = acc.Subject(i+1).get(j+1);
			}
		}
		
		dm.setDataVector(a,
			new Object[]{"�γ̴���", "�γ�����", "�ο���ʦ", "�Ͽεص�", "ѧʱ��", "ѧ��", "�Ͽ�ʱ��",});
		final JTable tab_1 = new JTable(dm){
			 public boolean isCellEditable(int row, int column) { 
				 return false; 
				 }
			};
		
		JScrollPane scro_1 = new JScrollPane(tab_1);
		JButton button_1 = new JButton(" ѡ�� ");
		final JButton button_2 = new JButton(" �˿� ");
		JButton button_3 = new JButton("�鿴��ʦ");
		JButton button_4 = new JButton("�鿴��ѡ�γ�");
		JButton button_5 = new JButton("�˳�ѡ��");
		tab_1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				row = tab_1.rowAtPoint(event.getPoint());  
				col = tab_1.columnAtPoint(event.getPoint());
			}
		});
		
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int roww = row + 1;
				String Studentid = "09014424";//ѧ��Ϊ��ʱ
				String s = "09014424#" + roww + "#1";
				//�õ�AccessBase��Subject()
				if(acc.search(Studentid,acc.Subject(roww).get(1)) == 0){
					JOptionPane.showMessageDialog(null ,"ѡ�γɹ���", "ѡ�ν��", JOptionPane.PLAIN_MESSAGE);
					ArrayList<String> da = acc.Subject(roww);
					acc.addSelected(Studentid, da.get(1));
				}else{
					JOptionPane.showMessageDialog(null ,"�Ѿ�ѡ���ÿγ̨r(�s���t)�q", "ѡ�ν��", JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		});
		
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int roww = row + 1;
				String s = "09014424#" + roww + "#1";
				//�õ�AccessBase��Subject()
				String Studentid = "09014424";//ѧ��Ϊ��ʱ
				if(acc.search(Studentid,acc.Subject(roww).get(1)) == 1){
					JOptionPane.showMessageDialog(null ,"�˿γɹ�!", "�˿ν��", JOptionPane.PLAIN_MESSAGE);
					ArrayList<String> da = acc.Subject(roww);
					acc.delSelected(Studentid, da.get(1));
				}else{
					JOptionPane.showMessageDialog(null ,"��δѡ�ÿγ̨r(�s���t)�q", "�˿ν��", JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		});
		
		button_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int roww = row + 1;
				String s = Integer.toString(roww);
				//�õ�AccessBase��Subject()
				ArrayList<String> da = acc.Subject(roww);
				JOptionPane.showMessageDialog(null ,da.get(8), "��ʦ���", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		
		button_4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				String Studentid = "09014424";//ѧ��Ϊ��ʱ
				String s = Studentid;
				//�õ�AccessBase��getSelidmax(), getSelectedid(), getSubname()
				int num = Integer.parseInt(acc.getSelidmax(Studentid));
				String[] d;
				d = new String[num];
				for(int i = 0; i < num; i ++){
					d[i] = acc.getSelectedid(Studentid,i+1);
				}
				String selected = null;
				String[] e;
				e = new String[num];
				StringBuffer sb = new StringBuffer();
				for(int i = 0; i < num; i ++){
					
					e[i] = acc.getSubname(d[i]);
					
					sb.append(e[i]+"    ");
				}
				
				s1 = sb.toString();
				if(e.length == 0){
					JOptionPane.showMessageDialog(null ,"��δѡ���κογ�", "��ѡ�γ����", JOptionPane.PLAIN_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null ,"�Ѿ�ѡ�Ŀγ���: [" + s1 + "]", "��ѡ�γ����", JOptionPane.PLAIN_MESSAGE);
				}
				Subid = null;
			}
		});
		
		button_5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				cho.setVisible(false);
				Main a = new Main(true);
			}
		});
		
		
		JTable tab_2 = new JTable();
		tab_2.add(new JButton("ѡ��"));
		tab_2.add(button_2);
		tab_2.add(button_3);
		GridBagConstraints GridBag= new GridBagConstraints();
		
		GridBag.fill = GridBagConstraints.BOTH;
		//�÷�����Ϊ���������������ڵ�������������Ҫ��ʱ����ʾ���
        //NONE�������������С��
        //HORIZONTAL���ӿ������ʹ����ˮƽ��������������ʾ���򣬵��ǲ��ı�߶ȡ�
        //VERTICAL���Ӹ������ʹ���ڴ�ֱ��������������ʾ���򣬵��ǲ��ı��ȡ�
        //BOTH��ʹ�����ȫ��������ʾ����

		
		GridBag.gridx = 0;//������Ͻ�����
		GridBag.gridy = 0;//������Ͻ�����
		GridBag.gridwidth = 8;//�÷������������ˮƽ��ռ�õĸ����������Ϊ0����˵��������Ǹ��е����һ��
		GridBag.weightx = 1;//�÷����������ˮƽ��������ȣ����Ϊ0��˵�������죬��Ϊ0�����Ŵ�������������죬0��1֮��
		GridBag.weighty = 1;//�÷������������ֱ��������ȣ����Ϊ0��˵�������죬��Ϊ0�����Ŵ�������������죬0��1֮��
		Grid.setConstraints(scro_1, GridBag);
		
		GridBag.gridx = 0;
		GridBag.gridy = 1;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 0;
		Grid.setConstraints(button_1, GridBag);
		
		GridBag.gridx = 1;
		GridBag.gridy = 1;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 0;
		Grid.setConstraints(button_2, GridBag);
		
		GridBag.gridx = 2;
		GridBag.gridy = 1;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 0;
		Grid.setConstraints(button_3, GridBag);
		
		GridBag.gridx = 3;
		GridBag.gridy = 1;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 0;
		Grid.setConstraints(button_4, GridBag);
		
		GridBag.gridx = 4;
		GridBag.gridy = 1;
		GridBag.gridwidth = 1;
		GridBag.weightx = 1;
		GridBag.weighty = 0;
		Grid.setConstraints(button_5, GridBag);
		
		con.add(scro_1);
		con.add(button_1);
		con.add(button_2);
		con.add(button_3);
		con.add(button_4);
		con.add(button_5);
		cho.setVisible(s);	
	}
}
	
	