package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 服务端
 * 1、创建服务端+端口
 * 2、准备接收容器
 * 3、封装成包
 * 4、接收数据
 * 5、分析数据
 * 6、释放资源
 * 
 * DatagramPacket(byte[] buf, int length) 
 *     构造 DatagramPacket，用来接收长度为 length 的数据包。 
 *     
 * DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
 *     构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号。 
 *
 * 思考：89.12   数据+类型       用 IO流
 */
public class MyServer {
	public static void main(String[] args) throws IOException {
		//1、创建服务端+端口
		DatagramSocket server = new DatagramSocket(8888);
		
		//2、准备接收容器
		byte[] container = new byte[1024];
		
		//3、封装成包     DatagramPacket(byte[] buf, int length)构造接收数据包
		DatagramPacket  packet = new DatagramPacket(container, container.length);
		
		//4、接收数据
		server.receive(packet);
		
		//5、分析数据
		byte[] data = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(data,0,len));
		
		//6、释放资源
		server.close();			
	}
}
