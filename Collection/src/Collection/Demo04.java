package Collection;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Demo04 {
	public static void main(String[] args) {
		Hero hero1 = new Hero(1001,"九尾狐",3150,"请宠爱我吧","2012-10");
		Hero hero2 = new Hero(1002,"探险家",4800,"是时候表演真正的技术了","2013-5");
		Hero hero3 = new Hero(1003,"蛮王",1350,"我的大刀早已饥渴难耐","2014-8");
		List list = new ArrayList();
		list.add(hero1);
		list.add(hero2);
		list.add(hero3);
		printHeroName(list);
	}
	public static void printHeroName(List<Hero> list){
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
	}
}
