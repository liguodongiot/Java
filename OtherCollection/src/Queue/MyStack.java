package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 使用双向队列实现自定义堆栈
 * 1.弹
 * 2.压
 * 3.获取
 */
public class MyStack<E> {
	//容器
	private Deque<E> container  = new ArrayDeque<E>();
	//容量
	private int cap;
	public MyStack(int cap)
	{
		super();
		this.cap = cap;		
	}	
	//压栈
	public boolean push(E e)
	{
		if(container.size()+1>cap)
		{
			return false;
		}
		return container.offerLast(e);
	}	
	//弹栈
	public E pop(){
		return container.pollLast();
	}
	//获取
	public E peek()
	{
		return container.peekLast();
	}
	
	public int size(){
		return this.container.size();
	}
}
