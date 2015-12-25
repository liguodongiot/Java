package IOOthers;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组流  节点流
 * 数组的长度有限，数据量不会很大
 * 
 * 节点  数据源（文件，字节数组<可以理解为服务器内存>）
 * 文件内容不用太大
 * 1、文件-文件输入流-程序-字节数组输出流->字节数组
 * 2、字节数组-字节数组输入流-程序-文件输出流->文件
 */
public class Demo01 {
	public static void main(String[] args) {
		try {
			//程序-字节数组输出流->字节数组-字节数组输入流-程序
			read(write());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 输入流的操作与文件输入流操作一致
	 * 读取字节数组
	 * @throws IOException 
	 */
	public static void read(byte[] src) throws IOException
	{
		/*//数据源
		String msg  = "操作与文件输入流操作一致";
		byte[] src = msg.getBytes();*/
		//选择流  
		InputStream is = new BufferedInputStream(
				new ByteArrayInputStream(src)
				);
		
		//操作
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len = is.read(flush)))
		{
			System.out.print(new String(flush,0,len));
		}
		//释放资源
		is.close();
	}	
	
	//输出流与操作文件输出流 有些不同，有新增方法，不能使用多态
	public static byte[] write() throws IOException
	{
		//目的地
		byte[] dest;
		//选择流  不同点  新增方法不能使用多态
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//操作写出
		String msg = "操作与文件输入流操作一致";
		byte[] info = msg.getBytes();
		bos.write(info,0,info.length);
		
		//获取数据   数据量不会很大
		dest = bos.toByteArray();
		//释放资源
		bos.close();
		return dest;
	}
	
	
	
}
