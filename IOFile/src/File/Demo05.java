package File;

import java.io.File;
import java.util.Arrays;

/**
 * 输出子孙级目录|文件的名称
 * 1、listFile()
 * 2、递归
 * 
 * static listRoots() 根路径
 * @author liguodong
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		String path = "G:/try/123";
		File parent = new File(path);
		printName(parent);
		System.out.println("----------");
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
	}
	
	public static void printName(File src){
		if(null==src||!src.exists()){
			return;
		}
		System.out.println(src.getAbsolutePath());
		if(src.isDirectory()){
			for(File sub:src.listFiles()){
				printName(sub);
			}
		}
	}
}
