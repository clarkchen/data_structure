package Sort.select;

import Sort.base.SqlList;

public class HeapSort {
	public  void sort(SqlList sl)
	{
			this.input(sl);
			sl.showList();
			int len = sl.length;
			int last;
			for(int i=0;i<sl.length;i++)
			{
				last =len-i-1;
				sl.swap(0, last);
				this.HeapAdjust(sl, 0, last);
			}
			
	}
	//MAX HEAP
	//从0开始的树，其叶子节点是 2*i+1 和 2*i+2
	public void HeapAdjust(SqlList sl, int start , int end)
	{
		int i,j;
		for (i=start;i<end;)
		{
			j = 2 * i+1;
			if(j>=end) break;
			if(j+1< end && sl.r[j+1]>sl.r[j]) j++;
			if(sl.r[i] >= sl.r[j]) break;
			sl.swap(i, j);
			i=j;
		}
		
	}
	public void input(SqlList sl)
	{
		for (int i = sl.length/2 ;i >=0 ; i--)
		{
			HeapAdjust(sl,i,sl.length);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlList sl =  new SqlList();
		sl.init(7);
		sl.showList();
		HeapSort hs  = new HeapSort();
		hs.sort(sl);
		sl.showList();
	}

}
