package Threadprocon;

/**
 * 一个场景，共同的资源 
 * 生产者消费者模式 信号灯法
 * wait()： 等待     释放锁  
 * sleep：休眠   不释放锁
 * notify()/notifyAll()：唤醒
 *  notify、wait要与synchronized一起使用才起作用
 */

public class Movie {
	private String pic;
	//信号灯
	//flag-->T 生产者生产，消费等待，生产完成后，通知消费
	//flag-->F 消费者消费，生产者等待，消费完后，通知生产
	private boolean flag = true;
	
	/**
	 * 播放
	 * @param pic
	 */
	public synchronized void play(String pic)
	{
		if(!flag)//生产者等待
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		//开始生产
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//生产完毕
		this.pic = pic;
		System.out.println("生产电影:"+pic);
		//通知消费
		this.notify();
		//生产者停下
		this.flag = false;
	}

	public synchronized void watch()
	{
		if(flag)//消费者等待
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始消费
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("看电影:"+pic);
		//消费完毕
		//通知生产
		this.notify();
		//消费停止
		this.flag = true;
	}
}
