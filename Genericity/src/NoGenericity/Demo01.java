package NoGenericity;

/**
 * 获取值：
 * 1、强制类型转换
 * 2、手动类型检查：避免转换错误 java.lang.ClassCaseException
 * @author liguodong
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		Object obj=80;
		//JDK6以前   Object-->Integer-->自动拆箱
		int score01 = (Integer)obj;
		
		//JDK7 以后  Object-->Integer-->自动拆箱
		int score02 = (int)obj;
				
		System.out.println("score01:"+score01+"，\nscore02:"+score02+"。");
		
		//存入整数：int-->Integer-->Object
		Student stu = new Student(80,90);
		
		int engScore = (Integer)stu.getEnglishScore();
		
		String mathsScore = null;
		if(stu.getMathsScore() instanceof String){
			mathsScore = (String) stu.getMathsScore();
		}		
		System.out.println("English分数为："+engScore+"，\nMaths分数为："+mathsScore+"。");

	}
}
