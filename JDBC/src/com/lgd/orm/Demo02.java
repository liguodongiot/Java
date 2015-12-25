package com.lgd.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用List<Object[]>存储多条记录
 * @author liguodong
 *
 */

public class Demo02 {
	public static void main(String[] args) {
		Connection connection = JDBCUtil2.getMysqlConn();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//存放多条记录
		List<Object[]> list = new ArrayList<Object[]>();
		
		try {
			preparedStatement = connection.prepareStatement("select enpname,salary,age from emp where id>=?");
			//preparedStatement.setObject(1, 2);
			preparedStatement.setInt(1, 2);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				Object[] objects = new Object[3];//一个Object数组封装了一条记录的信息！
				//System.out.println(resultSet.getString(1));
				objects[0] = resultSet.getObject(1);
				objects[1] = resultSet.getObject(2);
				objects[2] = resultSet.getObject(3);
				list.add(objects);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil2.close(resultSet,preparedStatement,connection);
		}	
		
		for (Object[] objects : list) {
			System.out.println(objects[0]+"--"+objects[1]+"--"+objects[2]);
		}
	}
}
