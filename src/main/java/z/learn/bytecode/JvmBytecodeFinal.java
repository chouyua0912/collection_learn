package z.learn.bytecode;

/**
 * javap -v -p -constants
 */
public class JvmBytecodeFinal {

    public void example() {
        final int abc = 1231121;
        new Thread(() -> {
            System.out.println(abc);        // abc 确实是引用的常量池的内容
        }, "exec-1").start();
    }
}
/**
 *z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn$ javap -v -p -constants LambdaBytecodeFinal.class
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/LambdaBytecodeFinal.class
 *   Last modified Sep 19, 2018; size 1201 bytes
 *   MD5 checksum d7a8a3345f44732ee0b726cde8d3c65b
 *   Compiled from "LambdaBytecodeFinal.java"
 * public class z.learn.LambdaBytecodeFinal
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #11.#25        // java/lang/Object."<init>":()V
 *    #2 = Integer            1231121
 *    #3 = Class              #26            // java/lang/Thread
 *    #4 = InvokeDynamic      #0:#31         // #0:run:()Ljava/lang/Runnable;
 *    #5 = String             #32            // exec-1
 *    #6 = Methodref          #3.#33         // java/lang/Thread."<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
 *    #7 = Methodref          #3.#34         // java/lang/Thread.start:()V
 *    #8 = Fieldref           #35.#36        // java/lang/System.out:Ljava/io/PrintStream;
 *    #9 = Methodref          #37.#38        // java/io/PrintStream.println:(I)V
 *   #10 = Class              #39            // z/learn/LambdaBytecodeFinal
 *   #11 = Class              #40            // java/lang/Object
 *   #12 = Utf8               <init>
 *   #13 = Utf8               ()V
 *   #14 = Utf8               Code
 *   #15 = Utf8               LineNumberTable
 *   #16 = Utf8               LocalVariableTable
 *   #17 = Utf8               this
 *   #18 = Utf8               Lz/learn/LambdaBytecodeFinal;
 *   #19 = Utf8               example
 *   #20 = Utf8               abc
 *   #21 = Utf8               I
 *   #22 = Utf8               lambda$example$0
 *   #23 = Utf8               SourceFile
 *   #24 = Utf8               LambdaBytecodeFinal.java
 *   #25 = NameAndType        #12:#13        // "<init>":()V
 *   #26 = Utf8               java/lang/Thread
 *   #27 = Utf8               BootstrapMethods
 *   #28 = MethodHandle       #6:#41         // invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
 *   #29 = MethodType         #13            //  ()V
 *   #30 = MethodHandle       #6:#42         // invokestatic z/learn/LambdaBytecodeFinal.lambda$example$0:()V
 *   #31 = NameAndType        #43:#44        // run:()Ljava/lang/Runnable;
 *   #32 = Utf8               exec-1
 *   #33 = NameAndType        #12:#45        // "<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
 *   #34 = NameAndType        #46:#13        // start:()V
 *   #35 = Class              #47            // java/lang/System
 *   #36 = NameAndType        #48:#49        // out:Ljava/io/PrintStream;
 *   #37 = Class              #50            // java/io/PrintStream
 *   #38 = NameAndType        #51:#52        // println:(I)V
 *   #39 = Utf8               z/learn/LambdaBytecodeFinal
 *   #40 = Utf8               java/lang/Object
 *   #41 = Methodref          #53.#54        // java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
 *   #42 = Methodref          #10.#55        // z/learn/LambdaBytecodeFinal.lambda$example$0:()V
 *   #43 = Utf8               run
 *   #44 = Utf8               ()Ljava/lang/Runnable;
 *   #45 = Utf8               (Ljava/lang/Runnable;Ljava/lang/String;)V
 *   #46 = Utf8               start
 *   #47 = Utf8               java/lang/System
 *   #48 = Utf8               out
 *   #49 = Utf8               Ljava/io/PrintStream;
 *   #50 = Utf8               java/io/PrintStream
 *   #51 = Utf8               println
 *   #52 = Utf8               (I)V
 *   #53 = Class              #56            // java/lang/invoke/LambdaMetafactory
 *   #54 = NameAndType        #57:#61        // metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
 *   #55 = NameAndType        #22:#13        // lambda$example$0:()V
 *   #56 = Utf8               java/lang/invoke/LambdaMetafactory
 *   #57 = Utf8               metafactory
 *   #58 = Class              #63            // java/lang/invoke/MethodHandles$Lookup
 *   #59 = Utf8               Lookup
 *   #60 = Utf8               InnerClasses
 *   #61 = Utf8               (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
 *   #62 = Class              #64            // java/lang/invoke/MethodHandles
 *   #63 = Utf8               java/lang/invoke/MethodHandles$Lookup
 *   #64 = Utf8               java/lang/invoke/MethodHandles
 * {
 *   public z.learn.LambdaBytecodeFinal();
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
 *             0       5     0  this   Lz/learn/LambdaBytecodeFinal;
 *
 *   public void example();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=4, locals=2, args_size=1
 *          0: ldc           #2                  // int 1231121
 *          2: istore_1
 *          3: new           #3                  // class java/lang/Thread
 *          6: dup
 *          7: invokedynamic #4,  0              // InvokeDynamic #0:run:()Ljava/lang/Runnable;
 *         12: ldc           #5                  // String exec-1
 *         14: invokespecial #6                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
 *         17: invokevirtual #7                  // Method java/lang/Thread.start:()V
 *         20: return
 *       LineNumberTable:
 *         line 6: 0
 *         line 7: 3
 *         line 9: 17
 *         line 10: 20
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      21     0  this   Lz/learn/LambdaBytecodeFinal;
 *             3      18     1   abc   I
 *
 *   private static void lambda$example$0();
 *     descriptor: ()V
 *     flags: ACC_PRIVATE, ACC_STATIC, ACC_SYNTHETIC
 *     Code:
 *       stack=2, locals=0, args_size=0
 *          0: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: ldc           #2                  // int 1231121
 *          5: invokevirtual #9                  // Method java/io/PrintStream.println:(I)V
 *          8: return
 *       LineNumberTable:
 *         line 8: 0
 *         line 9: 8
 * }
 * SourceFile: "LambdaBytecodeFinal.java"
 * InnerClasses:
 *      public static final #59= #58 of #62; //Lookup=class java/lang/invoke/MethodHandles$Lookup of class java/lang/invoke/MethodHandles
 * BootstrapMethods:
 *   0: #28 invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
 *     Method arguments:
 *       #29 ()V
 *       #30 invokestatic z/learn/LambdaBytecodeFinal.lambda$example$0:()V
 *       #29 ()V
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn$
 */