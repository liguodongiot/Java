package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo02 {
	public static void main(String[] args) {
		List<Goods> list = new ArrayList<>();
		list.add(new Goods("彩色祥云",1000,2000));
		list.add(new Goods("天使嫁衣",1050,1000));
		list.add(new Goods("坠痕流星",103,500));
		System.out.println("排序前:\n"+list);
		//Collections.sort(list,new GoodPriceComp());
		Collections.sort(list,new GoodsFavComp());
		System.out.println("排序后:\n"+list);
	}
}
