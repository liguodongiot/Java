package com.lgd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务的用法
 * @author liguodong
 *
 */

public class Demo07 {
	@SuppressWarnings("null")
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement  statement1 = null;
		PreparedStatement  statement2 = null;
		
		try {
			//1、加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//2、建立与数据库的连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","liguodong");
			
			
			connection.setAutoCommit(false);//JDBC中默认自动提交事务，默认是ture
			
			String sql1 = "insert into user (username,pwd) values(?,?)";
			
			statement1 = connection.prepareStatement(sql1);
			
			statement1.setObject(1, "卡特琳娜");
			statement1.setObject(2, "666");
			
			System.out.println("插入一条记录");
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			
			String sql2 = "insert into user (username,pwd) values(?,?,?)";
			
			statement2 = connection.prepareStatement(sql2);
			statement2.setObject(1, "提莫快跑");
			statement2.setObject(2, "666");		
		
			statement2.executeUpdate();
			
			System.out.println("插入另外一条记录");
			
			connection.commit();//提交事务
			
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			try {
				connection.rollback(); //回滚操作
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			//执行顺序resultset-->statement-->connection这样的关闭顺序！一定要将三个try-catch块分开写！
			if(statement2!=null){
				try {
					statement2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			if(statement1!=null){
				try {
					statement1.close();
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
