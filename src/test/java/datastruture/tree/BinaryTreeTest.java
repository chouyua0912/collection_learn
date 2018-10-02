package datastruture.tree;

import org.junit.Test;
import org.junit.Before;

public class BinaryTreeTest {

    @Before
    public void before() throws Exception {
        example.insert(10, "abc");
    }

    /**
     * Method: insert(K k, V v)
     */
    @Test
    public void testInsert() throws Exception {
        example.insert(5, "hello");
        example.insert(-3, "nothing");
        System.out.println(example.get(5));
    }

    /**
     * Method: get(K k)
     */
    @Test
    public void testGet() throws Exception {

    }

    /**
     * Method: contain(K k)
     */
    @Test
    public void testContain() throws Exception {

    }


    private BinaryTree<Integer, String> example = new BinaryTree();
} 
