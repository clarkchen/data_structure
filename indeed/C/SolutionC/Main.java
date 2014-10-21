package C.SolutionC;


import java.util.*;
public class Main{
	
	static int getYearMod(int s, int e, int n)
	{
		int rt = 0;
		int margin = e - s;

		int nModS = s%n;
		int nModE = e%n;
		int nModD = margin%n;

		if (nModS == 0 || nModE < nModS)
		{
			rt = margin/n + 1;
		}
		else
		{
			rt = margin/n;
		}

		return rt;
	}

	static int answer(int s, int e)
	{
		 

		return getYearMod(s, e, 4)
			- getYearMod(s, e, 100)
			+ getYearMod(s, e, 400);
		
		 
	}
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
     
    int s = sc.nextInt();
    
    int e = sc.nextInt();
   
  
    
    System.out.println(answer(s,e));
    }
}

