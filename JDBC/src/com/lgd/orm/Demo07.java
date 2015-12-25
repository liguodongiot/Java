package com.lgd.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 * 使用Javabean来封装一条记录
 * @author liguodong
 *
 */
public class Demo07 {
	public static void main(String[] args) {
		Connection connection = JDBCUtil2.getMysqlConn();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Emp> list = new ArrayList<Emp>();
		
		try {
			preparedStatement = connection.prepareStatement("select enpname,salary,age from emp where id>=?");
			//preparedStatement.setObject(1, 2);
			preparedStatement.setInt(1, 2);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				//System.out.println(resultSet.getString(1));
				Emp emp = new Emp(resultSet.getString(1), resultSet.getDouble(2), resultSet.getInt(3));				
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil2.close(resultSet,preparedStatement,connection);
		}
		for (Emp emp : list) {
			System.out.println(emp.getEmpname()+"--"+emp.getSalary()+"--"+emp.getAge());
		}
					
	}
}
