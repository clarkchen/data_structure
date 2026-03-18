package Sort.exchange;

import Sort.base.SqlList;

public class BubbleSort {
	public static void sort(SqlList sl)
	{
		Boolean ordered = false;
		for (int i = 0 ; i< sl.length && !ordered;i++)
		{
			ordered = true;
			for (int j=sl.length-1;j>i;j--)
			{
				if(sl.r[j]<sl.r[j-1])
				{
					sl.swap(j, j-1);
					ordered = false;
				}
			}
		}
	}
	public static void main(String[] args)
	{
		SqlList sl = new SqlList();
		sl.init(10);
		sl.showList();
		sort(sl);
		sl.showList();
	}
}
