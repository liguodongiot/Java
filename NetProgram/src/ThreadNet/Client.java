package ThreadNet;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端：发送数据+接收数据
 * 写出数据：输出流
 * 读取数据：输入流
 * 输入流与输出流在同一个线程内 应该独立出来
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",9999);
		new Thread(new Send(client)).start();//一条路径
		new Thread(new Receive(client)).start();//一条路径	
	}
}
