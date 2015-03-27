package Sort.other;

import java.util.Stack;

import Sort.base.SqlList;

public class MergeSortStack extends MergeSort  {
	protected void mergeSort(int[] sl, int start, int end)
	{
		if (start>=end-1) return ;
		int i=start,j=end;
		int mid = end/2;
		int k=1;
		
		while(k<=mid)
		{
			i= start;
			while(i<=end-2*k)
			{
				j=i+2*k;
				merge(sl,i,i+k,j);
				i=j;
			}
			if(i<end) {
				merge(sl,i-2*k,i,end);
			}
			k*=2;
		}
	}
	
	public void sort(SqlList sl)
	{
		 mergeSort(sl.r, 0, sl.length);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("merge sort no Recursion");
		SqlList sl =  new SqlList();
		sl.init(21);
		sl.showList();
		MergeSortStack qs  = new MergeSortStack();
		qs.sort(sl);
		sl.showList();
	}

}
