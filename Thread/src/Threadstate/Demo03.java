package Threadstate;
/**
 * yield：暂停自己的线程   static方法
 * @author liguodong
 *
 */
public class Demo03 extends Thread{
	public static void main(String[] args) {
		Demo03 demo = new Demo03();	
		Thread t  = new Thread(demo);//新生
		t.start();//就绪
		//cpu调度运行		
		for(int i=0; i<1000; i++)
		{
			if(i%20==0)
			{
				//在main线程中，暂停本线程main   
				//本方法写在那个线程体里面就停止那个线程，如果在run里面暂停 Demo03。
				Thread.yield();//静态方法(并没有严格意义上的暂停，可能CPU又调度到它)
			}
			System.out.println("main..."+i);
		}
		
	}	
	@Override
	public void run() {
		for(int i=0; i<1000; i++)
		{	
			System.out.println("yield..."+i);
		}
	}
}
