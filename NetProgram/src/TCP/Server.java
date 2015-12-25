package TCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 必须先启动再连接
 * 1、创建服务器 指定端口 ServerSocket(int port)
 * 2、接收客户端的连接  阻塞式
 * 3、发送数据+接收数据
 */
public class Server {
	public static void main(String[] args) throws IOException {
		//1、创建服务器 指定端口
		ServerSocket server = new ServerSocket(8888);//不同协议端口可以重复，同一协议端口不能重复
		//2、接收客户端的连接
		Socket socket = server.accept();//这里会等待连接
		System.out.println("一个客户端建立连接");
		
		//2、发送数据
		String msg = "欢迎使用";
		//3、输出流
		/*BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream()));
		bw.write(msg);
		bw.newLine();//一定要加行结束符，不然读不到数据
		bw.flush();*/
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();		
	}
}
