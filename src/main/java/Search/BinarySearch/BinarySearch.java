package Search.BinarySearch;

import java.util.Scanner;

public class BinarySearch {
	
	int []values = null;
	public  BinarySearch(int []a ) {
			values = a ;
	}
	void show(int i)
	{
		if(i==-1) System.out.println("not found");
		else
		System.out.println("find "+values[i]+ " in position "+i);
	}
	void show(int i, int times)
	{
		if(i==-1) System.out.println("not found");
		else
		System.out.println(times+" times search "+"find "+values[i]+ " in position "+i);
	}
	public void  search(int[]a, int len, int v)
	{
		
		int s,e,mid;
		s=0;e=len-1;
		while(s<=e)
		{
			mid=(e+s)/2;
			if(a[mid] == v) { show(mid); return;}
			else if(a[mid]<v){ s = mid+1;}
			else if(a[mid]>v){ e = mid-1;}
		}
		show(-1);
	}
	
  
	
	
	public void BSearch(int []a)
	{
		Scanner s = new Scanner(System.in);
		while(true){
			System.out.println("请输入要查找的数字");
			int v = s.nextInt();
			if(v<0) break;
			
			search (a,a.length,v);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		tempHS t =new tempHS();
		int [] va = t.init(10);
		t.sort(va);
		t.showList(va);
		
		BinarySearch bs = new BinarySearch(va);
		bs.BSearch(va);
	 

	}
	

}
