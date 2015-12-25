package Hashtable;

import java.util.Properties;

/**
 * Properties资源配置文件的读写
 * 1.key与value只能字符串
 * 2.存储于读取
 * setProperty(String key,String value)
 * getProperty(String key,String defaultValue)
 */
public class Demo01 {
	public static void main(String[] args) {
		//创建对象
		Properties pro = new Properties();
		//存储
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jsbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user","scott");
		pro.setProperty("pwd", "tiger");		
		//获取url,如果没有返回test。
		String url=pro.getProperty("url", "test");
		System.out.println(url);
	}
}

