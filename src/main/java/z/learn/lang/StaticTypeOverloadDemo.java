package z.learn.lang;

/**
 * Human h = new Man();
 * 变量h的静态类型:Human
 * 变量h的实际类型:Man
 * Overload重载方法调用的定位,编译期根据参数个数和静态类型确定调用那个重载的方法
 */
public class StaticTypeOverloadDemo {
    static abstract class Human {

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void sayHello(Human h) {
        System.out.println("Hello, human");
    }

    public void sayHello(Man m) {
        System.out.println("Hello, man");
    }

    public void sayHello(Woman w) {
        System.out.println("Hello, woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticTypeOverloadDemo sr = new StaticTypeOverloadDemo();
        sr.sayHello(man);
        sr.sayHello(woman);
        sr.sayHello((Man) man);
        sr.sayHello((Woman) woman);
    }
}
/**
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang$ javap -v -p StaticTypeOverloadDemo
 * StaticTypeOverloadDemo.class        StaticTypeOverloadDemo$Human.class  StaticTypeOverloadDemo$Man.class    StaticTypeOverloadDemo$Woman.class
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang$ javap -v -p StaticTypeOverloadDemo.class
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/lang/StaticTypeOverloadDemo.class
 *   Last modified Sep 23, 2018; size 1539 bytes
 *   MD5 checksum ff89091559cf95e6f6a07b69a0057294
 *   Compiled from "StaticTypeOverloadDemo.java"
 * public class z.learn.lang.StaticTypeOverloadDemo
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:                               常量池!!
 *    #1 = Methodref          #16.#48        // java/lang/Object."<init>":()V
 *    #2 = Fieldref           #49.#50        // java/lang/System.out:Ljava/io/PrintStream;
 *    #3 = String             #51            // Hello, human
 *    #4 = Methodref          #52.#53        // java/io/PrintStream.println:(Ljava/lang/String;)V
 *    #5 = String             #54            // Hello, man
 *    #6 = String             #55            // Hello, woman
 *    #7 = Class              #56            // z/learn/lang/StaticTypeOverloadDemo$Man
 *    #8 = Methodref          #7.#48         // z/learn/lang/StaticTypeOverloadDemo$Man."<init>":()V
 *    #9 = Class              #57            // z/learn/lang/StaticTypeOverloadDemo$Woman
 *   #10 = Methodref          #9.#48         // z/learn/lang/StaticTypeOverloadDemo$Woman."<init>":()V
 *   #11 = Class              #58            // z/learn/lang/StaticTypeOverloadDemo
 *   #12 = Methodref          #11.#48        // z/learn/lang/StaticTypeOverloadDemo."<init>":()V
 *   #13 = Methodref          #11.#59        // z/learn/lang/StaticTypeOverloadDemo.sayHello:(Lz/learn/lang/StaticTypeOverloadDemo$Human;)V
 *   #14 = Methodref          #11.#60        // z/learn/lang/StaticTypeOverloadDemo.sayHello:(Lz/learn/lang/StaticTypeOverloadDemo$Man;)V
 *   #15 = Methodref          #11.#61        // z/learn/lang/StaticTypeOverloadDemo.sayHello:(Lz/learn/lang/StaticTypeOverloadDemo$Woman;)V
 *   #16 = Class              #62            // java/lang/Object
 *   #17 = Utf8               Woman
 *   #18 = Utf8               InnerClasses
 *   #19 = Utf8               Man
 *   #20 = Class              #63            // z/learn/lang/StaticTypeOverloadDemo$Human
 *   #21 = Utf8               Human
 *   #22 = Utf8               <init>
 *   #23 = Utf8               ()V
 *   #24 = Utf8               Code
 *   #25 = Utf8               LineNumberTable
 *   #26 = Utf8               LocalVariableTable
 *   #27 = Utf8               this
 *   #28 = Utf8               Lz/learn/lang/StaticTypeOverloadDemo;
 *   #29 = Utf8               sayHello
 *   #30 = Utf8               (Lz/learn/lang/StaticTypeOverloadDemo$Human;)V
 *   #31 = Utf8               h
 *   #32 = Utf8               Lz/learn/lang/StaticTypeOverloadDemo$Human;
 *   #33 = Utf8               (Lz/learn/lang/StaticTypeOverloadDemo$Man;)V
 *   #34 = Utf8               m
 *   #35 = Utf8               Lz/learn/lang/StaticTypeOverloadDemo$Man;
 *   #36 = Utf8               (Lz/learn/lang/StaticTypeOverloadDemo$Woman;)V
 *   #37 = Utf8               w
 *   #38 = Utf8               Lz/learn/lang/StaticTypeOverloadDemo$Woman;
 *   #39 = Utf8               main
 *   #40 = Utf8               ([Ljava/lang/String;)V
 *   #41 = Utf8               args
 *   #42 = Utf8               [Ljava/lang/String;
 *   #43 = Utf8               man
 *   #44 = Utf8               woman
 *   #45 = Utf8               sr
 *   #46 = Utf8               SourceFile
 *   #47 = Utf8               StaticTypeOverloadDemo.java
 *   #48 = NameAndType        #22:#23        // "<init>":()V
 *   #49 = Class              #64            // java/lang/System
 *   #50 = NameAndType        #65:#66        // out:Ljava/io/PrintStream;
 *   #51 = Utf8               Hello, human
 *   #52 = Class              #67            // java/io/PrintStream
 *   #53 = NameAndType        #68:#69        // println:(Ljava/lang/String;)V
 *   #54 = Utf8               Hello, man
 *   #55 = Utf8               Hello, woman
 *   #56 = Utf8               z/learn/lang/StaticTypeOverloadDemo$Man
 *   #57 = Utf8               z/learn/lang/StaticTypeOverloadDemo$Woman
 *   #58 = Utf8               z/learn/lang/StaticTypeOverloadDemo
 *   #59 = NameAndType        #29:#30        // sayHello:(Lz/learn/lang/StaticTypeOverloadDemo$Human;)V
 *   #60 = NameAndType        #29:#33        // sayHello:(Lz/learn/lang/StaticTypeOverloadDemo$Man;)V
 *   #61 = NameAndType        #29:#36        // sayHello:(Lz/learn/lang/StaticTypeOverloadDemo$Woman;)V
 *   #62 = Utf8               java/lang/Object
 *   #63 = Utf8               z/learn/lang/StaticTypeOverloadDemo$Human
 *   #64 = Utf8               java/lang/System
 *   #65 = Utf8               out
 *   #66 = Utf8               Ljava/io/PrintStream;
 *   #67 = Utf8               java/io/PrintStream
 *   #68 = Utf8               println
 *   #69 = Utf8               (Ljava/lang/String;)V
 * {
 *   public z.learn.lang.StaticTypeOverloadDemo();
 *     descriptor: ()V                              构造函数
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
 *             0       5     0  this   Lz/learn/lang/StaticTypeOverloadDemo;
 *
 *   public void sayHello(z.learn.lang.StaticTypeOverloadDemo$Human);       方法1
 *     descriptor: (Lz/learn/lang/StaticTypeOverloadDemo$Human;)V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: ldc           #3                  // String Hello, human
 *          5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *          8: return
 *       LineNumberTable:
 *         line 17: 0
 *         line 18: 8
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       9     0  this   Lz/learn/lang/StaticTypeOverloadDemo;
 *             0       9     1     h   Lz/learn/lang/StaticTypeOverloadDemo$Human;
 *
 *   public void sayHello(z.learn.lang.StaticTypeOverloadDemo$Man);         方法2
 *     descriptor: (Lz/learn/lang/StaticTypeOverloadDemo$Man;)V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: ldc           #5                  // String Hello, man
 *          5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *          8: return
 *       LineNumberTable:
 *         line 21: 0
 *         line 22: 8
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       9     0  this   Lz/learn/lang/StaticTypeOverloadDemo;
 *             0       9     1     m   Lz/learn/lang/StaticTypeOverloadDemo$Man;
 *
 *   public void sayHello(z.learn.lang.StaticTypeOverloadDemo$Woman);       方法3
 *     descriptor: (Lz/learn/lang/StaticTypeOverloadDemo$Woman;)V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: ldc           #6                  // String Hello, woman
 *          5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *          8: return
 *       LineNumberTable:
 *         line 25: 0
 *         line 26: 8
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       9     0  this   Lz/learn/lang/StaticTypeOverloadDemo;
 *             0       9     1     w   Lz/learn/lang/StaticTypeOverloadDemo$Woman;
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=4, args_size=1
 *          0: new           #7                  // class z/learn/lang/StaticTypeOverloadDemo$Man                   分配内存
 *          3: dup
 *          4: invokespecial #8                  // Method z/learn/lang/StaticTypeOverloadDemo$Man."<init>":()V     调用构造函数
 *          7: astore_1
 *          8: new           #9                  // class z/learn/lang/StaticTypeOverloadDemo$Woman
 *         11: dup
 *         12: invokespecial #10                 // Method z/learn/lang/StaticTypeOverloadDemo$Woman."<init>":()V
 *         15: astore_2
 *         16: new           #11                 // class z/learn/lang/StaticTypeOverloadDemo
 *         19: dup
 *         20: invokespecial #12                 // Method "<init>":()V
 *         23: astore_3
 *         24: aload_3
 *         25: aload_1
 *         26: invokevirtual #13                 // Method sayHello:(Lz/learn/lang/StaticTypeOverloadDemo$Human;)V  编译时候确定调用Human参数的函数
 *         29: aload_3
 *         30: aload_2
 *         31: invokevirtual #13                 // Method sayHello:(Lz/learn/lang/StaticTypeOverloadDemo$Human;)V
 *         34: aload_3
 *         35: aload_1                              加载局部变量1到栈顶作为引用
 *         36: checkcast     #7                  // class z/learn/lang/StaticTypeOverloadDemo$Man           检查栈顶引用是否是合法的Man类型,合法的话则可以调用Man入参的sayHello
 *         39: invokevirtual #14                 // Method sayHello:(Lz/learn/lang/StaticTypeOverloadDemo$Man;)V    校验类型合法,可以进行sayHello(Man)调用
 *         42: aload_3
 *         43: aload_2
 *         44: checkcast     #9                  // class z/learn/lang/StaticTypeOverloadDemo$Woman
 *         47: invokevirtual #15                 // Method sayHello:(Lz/learn/lang/StaticTypeOverloadDemo$Woman;)V
 *         50: return
 *       LineNumberTable:
 *         line 29: 0
 *         line 30: 8
 *         line 31: 16
 *         line 32: 24
 *         line 33: 29
 *         line 34: 34
 *         line 35: 42
 *         line 36: 50
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      51     0  args   [Ljava/lang/String;
 *             8      43     1   man   Lz/learn/lang/StaticTypeOverloadDemo$Human;
 *            16      35     2 woman   Lz/learn/lang/StaticTypeOverloadDemo$Human;
 *            24      27     3    sr   Lz/learn/lang/StaticTypeOverloadDemo;
 * }
 * SourceFile: "StaticTypeOverloadDemo.java"
 * InnerClasses:
 *      static #17= #9 of #11; //Woman=class z/learn/lang/StaticTypeOverloadDemo$Woman of class z/learn/lang/StaticTypeOverloadDemo
 *      static #19= #7 of #11; //Man=class z/learn/lang/StaticTypeOverloadDemo$Man of class z/learn/lang/StaticTypeOverloadDemo
 *      static abstract #21= #20 of #11; //Human=class z/learn/lang/StaticTypeOverloadDemo$Human of class z/learn/lang/StaticTypeOverloadDemo
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang$
 */