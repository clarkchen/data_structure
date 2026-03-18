package Sort.base;

import java.util.Random;
import java.util.Scanner;

public class SqlList {
	public int  r[] ;
	public int length;
	public SqlList()
	{
		r = new int [1000];
		length = 0;
	}
	public void swap(int i, int j)
	{
		if (i==j) return;
		r[i] = r[i]+r[j];
		r[j] = r[i] - r[j];
		r[i] = r[i] - r[j];
	}
	public void init(int length){
		
		Random rand = new Random();

		for (int i=0;i<length;i++)
		{
			r[i] = rand.nextInt(99)+1;
		}
		this.length = length;
	}
	private static Scanner scanner = new Scanner( System.in );
	
	public static int inputLength()
	{
		int length=0;
		System.out.print("请输入数组长度");
		length = scanner.nextInt();
		return length;
	}
	public static SqlList initWithInput()
	{
		SqlList sl = new SqlList();
		int length = SqlList.inputLength();
		int i = 0;
		while (i<length)
		{
			int temp = scanner.nextInt();
			sl.r[i] = temp;
			i++;
		}
		sl.length = length;
		return sl;
	}
	public void showList()
	{
		System.out.print("数组内容是：\n");
		for(int i = 0; i < this.length;i++)
		{
			System.out.print(this.r[i]+" ");
		}
		System.out.println("");
	}
}
