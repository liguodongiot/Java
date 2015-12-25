package com.lgd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Demo04 {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement  statement = null;
		ResultSet rs1 = null;
		try {
			//1、加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//2、建立与数据库的连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","liguodong");
												
			//3、测试PreparedStatement的基本用法   ?占位符
			
			String sql1 = "select * from user where id>?";
			statement = connection.prepareStatement(sql1);
			statement.setObject(1, 2);//把大于2的记录都取出来
			
			rs1 = statement.executeQuery();
			
			while(rs1.next()){
				System.out.println(rs1.getInt(1)+"---"+rs1.getString(2)+"---"+rs1.getString(3));
			}
	
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
