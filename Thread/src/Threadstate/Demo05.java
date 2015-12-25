package Threadstate;

/**
 * sleep模拟网络延时  线程不安全的类   结果可能不准确
 */
public class Demo05 {
	public static void main(String[] args) {
		//真实角色
		Web12306 web = new Web12306();
		//代理
		Thread t1 = new Thread(web,"德玛西亚");
		Thread t2 = new Thread(web,"卡特琳娜");
		Thread t3 = new Thread(web,"德邦总管");
		//启动线程
		t1.start();
		t2.start();
		t3.start();
	}
}

class Web12306 implements Runnable{
	private int num = 50;
	@Override
	public void run() {
		while(true)
		{
			if(num<=0)
			{
				break;//跳出循环
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了倒数第"+num--+"张");			
		}
	}
}
