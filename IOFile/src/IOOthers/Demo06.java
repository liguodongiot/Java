package IOOthers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
/**
 * PrintStream  打印流 -->处理流
 */

public class Demo06 {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("test");
		PrintStream ps = System.out;
		ps.println(false);
		
		//输出到文件
		File src = new File("g:/try/test.txt");
		//false覆盖  true追加
		ps = new PrintStream(
				new BufferedOutputStream(new FileOutputStream(src,true)));		
		ps.println("io is so easy2fdsf13");
		ps.close();		 
	}
}
