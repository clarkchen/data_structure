package Search.BinarySearch;

import java.util.Random;

import Sort.base.SqlList;

public class tempHS {
	
	void swap(int[]a,int i,int j )
	{
		a[i] = a[i] + a[j]; 
		a[j] = a[i]-a[j];
		a[i] = a[i]-a[j];
	}
	//adjust from s to e-1
	void heapAdjust(int[]a, int s, int e)
	{
		int cur = s;
		while(cur<e)
		{
			int temp = 2*cur+1;
			if(temp>=e) break;
			if(temp+1<e && a[temp+1]>a[temp]) temp++;
			if(a[cur] < a[temp]) swap(a,cur,temp);
			cur = temp;
		}
	}
	//sort 0 to len-1
	//最大堆排序
	public void sort(int []a )
	{
		for(int i =a.length/2;i>=0;i--)
		{
			heapAdjust(a, i, a.length);
		}
		 
		for(int i =a.length-1;i>0;i--)
		{
			swap(a,0,i);
			heapAdjust(a, 0, i);
			 
		}
		
	}
	public int[] init(int count)
	{
		int []a = new int[count];
		Random rand = new Random();
		for(int i=0;i<count;i++)
		{
			a[i] = rand.nextInt(99)+1;
		}
		return a;
	}
	public void showList(int[]a)
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+"  ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count =10;
		tempHS ths = new tempHS();
		int [] a= ths.init(count);
		ths.showList(a);
		ths.sort(a);
		ths.showList(a);

	}

}
