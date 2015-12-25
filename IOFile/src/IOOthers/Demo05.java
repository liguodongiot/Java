package IOOthers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 * 不是所有的`对象`都可以序列化，必须实现java.io.Serializable接口。
 * 不是所有的`属性`都需要序列化，不需要使用序列化的属性使用transient。
 * @author liguodong
 */

public class Demo05 {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			seri("g:/try/ser.txt");
			readseri("g:/try/ser.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//序列化
	public static void seri(String destPath) 
			throws FileNotFoundException, IOException
	{
		Employee emp = new Employee("Mark",1000000);
		int[] arr = {1,2,4,32};// 数组对象，它的内部就可以进行序列化。
		//创建源
		File dest = new File(destPath);
		//选择源DataOutputStream
		ObjectOutputStream dos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(dest)));	
		//操作写出的顺序 为读写准备		
		dos.writeObject(emp);
		dos.writeObject(arr);
		//释放资源
		dos.close();
		
	}	
	
	//反序列化
	public static void readseri(String destPath) 
			throws FileNotFoundException, IOException, ClassNotFoundException
	{
		//1、创建院
		File src = new File(destPath);		
		//2、选择流
		ObjectInputStream dis = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(src)));
		//3、读取
		Object obj = dis.readObject();
		if(obj instanceof Employee)
		{
			Employee emp= (Employee)obj;
			System.out.println(emp.getName()+"-->"+emp.getSalary());
		}
		
		obj = dis.readObject();		
		int[] arr = (int [])obj;
		System.out.println(Arrays.toString(arr));
		//4、释放资源
		dis.close();
	}
}
