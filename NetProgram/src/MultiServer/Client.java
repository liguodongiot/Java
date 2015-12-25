package MultiServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


/**
 * 创建客户端：发送数据+接收数据
 * 写出数据：输出流
 * 读取数据：输入流
 * 输入流与输出流在同一个线程内 应该独立出来
 * 加入名称
 */
public class Client {
	public static void main(String[] args) throws IOException
	{
		System.out.println("请输入用户名：");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		if(name.equals(""))
		{
			return;
		}
		Socket client = new Socket("localhost",9999);
		new Thread(new Send(client,name)).start();//一条路径
		new Thread(new Receive(client)).start();//一条路径
		
	}
}

