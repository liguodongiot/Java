package com.lgd.jdbc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * BLOB文本大对象的使用
 * 包含：将字符集、字符串内容插入到数据库的CLOB字段、将CLOB字段值取出来
 * @author liguodong
 *
 */

public class Demo11 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement  ps = null;
		ResultSet rs = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","liguodong");			
			
			/////////输入///////////
			/*ps = conn.prepareStatement("insert into userblob (username,headImg) values (?,?) ");
			ps.setString(1, "sunshine");
			
			//将图片输入到数据库中
			//方式一
			ps.setBlob(2,new FileInputStream(new File("d:/sunshine.png")));
			ps.execute();
			//方式二
			FileInputStream fis = new FileInputStream("d:/sunshine.png");
			ps.setBinaryStream(2, fis,fis.available());
			ps.execute();*/
			
			
			
			/////////导出///////////			
			ps = conn.prepareStatement("select * from userblob where id=?");
			
			ps.setObject(1, 1);
			rs = ps.executeQuery();
			
			while(rs.next()){
				java.sql.Blob blob = rs.getBlob("headImg");
				
				is = blob.getBinaryStream();
				os = new FileOutputStream("d:/coco.png");
				int temp=0;
				while((temp=is.read())!=-1){
					//System.out.print((char)temp);
					os.write(temp);
				}
				
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			if(os!=null){
				try {
					os.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(is!=null){
				try {
					is.close();
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
