package z.learn.lang.dispatch;

/**
 * 动态分派
 * 根据变量实际类型进行了
 * invokevirtual 指令包含常量池中指向方法的引用,操作数是在栈顶的对象引用
 * 1. 查找栈顶引用实例的实际类型
 * 2. 如果在实际类型中找到与常量中的描述符和简单名称都相符的方法,则进行访问权限校验,如果通过则返回这个方法的直接引用,查找结束;如果不通过则返回java.lang.IllegalAccessError异常
 * 3. 否则,按照继承关系从下网上一次对对象的各个父类进行第2步的搜索和严重过程匹配.
 * 4. 最终没有找到合适的方法,则抛出java.lang.AbstractMethodError异常.
 */
public class DynamicDispatchDemo {

    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {

        @Override
        protected void sayHello() {
            System.out.println("Man say hello");
        }
    }

    static class Woman extends Human {

        @Override
        protected void sayHello() {
            System.out.println("Woman say hello");
        }
    }

    public static void main(String[] args) {
        Human h1 = new Man();
        Human h2 = new Woman();
        h1.sayHello();
        h2.sayHello();
        h1 = h2;
        h1.sayHello();
        h1 = new Woman();
        h1.sayHello();
    }
}
/**
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang$ javap -v -p DynamicDispatchDemo
 * DynamicDispatchDemo.class        DynamicDispatchDemo$Human.class  DynamicDispatchDemo$Man.class    DynamicDispatchDemo$Woman.class
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang$ javap -v -p DynamicDispatchDemo.class
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/lang/DynamicDispatchDemo.class
 *   Last modified Sep 23, 2018; size 803 bytes
 *   MD5 checksum a92f9181dd895bbe5149c4b67e41732e
 *   Compiled from "DynamicDispatchDemo.java"
 * public class z.learn.lang.DynamicDispatchDemo
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #8.#30         // java/lang/Object."<init>":()V
 *    #2 = Class              #31            // z/learn/lang/DynamicDispatchDemo$Man
 *    #3 = Methodref          #2.#30         // z/learn/lang/DynamicDispatchDemo$Man."<init>":()V
 *    #4 = Class              #32            // z/learn/lang/DynamicDispatchDemo$Woman
 *    #5 = Methodref          #4.#30         // z/learn/lang/DynamicDispatchDemo$Woman."<init>":()V
 *    #6 = Methodref          #12.#33        // z/learn/lang/DynamicDispatchDemo$Human.sayHello:()V
 *    #7 = Class              #34            // z/learn/lang/DynamicDispatchDemo
 *    #8 = Class              #35            // java/lang/Object
 *    #9 = Utf8               Woman
 *   #10 = Utf8               InnerClasses
 *   #11 = Utf8               Man
 *   #12 = Class              #36            // z/learn/lang/DynamicDispatchDemo$Human
 *   #13 = Utf8               Human
 *   #14 = Utf8               <init>
 *   #15 = Utf8               ()V
 *   #16 = Utf8               Code
 *   #17 = Utf8               LineNumberTable
 *   #18 = Utf8               LocalVariableTable
 *   #19 = Utf8               this
 *   #20 = Utf8               Lz/learn/lang/DynamicDispatchDemo;
 *   #21 = Utf8               main
 *   #22 = Utf8               ([Ljava/lang/String;)V
 *   #23 = Utf8               args
 *   #24 = Utf8               [Ljava/lang/String;
 *   #25 = Utf8               h1
 *   #26 = Utf8               Lz/learn/lang/DynamicDispatchDemo$Human;
 *   #27 = Utf8               h2
 *   #28 = Utf8               SourceFile
 *   #29 = Utf8               DynamicDispatchDemo.java
 *   #30 = NameAndType        #14:#15        // "<init>":()V
 *   #31 = Utf8               z/learn/lang/DynamicDispatchDemo$Man
 *   #32 = Utf8               z/learn/lang/DynamicDispatchDemo$Woman
 *   #33 = NameAndType        #37:#15        // sayHello:()V
 *   #34 = Utf8               z/learn/lang/DynamicDispatchDemo
 *   #35 = Utf8               java/lang/Object
 *   #36 = Utf8               z/learn/lang/DynamicDispatchDemo$Human
 *   #37 = Utf8               sayHello
 * {
 *   public z.learn.lang.DynamicDispatchDemo();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 3: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lz/learn/lang/DynamicDispatchDemo;
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=3, args_size=1
 *          0: new           #2                  // class z/learn/lang/DynamicDispatchDemo$Man
 *          3: dup
 *          4: invokespecial #3                  // Method z/learn/lang/DynamicDispatchDemo$Man."<init>":()V        Man的构造函数
 *          7: astore_1                             保存引用到本地变量2
 *          8: new           #4                  // class z/learn/lang/DynamicDispatchDemo$Woman
 *         11: dup
 *         12: invokespecial #5                  // Method z/learn/lang/DynamicDispatchDemo$Woman."<init>":()V      Woman的构造函数
 *         15: astore_2                             store a reference into local variable 2 保存引用到本地变量2
 *         16: aload_1                              加载本地变量1到栈顶(对象Man实例的引用)          invokevirtual 指令的操作数是 常量池里面的方法引用,另一个操作数是栈顶的对象引用
 *         17: invokevirtual #6                  // Method z/learn/lang/DynamicDispatchDemo$Human.sayHello:()V 编译期都是调用的Human上的方法,运行期JVM解析栈顶到底是什么引用,决定实际执行那块代码
 *         20: aload_2                              invoke virtual method on object objectref and puts the result on the stack (might be void); the method is identified by method reference index in constant pool (indexbyte1 << 8 + indexbyte2)
 *         21: invokevirtual #6                  // Method z/learn/lang/DynamicDispatchDemo$Human.sayHello:()V 编译期都是调用的Human上的方法
 *         24: aload_2                              查找栈顶实例引用的实际类型,把类型内方法与常量池方法匹配,返回方法的直接引用
 *         25: astore_1                             store a reference into local variable 1 保存引用到局部变量1
 *         26: aload_1
 *         27: invokevirtual #6                  // Method z/learn/lang/DynamicDispatchDemo$Human.sayHello:()V
 *         30: new           #4                  // class z/learn/lang/DynamicDispatchDemo$Woman
 *         33: dup
 *         34: invokespecial #5                  // Method z/learn/lang/DynamicDispatchDemo$Woman."<init>":()V      Woman的构造函数
 *         37: astore_1
 *         38: aload_1
 *         39: invokevirtual #6                  // Method z/learn/lang/DynamicDispatchDemo$Human.sayHello:()V
 *         42: return
 *       LineNumberTable:
 *         line 25: 0
 *         line 26: 8
 *         line 27: 16
 *         line 28: 20
 *         line 29: 24
 *         line 30: 26
 *         line 31: 30
 *         line 32: 38
 *         line 33: 42
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      43     0  args   [Ljava/lang/String;
 *             8      35     1    h1   Lz/learn/lang/DynamicDispatchDemo$Human;
 *            16      27     2    h2   Lz/learn/lang/DynamicDispatchDemo$Human;
 * }
 * SourceFile: "DynamicDispatchDemo.java"
 * InnerClasses:
 *      static #9= #4 of #7; //Woman=class z/learn/lang/DynamicDispatchDemo$Woman of class z/learn/lang/DynamicDispatchDemo
 *      static #11= #2 of #7; //Man=class z/learn/lang/DynamicDispatchDemo$Man of class z/learn/lang/DynamicDispatchDemo
 *      static abstract #13= #12 of #7; //Human=class z/learn/lang/DynamicDispatchDemo$Human of class z/learn/lang/DynamicDispatchDemo
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang$
 */