package z.learn.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 《Java核心技术 卷一》 p330, 通配符类型和上下界
 * List、List<Object>、List<?> 的三者的区别以及 <? extends T>与<? super T> 的区别
 * <p>
 * List、List<Object>、List<?>
 * <p>
 * List ：完全没有类型限制和赋值限定。
 * List<Object> ：看似用法与List一样，但是在接受其他泛型赋值时会出现编译错误。
 * List<?>：是一个泛型，在没有赋值前，表示可以接受任何类型的集合赋值，但赋值之后不能往里面随便添加元素，但可以remove和clear，并非immutable(不可变)集合。List<?>一般作为参数来接收外部集合，或者返回一个具体元素类型的集合，也称为通配符集合。
 * <p>
 * https://blog.csdn.net/qq_37964379/article/details/88528997
 * <? extends T>与<? super T>
 * <p>
 * List 最大的问题是只能放置一种类型，如果随意转变类型的话，就是破窗理论，泛型就失去了意义。为了放置多种受泛型约束的类型，出现了 <? extends T>与<? super T> 两种语法。简单来说， <? extends T> 是Get First，适用于，消费集合元素的场景；<? super T>是Put First，适用于，生产集合元素为主的场景。
 * <p>
 * <? extends T> ：可以赋值给任意T及T的子类集合，上界为T，取出来的类型带有泛型限制，向上强制转型为T。null 可以表示任何类型，所以null除外，任何元素都不得添加进<? extends T>集合内。
 * <? super T> : 可以复制T及任何T的父类集合，下界为T。再生活中，投票选举类似于<? super T>的操作。选举投票时，你只能往里投票，取数据时，根本不知道时是谁的票，相当于泛型丢失。
 * <p>
 * <? extends T>的场景是put功能受限，而<? super T>的场景是get功能受限。
 */
public class CollectionSuperExtends {

    static class Fruit {
        String say() {
            return "fruit";
        }
    }

    static class Apple extends Fruit {
        @Override
        String say() {
            return "apple";
        }
    }

    static class BigApple extends Apple {
        @Override
        String say() {
            return "bigApple";
        }
    }

    static class Box<T> {
        private T t;

        T getT() {
            return t;
        }

        void setT(T t) {
            this.t = t;
        }
    }

    // Super，extends区分安全的访问器和不安全的更改器方法
    public static void main(String[] args) {
        List<? super Apple> supperList = new ArrayList<>();     // 给定了上界是Apple
        supperList.add(new BigApple());
        supperList.add(new Apple());
        Iterator<? super Apple> iterator = supperList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();          // 取出来的只能是object然后强行转换
            System.out.println(((Apple) next).say());
        }

        Box<BigApple> bigAppleBox = new Box<>();
        bigAppleBox.setT(new BigApple());
        Box<? extends Apple> box = bigAppleBox;
        Apple apple = box.getT();
        System.out.println(apple.say());

        List<Apple> apples = Arrays.asList(new Apple(), new BigApple());
        for (Apple a : apples) {
            System.out.println(a.say());
        }
        List<? extends Apple> apples2 = Arrays.asList(new Apple(), new BigApple());
        for (Apple a : apples2) {
            System.out.println(a.say());
        }
        List<? extends Apple> extendsList = new ArrayList<>();         // put 受限，可以获取但不能向里面存
        /**
         * ? extends Apple get(i);
         * void add(? extends Apple);
         * /
         //  extendsList.add(new Apple());       // 没办法放进去，编译无法通过。 List的add方法定义为add(E e);并没有支持通配符
         */
    }
}
