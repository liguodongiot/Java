package IOChar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
/**
 * 纯文件的拷贝
 * @author liguodong
 *
 */

public class Demo03 {
	public static void main(String[] args) {
		String srcPath = "G:/output.txt";
		String destPath = "G:/writer.txt";		
		//创建源
		File src = new File(srcPath);
		//创建源
		File dest = new File(destPath);
		//选择流
		Reader reader = null;
		//选择流
		Writer writer = null;
		try {
			reader = new FileReader(src);
			writer = new FileWriter(dest);
			//读取操作
			char[] flush = new char[10];
			int len = 0;
			while(-1!=(len = reader.read(flush)))
			{
				//字符数组转成字符串
				//String str = new String(flush,0,len);
				//writer = new FileWriter(dest,true);
				//writer.write(str);
				writer.write(flush,0,len);				
			}
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件读写失败");
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
