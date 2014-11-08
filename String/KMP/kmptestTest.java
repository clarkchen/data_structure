package KMP;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
public class kmptestTest {
	kmptest kt = new kmptest();
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
