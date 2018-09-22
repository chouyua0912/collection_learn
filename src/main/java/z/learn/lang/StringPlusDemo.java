package z.learn.lang;

public class StringPlusDemo {

    public void example() {
        String str = "start";
        for (int i = 0; i < 100; i++) {
            str = str + "hello";        // 会反复 new StringBuilder对象出来
        }
    }
}
/**
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang$ javap -v -p StringPlusDemo.class
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/lang/StringPlusDemo.class
 *   Last modified Sep 22, 2018; size 691 bytes
 *   MD5 checksum f459028113526961fcd28e6562af19c4
 *   Compiled from "StringPlusDemo.java"
 * public class z.learn.lang.StringPlusDemo
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #9.#26         // java/lang/Object."<init>":()V
 *    #2 = String             #27            // start
 *    #3 = Class              #28            // java/lang/StringBuilder
 *    #4 = Methodref          #3.#26         // java/lang/StringBuilder."<init>":()V
 *    #5 = Methodref          #3.#29         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *    #6 = String             #30            // hello
 *    #7 = Methodref          #3.#31         // java/lang/StringBuilder.toString:()Ljava/lang/String;
 *    #8 = Class              #32            // z/learn/lang/StringPlusDemo
 *    #9 = Class              #33            // java/lang/Object
 *   #10 = Utf8               <init>
 *   #11 = Utf8               ()V
 *   #12 = Utf8               Code
 *   #13 = Utf8               LineNumberTable
 *   #14 = Utf8               LocalVariableTable
 *   #15 = Utf8               this
 *   #16 = Utf8               Lz/learn/lang/StringPlusDemo;
 *   #17 = Utf8               example
 *   #18 = Utf8               i
 *   #19 = Utf8               I
 *   #20 = Utf8               str
 *   #21 = Utf8               Ljava/lang/String;
 *   #22 = Utf8               StackMapTable
 *   #23 = Class              #34            // java/lang/String
 *   #24 = Utf8               SourceFile
 *   #25 = Utf8               StringPlusDemo.java
 *   #26 = NameAndType        #10:#11        // "<init>":()V
 *   #27 = Utf8               start
 *   #28 = Utf8               java/lang/StringBuilder
 *   #29 = NameAndType        #35:#36        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *   #30 = Utf8               hello
 *   #31 = NameAndType        #37:#38        // toString:()Ljava/lang/String;
 *   #32 = Utf8               z/learn/lang/StringPlusDemo
 *   #33 = Utf8               java/lang/Object
 *   #34 = Utf8               java/lang/String
 *   #35 = Utf8               append
 *   #36 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
 *   #37 = Utf8               toString
 *   #38 = Utf8               ()Ljava/lang/String;
 * {
 *   public z.learn.lang.StringPlusDemo();
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
 *             0       5     0  this   Lz/learn/lang/StringPlusDemo;
 *
 *   public void example();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=3, args_size=1
 *          0: ldc           #2                  // String start
 *          2: astore_1
 *          3: iconst_0
 *          4: istore_2
 *          5: iload_2
 *          6: bipush        100
 *          8: if_icmpge     37
 *         11: new           #3                  // class java/lang/StringBuilder
 *         14: dup
 *         15: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
 *         18: aload_1                           // load a reference onto the stack from local variable 1
 *         19: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *         22: ldc           #6                  // String hello
 *         24: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *         27: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 *         30: astore_1
 *         31: iinc          2, 1
 *         34: goto          5
 *         37: return
 *       LineNumberTable:
 *         line 6: 0
 *         line 7: 3
 *         line 8: 11
 *         line 7: 31
 *         line 10: 37
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             5      32     2     i   I
 *             0      38     0  this   Lz/learn/lang/StringPlusDemo;
 *             3      35     1   str   Ljava/lang/String;
 *       StackMapTable: number_of_entries = 2
 *         frame_type = 253 // append //
 *           offset_delta = 5
 *           locals = [ class java/lang/String, int ]
 *         frame_type = 250 // chop //
 *           offset_delta = 31
 * }
 * SourceFile: "StringPlusDemo.java"
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang$
 */