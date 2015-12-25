package ip;


/**
 * 没有封装端口
 */

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo01 {
	public static void main(String[] args) throws UnknownHostException {
		//使用getLocationHost方法创建InetAddree对象
		InetAddress addr = Inet4Address.getLocalHost();
		System.out.println(addr.getHostAddress());//返回ip地址
		System.out.println(addr.getHostName());//输出计算机名
		
		//根据域名得到InetAddress对象
		addr = InetAddress.getByName("www.163.com");
		System.out.println(addr.getHostAddress());//返回服务器的ip 
		System.out.println(addr.getHostName());
		//根据ip得到InetAddress对象
		addr = InetAddress.getByName("202.201.14.181");
		System.out.println(addr.getHostAddress());//返回服务器的ip 
		System.out.println(addr.getHostName());//地址不存在或者为了安全性DNS域名不能解析 就返回ip 182.140.147.57		
	}
}


