package com.lgd.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用Object数组来封装一条记录
 * @author liguodong
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		Connection connection = JDBCUtil2.getMysqlConn();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object[] objects = null;
		try {
			preparedStatement = connection.prepareStatement("select enpname,salary,age from emp where id=?");
			//preparedStatement.setObject(1, 2);
			preparedStatement.setInt(1, 2);
			resultSet = preparedStatement.executeQuery();
			objects = new Object[3];//一个Object数组封装了一条记录的信息！
			while(resultSet.next())
			{
				//System.out.println(resultSet.getString(1));
				objects[0] = resultSet.getObject(1);
				objects[1] = resultSet.getObject(2);
				objects[2] = resultSet.getObject(3);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil2.close(resultSet,preparedStatement,connection);
		}
		
		System.out.println(objects[0]+"--"+objects[1]+"--"+objects[2]);		
	}
}
