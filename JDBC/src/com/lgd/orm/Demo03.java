package com.lgd.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**
 * 使用map数组来封装一条记录
 * @author liguodong
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		Connection connection = JDBCUtil2.getMysqlConn();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Map<String,Object> map = new HashMap<String, Object>();//使用一个map封装了一条记录的信息！
		
		try {
			preparedStatement = connection.prepareStatement("select enpname,salary,age from emp where id=?");
			//preparedStatement.setObject(1, 2);
			preparedStatement.setInt(1, 2);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				//System.out.println(resultSet.getString(1));
				map.put("empname", resultSet.getObject(1));
				map.put("salary", resultSet.getObject(2));
				map.put("age", resultSet.getObject(3));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil2.close(resultSet,preparedStatement,connection);
		}
		
		//遍历Map，就是遍历这一行的多列的信息
		for (String key : map.keySet()) {
			System.out.println(key+"--"+map.get(key)+"\t");
		}
	}
}
