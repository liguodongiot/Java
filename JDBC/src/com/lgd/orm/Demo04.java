package com.lgd.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用List<Map<String,Object>>来封装多条记录
 * @author liguodong
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		Connection connection = JDBCUtil2.getMysqlConn();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		try {
			preparedStatement = connection.prepareStatement("select enpname,salary,age from emp where id>=?");
			//preparedStatement.setObject(1, 2);
			preparedStatement.setInt(1, 2);
			resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next())
			{
				Map<String,Object> map = new HashMap<String, Object>();//使用一个map封装了一条记录的信息！
				//System.out.println(resultSet.getString(1));
				map.put("empname", resultSet.getObject(1));
				map.put("salary", resultSet.getObject(2));
				map.put("age", resultSet.getObject(3));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil2.close(resultSet,preparedStatement,connection);
		}
		
		//遍历List<Map<String,Object>>
		for (Map<String, Object> map : list) {
			for (String key : map.keySet()) {
				System.out.print(key+":"+map.get(key)+"\t");
			}	
			System.out.println();
		}
	}
}
