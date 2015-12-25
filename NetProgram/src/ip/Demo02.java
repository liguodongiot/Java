package ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * 封装端口:在InetAddress基础上+端口
 */

public class Demo02 {
	public static void main(String[] args) throws UnknownHostException {
		InetSocketAddress address = new InetSocketAddress("localhost",9999);
		//address = new InetSocketAddress(InetAddress.getByName("127.0.0.1"),9999);
		System.out.println(address.getHostName());
		System.out.println(address.getPort());
		InetAddress addr = address.getAddress();//获得地址
		System.out.println(addr.getHostAddress());//返回：IP地址
		System.out.println(addr.getHostName());//输出计算机名
		
	}
}
