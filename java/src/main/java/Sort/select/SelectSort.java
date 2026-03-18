package Sort.select;
import Sort.base.SqlList;
public class SelectSort {
	
	public static void sort(SqlList sl)
	{
		int min;
		for (int i=0;i<sl.length;i++)
		{
			min = i;
			for (int j=i+1;j<sl.length;j++)
			{
				if (sl.r[min]> sl.r[j])
				{
					min = j;
				}
			}
			if (i!=min){
				sl.swap(i, min);
			}
		}
	}
	public static void  main(String[] args)
	{
		SqlList sl =  new SqlList();
		sl.init(10);
		sl.showList();
		sort(sl);
		sl.showList();
	}
	
}
