package File;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 5.创建目录
 * 	mkdir() 创建目录  必需确保父目录存在，如果不存在，创建失败。
 * 	mkdirs() 创建目录  如果父目录链不存在，一同创建。
 * 	String[] list()  文件|目录名   字符串形式
 * 	File[] listFiles()  文件|目录名   File对象形式
 *  File[] listFiles(FilenameFilter filter)  过滤
 */

@SuppressWarnings("all")
public class Demo04 {
	public static void main(String[] args) {
		test01();
		test02();
	}
	
	public static void test01()
	{
		String path = "G:/try/123/123/325";
		File src = new File(path);
		//src.mkdir();
		src.mkdirs();
		System.out.println("创建成功。");
	}
	public static void test02()
	{
		//String path = "G:/try/123";
		String path = "G:/work";
		File src = new File(path);//文件夹
		if(src.isDirectory())//存在并且为目录
		{
			System.out.println("======子目录|子文件名 《字符串的表现形式》======");
			String[] subNames = src.list();
			for(String temp:subNames)
			{
				System.out.println(temp);
			}
			
			System.out.println("====子目录|子文件 《File对象》=====");
			File[]  subFiles = src.listFiles();			
			for(File temp:subFiles ) 
			{
				System.out.println(temp.getAbsolutePath());
			}
			
			System.out.println("======子文件,Java对象======");
			//命令设计模式
			subFiles = src.listFiles(new FilenameFilter() {
				/**
				 * dir代表src
				 */
				@Override
				public boolean accept(File dir, String name) {
					//System.out.println(dir.getName());
					//System.out.println(dir.getAbsolutePath());
					//必须是文件且后缀是.java
					return  new File (dir,name).isFile()&&name.endsWith(".rar");
				}
			});
			for(File temp:subFiles)
			{
				System.out.println(temp.getAbsolutePath());
			}
		}
	}
}