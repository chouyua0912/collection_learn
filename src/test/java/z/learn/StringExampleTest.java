package z.learn;

import org.junit.Test;
import org.junit.Before;
import z.learn.lang.StringExample;

/**
 * StringExample Tester.
 *
 * @author chouyua
 * @version 1.0
 * @since <pre>Aug 18, 2018</pre>
 */
public class StringExampleTest {

    @Before
    public void before() throws Exception {
    }

    /**
     * Method: example()
     */
    @Test
    public void testExample() throws Exception {
        example.example();
        example.test1();
        example.test2();
        example.test2();
        example.test3();
        example.test4();
        example.test5();
        example.test6();
        example.test7();
        example.test8();
        example.test9();
        example.test10();
    }


    private StringExample example = new StringExample();
} 
