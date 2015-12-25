package IOOthers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 输出到文件中或者从文件中读取
 * 
 * 数据类型(基本数据类型+字符串)处理流
 * 1、输入流DataInputStream   readXxx()
 * 2、输出流DataOutputStream  writeXxx()
 * 新增方法不能使用多态
 * java.io.EOFException:没有读取到相关的内容
 */

@SuppressWarnings("all")
public class Demo03 {
	public static void main(String[] args) {
		try {
			write("g:/try/321.txt");
			read("g:/try/321.txt");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	/**
	 * 基本数据类型+字符串  输出到文件
	 * @param destPath
	 * @throws IOException
	 */
	public static void write(String destPath) throws IOException
	{
		double point = 2.5;
		long num = 100L;
		String str  = "数据类型";
		//创建源
		File dest = new File(destPath);
		//选择流 DataOutputStream
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(dest))
				);
		//操作  写出的顺序-->为读取做准备
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		 
		dos.flush();
		//释放资源
		dos.close();
	}
	
	/**
	 * 从文本中读取 （字符串+基本数据类型）
	 * @throws IOException 
	 */
	public static void read(String destPath) throws IOException 
	{
		//创建源
		File src = new File(destPath);
		//输入流
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(new FileInputStream(src))
				);	
		
		//操作 读取的顺序与写出一致，必须先存在才能读取
		//顺序与写的时候不一致，可能存在顺序问题
		double point = dis.readDouble();
		long num = dis.readLong();
		String str = dis.readUTF();
		dis.close();
		System.out.println(point+"--"+num+"--"+str);
	}
}

