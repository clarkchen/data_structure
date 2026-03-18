package Sort.other;

import Sort.base.SqlList;
import Sort.exchange.QuickSort;

public class MergeSort {
	protected void mergeSort(int[] sl, int start, int end)
	{
		if (start>=end-1) return ;
		int mid = (end - start)/2+start;
		mergeSort(sl, start, mid);
		mergeSort(sl,mid,end);
		merge(sl,start,mid,end);
	}
	
	protected void merge(int[] sl,int start, int mid, int end)
	{
		int i=start;int j=mid;int z=0;
		int [] rtValue =  new int[end-start];
		while(i<mid && j<end)
		{
			while(sl[i]<=sl[j] && i<mid){rtValue[z++] = sl[i++];}
			while(sl[j]<=sl[i] && j<end ){rtValue[z++] = sl[j++];}
		}
		if(i<mid) while (i<mid) rtValue[z++] = sl[i++];
		else if(j<end) while(j<end) rtValue[z++] = sl[j++];
		
		for (i=0;i<z;i++)
		{
			sl[start+i] = rtValue[i];
		}
		
	}
	
	public void sort(SqlList sl)
	{
		mergeSort(sl.r, 0, sl.length);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlList sl =  new SqlList();
		sl.init(20);
		sl.showList();
		MergeSort qs  = new MergeSort();
		qs.sort(sl);
		sl.showList();
		
	}
}
