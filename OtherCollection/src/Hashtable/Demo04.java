package Hashtable;

import java.io.IOException;
import java.util.Properties;

/**
 * 使用类相对路径读取配置文件
 */

public class Demo04 {
	public static void main(String[] args) {
		Properties pro = new Properties();		
		try {
			//类相对路径    /表示 bin
			//pro.load(Demo04.class.getResourceAsStream("/Hashtable/db.properties"));
			//类相对路径   ""表示 bin
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("Hashtable/db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(pro.getProperty("user", "fuck"));
	}
}
