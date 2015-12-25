package Threadinfo;

/**
 * Thread.currendThread()  当前线程
 * setName()   设置名称
 * getName()   获取名称
 * isAlive()   判断状态
 */
@SuppressWarnings("all")
public class Demo01 {
	public static void main(String[] args) throws InterruptedException {
		MyThread it = new MyThread();
		//Thread(Runnable target, String name) 如果不取名字，将是一个自动编号的名称。
		Thread proxy = new Thread(it,"挨踢");//（自定义线程，名字）
		proxy.setName("test");
		
		System.out.println(proxy.getName());//test
		
		//main线程
		System.out.println(Thread.currentThread().getName());
		
		proxy.start();
		System.out.println("启动后的状态："+proxy.isAlive());//true
		
		proxy.sleep(5);
		it.stop();
		proxy.sleep(5);
		System.out.println("停止后的状态："+proxy.isAlive());//false
	}
}
