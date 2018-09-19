package z.learn.bytecode;

public class JvmByteCodeArray {

    public void example() {
        String[] strs = new String[3];
    }
}
/**
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn$ javap -v JvmByteCodeArray.class
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/JvmByteCodeArray.class
 *   Last modified Aug 20, 2018; size 426 bytes
 *   MD5 checksum 3e0c2c09af1ca38221ae561a2410bcfc
 *   Compiled from "JvmByteCodeArray.java"
 * public class z.learn.JvmByteCodeArray
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #4.#17         // java/lang/Object."<init>":()V
 *    #2 = Class              #18            // java/lang/String
 *    #3 = Class              #19            // z/learn/JvmByteCodeArray
 *    #4 = Class              #20            // java/lang/Object
 *    #5 = Utf8               <init>
 *    #6 = Utf8               ()V
 *    #7 = Utf8               Code
 *    #8 = Utf8               LineNumberTable
 *    #9 = Utf8               LocalVariableTable
 *   #10 = Utf8               this
 *   #11 = Utf8               Lz/learn/JvmByteCodeArray;
 *   #12 = Utf8               example
 *   #13 = Utf8               strs
 *   #14 = Utf8               [Ljava/lang/String;
 *   #15 = Utf8               SourceFile
 *   #16 = Utf8               JvmByteCodeArray.java
 *   #17 = NameAndType        #5:#6          // "<init>":()V
 *   #18 = Utf8               java/lang/String
 *   #19 = Utf8               z/learn/JvmByteCodeArray
 *   #20 = Utf8               java/lang/Object
 * {
 *   public z.learn.JvmByteCodeArray();
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
 *             0       5     0  this   Lz/learn/JvmByteCodeArray;
 *
 *   public void example();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=2, args_size=1
 *          0: iconst_3
 *          1: anewarray     #2                  // class java/lang/String
 *          4: astore_1
 *          5: return
 *       LineNumberTable:
 *         line 6: 0
 *         line 7: 5
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       6     0  this   Lz/learn/JvmByteCodeArray;
 *             5       1     1  strs   [Ljava/lang/String;
 * }
 * SourceFile: "JvmByteCodeArray.java"
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn$
 * */