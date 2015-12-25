package MultiServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 接收线程：用于接收数据
 */
public class Receive implements Runnable{
	//管道的数据输入流
	private DataInputStream dis ;
	//线程标识
	private boolean isRunning = true;
	
	public Receive()	{	
	}	
	public Receive(Socket client) {
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
	}
	
	//接收数据的方法
	public String receive()
	{
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
		return msg;
	}
	
	@Override
	public void run() {
		//线程体
		while(isRunning){
			System.out.println(receive());
		}	
	}
}
