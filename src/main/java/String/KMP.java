package String;

public class KMP {
	
	public void getIndex(String s, int []next)
	{
		next [0] = -1;
		int i=1;
		int j=-1;
		
		while (i<s.length())
		{
			if(j==-1 || s.charAt(i-1) == s.charAt(j))
			{
				next[i] = j+1;
				i++;j++;
			}
			
			else
			{ 
				j = next[j];	
			}
		}
	}
	
	public Boolean KMP(String s, String t)
	{
		int [] next = new int[t.length()];
		Boolean in = false;
		getIndex(t,next);
				
		int i=0;
		int j=0;
		while (i<s.length()&& j<t.length())
		{
			if(j==-1 || s.charAt(i) == t.charAt(j))
			{
				i++;
				j++;
			}
			else if(s.charAt(i)!= t.charAt(j))
			{
				j = next[j];
			}
		}
		if(j==t.length()) in =true;
		
		
		return in;
	}
	
	
 

}
