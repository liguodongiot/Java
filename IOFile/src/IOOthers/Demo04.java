package IOOthers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/**
 * 输出到字节数组中或者从字节数组中读取
 * 
 * @author liguodong
 */

@SuppressWarnings("all")
public class Demo04 {
	public static void main(String[] args) {
		try {
			byte[] data = write();
			read(data);
			System.out.println(data.length);		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 数据+类型   输出到   字节数组中
	 * @return
	 * @throws IOException
	 */
	public static byte[] write() throws IOException
	{
		//目标数组
		byte[] dest = null;
		
		double point = 2.5;
		long num = 100L;
		String str  = "数据类型";
		
		
		//选择流DataOutputStream   存在多态行为
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(bos));
		//操作 写出的顺序
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		
		dos.flush();
		//获取数据
		dest =bos.toByteArray();
		//释放资源
		dos.close();		
		return dest;
	}

	/**
	 * 从字节数组中读取数据+类型
	 */
	public static void read(byte[] src) throws IOException 
	{	
		//输入流    没有所谓的多态行为
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(new ByteArrayInputStream(src)));
		
		//操作 读取的顺序与写出一致，必须先存在才能读取
		//顺序与写的时候不一致，可能存在顺序问题
		double point = dis.readDouble();
		long num = dis.readLong();
		String str = dis.readUTF();
		dis.close();
		System.out.println(point+"--"+num+"--"+str);
	}
}
