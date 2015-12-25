package CSNet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 */
@SuppressWarnings("all")
public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		Socket client = server.accept();

		//写出数据
		//输入流
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		System.out.println("服务器收到"+msg);
		
		//输出流
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("服务器发送给客户端"+msg);
		dos.flush();				
	}
}
