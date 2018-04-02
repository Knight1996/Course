/*
 * Created on 2016-8-30
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

//选课界面
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
	protected static JFrame cho = new JFrame("选课系统");
	protected static String s1 = null;
	
	public ChooseFrame(boolean s){
		//用到AccessBase的getmax(), Subject(), getConnection()
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
			new Object[]{"课程代码", "课程名称", "任课老师", "上课地点", "学时数", "学分", "上课时间",});
		final JTable tab_1 = new JTable(dm){
			 public boolean isCellEditable(int row, int column) { 
				 return false; 
				 }
			};
		
		JScrollPane scro_1 = new JScrollPane(tab_1);
		JButton button_1 = new JButton(" 选课 ");
		final JButton button_2 = new JButton(" 退课 ");
		JButton button_3 = new JButton("查看教师");
		JButton button_4 = new JButton("查看已选课程");
		JButton button_5 = new JButton("退出选课");
		tab_1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				row = tab_1.rowAtPoint(event.getPoint());  
				col = tab_1.columnAtPoint(event.getPoint());
			}
		});
		
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int roww = row + 1;
				String Studentid = "09014424";//学号为临时
				String s = "09014424#" + roww + "#1";
				//用到AccessBase的Subject()
				if(acc.search(Studentid,acc.Subject(roww).get(1)) == 0){
					JOptionPane.showMessageDialog(null ,"选课成功！", "选课结果", JOptionPane.PLAIN_MESSAGE);
					ArrayList<String> da = acc.Subject(roww);
					acc.addSelected(Studentid, da.get(1));
				}else{
					JOptionPane.showMessageDialog(null ,"已经选过该课程╮(╯▽╰)╭", "选课结果", JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		});
		
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int roww = row + 1;
				String s = "09014424#" + roww + "#1";
				//用到AccessBase的Subject()
				String Studentid = "09014424";//学号为临时
				if(acc.search(Studentid,acc.Subject(roww).get(1)) == 1){
					JOptionPane.showMessageDialog(null ,"退课成功!", "退课结果", JOptionPane.PLAIN_MESSAGE);
					ArrayList<String> da = acc.Subject(roww);
					acc.delSelected(Studentid, da.get(1));
				}else{
					JOptionPane.showMessageDialog(null ,"尚未选该课程╮(╯▽╰)╭", "退课结果", JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		});
		
		button_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int roww = row + 1;
				String s = Integer.toString(roww);
				//用到AccessBase中Subject()
				ArrayList<String> da = acc.Subject(roww);
				JOptionPane.showMessageDialog(null ,da.get(8), "教师情况", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		
		button_4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				String Studentid = "09014424";//学号为临时
				String s = Studentid;
				//用到AccessBase的getSelidmax(), getSelectedid(), getSubname()
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
					JOptionPane.showMessageDialog(null ,"尚未选择任何课程", "已选课程情况", JOptionPane.PLAIN_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null ,"已经选的课程有: [" + s1 + "]", "已选课程情况", JOptionPane.PLAIN_MESSAGE);
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
		tab_2.add(new JButton("选课"));
		tab_2.add(button_2);
		tab_2.add(button_3);
		GridBagConstraints GridBag= new GridBagConstraints();
		
		GridBag.fill = GridBagConstraints.BOTH;
		//该方法是为了设置如果组件所在的区域比组件本身要大时的显示情况
        //NONE：不调整组件大小。
        //HORIZONTAL：加宽组件，使它在水平方向上填满其显示区域，但是不改变高度。
        //VERTICAL：加高组件，使它在垂直方向上填满其显示区域，但是不改变宽度。
        //BOTH：使组件完全填满其显示区域。

		
		GridBag.gridx = 0;//组件左上角列数
		GridBag.gridy = 0;//组件左上角行数
		GridBag.gridwidth = 8;//该方法是设置组件水平所占用的格子数，如果为0，就说明该组件是该行的最后一个
		GridBag.weightx = 1;//该方法设置组件水平的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
		GridBag.weighty = 1;//该方法设置组件垂直的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
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
	
	