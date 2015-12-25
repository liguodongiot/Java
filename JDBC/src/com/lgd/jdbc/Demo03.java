package com.lgd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo03 {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			//1、加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//2、建立与数据库的连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","liguodong");
												
			//3、测试PreparedStatement的基本用法
			String sql1 = "insert into user(username,pwd,regTime) values (?,?,?)";
			statement = connection.prepareStatement(sql1);
			/*statement.setString(1, "周杰伦");//参数索引是从1开始计算，而不是0
			statement.setString(2, "fdsf323");						
			statement.execute();*/
			
			/*
			//也可以使用setObject方法处理参数
			statement.setObject(1, "詹姆斯");
			statement.setObject(2, "fdf323");						
			statement.execute();*/
			
			statement.setString(1, "德玛西亚");
			statement.setString(2, "fdsfds3");								
			statement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			statement.execute();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(statement!=null){
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
