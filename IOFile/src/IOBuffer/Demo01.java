package IOBuffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理流（字节缓冲流）
 * 字节流文件拷贝+缓冲流，提高性能
 * 缓冲流（节点流）
 */

@SuppressWarnings("all")
public class Demo01 {
	public static void main(String[] args) {
		String srcPath = "G:/1314.jpg";
		String destPath = "G:/try/520.jpg";
		try {
			copyFile(srcPath,destPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void copyFile(String srcPath,String destPath) throws IOException 
	{
		//1、建立联系  源存在(且为文件)+目的地(文件可以不存在)				
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(!src.isFile())
		{
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
		}
		
		//2、选择流	缓冲流(字节输入流)		
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		OutputStream os =new BufferedOutputStream(new FileOutputStream(dest)) ;
	
		//3、文件拷贝  循环+读取+写出
		byte[] flush = new byte[1024];
		int len = 0;	
		while(-1!=(len = is.read(flush)))
		{
			//写出
			os.write(flush,0,len);
		}
		os.flush();//强制刷出			
		//关闭流 先打开后关闭
		os.close();
		is.close();
	}
}
