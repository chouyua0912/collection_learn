package z.learn;

import org.junit.Test;
import org.junit.Before;

/**
 * TreeMapExample Tester.
 *
 * @author chouyua
 * @version 1.0
 * @since <pre>Aug 16, 2018</pre>
 */
public class TreeMapExampleTest {

    @Before
    public void before() throws Exception {
    }

    /**
     * Method: example()
     */
    @Test
    public void testExample() throws Exception {
        example.example();
    }

    @Test(expected = ClassCastException.class)
    public void testExampleException() throws Exception {
        example.example1();
    }

    @Test
    public void testExample2() throws Exception {
        example.example2();
    }


    private TreeMapExample example = new TreeMapExample();
} 
