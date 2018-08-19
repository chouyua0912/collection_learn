package z.learn;

/**
 * 方法执行的时候，入参被复制到本地变量表里，args->local variables table 复制
 */
public class JvmByteCodeExample {

    private String msg;
    private Inner var;

    public JvmByteCodeExample(String msg) {
        this.msg = msg;
        String test = this.msg;
        System.out.println(test);
    }

    public void example() {
        var = new Inner("testInner");

        System.out.println(var.getStr());
    }


    static class Inner {
        private String str;

        public Inner(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }
}
/**
 *
 ojects/collectionlearn/target/classes/z/learn$ javap -v JvmByteCodeExample.class
 Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/JvmByteCodeExample.class
 Last modified Aug 19, 2018; size 837 bytes
 MD5 checksum c09acd673760217813f8e1a461566195
 Compiled from "JvmByteCodeExample.java"
 public class z.learn.JvmByteCodeExample
 minor version: 0
 major version: 52
 flags: ACC_PUBLIC, ACC_SUPER
 Constant pool:
 #1 = Methodref          #11.#30        // java/lang/Object."<init>":()V
 #2 = Fieldref           #10.#31        // z/learn/JvmByteCodeExample.msg:Ljava/lang/String;
 #3 = Fieldref           #32.#33        // java/lang/System.out:Ljava/io/PrintStream;
 #4 = Methodref          #34.#35        // java/io/PrintStream.println:(Ljava/lang/String;)V
 #5 = Class              #36            // z/learn/JvmByteCodeExample$Inner
 #6 = String             #37            // testInner
 #7 = Methodref          #5.#38         // z/learn/JvmByteCodeExample$Inner."<init>":(Ljava/lang/String;)V
 #8 = Fieldref           #10.#39        // z/learn/JvmByteCodeExample.var:Lz/learn/JvmByteCodeExample$Inner;
 #9 = Methodref          #5.#40         // z/learn/JvmByteCodeExample$Inner.getStr:()Ljava/lang/String;
 #10 = Class              #41            // z/learn/JvmByteCodeExample
 #11 = Class              #42            // java/lang/Object
 #12 = Utf8               Inner
 #13 = Utf8               InnerClasses
 #14 = Utf8               msg
 #15 = Utf8               Ljava/lang/String;
 #16 = Utf8               var
 #17 = Utf8               Lz/learn/JvmByteCodeExample$Inner;
 #18 = Utf8               <init>
 #19 = Utf8               (Ljava/lang/String;)V
 #20 = Utf8               Code
 #21 = Utf8               LineNumberTable
 #22 = Utf8               LocalVariableTable
 #23 = Utf8               this
 #24 = Utf8               Lz/learn/JvmByteCodeExample;
 #25 = Utf8               test
 #26 = Utf8               example
 #27 = Utf8               ()V
 #28 = Utf8               SourceFile
 #29 = Utf8               JvmByteCodeExample.java
 #30 = NameAndType        #18:#27        // "<init>":()V
 #31 = NameAndType        #14:#15        // msg:Ljava/lang/String;
 #32 = Class              #43            // java/lang/System
 #33 = NameAndType        #44:#45        // out:Ljava/io/PrintStream;
 #34 = Class              #46            // java/io/PrintStream
 #35 = NameAndType        #47:#19        // println:(Ljava/lang/String;)V
 #36 = Utf8               z/learn/JvmByteCodeExample$Inner
 #37 = Utf8               testInner
 #38 = NameAndType        #18:#19        // "<init>":(Ljava/lang/String;)V
 #39 = NameAndType        #16:#17        // var:Lz/learn/JvmByteCodeExample$Inner;
 #40 = NameAndType        #48:#49        // getStr:()Ljava/lang/String;
 #41 = Utf8               z/learn/JvmByteCodeExample
 #42 = Utf8               java/lang/Object
 #43 = Utf8               java/lang/System
 #44 = Utf8               out
 #45 = Utf8               Ljava/io/PrintStream;
 #46 = Utf8               java/io/PrintStream
 #47 = Utf8               println
 #48 = Utf8               getStr
 #49 = Utf8               ()Ljava/lang/String;
 {
 public z.learn.JvmByteCodeExample(java.lang.String);
 descriptor: (Ljava/lang/String;)V      构造函数
 flags: ACC_PUBLIC
 Code:
 stack=2, locals=3, args_size=2         入参被按顺序复制到本地变量表里：this, String msg
 0: aload_0                             从本地变量表加载变量0： this
 1: invokespecial #1                  // Method java/lang/Object."<init>":()V   Methodref  #11.#30  调用Object的init方法
 4: aload_0                             入栈顶 this            putfield 是个两个操作数的指令  objectref, value →
 5: aload_1                             入栈顶 String msg
 6: putfield      #2                  // Field msg:Ljava/lang/String;       将栈顶值复制到filed msg    Fieldref #10.#31
 9: aload_0                                                                 本地变量表this复制到栈顶
 10: getfield      #2                  // Field msg:Ljava/lang/String;      objectref → value， 栈顶的ref变成引用变量的value
 13: astore_2
 14: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
 17: aload_2
 18: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V      objectref, [arg1, arg2, ...] → result
 21: return
 LineNumberTable:
 line 11: 0
 line 12: 4
 line 13: 9
 line 14: 14
 line 15: 21
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 0      22     0  this   Lz/learn/JvmByteCodeExample;
 0      22     1   msg   Ljava/lang/String;
 14       8     2  test   Ljava/lang/String;

 public void example();
 descriptor: ()V
 flags: ACC_PUBLIC
 Code:
 stack=4, locals=1, args_size=1
 0: aload_0
 1: new           #5                  // class z/learn/JvmByteCodeExample$Inner
 4: dup
 5: ldc           #6                  // String testInner   把String（引用）压栈 push a constant #index from a constant pool (String, int, float, Class, java.lang.invoke.MethodType, or java.lang.invoke.MethodHandle) onto the stack
 7: invokespecial #7                  // Method z/learn/JvmByteCodeExample$Inner."<init>":(Ljava/lang/String;)V        #7 = Methodref  #5.#38
 10: putfield      #8                  // Field var:Lz/learn/JvmByteCodeExample$Inner;
 13: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;      get a static field value of a class, where the field is identified by field reference in the constant pool index
 16: aload_0
 17: getfield      #8                  // Field var:Lz/learn/JvmByteCodeExample$Inner;
 20: invokevirtual #9                  // Method z/learn/JvmByteCodeExample$Inner.getStr:()Ljava/lang/String;   invokevirtual 将栈顶的数据作为参数传给方法
 23: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 26: return                            invokevirtual -> objectref, [arg1, arg2, ...] → result   调用方法的时候第一个参数都是 objectref，创建出来新的栈帧
 LineNumberTable:                       将返回地址压栈，改变programCounter到新的方法，开始执行
 line 18: 0
 line 20: 13
 line 21: 26
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 0      27     0  this   Lz/learn/JvmByteCodeExample;
 }
 SourceFile: "JvmByteCodeExample.java"
 InnerClasses:
 static #12= #5 of #10; //Inner=class z/learn/JvmByteCodeExample$Inner of class z/learn/JvmByteCodeExample

 * ---------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn$ javap -v 'JvmByteCodeExample$Inner.class'
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/JvmByteCodeExample$Inner.class
 *   Last modified Aug 19, 2018; size 648 bytes
 *   MD5 checksum 56f4e3b689516665b15d9d434042c59c
 *   Compiled from "JvmByteCodeExample.java"
 * class z.learn.JvmByteCodeExample$Inner
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #4.#21         // java/lang/Object."<init>":()V
 *    #2 = Fieldref           #3.#22         // z/learn/JvmByteCodeExample$Inner.str:Ljava/lang/String;
 *    #3 = Class              #24            // z/learn/JvmByteCodeExample$Inner
 *    #4 = Class              #25            // java/lang/Object
 *    #5 = Utf8               str
 *    #6 = Utf8               Ljava/lang/String;
 *    #7 = Utf8               <init>
 *    #8 = Utf8               (Ljava/lang/String;)V
 *    #9 = Utf8               Code
 *   #10 = Utf8               LineNumberTable
 *   #11 = Utf8               LocalVariableTable
 *   #12 = Utf8               this
 *   #13 = Utf8               Inner
 *   #14 = Utf8               InnerClasses
 *   #15 = Utf8               Lz/learn/JvmByteCodeExample$Inner;
 *   #16 = Utf8               getStr
 *   #17 = Utf8               ()Ljava/lang/String;
 *   #18 = Utf8               setStr
 *   #19 = Utf8               SourceFile
 *   #20 = Utf8               JvmByteCodeExample.java
 *   #21 = NameAndType        #7:#26         // "<init>":()V
 *   #22 = NameAndType        #5:#6          // str:Ljava/lang/String;
 *   #23 = Class              #27            // z/learn/JvmByteCodeExample
 *   #24 = Utf8               z/learn/JvmByteCodeExample$Inner
 *   #25 = Utf8               java/lang/Object
 *   #26 = Utf8               ()V
 *   #27 = Utf8               z/learn/JvmByteCodeExample
 * {
 *   public z.learn.JvmByteCodeExample$Inner(java.lang.String);
 *     descriptor: (Ljava/lang/String;)V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: aload_0
 *          5: aload_1
 *          6: putfield      #2                  // Field str:Ljava/lang/String;
 *          9: return
 *       LineNumberTable:
 *         line 22: 0
 *         line 23: 4
 *         line 24: 9
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      10     0  this   Lz/learn/JvmByteCodeExample$Inner;
 *             0      10     1   str   Ljava/lang/String;
 *
 *   public java.lang.String getStr();
 *     descriptor: ()Ljava/lang/String;
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: getfield      #2                  // Field str:Ljava/lang/String;
 *          4: areturn
 *       LineNumberTable:
 *         line 27: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lz/learn/JvmByteCodeExample$Inner;
 *
 *   public void setStr(java.lang.String);
 *     descriptor: (Ljava/lang/String;)V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: aload_0
 *          1: aload_1
 *          2: putfield      #2                  // Field str:Ljava/lang/String;
 *          5: return
 *       LineNumberTable:
 *         line 31: 0
 *         line 32: 5
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       6     0  this   Lz/learn/JvmByteCodeExample$Inner;
 *             0       6     1   str   Ljava/lang/String;
 * }
 * SourceFile: "JvmByteCodeExample.java"
 * InnerClasses:
 *      static #13= #3 of #23; //Inner=class z/learn/JvmByteCodeExample$Inner of class z/learn/JvmByteCodeExample
 */