package z.learn.lang;

public class SeasonEnumDemo {

    public void example() {
        System.out.println(SeasonEnum.SPRING);
    }
}
/**
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang$ javap -v -p SeasonEnumDemo.class
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/lang/SeasonEnumDemo.class
 *   Last modified Sep 22, 2018; size 580 bytes
 *   MD5 checksum de5389b7f5f5beb8f51284e9207f9fee
 *   Compiled from "SeasonEnumDemo.java"
 * public class z.learn.lang.SeasonEnumDemo
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #6.#17         // java/lang/Object."<init>":()V
 *    #2 = Fieldref           #18.#19        // java/lang/System.out:Ljava/io/PrintStream;
 *    #3 = Fieldref           #20.#21        // z/learn/lang/SeasonEnum.SPRING:Lz/learn/lang/SeasonEnum;
 *    #4 = Methodref          #22.#23        // java/io/PrintStream.println:(Ljava/lang/Object;)V
 *    #5 = Class              #24            // z/learn/lang/SeasonEnumDemo
 *    #6 = Class              #25            // java/lang/Object
 *    #7 = Utf8               <init>
 *    #8 = Utf8               ()V
 *    #9 = Utf8               Code
 *   #10 = Utf8               LineNumberTable
 *   #11 = Utf8               LocalVariableTable
 *   #12 = Utf8               this
 *   #13 = Utf8               Lz/learn/lang/SeasonEnumDemo;
 *   #14 = Utf8               example
 *   #15 = Utf8               SourceFile
 *   #16 = Utf8               SeasonEnumDemo.java
 *   #17 = NameAndType        #7:#8          // "<init>":()V
 *   #18 = Class              #26            // java/lang/System
 *   #19 = NameAndType        #27:#28        // out:Ljava/io/PrintStream;
 *   #20 = Class              #29            // z/learn/lang/SeasonEnum
 *   #21 = NameAndType        #30:#31        // SPRING:Lz/learn/lang/SeasonEnum;
 *   #22 = Class              #32            // java/io/PrintStream
 *   #23 = NameAndType        #33:#34        // println:(Ljava/lang/Object;)V
 *   #24 = Utf8               z/learn/lang/SeasonEnumDemo
 *   #25 = Utf8               java/lang/Object
 *   #26 = Utf8               java/lang/System
 *   #27 = Utf8               out
 *   #28 = Utf8               Ljava/io/PrintStream;
 *   #29 = Utf8               z/learn/lang/SeasonEnum
 *   #30 = Utf8               SPRING
 *   #31 = Utf8               Lz/learn/lang/SeasonEnum;
 *   #32 = Utf8               java/io/PrintStream
 *   #33 = Utf8               println
 *   #34 = Utf8               (Ljava/lang/Object;)V
 * {
 *   public z.learn.lang.SeasonEnumDemo();
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
 *             0       5     0  this   Lz/learn/lang/SeasonEnumDemo;
 *
 *   public void example();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: getstatic     #3                  // Field z/learn/lang/SeasonEnum.SPRING:Lz/learn/lang/SeasonEnum;
 *          6: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
 *          9: return
 *       LineNumberTable:
 *         line 6: 0
 *         line 7: 9
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      10     0  this   Lz/learn/lang/SeasonEnumDemo;
 * }
 * SourceFile: "SeasonEnumDemo.java"
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang$
 */