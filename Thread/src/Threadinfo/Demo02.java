package Threadinfo;

/**
 * 优先级：代表概率，不是绝对的优先级，不代表绝对的先后顺序
 * MAX_PRIORITY   10
 * NORM_PRIORITY  5(默认)
 * MIN_PRIORITY  1
 * setPriority()设置优先级
 * getPriority()
 */
public class Demo02 {
	public static void main(String[] args) throws InterruptedException {
		MyThread it1 = new MyThread();
		Thread p1 = new Thread(it1,"挨踢1");//（自定义线程，名字）
		MyThread it2 = new MyThread();
		Thread p2 = new Thread(it2,"挨踢2");//（自定义线程，名字）
		//没有设置优先级就是普通（默认）优先级
		p1.setPriority(Thread.MIN_PRIORITY);//设置优先级
		p2.setPriority(Thread.MAX_PRIORITY);
		p1.start();
		p2.start(); 
		Thread.sleep(100);
		it1.stop();
		it2.stop();  
	}
}
