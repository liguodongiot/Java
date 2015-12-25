package IOByte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件夹的拷贝
 * 1、文件  复制
 * 2、文件夹  创建mkdirs()
 * 3、递归查找子孙级
 * @author Administrator
 */

@SuppressWarnings("all")
public class Demo04 {
	
	public static void main(String[] args) {
		String srcPath = "g:/try/123/432";//源目录
		String destPath = "g:/try/";//目标目录
		
		//File dest =null;
		//copyDir(srcPath,destPath);
		//FileUtil.copyDir(srcPath,destPath);
		copyDir(new File(srcPath),new File(destPath));	
	}
	
	
	/**
	 * 拷贝文件夹
	 * src 源文件对象
	 * dest 目标文件对象
	 */
	public static void copyDir(File src,File dest)
	{
		if(src.isDirectory())//文件夹
		{
			
			dest = new File(dest,src.getName());//****
			//如果父目录不能拷贝到子目录中，这样会造成死循环。
			if(dest.getAbsolutePath().contains(src.getAbsolutePath()))
			{
				System.out.println("父目录不能拷贝到子目录中");
				return;
			}
		}
		copyDirDetail(src,dest);
	}
	
	/**
	 * 拷贝文件夹细节
	 * @param src
	 * @param dest
	 */
	public static void copyDirDetail(File src,File dest)
	{
		if(src.isFile())//如果是文件，直接拷贝。
		{
			try {
				copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(src.isDirectory())//如果是文件夹，递归。
		{
			//确保目标文件夹存在
			dest.mkdirs();//****
			//获取下一级目录文件夹
			for(File sub:src.listFiles())
			{
				copyDirDetail(sub, new File(dest,sub.getName()));
			}
		}		
	}
	
	/**
	 * 文件的拷贝
	 * 源文件的File对象
	 * 目标文件的File对象
	 */
	public static void copyFile(File src,File dest) throws IOException 
	{
		if(!src.isFile())
		{
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
		}
		//如果过dest为已经存在的文件件，不能建立同名的文件。
		if(dest.isDirectory())
		{
			System.out.println("不能建立同名的文件");
			throw new IOException("不能建立同名的文件");
		}
		
		//2、选择流	
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);		
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

