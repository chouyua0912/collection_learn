package z.learn.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 解决CAS的ABA问题
 * 原子带信笺（时间戳）的引用
 */
public class AtomicStampedReferenceDemo {

    public static void main(String[] args) {
        String str1 = "aaa";
        String str2 = "bbb";
        AtomicStampedReference<String> reference = new AtomicStampedReference<>(str1, 1);       // 初始标签是1
        reference.compareAndSet(str1, str2, reference.getStamp(), reference.getStamp() + 1);    // 传入正确的信笺才能更新成功，如果被别人抢占更新了，信笺错误会更新失败
        System.out.println("reference.getReference() = " + reference.getReference());       // bbb

        boolean b = reference.attemptStamp(str2, reference.getStamp() + 1);         // 强制更新 stamp
        System.out.println("b: " + b);
        System.out.println("reference.getStamp() = " + reference.getStamp());               // 3

        boolean c = reference.weakCompareAndSet(str2, "ccc", 4, reference.getStamp() + 1);  // 类似于compareAndSwap方法，不保证顺序
        System.out.println("reference.getReference() = " + reference.getReference());
        System.out.println("c = " + c);
    }
}
