package IOChar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/**
 * 纯文本读取
 * String(char[] value, int offset, int count) 
 * 分配一个新的 String，它包含取自字符数组参数一个子数组的字符。
 */
public class Demo01 {
	public static void main(String[] args) {
		String path = "G:/kfcv.txt";
		//1、创建源
		File src = new File(path);
		//2、选择流
		Reader reader = null;
		try {
			reader = new FileReader(src);
			//3、读取操作
			char[] flush = new char[10];
			int len = 0;
			while(-1!=(len = reader.read(flush)))
			{
				//字符数组转成字符串
				String str = new String(flush,0,len);
				System.out.print(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件读取失败");
		}
		finally
		{
			if(null!=reader)
			{
				try {
					//4、关闭
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
}
