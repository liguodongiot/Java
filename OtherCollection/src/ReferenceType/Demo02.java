package ReferenceType;

import java.util.WeakHashMap;
/**
 * WeakHashMap 键为弱引用，gc运行立即回收。
 * @author liguodong
 *
 */
public class Demo02 {
	
	public static void main(String[] args) {
		WeakHashMap<String,String>  map = new WeakHashMap<String,String>();	
		//测试数据
		//常量池对象，不会回收
		map.put("abc","a");
		map.put("d","test");
		//gc运行, 已被回收
		map.put(new String("coco"), "c");
		map.put(new String("dfg"), "dx");
		//通知回收
		System.gc();
		System.runFinalization();
		System.out.println("gc运行后："+map.size());
	}
}

