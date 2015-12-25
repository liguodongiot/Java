package Threadsyn;

public class Demo01 {
	public static void main(String[] args) {
		//真实角色
		Web12306 web = new Web12306();
		//代理
		Thread t1 = new Thread(web,"111");
		Thread t2 = new Thread(web,"222");
		Thread t3 = new Thread(web,"333");
		//启动线程
		t1.start();
		t2.start();
		t3.start();
	}
}

class Web12306 implements Runnable{
	private int num = 20;
	private boolean flag = true;
	
	@Override
	public void run() {
		while(flag)
		{
			test5();
		}
	}	
	
	//线程不安全
	public void test1()
	{
		if(num<=0)
		{
			flag = false;//跳出循环
			return;
		}
		try {
			Thread.sleep(500);//模拟延时
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"抢到了"+num--);		
	}
	
	//线程安全（效率降低了） 只能被一个线程进行访问
	public synchronized void test2()
	{
		if(num<=0)
		{
			flag = false;//跳出循环
			return;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
	}
	
	//线程安全 锁定正确
	public void test3()
	{
		//a   b   c
		synchronized (this) {
			if(num<=0)
			{
				flag = false;//跳出循环
				return;
			}
			try {
				Thread.sleep(500);//模拟延时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了"+num--);			
		}
	}
	
	//线程安全 锁定范围（过小）不正确  可能出现问题
	public void test4()
	{
		//a   b   c
		synchronized (this) {
			if(num<=0)
			{
				flag = false;//跳出循环
				return;
			}
		}
		try {
			Thread.sleep(500);//模拟延时
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"抢到了"+num--);	
	}

	//线程不安全 锁定资源不正确
	public void test5()
	{
		//a   b   c
		synchronized ((Integer)num) {
			if(num<=0)
			{
				flag = false;//跳出循环
				return;
			}
			try {
				Thread.sleep(500);//模拟延时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了"+num--);			
		}	
	}
	//线程安全 锁定不正确
	public void test6()
	{	
		if(num<=0)
		{
			flag = false;//跳出循环
			return;
		}
		//a   b   c
		synchronized (this) {		
			try {
				Thread.sleep(500);//模拟延时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了"+num--);			
		}
	}
}
