package z.learn.bytecode;

/**
 * 并没有加载String.class生成Class对象
 */
public class JvmByteCodeString {

    private String msg;

    public void example() {
        msg = "hello";
        System.out.println(msg);
    }
}
/**
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn$ javap -v -p JvmByteCodeString.class
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/JvmByteCodeString.class
 *   Last modified Aug 20, 2018; size 570 bytes
 *   MD5 checksum 39e6abbf0c1e9d538b4198c44cfa9201
 *   Compiled from "JvmByteCodeString.java"
 * public class z.learn.JvmByteCodeString
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #7.#20         // java/lang/Object."<init>":()V
 *    #2 = String             #21            // hello
 *    #3 = Fieldref           #6.#22         // z/learn/JvmByteCodeString.msg:Ljava/lang/String;
 *    #4 = Fieldref           #23.#24        // java/lang/System.out:Ljava/io/PrintStream;
 *    #5 = Methodref          #25.#26        // java/io/PrintStream.println:(Ljava/lang/String;)V
 *    #6 = Class              #27            // z/learn/JvmByteCodeString
 *    #7 = Class              #28            // java/lang/Object
 *    #8 = Utf8               msg
 *    #9 = Utf8               Ljava/lang/String;
 *   #10 = Utf8               <init>
 *   #11 = Utf8               ()V
 *   #12 = Utf8               Code
 *   #13 = Utf8               LineNumberTable
 *   #14 = Utf8               LocalVariableTable
 *   #15 = Utf8               this
 *   #16 = Utf8               Lz/learn/JvmByteCodeString;
 *   #17 = Utf8               example
 *   #18 = Utf8               SourceFile
 *   #19 = Utf8               JvmByteCodeString.java
 *   #20 = NameAndType        #10:#11        // "<init>":()V
 *   #21 = Utf8               hello
 *   #22 = NameAndType        #8:#9          // msg:Ljava/lang/String;
 *   #23 = Class              #29            // java/lang/System
 *   #24 = NameAndType        #30:#31        // out:Ljava/io/PrintStream;
 *   #25 = Class              #32            // java/io/PrintStream
 *   #26 = NameAndType        #33:#34        // println:(Ljava/lang/String;)V
 *   #27 = Utf8               z/learn/JvmByteCodeString
 *   #28 = Utf8               java/lang/Object
 *   #29 = Utf8               java/lang/System
 *   #30 = Utf8               out
 *   #31 = Utf8               Ljava/io/PrintStream;
 *   #32 = Utf8               java/io/PrintStream
 *   #33 = Utf8               println
 *   #34 = Utf8               (Ljava/lang/String;)V
 * {
 *   private java.lang.String msg;
 *     descriptor: Ljava/lang/String;
 *     flags: ACC_PRIVATE
 *
 *   public z.learn.JvmByteCodeString();
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
 *             0       5     0  this   Lz/learn/JvmByteCodeString;
 *
 *   public void example();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: aload_0                              load a reference onto the stack from local variable 0
 *          1: ldc           #2                  // String hello   从常量池取值然后存入栈。字节码里显示是符号，加载，连接之后是实际内存中的地址。 push a constant #index from a constant pool onto the stack
 *          3: putfield      #3                  // Field msg:Ljava/lang/String;
 *          6: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          9: aload_0
 *         10: getfield      #3                  // Field msg:Ljava/lang/String;
 *         13: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         16: return
 *       LineNumberTable:
 *         line 8: 0
 *         line 9: 6
 *         line 10: 16
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      17     0  this   Lz/learn/JvmByteCodeString;
 * }
 * SourceFile: "JvmByteCodeString.java"
 */