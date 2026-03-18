package Search.Hash;

public class HashList {
	ValuePoint []value;
	int count=0;
	int capacity;
	public HashList(int capacity)
	{
		value = new ValuePoint[capacity];
		this.capacity = capacity;
		this.init();
	}
	public HashList()
	{
		this.capacity = 1000;
		value =  new ValuePoint[this.capacity];
		this.init();
	}
	public void init()
	{
		for(int i = 0;i<value.length;i++)
		{
			value[i] = new ValuePoint();
		}
	}
	
	
	public Boolean isFull()
	{
		return capacity == count;
	}
	Boolean isEmpty(int k )
	{
		if(k>capacity) k = index(k);
		return this.value[k].isEmpty();
	}
	int index(int key){return key%capacity;}
	 int getEmptyIndex(int key)
	{
		if(isEmpty(index(key))) return index(key);
		return getEmptyIndex(index(key+1));
	}
	
	public void set(ValuePoint vp ){
		this.set(vp.key,vp.value);
	}
	
	public void set(int key ,int value)
	{
		int i = getIndex(key);
		if(isFull() && i ==-1) {
			System.out.println("Full Capacity "); return ;
		}
		if(i==-1) {
			this.value[getEmptyIndex(key)].set(key, value);
			count++;
		}
		else 
		{
			this.value[i].set(key, value);
		}
		
	}
	
	int  getIndex(int key)
	{
		if(this.value[index(key)].key== key ) 
			return index(key);
		
		for(int i =1 ;i < capacity;i++)
		{
			
			if(this.value[index(key+i)].key==key)
				return index(key+i);
		}
		
		return -1;
	}
	
	public ValuePoint get(int key )
	{	
		int i = getIndex(key);
		if(i>-1)  return this.value[i];
		System.out.println("not found");
		return null;
	}
	
	public void remove(int key)
	{
		int i = getIndex(key);
		if(i>-1) {
			this.value[i].reset();
			count--;
			return ;
		}
		System.out.println("not found");

	}
	public void Print()
	{
		System.out.println("Start"+ count);
		for(int i = 0;i<capacity;i++)
		{
			if(isEmpty(i)) System.out.print("empty ");
			else System.out.print(this.value[i].key+" ");
		}
		System.out.println();
		for(int i = 0;i<capacity;i++)
		{
			if(isEmpty(i)) System.out.print("empty ");
			else System.out.print(this.value[i].value+" ");
		}
		System.out.println("\nEnd");
	}
	public static void main(String[]args)
	{
		HashList hl = new HashList(5);
		
		ValuePoint v1 = new ValuePoint(20, 8);
		ValuePoint v2 = new ValuePoint(31, 9);
		ValuePoint v3 = new ValuePoint(41, 10);
		ValuePoint v4 = new ValuePoint(84, 12);
		ValuePoint v5 = new ValuePoint(90, 11);
		
		hl.set(v1);
		hl.set(v2);
		hl.set(v3);
		hl.set(v4);
		
		hl.Print();
		
		hl.set(v5);
		
		hl.Print();
		
		hl.set(90,hl.get(90).value+1);
		hl.Print();
		
		hl.get(10010);

		
		hl.remove(41);
		hl.Print();
		hl.remove(51);
	}
}
