package Sort.RadixSort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenxi on 15/4/28.
 */
public class SolutionTest {
    Solution s = null;

    @org.junit.Before
    public void setUp() throws Exception {
        s = new Solution();
    }

    @org.junit.Test
    public void testGetValueFromIndex() throws Exception {
        assertEquals(s.getValueFromIndex(12345,0),5);
        assertEquals(s.getValueFromIndex(12345,1),4);
    }

    @Test
    public void testSort() throws Exception {
        int [] values = new int []{1, 97, 43,  59, 53, 88,3, 78, 2, 8 };
        s.sort(values);

        int [] sorted_values = new int[]{1, 2, 3, 8, 43, 53, 59, 78, 88, 97 };
        for (int i=0;i<sorted_values.length;i++)
        {
            assertEquals(sorted_values[i], values[i]);
        }

    }

    @Test
    public void testSort2() throws Exception {
        int [] values = new int []{1 };
        s.sort(values);

        int [] sorted_values = new int[]{1 };
        for (int i=0;i<sorted_values.length;i++)
        {
            assertEquals(sorted_values[i], values[i]);
        }

    }
}
