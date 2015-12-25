package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
/**
 * 模拟银行排队情况
 * @author liguodong
 */
public class Demo01 {
	public static void main(String[] args) {
		Queue<Request> que = new ArrayDeque<>();		
		for(int i=0;i<10;i++)
		{
			final int num = i;//每次进行这个循环时num都会重新被声明。
			que.offer(new Request() {	
				@Override
				public void deposit() {
					//匿名内部类只能访问final修饰的对象
					System.out.println("第"+num+"个人，办理存款业务，存款额度为"+(Math.random()*10000));
				}
			});
		}
		dealWith(que);
	}
	
	//处理业务
	public static void dealWith(Queue<Request> que)
	{
		Request req = null;
		while(null!=(req=que.poll()))
		{
			req.deposit();
		}
	}
}

interface Request
{
	//存款
	void deposit();	
}
