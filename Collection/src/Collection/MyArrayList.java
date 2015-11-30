package Collection;

/**
 * 自己实现ArrayList
 * @author liguodong
 *
 */
public class MyArrayList {
	private Object[] elementData;
	private int size;
	
	public int size(){
		return size;
	}
	
	public MyArrayList(){
		this(10);
	}
	
	public MyArrayList(int initialCapacity)	{
		if(initialCapacity<0)
		{
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		elementData = new Object[initialCapacity];
	}
	//实现数组扩容和数据的拷贝
	public boolean add(Object obj)	{
		if(size>=elementData.length)//如果size大于初始的大小，进行扩容
		{
			Object[] newArray = new Object[size*2+1];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}   
		elementData[size] = obj;
		size++;
		return true;
	}
	 

	
	public boolean isEmpty()	{
		return size==0;
	}
	
	public Object get(int index)	{
		rangeCheck(index); 
		return elementData[index];
	}	
	
	//移除指定位置的对象	
	public Object remove(int index) {	
		rangeCheck(index); 
		
		Object oldValue = elementData[index];
		
		int numMoved = size - index - 1;
		
		if (numMoved > 0)
		    System.arraycopy(elementData, index+1, elementData, index,
		                     numMoved);
		elementData[--size] = null; // Let gc do its work
		
		return oldValue;
	}
	
	private void rangeCheck(int index) 
	{
		if(index>=size){
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }
 
    private void fastRemove(int index) {
   	
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null; // Let gc do its work
    }

	
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(3);
		list.add("324");
		list.add("343");
		list.add("3dsaf4");
		list.add("3432");
		list.add("3432");
		System.out.println(list.size());
		System.out.println(list.get(3));//第四个数据
		list.remove(2);//第三个数据
		System.out.println(list.size());
		System.out.println("----------");
		list.remove(new String("3432"));
		String string;		
		for(int i=0;i<list.size();i++)
		{
			string=(String) list.get(i).toString();
			System.out.println(string);
		}
	}
}


	

