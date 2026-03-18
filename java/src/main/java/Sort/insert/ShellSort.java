package Sort.insert;

import Sort.base.SqlList;

public class ShellSort {
	public static void sort(SqlList sl)
	{
		int inc = sl.length;
		int j;
		while (inc>1)
		{
			inc = inc/3 +1;
			for(int i = inc;i<sl.length;i++)
			{
				if (sl.r[i]<sl.r[i-inc])
				{
					int temp = sl.r[i];
					
					for ( j = i-inc;j>=0&&sl.r[j] > temp;j-=inc)
					{
						sl.r[j+inc] = sl.r[j];
					}
					sl.r[j+inc] = temp;
				}
			}
			//if(inc ==1) break;
		
		}
	}
	public static void main(String[] args)
	{
		SqlList sl =  new SqlList();
		sl.init(10);
		sl.showList();
		ShellSort.sort(sl);
		sl.showList();
	}
}
