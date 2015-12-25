package ThreadNet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据线程：用于发送数据
 */
public class Send implements Runnable{
	//控制台的输入流
	private BufferedReader console;
	//管道的数据输出流
	private DataOutputStream dos;
	//控制线程标识
	private boolean isRunning = true;
	
	//初始化
	public Send() {
		console = new BufferedReader(new InputStreamReader(System.in));	
	}
	
	public Send(Socket client)
	{
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
		}
	}
	
	//1、从控制台接收数据
	private String getMsgFromConsole()
	{
		try {
			return console.readLine();
		} catch (IOException e) {
		}
		return "";
	}
	
	/**
	 * 1、从控制台接收数据
	 * 2、发送数据
	 */
	public void send()
	{
		String msg = getMsgFromConsole();
		try {
			if(null!=msg&& !msg.equals(""))
			{
				dos.writeUTF(msg);
				dos.flush();//强制刷新
			}
		} catch (IOException e) {
			 isRunning = false;//发送失败，提示关闭线程
			 CloseUtil.closeAll(dos,console);//如果不能发送成功，直接关闭流。
		}
	}
	
	@Override
	public void run() {
		//线程体
		while(isRunning)
		{
			send();
		}
	}
}
