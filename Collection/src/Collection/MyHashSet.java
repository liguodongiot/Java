package Collection;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class MyHashSet {
	HashMap hashMap;
	// Dummy value to associate with an Object in the backing Map
    private static final Object PRESENT = new Object();

    public MyHashSet() {
		hashMap = new HashMap();
	}
    
    public Boolean add(Object o){
    	return hashMap.put(o, PRESENT)==null;//set的不可重复就是利用了map里面键对象的不可重复！
    }
    
    public boolean remove(Object o) {
        return hashMap.remove(o)==PRESENT;
    }
    
    public void clear() {
    	hashMap.clear();
    }
    public int size() {
        return hashMap.size();
    }
    public static void main(String[] args) {
		MyHashSet myHashSet = new MyHashSet();
		myHashSet.add("大宝");
		myHashSet.add("吃饭");
		myHashSet.add("傻瓜");
		System.out.println(myHashSet.size());
		myHashSet.clear();
		System.out.println(myHashSet.size());
	}
}
