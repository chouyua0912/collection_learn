package z.learn;

import java.util.Stack;

/**
 * FILO
 * 继承自Vector，底层是数组实现，所以可以容易的访问任意位置的元素，通过元素总数指定在数组尾巴即是栈顶
 */
public class StackExample {

    public void example() {
        Stack<String> stack = new Stack<>();
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");

        System.out.println(stack.pop());        // pop会出栈
        System.out.println(stack.peek());       // peek不会出栈，只是获取栈顶元素
        System.out.println(stack.peek());
    }
}
