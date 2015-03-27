package String;
import static org.junit.Assert.*;

import java.util.*;

import String.KMP;
import org.junit.Before;
import org.junit.Test;
public class kmptestTest {
	KMP kt = new KMP();
	@Before
	public void setUp() throws Exception {
	}

	void output(int a[])
	{
		for(int i:a)
			System.out.print(i+",");
		System.out.println();
	}
	
	@Test
	public void test() {
		String[] s = new String[]{"babcedf","abcdababeabc"};
		String[] t =  new String[]{"ce","abab"};
		
		int index = 0;
		for(int i=0;i<s.length;i++)
		{
			assertTrue(kt.KMP(s[i], t[i]));
		}

	}

}
