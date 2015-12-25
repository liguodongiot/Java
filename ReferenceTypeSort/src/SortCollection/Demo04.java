package SortCollection;

import java.util.TreeMap;

public class Demo04 {
	public static void main(String[] args) {
		Worker w1 = new Worker("垃圾回收员",12000);
		Worker w2 = new Worker("农民工",10000);
		Worker w3 = new Worker("程序员",11000);
		
		TreeMap<Worker,String>  empoyee = new TreeMap<>();
		empoyee.put(w1,"scgalgd");
		empoyee.put(w2,"scgalgd");
		empoyee.put(w3,"scgalgd");
		System.out.println(empoyee.keySet());
	}
}
