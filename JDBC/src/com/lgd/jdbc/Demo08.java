package com.lgd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 时间处理（java.sql.Date, java.sql.Time, java.sql.Timestamp）
 * @author liguodong
 *
 */

public class Demo08 {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement  statement = null;
		Statement rs1 = null;
		try {
			//1、加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//2、建立与数据库的连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","liguodong");
												
			//3、测试PreparedStatement的基本用法   ?占位符
			String sql1 = "insert into user(username,pwd,regTime,lastLoginTime) values(?,?,?,?)";
			statement = connection.prepareStatement(sql1);
			
			statement.setObject(1, "模特");
			statement.setObject(2, "mm");
			//java.sql.Date没有空构造器，必须要传值。
			java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			
			//如果需要指定日期，可以使用Calendar，DateFormat
			java.sql.Timestamp stamp = new java.sql.Timestamp(System.currentTimeMillis());
			
			statement.setObject(3, date);
			
			statement.setTimestamp(4, stamp);
			
			statement.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			//执行顺序resultset-->statement-->connection这样的关闭顺序！一定要将三个try-catch块分开写！
			if(rs1!=null){
				try {
					rs1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
