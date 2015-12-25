package Threadsyn;

/**
 * 单例设计模式：确保一个类只有一个对象
 */
public class Demo02 {
	public static void main(String[] args) {
		Jvm jvm1 = Jvm.getInstance();
		Jvm jvm2 = Jvm.getInstance();	
		//单线程jvm1与jvm2地址一样，如果是多线程可能就不一样了，存在延时。
		System.out.println(jvm1);
		System.out.println(jvm2);
		System.out.println("------------");
		JvmThread thread1 = new JvmThread(2000);
		JvmThread thread2 = new JvmThread(2000);
		thread1.start();
		thread2.start();
	}
}
class JvmThread extends Thread{
	private long time;
	public JvmThread() {
	}	
	public JvmThread(long time) {
		this.time = time;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()
				+"-->创建："+Jvm.getInstance1(time));
	}
}

/**
 * 单例设计模式
 * 确保一个类只有一个对象
 * 懒汉式  双重检查
 * 1、构造器私有化，避免外部直接创建对象
 * 2、声明一个私有的静态变量
 * 3、创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象。
 */
class Jvm
{
	//声明一个私有的静态变量  
	private static Jvm instance = null;

	//构造器私有化，避免外部直接创建对象
	private Jvm(){		
	}
	
	//创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
	public static Jvm getInstance()
	{
		if(null==instance){
			instance = new Jvm();	
		}
		return instance;
	}
		
	//用多线程是访问的地址可能不一样  没有同步不需要等待，可能发生错误。
	public static Jvm getInstance1(long time)
	{
		if(null==instance){
			try {
				Thread.sleep(time);//延时，放大错误发生的概率
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();	
		}
		return instance;
	}
	
	//创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
	//同步方法，这样就可以避免错误。
	public static synchronized Jvm getInstance2(long time)
	{
		if(null==instance)
		{
			try {
				Thread.sleep(time);//延时，放大错误发生的概率
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();	
		}
		return instance;
	}
	
	//创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
	public static Jvm getInstance3(long time)
	{
		//a b -->效率不高  c 存在对象也需要等待（同getInstance2方法效率差不多）
		synchronized(Jvm.class)
		{
			if(null==instance)
			{
				try {
					Thread.sleep(time);//延时，放大错误发生的概率
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new Jvm();			
			}
		}		
		return instance;
	}
	
	//创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
	public static Jvm getInstance4(long time)
	{
		//c d e -->提高效率  提供已经存在对象的访问效率
		if(null==instance)
		{
			//a b
			synchronized (Jvm.class) { //第一个创建了，之后以后就可以直接使用。
				if(null==instance){
					try {
						Thread.sleep(time);//延时，放大错误发生的概率
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new Jvm();
				}
			}			
		}	
		return instance;
	}

}


