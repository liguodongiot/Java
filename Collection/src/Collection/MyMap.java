package Collection;

public class MyMap{
	//Map  HashMap Hashtable	
	MyEntry[] arr = new MyEntry[990];
	int size;	
	
	public void put(Object key,Object value){
		MyEntry entry = new MyEntry(key,value);
		
		for(int i=0; i<size; i++){
			//解决键值重复的处理
			if(arr[i].key.equals(key)){
				arr[i].value = value;
				return;
			}
		}
		arr[size++] = entry;		
	}
	
	public Object get(Object key){
		for(int i=0; i<size; i++){
			if(arr[i].key.equals(key))
			{
				return arr[i].value;
			}
		}
		return null;
	}
	
	public MyEntry remove(Object key){
		for(int i=0; i<size; i++){
			if(arr[i].key.equals(key))
			{
				MyEntry oldValue = arr[i];				
				int numMoved = size - i - 1;
				
				if (numMoved > 0)
				    System.arraycopy(arr, i+1, arr, i,numMoved);				
				arr[--size] = null; // Let gc do its work				
				return oldValue;
			}
		}
		return null;
	}
	
	public boolean containsKey(Object key)	{
		for(int i=0;i<size;i++)
		{
			if(arr[i].key.equals(key))
				return true;
		}
		return false;			
	}
	
	public boolean containsValue(Object value)
	{
		for(int i=0;i<size;i++)
		{
			if(arr[i].value.equals(value))
				return true;
		}
			return false;			
	}
	public int Size(){
		return size;
	}
	public static void main(String[] args) {
		MyMap map = new MyMap();
		map.put("习大大", new Wife("彭麻麻"));
		map.put("灰太狼", new Wife("红太狼"));
		map.put("猪八戒", "嫦娥");
		MyEntry entry = map.remove("猪八戒");		
		System.out.println(map.Size());
		System.out.println(entry.key+" "+entry.value);
	}
}

//键值对
class MyEntry{
	Object key;
	Object value;
	public MyEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}	
}
