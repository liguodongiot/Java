package innerType;

import java.util.ArrayList;
import java.util.List;

public class Demo04 {
	public static void main(String[] args) {
		/**
		 * 使用Compatator数组排序
		 */
		String[] arr = new String[] {"a","abcd","abc","def"};
		Utils02.BubbleSort(arr,new StringComp());
		
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("abcd");
		list.add("abbd");
		list.add("def");
		Utils02.BubbleSort(list,new StringComp());
	}
}
