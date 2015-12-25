package com.lgd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			//1、加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//2、建立与数据库的连接
			//连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时间，这是Connection对象管理的一个要点！
			//真正开发中，为了提高效率，都会使用连接池来管理连接对象。
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","liguodong");
			System.out.println(connection);
			
									
			//3、测试指定SQL语句以及SQL注入问题
			//实际应用中比较少
			//1.处理参数不方便
			//2.容易发生SQL注入的危险
			statement = connection.createStatement();
			
			/*String sqlone = "insert into user(username,pwd,regTime) values ('苏三',54423,NOW())";
			statement.execute(sqlone);*/
			
			/*String nameString = "宋八";
			String sqltwo = "insert into user(username,pwd,regTime) values('"+nameString+"',54ds23,NOW())";
			statement.execute(sqltwo);*/
			
			//测试SQL注入
			String idString = "5 or 1=1";
			String sql1 = "delete from user where id="+idString;
			statement.execute(sql1);//这样会删除所有元素
			
			
			
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
