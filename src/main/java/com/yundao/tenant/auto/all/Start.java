package com.yundao.tenant.auto.all;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


/**
 * MyBatis模板代码生成工具启动类
 * @author 
 * 创建时间:2012-07-03
 */
public class Start extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	private static String driver;
	private static String url;
	private static String user;
	private static String passwd;

	static {
		Properties prop = new Properties();
		try {
			File   dir=new File("");
			prop.load(new FileInputStream(Start.class.getResource("/").getPath() + "application.properties"));
			url = prop.getProperty("spring.datasource.url");
			passwd = prop.getProperty("spring.datasource.password");
			user = prop.getProperty("spring.datasource.username");
			driver = prop.getProperty("spring.datasource.driver-class-name");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	JTextField t1 = new JTextField(driver);
	JTextField t2 = new JTextField(url);
	JTextField t3 = new JTextField(user);
	JTextField t4 = new JTextField(passwd);

	Connection conn = null;
	JList list = new JList();
	
	JTextField field0 = new JTextField();//数据库名,作查询条件
	JTextField field = new JTextField();//表名,作查询条件
	
	JTextField field2 = new JTextField("com.yundao.tenant");
	JTextField field3 = new JTextField("");
	public Start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		Toolkit tk = Toolkit.getDefaultToolkit();//得到Toolkit对象
		Dimension screen=tk.getScreenSize();//得到屏幕的大小
		this.setBounds(((int)(screen.getWidth()-400)/2),((int)(screen.getHeight()-500)/2), 400, 500);
		
		JLabel l1 = new JLabel("数据库驱动");
		l1.setBounds(10, 10, 120, 20);
		this.add(l1);
		JLabel l2 = new JLabel("连接地址");
		l2.setBounds(10, 30, 120, 20);
		this.add(l2);
		JLabel l3 = new JLabel("用户名");
		l3.setBounds(10, 50, 120, 20);
		this.add(l3);
		JLabel l4 = new JLabel("密码");
		l4.setBounds(10, 70, 120, 20);
		this.add(l4);
		
		t1.setBounds(100, 10, 270, 20);
		this.add(t1);
		t2.setBounds(100, 30, 270, 20);
		this.add(t2);
		t3.setBounds(100, 50, 270, 20);
		this.add(t3);
		t4.setBounds(100, 70, 270, 20);
		this.add(t4);
		
		JButton button = new JButton("测试");
		button.setBounds(10, 90, 70, 25);
		this.add(button);
		JLabel jl0 = new JLabel("连接设置请在applicationContext.xml中进行配置!");
		jl0.setForeground(Color.red);
		jl0.setBounds(90,90,450,25);
		this.add(jl0);
		button.addActionListener(this);
		//查询条件
		JLabel label0 = new JLabel("数据库名");
		label0.setBounds(10, 120, 60, 20);
		this.add(label0);
		
		String database = url.substring(url.lastIndexOf('/')+1);
		if(url.indexOf('?')>-1){
			database = database.substring(0,database.lastIndexOf('?'));
		}
		field0.setText(database);
		field0.setBounds(70,120,100,20);
		this.add(field0);
		
		JLabel label = new JLabel("表名");
		label.setBounds(170, 120, 30, 20);
		this.add(label);
		
		field.setBounds(200, 120, 100, 20);
		this.add(field);
		JButton button2 = new JButton("查询");
		button2.setBounds(300, 120, 60, 20);
		this.add(button2);
		button2.addActionListener(this);
		
		JScrollPane pane = new JScrollPane(list);
		pane.setBounds(10, 150, 350, 150);
		this.add(pane);
		//生成名路径
		JLabel label2 = new JLabel("请输入包路径: ");
		label2.setBounds(10, 310, 150, 20);
		this.add(label2);
		
		field2.setBounds(100, 310, 260, 20);
		this.add(field2);
		//生成名路径
		JLabel label3 = new JLabel("扩展包路径: ");
		label3.setBounds(10, 340, 150, 20);
		this.add(label3);
		field3.setBounds(100, 340, 260, 20);
		this.add(field3);

		JButton button3 = new JButton("生成");
		button3.setBounds(10, 370, 60, 20);
		this.add(button3);
		button3.addActionListener(this);
		this.setTitle("ibatis模板代码生成工具 for mysql");
		this.setResizable(false);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		String database = url.substring(url.lastIndexOf('/')+1);
		if(url.indexOf('?')>-1){
			database = database.substring(0,database.lastIndexOf('?'));
		}
		if("测试".equals(cmd)){
			driver = t1.getText().trim();
			url = t2.getText().trim();
			user = t3.getText().trim();
			passwd = t4.getText().trim();
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, passwd);
				conn.close();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			if(conn == null){
				JOptionPane.showMessageDialog(this, "连接失败!");
			}else{
				JOptionPane.showMessageDialog(this, "连接成功!");
			}
		}else if("查询".equals(cmd)){
			List<String> listTemp = new ArrayList<String>();
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, passwd);
				String tablename = field.getText().replace(" ","").replace("　","");
				String querytable = "SELECT TABLE_NAME,TABLE_ROWS,TABLE_SCHEMA FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='"+database+"' "
						+ "and LOWER(table_name) like '%"+tablename.toLowerCase()+"%'";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(querytable);
				while(rs.next()){
					listTemp.add(rs.getString(1).toLowerCase());
				}
				list.setListData(listTemp.toArray());
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}else if("生成".equals(cmd)){
			Object[] tables = list.getSelectedValues();
			for (int i = 0; i < tables.length; i++) {
				try {
					new Auto().create(driver,url,user,passwd,tables[i].toString()
							,field2.getText().replace(" ","").replace("　","")
					,field3.getText().replace(" ","").replace("　",""));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			JOptionPane.showMessageDialog(this, "生成完成,请刷新工程代码!");
		}
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
