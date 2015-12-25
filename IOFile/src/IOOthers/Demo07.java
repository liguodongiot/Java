package IOOthers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *三个常量
 *1、System.in   输入流  键盘输入
 *2、System.out  输出流  标准输出
 *3、System.err  
 *   
 *  ==>重定向
 *  setIn()
 *  setOut()
 *  setErr()
 *  static FileDescriptor in  输入
 *  static FileDescriptor out  输出
 */
@SuppressWarnings("all")
public class Demo07 {
	public static void main(String[] args) throws FileNotFoundException {
		test1();
		System.out.println("=====@@@=====");
		test2();
		System.out.println("=====@@@=====");		
		test3();
		
	}
	
	public static void test1()
	{
		System.out.println("test");
		System.err.println("err");
	}
	
	//不再使用控制台输入，而是从文件中获取
	public static void test2() throws FileNotFoundException
	{
		InputStream is = System.in;//键盘输入
		is = new BufferedInputStream(new FileInputStream("g:/try/test.txt"));
		Scanner sc = new Scanner(is);
		System.out.println("从文件中读取：");
		//System.out.println(sc.nextLine());//注意这只是读取了一行
		while(sc.hasNextLine())
		{
			System.out.println(sc.nextLine());
		}
	}
	
	public static void test3() throws FileNotFoundException
	{
		//重定向 到文件中 
		//PrintStream(OutputStream out, boolean autoFlush)  
		//创建新的打印流，后面一个形参,true表示自动flush到文件中,而不需要手动flush
		System.setOut(new PrintStream(new BufferedOutputStream(
				new FileOutputStream("g:/try/print.txt")),true));
		System.out.println("file--a");//控制台到文件
		System.out.println("file--test");
		//重定向回控制台  要加true  将流flush出去     FileDescriptor不能直接使用
		System.setOut(new PrintStream(new BufferedOutputStream(
				new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("console--test");
	}
}
