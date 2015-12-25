package URL;

import java.net.MalformedURLException;
import java.net.URL;

public class Demo01 {
	public static void main(String[] args) throws MalformedURLException {
		//绝对路径构建
		URL url = new URL("http://www.baidu.com:80/index.html#bb?uname=liguodong");
		//url = new URL("http://www.baidu.com:80/index.html?uname=liguodong");
		System.out.println("协议："+url.getProtocol());
		System.out.println("域名："+url.getHost());
		System.out.println("端口："+url.getPort());
		System.out.println("资源："+url.getFile());
		System.out.println("相对路径的资源："+url.getPath());//用得比较多
		System.out.println("緢点："+url.getRef());//緢点    bb?uname=liguodong
		System.out.println("参数："+url.getQuery());//参数:存在緢点返回null，不存在，返回正确
				
		url = new URL("http://www.baidu.com:80/a/");
		url = new URL(url,"b.txt");
		System.out.println(url.toString());
		
	}
}
