package Sort.insert;
import Sort.base.SqlList;
public class InsertSort {
	public static void sort(SqlList sl)
	{
		int temp;
		for (int i=1;i<sl.length;i++)
		{
			
			if (sl.r[i]<sl.r[i-1])
			{
				temp = sl.r[i];
				int j;
				for (j = i-1;j>=0;j--)
				{
					if(sl.r[j]<=temp){break;}
					sl.r[j+1] = sl.r[j];
					
				}
				sl.r[j+1] = temp;
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
