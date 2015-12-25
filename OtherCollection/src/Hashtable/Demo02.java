package Hashtable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *使用Properties输出到文件
 *资源配置文件:
 *1、.properties
 *store(OutputStream out,String comments)
 *store(Writer writer,String comments)
 *2、.xml
 *storeToXML(OutputStream out,String comments)      UTF-8字符集
 *storeToXML(OutputStream out,String comments,String encoding)
 */

public class Demo02 {
	public static void main(String[] args) {
		//创建对象
		Properties pro = new Properties();
		//存储
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jsbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user","scott");
		pro.setProperty("pwd", "tiger");		
		//1、绝对路径:带盘符 存储到d:/others  
		try {
			pro.store(new FileOutputStream(new File("d:/others/db.properties")),"db配置");
			pro.storeToXML(new FileOutputStream(new File("d:/others/db.xml")),"db配置");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		//2、使用相对路径  默认是当前的工程
		try {
			pro.storeToXML(new FileOutputStream(new File("db.xml")),"db配置");
			pro.store(new FileOutputStream(new File("src/Hashtable/db.properties")),"db配置");	
			//pro.store(new FileOutputStream(new File("db.properties")),"db配置");
			System.out.println("完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

