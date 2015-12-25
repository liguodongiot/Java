package Thread;

/**
 * 静态代理设计模式
 * 1、真实角色
 * 2、代理角色  持有真实角色的引用
 * 3、二者要实现相同的接口
 */
public class Demo02 {
	public static void main(String[] args) {
		//创建真实角色
		You you = new You();
		//创建代理角色 + 加入真实角色的引用
		WeddingCompany company = new WeddingCompany(you);//
		//执行任务
		company.marry();	
	}	
}

//接口
interface Marry
{
	public abstract void marry();
}

//真实角色
class You implements Marry{
	@Override
	public void marry() {
		System.out.println("今天你要嫁给我。。。");
	}	
}

//代理角色
class WeddingCompany implements Marry{
	private Marry you;
	
	public WeddingCompany() {
	}
	public WeddingCompany(Marry you) {
		super();
		this.you = you;//使用真实角色对其初始化
	}
	private void before(){
		System.out.println("婚前布置会场");
	}	
	
	private void after(){
		System.out.println("婚后打扫清洁");
	}	
	
	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}	
}
