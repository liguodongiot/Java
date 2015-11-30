package Collection;

/**
 * 自己写一个链表
 * @author liguodong
 *
 */
public class MyLinkedList
{
	/**
	 * 用来表示一个节点
	 */
	private static class Node {
		Node previous;//上一个节点
		Object obj;
		Node next;//下一个节点
		public Node getPrevious() {
			return previous;
		}
		public void setPrevious(Node previous) {
			this.previous = previous;
		}
		public Object getObj() {
			return obj;
		}
		public void setObj(Object obj) {
			this.obj = obj;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node() {
			super();
		}	
	}
	
	private Node first;
	private Node last;
	private int size;
	
	//新增一个元素
	public void add(Object obj)
	{
		Node node = new Node();
		if(first == null)
		{
			node.setPrevious(null);
			node.setObj(obj);
			node.setNext(null);
			
			first = node;
			last = node;
		}
		else {
			//直接往last后新增新的节点			
			node.setPrevious(last);
			node.setObj(obj);
			node.setNext(null);
			
			last.setNext(node);
			last = node;
		}
		size++;
	}
	
	public int size()
	{
		return size;
	}
	
	//判断是否合法
	private void rangeCheck(int index)
	{
		if(index>=size)
		{
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
	
	public Object get(int index)
	{
		rangeCheck(index);//判断是否合法		
		Node temp=iteratorNode(index);//遍历到指定节点
		if(temp != null){
			return temp.getObj();
		}
		return null;
		
	}
	
	//遍历到指定节点
	public Node iteratorNode(int index)
	{
		Node tempNode = null;
		if(first != null){
			tempNode = first; //先指到链表头，很重要。
			for(int i=0;i<index;i++)
			{
				tempNode  = tempNode.getNext();
			}				
		}
		return tempNode;
	}
	
	//移除索引位置的对象
	public Object remove(int index)
	{
		Node tempNode =iteratorNode(index);		
		if(tempNode != null)
		{
			Node up = tempNode.getPrevious();//tempNode.previous
			Node down = tempNode.getNext();//tempNode.next
			up.setNext(down);//up.next = down
			down.setPrevious(up);//down.previous = up;					
		}
		size--;
		return true;
	}
		
	public void add(int index,Object obj)
	{
		Node tempNode = iteratorNode(index);//指定位置节点
		
		Node newNode = new Node();//新节点
		newNode.setObj(obj);//newNode.obj = obj;
		if(tempNode != null)
		{
			//上一个节点
			Node upNode = tempNode.getPrevious();//tempNode.previous;
			
			upNode.setNext(newNode);//upNode.next = newNode;
			newNode.setPrevious(upNode);//newNode.previous = upNode;
			
			newNode.setNext(tempNode);//newNode.next = tempNode;
			tempNode.setPrevious(newNode);//tempNode.previous = newNode;
			size++;
		}
	}
	
	public void set(int index,Object obj)
	{
		Node tempNode = iteratorNode(index);
		tempNode.setObj(obj);//tempNode.obj = obj;
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add("探险家");
		list.add("齐天大圣");
		list.add("风暴之怒");
		list.add(1,"德玛西亚皇子");
		list.set(3, "盲僧");
		System.out.println(list.get(1));
		System.out.println(list.size());
		//System.out.println(list.remove(1));
		for(int i=0;i<list.size();i++)			
			System.out.println(list.get(i));
	}	
}












