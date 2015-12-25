package Thread;

/**
 * 推荐使用Runnable创建线程
 * 1、避免单继承的局限性
 * 2、便于共享资源
 */
public class Demo03 {
	public static void main(String[] args) {
		//1)、创建真实角色
		Programmer pro = new Programmer();
		//2)、创建代理角色+真实角色引用
		Thread proxy = new Thread(pro);				
		//3)、调用start()方法 启动线程
		proxy.start();
		
		for(int i=0;i<100;i++){
			System.out.println("一边聊QQ");
		}
	}
}

/**
 * 使用Runnable 创建进程
 * 1、类实现Runable接口+重写run()方法
 * 2、启动多线程 使用静态代理
 * 		1)、创建真实角色
 * 		2)、创建代理角色
 * 		3)、调用start()方法 启动线程
 */
class Programmer implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("一边敲代码");
		}
	}
}
