package IOOthers;

import java.io.Closeable;
import java.io.IOException;

@SuppressWarnings("all")
public class FileUtil {
	//工具类关闭流
	//多态方式
	//可变参数：...  <只能放在形参最后一个位置>   处理方式与数组一致	
	public static void close(Closeable ... io)
	{
		for(Closeable temp:io)
		{
			try {
				if(null!=temp)
				{
					temp.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 泛型方法  和上一种一样的效果 
	 */	
	public static <T extends Closeable> void cloaseAll(T ... io)
	{
		for(Closeable temp:io)
		{
			try {
				if(null!=temp)
				{
					temp.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
}
