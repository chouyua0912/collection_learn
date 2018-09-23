package z.learn.lang.dispatch;

/**
 * 编译期进行静态分派:根据变量的静态类型和参数的静态类型选择编译生成对应方法的符号引用
 * 运行期动态分派:根据接收方法调用的对象实际类型来决定调用那个方法
 */
public class DispatchDemo {
    static class QQ {

    }

    static class Geely {

    }

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("Father chose qq");
        }

        public void hardChoice(Geely arg) {
            System.out.println("Father chose geely");
        }
    }

    public static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("Son chose qq");
        }

        public void hardChoice(Geely arg) {
            System.out.println("Son chose geely");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        father.hardChoice(new Geely());
        Father son = new Son();
        son.hardChoice(new QQ());
    }
}
/**
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang/dispatch$ javap -v -p DispatchDemo.class
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/lang/dispatch/DispatchDemo.class
 *   Last modified Sep 23, 2018; size 967 bytes
 *   MD5 checksum c3e24b67d56cd98fdd0aa1d3d88638c6
 *   Compiled from "DispatchDemo.java"
 * public class z.learn.lang.dispatch.DispatchDemo
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:                               常量池
 *    #1 = Methodref          #13.#35        // java/lang/Object."<init>":()V
 *    #2 = Class              #36            // z/learn/lang/dispatch/DispatchDemo$Father
 *    #3 = Methodref          #2.#35         // z/learn/lang/dispatch/DispatchDemo$Father."<init>":()V
 *    #4 = Class              #37            // z/learn/lang/dispatch/DispatchDemo$Geely
 *    #5 = Methodref          #4.#35         // z/learn/lang/dispatch/DispatchDemo$Geely."<init>":()V
 *    #6 = Methodref          #2.#38         // z/learn/lang/dispatch/DispatchDemo$Father.hardChoice:(Lz/learn/lang/dispatch/DispatchDemo$Geely;)V
 *    #7 = Class              #39            // z/learn/lang/dispatch/DispatchDemo$Son
 *    #8 = Methodref          #7.#35         // z/learn/lang/dispatch/DispatchDemo$Son."<init>":()V
 *    #9 = Class              #40            // z/learn/lang/dispatch/DispatchDemo$QQ
 *   #10 = Methodref          #9.#35         // z/learn/lang/dispatch/DispatchDemo$QQ."<init>":()V
 *   #11 = Methodref          #2.#41         // z/learn/lang/dispatch/DispatchDemo$Father.hardChoice:(Lz/learn/lang/dispatch/DispatchDemo$QQ;)V
 *   #12 = Class              #42            // z/learn/lang/dispatch/DispatchDemo
 *   #13 = Class              #43            // java/lang/Object
 *   #14 = Utf8               Son
 *   #15 = Utf8               InnerClasses
 *   #16 = Utf8               Father
 *   #17 = Utf8               Geely
 *   #18 = Utf8               QQ
 *   #19 = Utf8               <init>
 *   #20 = Utf8               ()V
 *   #21 = Utf8               Code
 *   #22 = Utf8               LineNumberTable
 *   #23 = Utf8               LocalVariableTable
 *   #24 = Utf8               this
 *   #25 = Utf8               Lz/learn/lang/dispatch/DispatchDemo;
 *   #26 = Utf8               main
 *   #27 = Utf8               ([Ljava/lang/String;)V
 *   #28 = Utf8               args
 *   #29 = Utf8               [Ljava/lang/String;
 *   #30 = Utf8               father
 *   #31 = Utf8               Lz/learn/lang/dispatch/DispatchDemo$Father;
 *   #32 = Utf8               son
 *   #33 = Utf8               SourceFile
 *   #34 = Utf8               DispatchDemo.java
 *   #35 = NameAndType        #19:#20        // "<init>":()V
 *   #36 = Utf8               z/learn/lang/dispatch/DispatchDemo$Father
 *   #37 = Utf8               z/learn/lang/dispatch/DispatchDemo$Geely
 *   #38 = NameAndType        #44:#45        // hardChoice:(Lz/learn/lang/dispatch/DispatchDemo$Geely;)V
 *   #39 = Utf8               z/learn/lang/dispatch/DispatchDemo$Son
 *   #40 = Utf8               z/learn/lang/dispatch/DispatchDemo$QQ
 *   #41 = NameAndType        #44:#46        // hardChoice:(Lz/learn/lang/dispatch/DispatchDemo$QQ;)V
 *   #42 = Utf8               z/learn/lang/dispatch/DispatchDemo
 *   #43 = Utf8               java/lang/Object
 *   #44 = Utf8               hardChoice
 *   #45 = Utf8               (Lz/learn/lang/dispatch/DispatchDemo$Geely;)V
 *   #46 = Utf8               (Lz/learn/lang/dispatch/DispatchDemo$QQ;)V
 * {
 *   public z.learn.lang.dispatch.DispatchDemo();
 *     descriptor: ()V                              构造函数
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 4: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lz/learn/lang/dispatch/DispatchDemo;
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=3, locals=3, args_size=1
 *          0: new           #2                  // class z/learn/lang/dispatch/DispatchDemo$Father
 *          3: dup
 *          4: invokespecial #3                  // Method z/learn/lang/dispatch/DispatchDemo$Father."<init>":()V
 *          7: astore_1
 *          8: aload_1
 *          9: new           #4                  // class z/learn/lang/dispatch/DispatchDemo$Geely
 *         12: dup
 *         13: invokespecial #5                  // Method z/learn/lang/dispatch/DispatchDemo$Geely."<init>":()V
 *         16: invokevirtual #6                  // Method z/learn/lang/dispatch/DispatchDemo$Father.hardChoice:(Lz/learn/lang/dispatch/DispatchDemo$Geely;)V   静态分派到Father
 *         19: new           #7                  // class z/learn/lang/dispatch/DispatchDemo$Son
 *         22: dup
 *         23: invokespecial #8                  // Method z/learn/lang/dispatch/DispatchDemo$Son."<init>":()V
 *         26: astore_2
 *         27: aload_2
 *         28: new           #9                  // class z/learn/lang/dispatch/DispatchDemo$QQ
 *         31: dup
 *         32: invokespecial #10                 // Method z/learn/lang/dispatch/DispatchDemo$QQ."<init>":()V
 *         35: invokevirtual #11                 // Method z/learn/lang/dispatch/DispatchDemo$Father.hardChoice:(Lz/learn/lang/dispatch/DispatchDemo$QQ;)V
 *         38: return
 *       LineNumberTable:
 *         line 34: 0
 *         line 35: 8
 *         line 36: 19
 *         line 37: 27
 *         line 38: 38
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      39     0  args   [Ljava/lang/String;
 *             8      31     1 father   Lz/learn/lang/dispatch/DispatchDemo$Father;
 *            27      12     2   son   Lz/learn/lang/dispatch/DispatchDemo$Father;
 * }
 * SourceFile: "DispatchDemo.java"
 * InnerClasses:
 *      public static #14= #7 of #12; //Son=class z/learn/lang/dispatch/DispatchDemo$Son of class z/learn/lang/dispatch/DispatchDemo
 *      public static #16= #2 of #12; //Father=class z/learn/lang/dispatch/DispatchDemo$Father of class z/learn/lang/dispatch/DispatchDemo
 *      static #17= #4 of #12; //Geely=class z/learn/lang/dispatch/DispatchDemo$Geely of class z/learn/lang/dispatch/DispatchDemo
 *      static #18= #9 of #12; //QQ=class z/learn/lang/dispatch/DispatchDemo$QQ of class z/learn/lang/dispatch/DispatchDemo
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang/dispatch$
 */
