package z.learn.bytecode;

import java.util.ArrayList;
import java.util.List;

public class JvmBytecodeFinalArrayList {

    public void example() {

        List list = new ArrayList();
        list.add("abc");
        new Thread(() -> {
            list.add("cde");
        }, "exec").start();
    }
}
/**
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/bytecode$ javap -v -p -constants JvmBytecodeFinalArrayList.class
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/bytecode/JvmBytecodeFinalArrayList.class
 *   Last modified Sep 19, 2018; size 1316 bytes
 *   MD5 checksum 83e03c856d708da1d30c4ce8b869cfbf
 *   Compiled from "JvmBytecodeFinalArrayList.java"
 * public class z.learn.bytecode.JvmBytecodeFinalArrayList
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #13.#28        // java/lang/Object."<init>":()V
 *    #2 = Class              #29            // java/util/ArrayList
 *    #3 = Methodref          #2.#28         // java/util/ArrayList."<init>":()V
 *    #4 = String             #30            // abc
 *    #5 = InterfaceMethodref #31.#32        // java/util/List.add:(Ljava/lang/Object;)Z
 *    #6 = Class              #33            // java/lang/Thread
 *    #7 = InvokeDynamic      #0:#38         // #0:run:(Ljava/util/List;)Ljava/lang/Runnable;
 *    #8 = String             #39            // exec
 *    #9 = Methodref          #6.#40         // java/lang/Thread."<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
 *   #10 = Methodref          #6.#41         // java/lang/Thread.start:()V
 *   #11 = String             #42            // cde
 *   #12 = Class              #43            // z/learn/bytecode/JvmBytecodeFinalArrayList
 *   #13 = Class              #44            // java/lang/Object
 *   #14 = Utf8               <init>
 *   #15 = Utf8               ()V
 *   #16 = Utf8               Code
 *   #17 = Utf8               LineNumberTable
 *   #18 = Utf8               LocalVariableTable
 *   #19 = Utf8               this
 *   #20 = Utf8               Lz/learn/bytecode/JvmBytecodeFinalArrayList;
 *   #21 = Utf8               example
 *   #22 = Utf8               list
 *   #23 = Utf8               Ljava/util/List;
 *   #24 = Utf8               lambda$example$0
 *   #25 = Utf8               (Ljava/util/List;)V
 *   #26 = Utf8               SourceFile
 *   #27 = Utf8               JvmBytecodeFinalArrayList.java
 *   #28 = NameAndType        #14:#15        // "<init>":()V
 *   #29 = Utf8               java/util/ArrayList
 *   #30 = Utf8               abc
 *   #31 = Class              #45            // java/util/List
 *   #32 = NameAndType        #46:#47        // add:(Ljava/lang/Object;)Z
 *   #33 = Utf8               java/lang/Thread
 *   #34 = Utf8               BootstrapMethods
 *   #35 = MethodHandle       #6:#48         // invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
 *   #36 = MethodType         #15            //  ()V
 *   #37 = MethodHandle       #6:#49         // invokestatic z/learn/bytecode/JvmBytecodeFinalArrayList.lambda$example$0:(Ljava/util/List;)V
 *   #38 = NameAndType        #50:#51        // run:(Ljava/util/List;)Ljava/lang/Runnable;
 *   #39 = Utf8               exec
 *   #40 = NameAndType        #14:#52        // "<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
 *   #41 = NameAndType        #53:#15        // start:()V
 *   #42 = Utf8               cde
 *   #43 = Utf8               z/learn/bytecode/JvmBytecodeFinalArrayList
 *   #44 = Utf8               java/lang/Object
 *   #45 = Utf8               java/util/List
 *   #46 = Utf8               add
 *   #47 = Utf8               (Ljava/lang/Object;)Z
 *   #48 = Methodref          #54.#55        // java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
 *   #49 = Methodref          #12.#56        // z/learn/bytecode/JvmBytecodeFinalArrayList.lambda$example$0:(Ljava/util/List;)V
 *   #50 = Utf8               run
 *   #51 = Utf8               (Ljava/util/List;)Ljava/lang/Runnable;
 *   #52 = Utf8               (Ljava/lang/Runnable;Ljava/lang/String;)V
 *   #53 = Utf8               start
 *   #54 = Class              #57            // java/lang/invoke/LambdaMetafactory
 *   #55 = NameAndType        #58:#62        // metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
 *   #56 = NameAndType        #24:#25        // lambda$example$0:(Ljava/util/List;)V
 *   #57 = Utf8               java/lang/invoke/LambdaMetafactory
 *   #58 = Utf8               metafactory
 *   #59 = Class              #64            // java/lang/invoke/MethodHandles$Lookup
 *   #60 = Utf8               Lookup
 *   #61 = Utf8               InnerClasses
 *   #62 = Utf8               (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
 *   #63 = Class              #65            // java/lang/invoke/MethodHandles
 *   #64 = Utf8               java/lang/invoke/MethodHandles$Lookup
 *   #65 = Utf8               java/lang/invoke/MethodHandles
 * {
 *   public z.learn.bytecode.JvmBytecodeFinalArrayList();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 6: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lz/learn/bytecode/JvmBytecodeFinalArrayList;
 *
 *   public void example();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=4, locals=2, args_size=1
 *          0: new           #2                  // class java/util/ArrayList
 *          3: dup
 *          4: invokespecial #3                  // Method java/util/ArrayList."<init>":()V
 *          7: astore_1
 *          8: aload_1
 *          9: ldc           #4                  // String abc
 *         11: invokeinterface #5,  2            // InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
 *         16: pop
 *         17: new           #6                  // class java/lang/Thread
 *         20: dup
 *         21: aload_1
 *         22: invokedynamic #7,  0              // InvokeDynamic #0:run:(Ljava/util/List;)Ljava/lang/Runnable;
 *         27: ldc           #8                  // String exec
 *         29: invokespecial #9                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
 *         32: invokevirtual #10                 // Method java/lang/Thread.start:()V
 *         35: return
 *       LineNumberTable:
 *         line 10: 0
 *         line 11: 8
 *         line 13: 17
 *         line 15: 32
 *         line 16: 35
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      36     0  this   Lz/learn/bytecode/JvmBytecodeFinalArrayList;
 *             8      28     1  list   Ljava/util/List;
 *
 *   private static void lambda$example$0(java.util.List);
 *     descriptor: (Ljava/util/List;)V
 *     flags: ACC_PRIVATE, ACC_STATIC, ACC_SYNTHETIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: aload_0
 *          1: ldc           #11                 // String cde
 *          3: invokeinterface #5,  2            // InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
 *          8: pop
 *          9: return
 *       LineNumberTable:
 *         line 14: 0
 *         line 15: 9
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      10     0  list   Ljava/util/List;
 * }
 * SourceFile: "JvmBytecodeFinalArrayList.java"
 * InnerClasses:
 *      public static final #60= #59 of #63; //Lookup=class java/lang/invoke/MethodHandles$Lookup of class java/lang/invoke/MethodHandles
 * BootstrapMethods:
 *   0: #35 invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
 *     Method arguments:
 *       #36 ()V
 *       #37 invokestatic z/learn/bytecode/JvmBytecodeFinalArrayList.lambda$example$0:(Ljava/util/List;)V
 *       #36 ()V
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/bytecode$
 */