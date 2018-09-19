package z.learn.bytecode;

/**
 * javap -p -v
 * -p  -private             Show all classes and members
 * -v  -verbose             Print additional information
 * 字节码层面与普通变量没有差别，变量会被标记 ACC_VOLATILE
 * 汇编机器指令层次区别，加入了lock指令
 * 内存屏障有两个能力：
 *   1. 阻止屏障两边的指令重排序
 *   2. 强制把写缓冲区/高速缓存中的脏数据等写回主内存，让缓存中相应的数据失效
 *   上述volatile方式的i++，总共是四个步骤：
 *     * Load、Increment、Store、Memory Barriers。
 *
 *     https://my.oschina.net/tantexian/blog/808032
 *     https://www.cnblogs.com/xrq730/p/7048693.html
 * 方法不被调用编译器会自动把他优化掉
 */
public class JvmByteCodeVolatile {
    private volatile boolean stop = false;
    private static volatile boolean stop2;

    public void example() throws InterruptedException {
        stop2 = false;
        System.out.println("Example Started");
        new Thread(new Loop(), "Loop").start();
        Thread.sleep(1000);
        stop = true;
        System.out.println("Example ended");
    }

    class Loop implements Runnable {
        @Override
        public void run() {
            while (!stop) {
                System.out.println("Hello world");
            }
        }
    }
}
/**
 *z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn$ javap -p -v JvmByteCodeVolatile.class
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/JvmByteCodeVolatile.class
 *   Last modified Aug 19, 2018; size 1100 bytes
 *   MD5 checksum b7b1f96259eb0b39f857647f41e489ad
 *   Compiled from "JvmByteCodeVolatile.java"
 * public class z.learn.JvmByteCodeVolatile
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Fieldref           #17.#39        // z/learn/JvmByteCodeVolatile.stop:Z
 *    #2 = Methodref          #18.#40        // java/lang/Object."<init>":()V
 *    #3 = Fieldref           #17.#41        // z/learn/JvmByteCodeVolatile.stop2:Z
 *    #4 = Fieldref           #42.#43        // java/lang/System.out:Ljava/io/PrintStream;
 *    #5 = String             #44            // Example Started
 *    #6 = Methodref          #45.#46        // java/io/PrintStream.println:(Ljava/lang/String;)V
 *    #7 = Class              #47            // java/lang/Thread
 *    #8 = Class              #48            // z/learn/JvmByteCodeVolatile$Loop
 *    #9 = Methodref          #8.#49         // z/learn/JvmByteCodeVolatile$Loop."<init>":(Lz/learn/JvmByteCodeVolatile;)V
 *   #10 = String             #19            // Loop
 *   #11 = Methodref          #7.#50         // java/lang/Thread."<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
 *   #12 = Methodref          #7.#51         // java/lang/Thread.start:()V
 *   #13 = Long               1000l
 *   #15 = Methodref          #7.#52         // java/lang/Thread.sleep:(J)V
 *   #16 = String             #53            // Example ended
 *   #17 = Class              #54            // z/learn/JvmByteCodeVolatile
 *   #18 = Class              #55            // java/lang/Object
 *   #19 = Utf8               Loop
 *   #20 = Utf8               InnerClasses
 *   #21 = Utf8               stop
 *   #22 = Utf8               Z
 *   #23 = Utf8               stop2
 *   #24 = Utf8               <init>
 *   #25 = Utf8               ()V
 *   #26 = Utf8               Code
 *   #27 = Utf8               LineNumberTable
 *   #28 = Utf8               LocalVariableTable
 *   #29 = Utf8               this
 *   #30 = Utf8               Lz/learn/JvmByteCodeVolatile;
 *   #31 = Utf8               example
 *   #32 = Utf8               Exceptions
 *   #33 = Class              #56            // java/lang/InterruptedException
 *   #34 = Utf8               access$000
 *   #35 = Utf8               (Lz/learn/JvmByteCodeVolatile;)Z
 *   #36 = Utf8               x0
 *   #37 = Utf8               SourceFile
 *   #38 = Utf8               JvmByteCodeVolatile.java
 *   #39 = NameAndType        #21:#22        // stop:Z
 *   #40 = NameAndType        #24:#25        // "<init>":()V
 *   #41 = NameAndType        #23:#22        // stop2:Z
 *   #42 = Class              #57            // java/lang/System
 *   #43 = NameAndType        #58:#59        // out:Ljava/io/PrintStream;
 *   #44 = Utf8               Example Started
 *   #45 = Class              #60            // java/io/PrintStream
 *   #46 = NameAndType        #61:#62        // println:(Ljava/lang/String;)V
 *   #47 = Utf8               java/lang/Thread
 *   #48 = Utf8               z/learn/JvmByteCodeVolatile$Loop
 *   #49 = NameAndType        #24:#63        // "<init>":(Lz/learn/JvmByteCodeVolatile;)V
 *   #50 = NameAndType        #24:#64        // "<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
 *   #51 = NameAndType        #65:#25        // start:()V
 *   #52 = NameAndType        #66:#67        // sleep:(J)V
 *   #53 = Utf8               Example ended
 *   #54 = Utf8               z/learn/JvmByteCodeVolatile
 *   #55 = Utf8               java/lang/Object
 *   #56 = Utf8               java/lang/InterruptedException
 *   #57 = Utf8               java/lang/System
 *   #58 = Utf8               out
 *   #59 = Utf8               Ljava/io/PrintStream;
 *   #60 = Utf8               java/io/PrintStream
 *   #61 = Utf8               println
 *   #62 = Utf8               (Ljava/lang/String;)V
 *   #63 = Utf8               (Lz/learn/JvmByteCodeVolatile;)V
 *   #64 = Utf8               (Ljava/lang/Runnable;Ljava/lang/String;)V
 *   #65 = Utf8               start
 *   #66 = Utf8               sleep
 *   #67 = Utf8               (J)V
 * {
 *   private volatile boolean stop;
 *     descriptor: Z
 *     flags: ACC_PRIVATE, ACC_VOLATILE         表示易变属性
 *
 *   private static volatile boolean stop2;
 *     descriptor: Z
 *     flags: ACC_PRIVATE, ACC_STATIC, ACC_VOLATILE
 *
 *   public z.learn.JvmByteCodeVolatile();      构造函数
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #2                  // Method java/lang/Object."<init>":()V
 *          4: aload_0
 *          5: iconst_0
 *          6: putfield      #1                  // Field stop:Z
 *          9: return
 *       LineNumberTable:
 *         line 8: 0
 *         line 9: 4
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      10     0  this   Lz/learn/JvmByteCodeVolatile;
 *
 *   public void example() throws java.lang.InterruptedException;
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=5, locals=1, args_size=1
 *          0: iconst_0
 *          1: putstatic     #3                  // Field stop2:Z    设置 volatile 变量，与普通设置相同   set static field to value in a class, where the field is identified by a field reference index in constant pool
 *          4: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          7: ldc           #5                  // String Example Started
 *          9: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         12: new           #7                  // class java/lang/Thread
 *         15: dup
 *         16: new           #8                  // class z/learn/JvmByteCodeVolatile$Loop
 *         19: dup
 *         20: aload_0
 *         21: invokespecial #9                  // Method z/learn/JvmByteCodeVolatile$Loop."<init>":(Lz/learn/JvmByteCodeVolatile;)V
 *         24: ldc           #10                 // String Loop
 *         26: invokespecial #11                 // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
 *         29: invokevirtual #12                 // Method java/lang/Thread.start:()V
 *         32: ldc2_w        #13                 // long 1000l
 *         35: invokestatic  #15                 // Method java/lang/Thread.sleep:(J)V
 *         38: aload_0
 *         39: iconst_1
 *         40: putfield      #1                  // Field stop:Z
 *         43: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         46: ldc           #16                 // String Example ended
 *         48: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         51: return
 *       LineNumberTable:
 *         line 13: 0
 *         line 14: 4
 *         line 15: 12
 *         line 16: 32
 *         line 17: 38
 *         line 18: 43
 *         line 19: 51
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      52     0  this   Lz/learn/JvmByteCodeVolatile;
 *     Exceptions:
 *       throws java.lang.InterruptedException
 *
 *   static boolean access$000(z.learn.JvmByteCodeVolatile);            自动生成的静态方法，用户访问volatile变量
 *     descriptor: (Lz/learn/JvmByteCodeVolatile;)Z
 *     flags: ACC_STATIC, ACC_SYNTHETIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: getfield      #1                  // Field stop:Z        访问获取 Volatile 变量
 *          4: ireturn
 *       LineNumberTable:
 *         line 8: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0    x0   Lz/learn/JvmByteCodeVolatile;
 * }
 * SourceFile: "JvmByteCodeVolatile.java"
 * InnerClasses:
 *      #19= #8 of #17; //Loop=class z/learn/JvmByteCodeVolatile$Loop of class z/learn/JvmByteCodeVolatile
 -------------------------------------------------------------------------------------------------------------------
 -------------------------------------------------------------------------------------------------------------------
 -------------------------------------------------------------------------------------------------------------------
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn$ javap -v JvmByteCodeVolatile\$Loop.class
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/JvmByteCodeVolatile$Loop.class
 *   Last modified Aug 19, 2018; size 838 bytes
 *   MD5 checksum 6db986f83845f0d351fe0ac9ee76d13f
 *   Compiled from "JvmByteCodeVolatile.java"
 * class z.learn.JvmByteCodeVolatile$Loop implements java.lang.Runnable
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_SUPER
 * Constant pool:
 *    #1 = Fieldref           #7.#26         // z/learn/JvmByteCodeVolatile$Loop.this$0:Lz/learn/JvmByteCodeVolatile;
 *    #2 = Methodref          #8.#27         // java/lang/Object."<init>":()V
 *    #3 = Methodref          #28.#29        // z/learn/JvmByteCodeVolatile.access$000:(Lz/learn/JvmByteCodeVolatile;)Z
 *    #4 = Fieldref           #30.#31        // java/lang/System.out:Ljava/io/PrintStream;
 *    #5 = String             #32            // Hello world
 *    #6 = Methodref          #33.#34        // java/io/PrintStream.println:(Ljava/lang/String;)V
 *    #7 = Class              #35            // z/learn/JvmByteCodeVolatile$Loop
 *    #8 = Class              #36            // java/lang/Object
 *    #9 = Class              #37            // java/lang/Runnable
 *   #10 = Utf8               this$0
 *   #11 = Utf8               Lz/learn/JvmByteCodeVolatile;
 *   #12 = Utf8               <init>
 *   #13 = Utf8               (Lz/learn/JvmByteCodeVolatile;)V
 *   #14 = Utf8               Code
 *   #15 = Utf8               LineNumberTable
 *   #16 = Utf8               LocalVariableTable
 *   #17 = Utf8               this
 *   #18 = Utf8               Loop
 *   #19 = Utf8               InnerClasses
 *   #20 = Utf8               Lz/learn/JvmByteCodeVolatile$Loop;
 *   #21 = Utf8               run
 *   #22 = Utf8               ()V
 *   #23 = Utf8               StackMapTable
 *   #24 = Utf8               SourceFile
 *   #25 = Utf8               JvmByteCodeVolatile.java
 *   #26 = NameAndType        #10:#11        // this$0:Lz/learn/JvmByteCodeVolatile;
 *   #27 = NameAndType        #12:#22        // "<init>":()V
 *   #28 = Class              #38            // z/learn/JvmByteCodeVolatile
 *   #29 = NameAndType        #39:#40        // access$000:(Lz/learn/JvmByteCodeVolatile;)Z
 *   #30 = Class              #41            // java/lang/System
 *   #31 = NameAndType        #42:#43        // out:Ljava/io/PrintStream;
 *   #32 = Utf8               Hello world
 *   #33 = Class              #44            // java/io/PrintStream
 *   #34 = NameAndType        #45:#46        // println:(Ljava/lang/String;)V
 *   #35 = Utf8               z/learn/JvmByteCodeVolatile$Loop
 *   #36 = Utf8               java/lang/Object
 *   #37 = Utf8               java/lang/Runnable
 *   #38 = Utf8               z/learn/JvmByteCodeVolatile
 *   #39 = Utf8               access$000
 *   #40 = Utf8               (Lz/learn/JvmByteCodeVolatile;)Z
 *   #41 = Utf8               java/lang/System
 *   #42 = Utf8               out
 *   #43 = Utf8               Ljava/io/PrintStream;
 *   #44 = Utf8               java/io/PrintStream
 *   #45 = Utf8               println
 *   #46 = Utf8               (Ljava/lang/String;)V
 * {
 *   final z.learn.JvmByteCodeVolatile this$0;
 *     descriptor: Lz/learn/JvmByteCodeVolatile;
 *     flags: ACC_FINAL, ACC_SYNTHETIC
 *
 *   z.learn.JvmByteCodeVolatile$Loop(z.learn.JvmByteCodeVolatile);
 *     descriptor: (Lz/learn/JvmByteCodeVolatile;)V
 *     flags:
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: aload_0
 *          1: aload_1
 *          2: putfield      #1                  // Field this$0:Lz/learn/JvmByteCodeVolatile;
 *          5: aload_0
 *          6: invokespecial #2                  // Method java/lang/Object."<init>":()V
 *          9: return
 *       LineNumberTable:
 *         line 17: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      10     0  this   Lz/learn/JvmByteCodeVolatile$Loop;
 *             0      10     1 this$0   Lz/learn/JvmByteCodeVolatile;
 *
 *   public void run();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: aload_0
 *          1: getfield      #1                  // Field this$0:Lz/learn/JvmByteCodeVolatile;
 *          4: invokestatic  #3                  // Method z/learn/JvmByteCodeVolatile.access$000:(Lz/learn/JvmByteCodeVolatile;)Z     调用外部类生成的static方法来访问volatile变量
 *          7: ifne          21                     分支判断 if value is not 0, branch to instruction at branchoffset
 *         10: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         13: ldc           #5                  // String Hello world
 *         15: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         18: goto          0
 *         21: return
 *       LineNumberTable:
 *         line 20: 0
 *         line 21: 10
 *         line 23: 21
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      22     0  this   Lz/learn/JvmByteCodeVolatile$Loop;
 *       StackMapTable: number_of_entries = 2
 *         frame_type = 0        //* same
 *         frame_type=20         //* same
  }
         *SourceFile:"JvmByteCodeVolatile.java"
         *InnerClasses:
         *      #18= #7of #28; //Loop=class z/learn/JvmByteCodeVolatile$Loop of class z/learn/JvmByteCodeVolatile
 * */