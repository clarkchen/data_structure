package List.Test;
import static org.junit.Assert.*;

import List.MyList.DoubleList;

public class DoubleListTest extends ListTest{
	@Override
	void init()
	{
		il = new DoubleList<Integer>();
		int [] v= {1,2,3,9,5,8};
		for(int i:v) {il.insert(i);testInt.add(i);}
		
		sl = new DoubleList<String>();
		String [] strs = {"hello","nice","nee you","mei guo"};
		for(String s:strs) {sl.insert(s);testStr.add(s);}	
	}
	 @Override
	 public void assertEqual()
	 {
		 super.assertEqual();
		 assertTrue(il.equalReverseList(testInt));
		 assertTrue(sl.equalReverseList(testStr));
		 
	 }
}
