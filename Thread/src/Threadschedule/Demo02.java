package Threadschedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo02 implements Runnable {
	private String jobName = "";

	public Demo02(String jobName) {
		super();
		this.jobName = jobName;
	}

	@Override
	public void run() {
		System.out.println("execute " + jobName);
	}

	public static void main(String[] args) {
		//创建一个线程池
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

		long initialDelay1 = 1;
		long period1 = 1;
        // 从现在开始1秒钟之后，每隔1秒钟执行一次job1   时间固定
		service.scheduleAtFixedRate(
		        new Demo02("job1"), initialDelay1,
				period1, TimeUnit.SECONDS);//TimeUnit.SECONDS表示以秒为单位

		long initialDelay2 = 2;
		long delay2 = 2;
        // 从现在开始2秒钟之后，每隔2秒钟执行一次job2   时间不固定
		service.scheduleWithFixedDelay(
		        new Demo02("job2"), initialDelay2,
				delay2, TimeUnit.SECONDS);
	}
}