package Threadsyn;

/**
 * 模拟死锁
 * 过多的同步方法可能造成死锁 
 * 一个把商品的资源获取了，一个把钱的资源获取了
 */

public class Demo03 {
	public static void main(String[] args)
	{
		//同一份资源，不同的线程
		Object g = new Object();
		Object m = new Object();
		
		//一手给钱
		Test1 t1 = new Test1(g,m);
		//多态不能使用新增方法
		//Runnable proxy = new Thread(t1);
		Thread proxy = new Thread(t1);
		proxy.start();
		
		//一手给货
		Test2  t2 = new Test2(g,m);
		Thread proxy2 = new Thread(t2);
		proxy2.start();
	}	
}

class Test1 implements Runnable
{
	Object goods ;
	Object money ;
	
	public Test1(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	
	@Override
	public void run() {
		while(true)
		{
			test();
		}
	}
	
	public void test()
	{
		synchronized (goods) {
			try {
				Thread.sleep(500);//延时，加大发生错误的可能性。
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(money){	
			}	
		}
		System.out.println("一手给货");
	}
}


class Test2 implements Runnable
{
	Object goods ;
	Object money ;
	
	public Test2(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	@Override
	public void run() {
		while(true)
		{
			test();
		}
	}
	
	public void test()
	{
		synchronized (money) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(goods)
			{		
			}		
		}
		System.out.println("一手给钱");
	}
}
