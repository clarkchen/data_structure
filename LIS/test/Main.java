package test;

import java.util.Scanner;
public class Main {
	public int getLISLength(int []a){
		if(a ==null) return 0;
		if(a.length==0) return 0;
		int []count = new int[a.length];
		count[0] = 1;
		for(int i=1;i<a.length;i++)
		{
			
			int max = 0;
			for(int j=0;j<i;j++)
			{
				if(a[j]<a[i] & count[j]>max)
				{
					max = count[j];
				}
			}
			count[i] = max+1;
		}
		int max=0;
		for(int i=0;i<count.length;i++)
		{
			if(count[i]>max) max =count[i];
		}
		return max;
	}
	public static void main(String[]args)
	{
		Scanner s = new Scanner(System.in);
		int length = s.nextInt();
		int [] a= new int[length];
		for(int i=0;i<length;i++)
		{
			a[i] = s.nextInt();
		}
		Main m = new Main();
		System.out.println(m.getLISLength(a));
	}
	
}
