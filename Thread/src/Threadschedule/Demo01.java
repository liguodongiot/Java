package Threadschedule;

/**
 * 了解任务调度
 * Timer()
 * 
 *  运行一次
 * 	schedule(TimerTask task, Date time)   
 * 
 *  起始时间开始执行，以后每个多少秒执行一次。   
 *	schedule(TimerTask task, Date firstTime, long period)
 */
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo01 {
	public static void main(String[] args) {
		Timer timer = new Timer();//计数器
		//schedule(TimerTask task, Date firstTime, long period) 
		timer.schedule(new TimerTask(){	
			int iNum=1;
			@Override
			public void run() {
				
				System.out.println("女神来啦,屌丝"+(iNum++)+"号就位。");
			}
		},
		new Date(System.currentTimeMillis()+1000),
		1000);
	}
}
