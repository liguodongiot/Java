package Threadstate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep：指定的毫秒数内让当前正在执行的线程**休眠**（暂停执行），不会释放锁。
 * 倒计时
 * 1、倒数十个数，1秒内打印一个
 * 2、倒计时
 */
public class Demo04 {
	public static void main(String[] args) throws InterruptedException
	{		
		//test01();
		test02();	
	}	
	//倒数十个数，1秒内打印一个
	public static void test01() throws InterruptedException
	{
		int num = 10;
		while(true)
		{
			System.out.println(num--);
			Thread.sleep(1000);//暂停
			if(num<=0)
			{
				break;
			}
		}
	}
	
	//倒计时
	public static void test02() throws InterruptedException
	{
		//new Date()当前时间   System.currentTimeMillis()也表示当前时间
		Date endTime = new Date(System.currentTimeMillis()+10*1000);//当前时间往后10秒
		long end = endTime.getTime();//获取结束时间的长整型
		while(true)
		{
			//输出
			System.out.println(new SimpleDateFormat("HH:mm:ss").format(endTime));
			//构建下一秒的时间
			endTime = new Date(endTime.getTime()-1000);//减一秒  endTime依次递减
			//等待1秒
			Thread.sleep(1000);//暂停
			//10秒以内继续   否则退出 end-10000当前时间  
			if(end-10000>endTime.getTime())
			{
				break;
			}
		}	
	}		
}
