package z.learn.lang;

/**
 * 自动装箱与IntegerCache
 * 自动装箱编译器将Primitive赋值操作转化成对Integer.valueOf(int i)的方法调用
 */
public class IntegerDemo {

    public void example() {
        Integer one = Integer.valueOf(1);
        Integer one1 = Integer.valueOf(1);
        Integer onePrimitive = 1;                         // 自动装箱  编译器加入的代码  调用的是Integer.valueOf(int i)方法
        Integer oneNew = new Integer(1);            // new 出来的对象自动在堆上分配,不会使用IntegerCache里面的数据
        System.out.println("one == one1 ? " + (one == one1));                   // true
        System.out.println("one == onePrimitive ? " + (one == onePrimitive));   // true
        System.out.println("one == oneNew ? " + (one == oneNew));               // false
    }
}
/**
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang$ javap -v -p -constants IntegerDemo.class
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/lang/IntegerDemo.class
 *   Last modified Sep 22, 2018; size 1285 bytes
 *   MD5 checksum 395d3b24553e78ff7c18eeb4b62811e8
 *   Compiled from "IntegerDemo.java"
 * public class z.learn.lang.IntegerDemo
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:                               常量池
 *    #1 = Methodref          #16.#37        // java/lang/Object."<init>":()V
 *    #2 = Methodref          #3.#38         // java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
 *    #3 = Class              #39            // java/lang/Integer
 *    #4 = Methodref          #3.#40         // java/lang/Integer."<init>":(I)V
 *    #5 = Fieldref           #41.#42        // java/lang/System.out:Ljava/io/PrintStream;
 *    #6 = Class              #43            // java/lang/StringBuilder
 *    #7 = Methodref          #6.#37         // java/lang/StringBuilder."<init>":()V
 *    #8 = String             #44            // one == one1 ?
 *    #9 = Methodref          #6.#45         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *   #10 = Methodref          #6.#46         // java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
 *   #11 = Methodref          #6.#47         // java/lang/StringBuilder.toString:()Ljava/lang/String;
 *   #12 = Methodref          #48.#49        // java/io/PrintStream.println:(Ljava/lang/String;)V
 *   #13 = String             #50            // one == onePrimitive ?
 *   #14 = String             #51            // one == oneNew ?
 *   #15 = Class              #52            // z/learn/lang/IntegerDemo
 *   #16 = Class              #53            // java/lang/Object
 *   #17 = Utf8               <init>
 *   #18 = Utf8               ()V
 *   #19 = Utf8               Code
 *   #20 = Utf8               LineNumberTable
 *   #21 = Utf8               LocalVariableTable
 *   #22 = Utf8               this
 *   #23 = Utf8               Lz/learn/lang/IntegerDemo;
 *   #24 = Utf8               example
 *   #25 = Utf8               one
 *   #26 = Utf8               Ljava/lang/Integer;
 *   #27 = Utf8               one1
 *   #28 = Utf8               onePrimitive
 *   #29 = Utf8               oneNew
 *   #30 = Utf8               StackMapTable
 *   #31 = Class              #52            // z/learn/lang/IntegerDemo
 *   #32 = Class              #39            // java/lang/Integer
 *   #33 = Class              #54            // java/io/PrintStream
 *   #34 = Class              #43            // java/lang/StringBuilder
 *   #35 = Utf8               SourceFile
 *   #36 = Utf8               IntegerDemo.java
 *   #37 = NameAndType        #17:#18        // "<init>":()V
 *   #38 = NameAndType        #55:#56        // valueOf:(I)Ljava/lang/Integer;
 *   #39 = Utf8               java/lang/Integer
 *   #40 = NameAndType        #17:#57        // "<init>":(I)V
 *   #41 = Class              #58            // java/lang/System
 *   #42 = NameAndType        #59:#60        // out:Ljava/io/PrintStream;
 *   #43 = Utf8               java/lang/StringBuilder
 *   #44 = Utf8               one == one1 ?
 *   #45 = NameAndType        #61:#62        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *   #46 = NameAndType        #61:#63        // append:(Z)Ljava/lang/StringBuilder;
 *   #47 = NameAndType        #64:#65        // toString:()Ljava/lang/String;
 *   #48 = Class              #54            // java/io/PrintStream
 *   #49 = NameAndType        #66:#67        // println:(Ljava/lang/String;)V
 *   #50 = Utf8               one == onePrimitive ?
 *   #51 = Utf8               one == oneNew ?
 *   #52 = Utf8               z/learn/lang/IntegerDemo
 *   #53 = Utf8               java/lang/Object
 *   #54 = Utf8               java/io/PrintStream
 *   #55 = Utf8               valueOf
 *   #56 = Utf8               (I)Ljava/lang/Integer;
 *   #57 = Utf8               (I)V
 *   #58 = Utf8               java/lang/System
 *   #59 = Utf8               out
 *   #60 = Utf8               Ljava/io/PrintStream;
 *   #61 = Utf8               append
 *   #62 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
 *   #63 = Utf8               (Z)Ljava/lang/StringBuilder;
 *   #64 = Utf8               toString
 *   #65 = Utf8               ()Ljava/lang/String;
 *   #66 = Utf8               println
 *   #67 = Utf8               (Ljava/lang/String;)V
 * {
 *   public z.learn.lang.IntegerDemo();
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
 *             0       5     0  this   Lz/learn/lang/IntegerDemo;
 *
 *   public void example();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=4, locals=5, args_size=1
 *          0: iconst_1
 *          1: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
 *          4: astore_1
 *          5: iconst_1
 *          6: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
 *          9: astore_2
 *         10: iconst_1
 *         11: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;     自动装箱的实现, 编译器将primitive赋值操作转化为对Integer.valueOf(int)方法的调用
 *         14: astore_3
 *         15: new           #3                  // class java/lang/Integer
 *         18: dup
 *         19: iconst_1
 *         20: invokespecial #4                  // Method java/lang/Integer."<init>":(I)V
 *         23: astore        4
 *         25: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         28: new           #6                  // class java/lang/StringBuilder
 *         31: dup
 *         32: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
 *         35: ldc           #8                  // String one == one1 ?
 *         37: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *         40: aload_1
 *         41: aload_2
 *         42: if_acmpne     49
 *         45: iconst_1
 *         46: goto          50
 *         49: iconst_0
 *         50: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
 *         53: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 *         56: invokevirtual #12                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         59: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         62: new           #6                  // class java/lang/StringBuilder
 *         65: dup
 *         66: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
 *         69: ldc           #13                 // String one == onePrimitive ?
 *         71: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *         74: aload_1
 *         75: aload_3
 *         76: if_acmpne     83
 *         79: iconst_1
 *         80: goto          84
 *         83: iconst_0
 *         84: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
 *         87: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 *         90: invokevirtual #12                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         93: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         96: new           #6                  // class java/lang/StringBuilder
 *         99: dup
 *        100: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
 *        103: ldc           #14                 // String one == oneNew ?
 *        105: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *        108: aload_1
 *        109: aload         4
 *        111: if_acmpne     118
 *        114: iconst_1
 *        115: goto          119
 *        118: iconst_0
 *        119: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
 *        122: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 *        125: invokevirtual #12                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        128: return
 *       LineNumberTable:
 *         line 9: 0
 *         line 10: 5
 *         line 11: 10
 *         line 12: 15
 *         line 13: 25
 *         line 14: 59
 *         line 15: 93
 *         line 16: 128
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0     129     0  this   Lz/learn/lang/IntegerDemo;
 *             5     124     1   one   Ljava/lang/Integer;
 *            10     119     2  one1   Ljava/lang/Integer;
 *            15     114     3 onePrimitive   Ljava/lang/Integer;
 *            25     104     4 oneNew   Ljava/lang/Integer;
 *       StackMapTable: number_of_entries = 6
 *         frame_type = 255 // full_frame //
 *           offset_delta = 49
 *           locals = [ class z/learn/lang/IntegerDemo, class java/lang/Integer, class java/lang/Integer, class java/lang/Integer, class java/lang/Integer ]
 *           stack = [ class java/io/PrintStream, class java/lang/StringBuilder ]
 *         frame_type = 255 // full_frame //
 *           offset_delta = 0
 *           locals = [ class z/learn/lang/IntegerDemo, class java/lang/Integer, class java/lang/Integer, class java/lang/Integer, class java/lang/Integer ]
 *           stack = [ class java/io/PrintStream, class java/lang/StringBuilder, int ]
 *         frame_type = 255 // full_frame //
 *           offset_delta = 32
 *           locals = [ class z/learn/lang/IntegerDemo, class java/lang/Integer, class java/lang/Integer, class java/lang/Integer, class java/lang/Integer ]
 *           stack = [ class java/io/PrintStream, class java/lang/StringBuilder ]
 *         frame_type = 255 // full_frame //
 *           offset_delta = 0
 *           locals = [ class z/learn/lang/IntegerDemo, class java/lang/Integer, class java/lang/Integer, class java/lang/Integer, class java/lang/Integer ]
 *           stack = [ class java/io/PrintStream, class java/lang/StringBuilder, int ]
 *         frame_type = 255 // full_frame //
 *           offset_delta = 33
 *           locals = [ class z/learn/lang/IntegerDemo, class java/lang/Integer, class java/lang/Integer, class java/lang/Integer, class java/lang/Integer ]
 *           stack = [ class java/io/PrintStream, class java/lang/StringBuilder ]
 *         frame_type = 255 // full_frame //
 *           offset_delta = 0
 *           locals = [ class z/learn/lang/IntegerDemo, class java/lang/Integer, class java/lang/Integer, class java/lang/Integer, class java/lang/Integer ]
 *           stack = [ class java/io/PrintStream, class java/lang/StringBuilder, int ]
 * }
 * SourceFile: "IntegerDemo.java"
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang$
 */