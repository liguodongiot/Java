package com.lgd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 批处理
 * @author liguodong
 *
 */

public class Demo05 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement  statement = null;
		ResultSet rs1 = null;
		try {
			//1、加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//2、建立与数据库的连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","liguodong");
			
			
			connection.setAutoCommit(false);//设置为手动提交
			
			statement = connection.createStatement();
			
			long start = System.currentTimeMillis();
			for(int i=0;i<20000;i++)
			{
				statement.addBatch("insert into user(username,pwd,regTime) values ('神舟"+i+"号',666666,NOW())");
			}
			
			statement.executeBatch();
			
			connection.commit();//提交事务
			
			long end = System.currentTimeMillis();
			
			System.out.println("批量插入数据耗时（毫秒）："+(end-start));
			
	
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
