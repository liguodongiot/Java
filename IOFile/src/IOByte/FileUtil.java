package IOByte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件操作综合更加完整，健壮
 * 1、文件拷贝
 * 2、文件夹拷贝
 */
public class FileUtil {
	/**
	 * 文件的拷贝
	 * 源文件的String对象
	 * 目标文件的String对象
	 */
	public static void copyFile(String srcPath,String destPath) throws IOException 
	{
		//1、建立联系  源存在(且为文件)+目的地(文件可以不存在)
		 copyFile(new File(srcPath),new File(destPath));
	}
	
	/**
	 * 文件的拷贝
	 * 源文件的File对象
	 * 目标文件的File对象
	 */
	public static void copyFile(File src,File dest) throws IOException 
	{
		if(!src.isFile()||null==src)//不是文件或者为null
		{
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
		}
		//如果dest为已经存在的文件夹，不能建立与文件夹同名的文件。
		if(dest.isDirectory())
		{
			System.out.println(dest.getAbsolutePath()+"不能建立与文件夹同名的文件");
			throw new IOException(dest.getAbsolutePath()+"不能建立与文件夹同名的文件");
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
		//4、关闭流 先打开后关闭
		os.close();
		is.close();
	}

	/**
	 * 拷贝文件夹
	 * 原路径
	 * 目标路径
	 */
	public static void copyDir(String srcPath,String destPath)
	{
		File src = new File(srcPath);
		File dest = new File(destPath);
		copyDir(src,dest);
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
			dest = new File(dest,src.getName());
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
		if(src.isFile())
		{
			try {
				FileUtil.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(src.isDirectory())//文件夹
		{
			//确保目标文件夹存在
			dest.mkdirs();
			//获取下一级目录文件夹
			for(File sub:src.listFiles())
			{
				copyDirDetail(sub, new File(dest,sub.getName()));
			}
		}		
	}
}
