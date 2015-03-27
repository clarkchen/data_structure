package Sort.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import Sort.base.SqlList;

//基数排序
public class RadixSort {
	//假设最高就是两位数
	int rMost =2;
	int [][] rtValue;
	int [] index = new int[10];;
	public void sort(SqlList sl)
	{
		
		rMost = getMaxRadix(sl);
		
		rtValue = new int [10][100];
		
		
		for(int i=0;i<rMost;i++)
		{
			this.PutIntoBucket(sl,i+1);
			this.CollectFromBucket(sl, i+1);
		}
	}
	//获取最大值的位数
	private int getMaxRadix(SqlList sl)
	{
		int max= 0;
		for (int i=0;i<sl.length;i++)
		{
			if(max<sl.r[i]) max = sl.r[i];
		}
		int r =0;
		while(max!=0)
		{
			max = max/10;
			r++;
		}
		return r;
	}
	//获取 v 的 r 位
	private int getValue(int v,int r)
	{
		for(int i=1;i<r;i++)
		{
			v /= 10;
		}
		v = v % 10;
		return v;
		
	}
	
	public void PutIntoBucket(SqlList sl, int r)
	{
		for (int i=0;i<index.length;i++)
		{
			index[i] = 0;
		}
		for (int i=0;i<sl.length;i++)
		{
			int key = getValue(sl.r[i], r);
			rtValue[key][index[key] ++]= sl.r[i];
		}		
	}
	public void CollectFromBucket(SqlList sl,int r)
	{
		int z= 0;
		for (int i=0;i<index.length;i++)
		{
			int num = index[i];
			for (int j=0;j<num;j++)
			{
				sl.r[z++] = rtValue[i][j];
			}
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("Radix");
		SqlList sl =  new SqlList();
		sl.init(15);
		sl.showList();
		RadixSort qs  = new RadixSort();
		qs.sort(sl);
		sl.showList();
	}
}
