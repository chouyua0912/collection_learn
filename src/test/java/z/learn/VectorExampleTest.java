package z.learn;

import org.junit.Test;
import org.junit.Before;

/**
 * VectorExample Tester.
 *
 * @author chouyua
 * @version 1.0
 * @since <pre>Aug 13, 2018</pre>
 */
public class VectorExampleTest {

    @Before
    public void before() throws Exception {
    }

    /**
     * Method: example()
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testExample() throws Exception {
        example.example();
        example.example1();
        example.example2();
    }

    @Test
    public void testExample1() throws Exception {
        example.example1();
    }

    @Test
    public void testExample2() throws Exception {
        example.example2();
    }


    private VectorExample example = new VectorExample();
} 
