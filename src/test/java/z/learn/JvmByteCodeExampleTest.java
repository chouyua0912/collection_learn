package z.learn;

import org.junit.Test;
import org.junit.Before;

/**
 * JvmByteCodeExample Tester.
 *
 * @author chouyua
 * @version 1.0
 * @since <pre>Aug 19, 2018</pre>
 */
public class JvmByteCodeExampleTest {

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

    private JvmByteCodeExample example = new JvmByteCodeExample("123");
} 
