package SortCollection;


import java.util.TreeSet;

public class Demo02 {
	public static void main(String[] args) {
		Worker w1 = new Worker("垃圾回收员",12000);
		Worker w2 = new Worker("农民工",10000);
		Worker w3 = new Worker("程序员",11000);
		
		TreeSet<Worker>  empoyee = new TreeSet<Worker>();
		empoyee.add(w1);
		empoyee.add(w2);
		empoyee.add(w3);
		System.out.println(empoyee);
	}
}

