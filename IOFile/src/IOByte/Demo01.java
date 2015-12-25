package IOByte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件的读取
 * 1、建立联系
 * 2、选择流
 * 3、操作 不断读取
 * 4、释放资源
 * 
 * String(byte[] bytes, int offset, int length) 
 * 通过使用平台的 默认字符集解码 指定的byte子数组，构造一个新的 String。
 */

public class Demo01 {
	public static void main(String[] args) {	
		String path = "g:/love.txt";
		//1、建立联系
		File src= new File(path);
		//2、选择流
		InputStream is= null;//提升作用域
		try {
			//is = new FileInputStream(path);
			is = new FileInputStream(src);
			
			//3、操作不断读取   缓冲数组
			byte[] car = new byte[20];
			int len = 0;//接收实际读取的大小
			//循环读取
			while(-1!=(len=is.read(car)))
			{
				//输出 字节数组转成字符串(默认字符集解码)
				String info = new String(car,0,len);
				System.out.print(info);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("读取文件失败");
		}
		finally
		{
			//4、释放资源
			if(null!=is)
			{
				
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("关闭输入流文件失败");
				}				
			}
		}
		
	}
}
