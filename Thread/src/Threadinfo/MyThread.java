package Threadinfo;

public class MyThread implements Runnable{
	private boolean flag = true;
	private int num = 0;
	@Override
	public void run() {
		while(flag)
		{
			System.out.println(Thread.currentThread().getName()+"-->"+num++);
		}
	}
	
	public void stop()
	{
		this.flag = !this.flag;
	}
}
