package test;

public class LIS {
	
	//dp[i] = MAX{1+count[j]} where a[j]<a[i] and j<i
	public void run(int []a){
		if(a ==null) return ;
		if(a.length==0) System.out.print(a);
		int []count = new int[a.length];
		count[0] = 1;
		for(int i=1;i<a.length;i++)
		{
			
			int max = 0;
			for(int j=0;j<i;j++)
			{
				if(a[j]<a[i] & a[j]>max)
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
		this.output(count, a,max);
		
	}
	public void output(int[]count, int []v,int max)
	{
		int i = count.length-1;
		int [] rtValue = new int [100];
		int j=0;
		int c = max;
		while(i>=0&&c>0)
		{
			
			if(count[i]==c)
			{
				rtValue[j++] = v[i];
				c--;
			}
			i--;
		}
		
		for(i=j-1;i>=0;i--)
		{
			System.out.print(rtValue[i]);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a= new int []{1,3,9,8};
//		a = new int[]{3,1,9,7};
//		a = new int[]{1,2,1,1};
//		a = new int[]{3,2,1,3};
		//a = new int[]{1,2,3,4,5};
		a = new int[]{1,1,1};
		a = new int[]{1,1,1};
		LIS L =new LIS();
		L.run(a);		
	}

}
