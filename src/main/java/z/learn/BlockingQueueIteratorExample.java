package z.learn;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Iterator被创建之后，不会因为有出队入队操作，而没办法next获取元素
 * 哨兵节点出队，next被指向自己
 * 首节点被移动到头部作为哨兵，哨兵的next指向首节点
 */
public class BlockingQueueIteratorExample {

    List<String> strs = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff");

    public void example() {
        System.out.println("example1------");
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(strs);
        Iterator<String> iterator = queue.iterator();

        String polled;
        System.out.println("Poll one element: " + ((polled = queue.poll()) == null ? "empty" : polled));

        while (iterator.hasNext()) {
            System.out.println("Iterator: " + iterator.next());
        }
    }

    public void example2() {
        System.out.println("example2------");
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(strs);
        Iterator<String> iterator = queue.iterator();                   // 出队两次之后，iterator缓存的current变成已出队哨兵，item是null，next指向自己

        queue.offer("ggg");
        String polled;
        System.out.println("Poll one element: " + ((polled = queue.poll()) == null ? "empty" : polled));
        System.out.println("Poll another element: " + ((polled = queue.poll()) == null ? "empty" : polled));
        System.out.println("Poll three element: " + ((polled = queue.poll()) == null ? "empty" : polled));

        while (iterator.hasNext()) {
            System.out.println("Iterator: " + iterator.next());
        }
    }

    public void example3() {        // 插入到尾巴的节点是可以遍历得到的
        System.out.println("example3------");
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(strs);
        Iterator<String> iterator = queue.iterator();                   // 出队两次之后，iterator缓存的current变成已出队哨兵，item是null，next指向自己

        queue.offer("ggg");
        String polled;
        System.out.println("Poll one element: " + ((polled = queue.poll()) == null ? "empty" : polled));
        System.out.println("Poll another element: " + ((polled = queue.poll()) == null ? "empty" : polled));
        System.out.println("Poll three element: " + ((polled = queue.poll()) == null ? "empty" : polled));

        while (iterator.hasNext()) {
            System.out.println("Iterator: " + iterator.next());
        }
    }

    public void example4() {    // deque 可以反向遍历
        System.out.println("example4------");
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(strs);
        Iterator<String> iterator = ((LinkedBlockingDeque<String>) queue).descendingIterator(); // 出队两次之后，iterator缓存的current变成已出队哨兵，item是null，next指向自己

        String polled;
        System.out.println("Poll one element: " + ((polled = queue.poll()) == null ? "empty" : polled));
        System.out.println("Poll another element: " + ((polled = queue.poll()) == null ? "empty" : polled));

        while (iterator.hasNext()) {
            System.out.println("Iterator: " + iterator.next());
        }
    }

    public void example5() {    // 后续插入头部的节点是遍历不到的
        System.out.println("example5------");
        LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>(strs);
        Iterator<String> iterator = queue.iterator();

        queue.offerFirst("000");
        queue.offerFirst("111");

        while (iterator.hasNext()) {
            System.out.println("Iterator: " + iterator.next());
        }
    }
}
