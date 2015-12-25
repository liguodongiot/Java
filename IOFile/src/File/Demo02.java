package File;

import java.io.File;

/**
 * 相对路径与绝对路径 构造File对象
 * 1.相对路径
 *    File(String parent,String child) ==>File("E:/xp/test","2.jpg");
 *    File(File parent,String child)  ==>File(new File("E:/xp/test"),"2.jpg");
 * 2.绝对路径
 *    src = new File("E:/xp/test/2.jpg");
 *    
 *  getName()  返回名称
 *  getPath()  如果是绝对的，返回绝对路径；如果是相对的，返回相对路径。
 *  getAbsolutePath()  返回绝对路径
 */

public class Demo02 {
	public static void main(String[] args) {
		String parentPath = "E:/xp/test";
		String name = "2.jpg";
		//相对路径
		File   src = new File(parentPath,name);
		//src = new File(new File(parentPath),name);
		//输出
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println("-------------");
		//绝对路径
		src = new File("E:/xp/test/2.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println("-------------");
		//没有盘符，一user.dir构建
		src= new File("test.txt");
		//src= new File(".");//当前路径，通过这种方式可以找到当前工作空间路径。
		System.out.println(src.getName());//返回名称
		System.out.println(src.getPath());//如果是绝对的，返回绝对路径；如果是相对的，返回相对路径。
		System.out.println(src.getAbsolutePath());
	}
}
