package z.learn;

import org.junit.Test;
import org.junit.Before;

/**
 * EnumLearn Tester.
 *
 * @author chouyua
 * @version 1.0
 * @since <pre>Aug 7, 2018</pre>
 */
public class EnumLearnTest {

    @Before
    public void before() throws Exception {
        example = new EnumLearn();
    }


    @Test
    public void testExample() throws Exception {
        example.example();
    }

    private EnumLearn example;
} 
