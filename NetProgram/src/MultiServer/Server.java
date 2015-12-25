package MultiServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器
 */
public class Server {
	private List<MyChannel> all = new ArrayList<>();
	
	public static void main(String[] args) throws IOException  {	
		new Server().start();
				
	}
	
	public void start() throws IOException
	{	
		ServerSocket server = new ServerSocket(9999);	
		while(true)
		{
			Socket client = server.accept();
			MyChannel channel = new MyChannel(client);
			all.add(channel);//统一管理
			new Thread(channel).start();//一条道路
		}
	}
	
	/**
	 * 内部类
	 * 一个客户端 一条道路
	 * 1、输入流
	 * 2、输出流
	 * 3、接收数据
	 * 4、发送数据
	 * @author Administrator
	 *
	 */
	class MyChannel implements Runnable
	{
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning = true;
		private String name;
		
		public MyChannel() {	
		}
		//初始化
		public MyChannel(Socket client)
		{
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				
				this.name = dis.readUTF();
				//System.out.println(this.name);
				this.send("欢迎进入聊天室");
				
				sendOthers(this.name+"进入了聊天室",true);			
			} catch (IOException e) {
				CloseUtil.closeAll(dos,dis);
				isRunning = false;
			}
		}
		
		//接收数据
		private String receive()
		{
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				CloseUtil.closeAll(dis);
				isRunning = false;
				all.remove(this);//移除自身
			}
			return msg;
			
		}
		
		//发送数据
		private void send(String msg)
		{
			if(null==msg||msg.equals(""))
			{
				return;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				CloseUtil.closeAll(dos);
				isRunning = false;
				all.remove(this);//移除自身 
			}
		}
		
		//发送给其他客户端
		private void sendOthers(String msg,boolean sys)
		{
			//是否为私聊  约定
			if(msg.startsWith("@")&& msg.indexOf(":")>-1)
			{
				//获取name
				String name = msg.substring(1,msg.indexOf(":"));
				String contant = msg.substring(msg.indexOf(":")+1);
				for(MyChannel other:all)
				{
					if(other.name.equals(name))
					{
						other.send(this.name+"对你悄悄的说："+contant);
					}
				}
			}
			else {
				for(MyChannel other:all)
				{
					if(other ==this)
					{
						continue;
					}
					
					if(sys==true)//系统信息
					{
						other.send("系统信息："+msg);
					}
					else {
						//发送其它客户端
						other.send(this.name+"对所有人说"+msg);
					}
					
				}
			}
			/*
			//遍历容器
			for(MyChannel others:all)
			{
				if(others == this)
				{
					continue;
				}
				//发送给其他客户端
				others.send(msg);
			}*/
				
		}
		
		@Override
		public void run() {
			while(isRunning)
			{
				sendOthers(receive(),false);
			}
		}
	}
	
}
