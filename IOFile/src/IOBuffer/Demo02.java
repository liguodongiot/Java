package IOBuffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * 字符缓冲流+新增方法（不能发生多态）
 */

public class Demo02 {
	public static void main(String[] args) {
		String srcPath = "G:/oo.txt";
		String destPath = "G:/xx.txt";		
		//创建源
		File src = new File(srcPath);
		File dest = new File(destPath);
		
		//选择流   缓冲流   如果后面要使用新增方法，就不能使用多态了。
		//如果没有使用子类的新增方法，可以使用多态方式。
		/*Reader reader = null;
		Writer writer = null;
		reader =new BufferedReader(new FileReader(src)) ;
		writer = new BufferedWriter(new FileWriter(dest));
		reader.read(flush)
		writer.write(flush,0,len)*/		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			reader =new BufferedReader(new FileReader(src)) ;
			writer = new BufferedWriter(new FileWriter(dest));
			//读取操作
			//新增方法操作的字符缓冲流
			String line = null;//一行一行读取 BufferedReader新增readLine()
			while(null!=(line = reader.readLine()))
			{
				writer.write(line);
				//writer.append("\r\n");//换行符
				writer.newLine();//换行符  新增方法
			}
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			if(null!=reader)
			{
				try {
					writer.close();
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
}
