package Hashtable;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Properties读取配置文件
 * 资源配置文件
 * load(InputStream inStream)
 * load(Reader reader)
 * loadFromXML(InputStream in)
 */

public class Demo03 {
	
	public static void main(String[] args) {
		Properties pro = new Properties();
		
		try {
			//读取 绝对路径
			//pro.load(new FileReader("d:/others/db.properties"));			
			//读取 相对路径
			//pro.load(new FileReader("db.xml"));
			pro.load(new FileReader("src/Hashtable/db.properties"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(pro.getProperty("pwd", "sclgd"));
		//pro.list(System.out);
	}
}
