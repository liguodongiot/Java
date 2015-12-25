package Threadstate;

/**
 * 线程阻塞： join合并线程   
 */
public class Demo02 extends Thread{
	
	@Override
	public void run() {
		for(int i=0;i<100;i++)
		{
				System.out.println("join..."+i);			
		}	
	}	
	public static void main(String[] args) throws InterruptedException {
		
		Demo02 demo = new Demo02();
		Thread t = new Thread(demo);//新生
		t.start();//就绪
		//cpu调度运行		
		for(int i=0;i<100;i++)
		{
			if(50==i)
			{
				t.join();//main阻塞
			}
			System.out.println("main..."+i);				
		}
	}
}
