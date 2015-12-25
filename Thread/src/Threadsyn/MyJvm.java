package Threadsyn;

/**
 * 单例设计模式
 * 确保一个类只有一个对象  //外部只能使用对象，不能创建对象。
 * 懒汉式
 * 1、构造器私有化
 * 2、声明私有的静态属性
 * 3、对外提供访问属性的静态方法，确保该对象存在
 */

public class MyJvm {
	private static MyJvm instance = null;
	private MyJvm(){
	}	
	
	public static MyJvm getInstance()
	{
		if(null==instance)//提高效率
		{
			synchronized (MyJvm.class) {
				if(null==instance)//安全
				{
					instance = new MyJvm();
				}
			}
		}
		return instance;
	}
}

/**
 * 饿汉式
 * 1、构造私有化
 * 2、声明私有的静态属性，同时创建对象
 * 3、对外提供访问属性的静态方法，确保该对象存在
 */
class MyJvm2 {
	private static MyJvm2 instance = new MyJvm2();//类加载时创建
	private MyJvm2(){		
	}
	
	public static MyJvm2 getInstance(){	
		return instance;
	}
}


/**
 * 使用了内部类，类在使用的时候才加载   延缓了加载时间  提高效率
 */
class MyJvm3 {
	
	private MyJvm3(){		
	}
	
	public static MyJvm3 getInstance(){	
		return JVMholder.instance;
	}
	
	private static class JVMholder{
		private static MyJvm3 instance = new MyJvm3();
	}
}

