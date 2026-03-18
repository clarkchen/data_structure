package Sort.exchange;

import Sort.select.HeapSort;
import Sort.base.SqlList;

public class QuickSort {
	protected int parting(SqlList sl, int start ,int end)
	{
		int mV= sl.r[start];
		int i=start;
		int j=end;
		while(i<j)
		{
			while(sl.r[j]>=mV && i<j){j--;}
			sl.swap(i, j);
			
			while(sl.r[i]<mV && i<j){i++;}
			sl.swap(i, j);
		}
		return i;
	}
	protected void qsort(SqlList sl, int start ,int end)
	{
		if(start>=end || end>sl.length) return;
		
		int mid = this.parting(sl,start,end);		
		this.qsort(sl, start, mid-1);
		this.qsort(sl, mid+1, end);
	}
	public void sort(SqlList sl)
	{
		this.qsort(sl, 0, sl.length-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlList sl =  new SqlList();
		sl.init(7);
		sl.showList();
		QuickSort qs  = new QuickSort();
		qs.sort(sl);
		sl.showList();
	}

}
