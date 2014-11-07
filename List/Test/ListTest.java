package Test;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import MyList.MyList;
import MyList.SingleList;
public class ListTest {
	MyList<Integer> il;
	MyList<String> sl;
	
	ArrayList<Integer> testInt = new ArrayList<Integer>();
	ArrayList<String> testStr = new ArrayList<String>();
	
	@Before
	public void setUp() throws Exception {
		il = new SingleList<Integer>();
		int [] v= {1,2,3,9,5,8};
		for(int i:v) {il.insert(i);testInt.add(i);}
		
		sl = new SingleList<String>();
		String [] strs = {"hello","nice","nee you","mei guo"};
		for(String s:strs) {sl.insert(s);testStr.add(s);}		
	}
	public void assertEqual()
	{
		assertTrue(il.equalsList(testInt));
		assertTrue(sl.equalsList(testStr));
	}
	
	@Test
	public void test() {
		assertEqual();
		
		for(int i=0;i<testInt.size();i++)
		{
			int v =(int) il.find(i).Value;
			assertTrue(v ==testInt.get(i));
		}
		
		for(int i=0;i<testStr.size();i++)
		{
			String v = sl.find(i).Value;
			assertTrue(v.equals(testStr.get(i)));
		}
		
		int in [] = {2,1};
		for(int i:in)
		{
			il.delete(i);sl.delete(i);
			testInt.remove(i);testStr.remove(i);
			assertEqual();	
		}
		
		
	}

}
