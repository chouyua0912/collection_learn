package z.learn;

import org.junit.Test;
import org.junit.Before;

/**
 * ListStreamLearn Tester.
 *
 * @author chouyua
 * @version 1.0
 * @since <pre>Aug 9, 2018</pre>
 */
public class ListStreamLearnTest {

    @Before
    public void before() throws Exception {
        example = new ListStreamLearn();
    }

    @Test
    public void testExample() throws Exception {
        example.example();
    }

    private ListStreamLearn example;
} 
