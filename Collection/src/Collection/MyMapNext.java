package Collection;

import java.util.LinkedList;

/**
 *  升级版
 *	提高查询效率 
 */
@SuppressWarnings("all")
public class MyMapNext{
	LinkedList[] arr = new LinkedList[999];//Map的底层实现是数组+链表
	int size;
	
	public void put(Object key,Object value)
	{
		MyEntry e = new MyEntry(key, value);//键值对		
		int a = key.hashCode()%arr.length;
		
		if(arr[a] == null){
			LinkedList list = new LinkedList();
			//将链表放进数组里面
			arr[a] = list;
			list.add(e);
			size++;
		}
		else{
			LinkedList list = arr[a];
			
			for(int i=0;i<list.size();i++)
			{
				MyEntry entry = (MyEntry) list.get(i);
				if(entry.key.equals(key))
				{
					entry.value = value;//键值重复直接覆盖
				}
			}			
			arr[a].add(e);
		}	
		
	}	
	public Object get(Object key)
	{
		int a = key.hashCode()%arr.length;
		
		if(arr[a] != null)
		{
			LinkedList list = arr[a];
			for(int i=0;i<list.size();i++)
			{
				MyEntry entry = (MyEntry) list.get(i);
				if(entry.key.equals(key))
				{
					return entry.value;
				}
			}
		}
		else{
			size--;
		}
		
		return null;
	}
	public int Size(){
		return size;
	}
	public static void main(String[] args) {
		MyMapNext map = new MyMapNext();
		map.put("习大大", new Wife("彭麻麻"));
		map.put("灰太狼", new Wife("红太狼"));
		map.put("猪八戒", "嫦娥");
		System.out.println(map.Size());
		Wife wife = (Wife)map.get("灰太狼");
		System.out.println(wife.name);
	}
}
