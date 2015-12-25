package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 客户端
 *1、创建客户端+端口
 *2、准备数据
 *3、打包（发送地点及端口）
 *4、发送
 *5、释放
 *
 */
public class MyClient {
	public static void main(String[] args) throws IOException {
		//1、创建客户端+端口
		DatagramSocket client = new DatagramSocket(6666);
		
		//2、准备数据
		String msg = "模拟UDP过程";
		byte[] data = msg.getBytes();
		
		//3、打包(指定发送的地点及端口)
		//DatagramPacket(byte[] buf, int length, SocketAddress address) 构造发送数据报包
		DatagramPacket packet = new DatagramPacket(data, data.length,
				new InetSocketAddress("localhost",8888));
		
		//4、发送
		client.send(packet);
		
		//5、释放
		client.close();
	}
}
