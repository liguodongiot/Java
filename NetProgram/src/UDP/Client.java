package UDP;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 89.12  数据的发送要字节数组，因此将double类型转成字节数组
 * 客户端
 *1、创建客户端+端口
 *2、准备数据   double类型转成字节数组   字节数组输出流   类型转换问题
 *3、打包（发送地点及端口）
 *4、发送
 *5、释放
 */
public class Client {
	public static void main(String[] args) throws IOException {
		//1、创建服务器+端口
		DatagramSocket client = new DatagramSocket(6666);
		//2、准备数据
		double num = 89.12;
		
		byte[] data = convert(num);
		
		//3、打包(发送的地点及端口)
		DatagramPacket packet = new DatagramPacket(data, data.length,
				new InetSocketAddress("localhost",8888));
		//4、发送
		client.send(packet);
		//5、释放
		client.close();
	}
	
	/**
	 * 字节数组输出流ByteArrayOutputStream+DataOutputStream数据输出流
	 * @param num
	 * @return
	 * @throws IOException 
	 */
	public static byte[] convert(double num) throws IOException
	{
		byte[] data = null;
		//有新增方法，不能使用多态
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		
		dos.writeDouble(num);
		dos.flush();
		
		//获取数据
		data = bos.toByteArray();
		dos.close();
		bos.close();//此方法关闭 ByteArrayOutputStream无效。
		
		return data;
	}
}
