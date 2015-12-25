package com.lgd.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class JDBCUtil2 {

	static Properties pros = null; //可以帮助和处理资源文件中的信息
	
	static{//加载JDBCUtil2类的时候调用一次
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getMysqlConn()
	{		
		try {
			Class.forName(pros.getProperty("mysqlDriver"));
			return DriverManager.getConnection(pros.getProperty("mysqlURL"),
					pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}				
	}
	
	public static Connection getOracleConn()
	{		
		try {
			Class.forName(pros.getProperty("oracleDriver"));
			return DriverManager.getConnection(pros.getProperty("oracleURL"),
					pros.getProperty("oracleUser"),pros.getProperty("oraclePwd"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}				
	}
	
	public static void close(Connection conn)
	{				
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stat,Connection conn)
	{		
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs, Statement stat,Connection conn)
	{
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
