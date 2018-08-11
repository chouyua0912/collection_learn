package z.learn;

import org.junit.Test;
import org.junit.Before;

/**
 * BlockingQueueProducerConsumerExample Tester.
 *
 * @author chouyua
 * @version 1.0
 * @since <pre>Aug 11, 2018</pre>
 */
public class BlockingQueueProducerConsumerExampleTest {

    @Before
    public void before() throws Exception {
    }

    /**
     * Method: example(int max)
     */
    @Test
    public void testExample() throws Exception {
        example.example(10);
    }


    private BlockingQueueProducerConsumerExample example = new BlockingQueueProducerConsumerExample();
} 
