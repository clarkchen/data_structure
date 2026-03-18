package Trees.Huffman;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HuffmanTreePriorityTest extends TestCase {

    @Before
    public void setUp() throws Exception {
    }

    void codeTest(String text)
    {
        HuffmanTreePriority ht = new HuffmanTreePriority();

        //编码
        String code = ht.encode(text);
        //System.out.println(code);
        //ht.showCharList();

        //解码
        ht.clear();
        ht.decode(code,ht.root);
        System.out.println(ht.res);
        assertTrue(ht.res.equals(text));
    }
    @Test
    public void test() {
        // TODO Auto-generated method stub
        String  ts []={ "beep boop beer!","teste hello world"};
        for(String s:ts)
        {
            codeTest(s);
        }
    }
}