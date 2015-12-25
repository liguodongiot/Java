package com.lgd.jdbc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * CLOB文本大对象的使用
 * 包含：将字符集、字符串内容插入到数据库的CLOB字段、将CLOB字段值取出来
 * @author liguodong
 *
 */

public class Demo10 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement  ps = null;
		ResultSet rs = null;
		Reader reader = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","liguodong");			
			
			/////////输入///////////
			
			//ps = conn.prepareStatement("insert into user(username,myInfo) values(?,?)");
	
			/*ps.setString(1, "风城玫瑰");
			//将文本文件字节输入到数据库中
			ps.setClob(2, new FileReader(new File("d:/rose.txt")));		
			ps.executeUpdate();
			
			ps.setString(1, "风城玫瑰");
			//将程序中的字符串输入到数据库的CLOB字段中
			ps.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("司职控球后卫，最年轻的MVP".getBytes()))));
			ps.executeUpdate();*/
			
			/////////导出///////////			
			ps = conn.prepareStatement("select * from user where id=?");
			
			ps.setObject(1, 2006);
			rs = ps.executeQuery();
			
			while(rs.next()){
				java.sql.Clob clob = rs.getClob("myInfo");
				
				reader = clob.getCharacterStream();
				int temp=0;
				while((temp=reader.read())!=-1){
					System.out.print((char)temp);
				}
				
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			if(reader!=null){
				try {
					reader.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//执行顺序resultset-->statement-->connection这样的关闭顺序！一定要将三个try-catch块分开写！
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
