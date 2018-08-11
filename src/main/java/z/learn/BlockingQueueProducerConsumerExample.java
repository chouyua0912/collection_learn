package z.learn;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class BlockingQueueProducerConsumerExample {

    volatile boolean stop = false;

    public void example(int max) {
        Random random = new Random();
        int consumer = Math.max(2, Math.abs(random.nextInt()) % max);
        int producer = Math.max(2, Math.abs(random.nextInt()) % max);
        int queueCapacity = Math.max(2, Math.abs(random.nextInt()) % max);

        System.out.println(String.format("Queue:%d Consumer=%d Producer=%d", queueCapacity, consumer, producer));

        CountDownLatch producerLatch = new CountDownLatch(producer);
        CountDownLatch consumerLatch = new CountDownLatch(consumer);

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(queueCapacity);

        for (int i = 0; i < consumer; i++) {
            Thread t = new Thread(() -> {
                String str = null;
                while (!stop || !queue.isEmpty()) {
                    if (null != (str = queue.poll())) {
                        System.out.println(str);
                    }
                    try {
                        Thread.sleep(Math.round(Math.random() * 100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                consumerLatch.countDown();
            }, "Consumer-" + i);
            t.start();
        }

        for (int i = 0; i < producer; i++) {
            Thread t = new Thread(() -> {
                int maxCount = Math.abs(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName() + " going to send " + maxCount);
                for (int j = 0; j < maxCount; j++) {
                    try {
                        queue.put(Thread.currentThread().getName() + "_" + Math.random());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                producerLatch.countDown();
            }, "Producer-" + i);
            t.start();
        }

        try {
            producerLatch.await();
            stop = true;
            consumerLatch.await();
            System.out.println("Ended..");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
