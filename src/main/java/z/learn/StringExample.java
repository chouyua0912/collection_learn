package z.learn;

/**
 * Java 计算模型是基于栈的，没有寄存器这种设计
 * 所有操作指令都是先入栈操作数，然后执行操作指令
 */
public class StringExample {

    public void example() {
        char data[] = {'a', 'b', 'c'};
        String str = new String(data);
        System.out.println(str);

        System.out.println("abc");
        String cde = "cde";
        System.out.println("abc" + cde);    // + 是通过StringBuilder的append实现的，StringBuilder线程不安全
        String c = "abc".substring(2, 3);   // begin 被包含， end 不被包含
        System.out.println(c);

        String d = cde.substring(1, 2);
        System.out.println(d);
    }

    public void test1(){
        String str1="aaa";
        String str2="aaa";
        System.out.println("===========test1============");
        System.out.println(str1==str2);//true 可以看出str1跟str2是指向同一个对象
    }

    public void test2(){
        String str3=new String("aaa");              // 创建String对象，放在堆内存这种， value指向常量池
        String str4=new String("aaa");
        System.out.println("===========test2============");
        System.out.println(str3==str4);//false 可以看出用new的方式是生成不同的对象
    }

    public void test3(){
        String s0="helloworld";
        String s1="helloworld";
        String s2="hello"+"world";
        System.out.println("===========test3============");
        System.out.println(s0==s1); //true 可以看出s0跟s1是指向同一个对象
        System.out.println(s0==s2); //true 可以看出s0跟s2是指向同一个对象
    }

    public void test4(){
        String s0="helloworld";
        String s1=new String("helloworld");
        String s2="hello" + new String("world");
        System.out.println("===========test4============");
        System.out.println( s0==s1 ); //false
        System.out.println( s0==s2 ); //false
        System.out.println( s1==s2 ); //false
    }

    public void test5(){
        String str1="abc";
        String str2="def";
        String str3=str1+str2;
        System.out.println("===========test5============");
        System.out.println(str3=="abcdef"); //false
    }

    public void test6(){
        String s0 = "a1";
        String s1 = "a" + 1;
        System.out.println("===========test6============");
        System.out.println((s0 == s1)); //result = true
        String s2 = "atrue";
        String s3= "a" + "true";
        System.out.println((s2 == s3)); //result = true
        String s4 = "a3.4";
        String s5 = "a" + 3.4;
        System.out.println((s4 == s5)); //result = true
    }

    public void test7(){
        String s0 = "ab";
        String s1 = "b";
        String s2 = "a" + s1;
        System.out.println("===========test7============");
        System.out.println((s0 == s2)); //result = false
    }

    public void test8(){
        String test="javalanguagespecification";
        String str="java";
        String str1="language";
        String str2="specification";
        System.out.println("===========test8============");
        System.out.println(test == "java" + "language" + "specification");
        System.out.println(test == str + str1 + str2);
    }

    public void test9(){
        String s0 = "ab";
        final String s1 = "b";
        String s2 = "a" + s1;
        System.out.println("===========test9============");
        System.out.println((s0 == s2)); //result = true
    }

    public void test10(){
        String s0 = "ab";
        final String s1 = getS1();
        String s2 = "a" + s1;
        System.out.println("===========test10============");
        System.out.println((s0 == s2)); //result = false

    }

    private static String getS1() {
        return "b";
    }
}
/**
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn$ javap -v StringExample.class
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/StringExample.class
 *   Last modified Aug 18, 2018; size 969 bytes
 *   MD5 checksum e7c7b6c8321848c1c5437dd5e966bb66
 *   Compiled from "StringExample.java"
 * public class z.learn.StringExample
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:                            // 常量表
 *    #1 = Methodref          #14.#32        // java/lang/Object."<init>":()V
 *    #2 = Class              #33            // java/lang/String
 *    #3 = Methodref          #2.#34         // java/lang/String."<init>":([C)V
 *    #4 = Fieldref           #35.#36        // java/lang/System.out:Ljava/io/PrintStream;
 *    #5 = Methodref          #37.#38        // java/io/PrintStream.println:(Ljava/lang/String;)V
 *    #6 = String             #39            // abc
 *    #7 = String             #27            // cde
 *    #8 = Class              #40            // java/lang/StringBuilder
 *    #9 = Methodref          #8.#32         // java/lang/StringBuilder."<init>":()V
 *   #10 = Methodref          #8.#41         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *   #11 = Methodref          #8.#42         // java/lang/StringBuilder.toString:()Ljava/lang/String;
 *   #12 = Methodref          #2.#43         // java/lang/String.substring:(II)Ljava/lang/String;
 *   #13 = Class              #44            // z/learn/StringExample
 *   #14 = Class              #45            // java/lang/Object
 *   #15 = Utf8               <init>
 *   #16 = Utf8               ()V
 *   #17 = Utf8               Code
 *   #18 = Utf8               LineNumberTable
 *   #19 = Utf8               LocalVariableTable
 *   #20 = Utf8               this
 *   #21 = Utf8               Lz/learn/StringExample;
 *   #22 = Utf8               example
 *   #23 = Utf8               data
 *   #24 = Utf8               [C
 *   #25 = Utf8               str
 *   #26 = Utf8               Ljava/lang/String;
 *   #27 = Utf8               cde
 *   #28 = Utf8               c
 *   #29 = Utf8               d
 *   #30 = Utf8               SourceFile
 *   #31 = Utf8               StringExample.java
 *   #32 = NameAndType        #15:#16        // "<init>":()V
 *   #33 = Utf8               java/lang/String
 *   #34 = NameAndType        #15:#46        // "<init>":([C)V
 *   #35 = Class              #47            // java/lang/System
 *   #36 = NameAndType        #48:#49        // out:Ljava/io/PrintStream;
 *   #37 = Class              #50            // java/io/PrintStream
 *   #38 = NameAndType        #51:#52        // println:(Ljava/lang/String;)V
 *   #39 = Utf8               abc
 *   #40 = Utf8               java/lang/StringBuilder
 *   #41 = NameAndType        #53:#54        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *   #42 = NameAndType        #55:#56        // toString:()Ljava/lang/String;
 *   #43 = NameAndType        #57:#58        // substring:(II)Ljava/lang/String;
 *   #44 = Utf8               z/learn/StringExample
 *   #45 = Utf8               java/lang/Object
 *   #46 = Utf8               ([C)V
 *   #47 = Utf8               java/lang/System
 *   #48 = Utf8               out
 *   #49 = Utf8               Ljava/io/PrintStream;
 *   #50 = Utf8               java/io/PrintStream
 *   #51 = Utf8               println
 *   #52 = Utf8               (Ljava/lang/String;)V
 *   #53 = Utf8               append
 *   #54 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
 *   #55 = Utf8               toString
 *   #56 = Utf8               ()Ljava/lang/String;
 *   #57 = Utf8               substring
 *   #58 = Utf8               (II)Ljava/lang/String;
 * {
 *   public z.learn.StringExample();
 *     descriptor: ()V                           // 编译器自动添加，构造函数
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
 *             0       5     0  this   Lz/learn/StringExample;
 *
 *   public void example();                     // example方法
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=4, locals=6, args_size=1         当int取值-1~5采用iconst指令，取值-128~127采用bipush指令，取值-32768~32767采用sipush指令，取值-2147483648~2147483647采用 ldc 指令。
 *          0: iconst_3                         3(int)值入栈。      int取值0~5时JVM采用iconst_0、iconst_1、iconst_2、iconst_3、iconst_4、iconst_5指令将常量压入栈中，取值-1时采用iconst_m1指令将常量压入栈中。
 *          1: newarray       char              创建type类型的数组。  char
 *          3: dup                              复制栈顶一个字长的数据，将复制后的数据压栈。
 *          4: iconst_0                         0(int)值入栈。
 *          5: bipush        97                 valuebyte值带符号扩展成int值入栈。
 *          7: castore                          将栈顶char类型值保存到指定char类型数组的指定项。        数组位置0存储a
 *          8: dup
 *          9: iconst_1                         数组位置1存储b
 *         10: bipush        98
 *         12: castore
 *         13: dup
 *         14: iconst_2                         数组位置2存储c
 *         15: bipush        99
 *         17: castore                          将栈顶char类型值保存到指定char类型数组的指定项。
 *         18: astore_1                         将栈顶引用类型值保存到局部变量1中。
 *         19: new           #2                  // class java/lang/String          加载Class
 *         22: dup
 *         23: aload_1
 *         24: invokespecial #3                  // Method java/lang/String."<init>":([C)V
 *         27: astore_2                                                                                 从栈中弹出对象引用，然后将其存到位置为2的局部变量中
 *         28: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         31: aload_2                                                                                  将位置为2的对象引用局部变量压入栈
 *         32: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         35: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         38: ldc           #6                  // String abc                                          常量池中的常量值（int, float, string reference, object reference）入栈。
 *         40: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         43: ldc           #7                  // String cde
 *         45: astore_3
 *         46: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         49: new           #8                  // class java/lang/StringBuilder                       StringBuilder对象实现 + 操作
 *         52: dup
 *         53: invokespecial #9                  // Method java/lang/StringBuilder."<init>":()V
 *         56: ldc           #6                  // String abc
 *         58: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *         61: aload_3
 *         62: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *         65: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 *         68: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         71: ldc           #6                  // String abc
 *         73: iconst_2
 *         74: iconst_3
 *         75: invokevirtual #12                 // Method java/lang/String.substring:(II)Ljava/lang/String;
 *         78: astore        4
 *         80: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         83: aload         4
 *         85: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         88: aload_3
 *         89: iconst_1
 *         90: iconst_2
 *         91: invokevirtual #12                 // Method java/lang/String.substring:(II)Ljava/lang/String;
 *         94: astore        5
 *         96: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         99: aload         5
 *        101: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        104: return
 *       LineNumberTable:
 *         line 6: 0
 *         line 7: 19
 *         line 8: 28
 *         line 10: 35
 *         line 11: 43
 *         line 12: 46
 *         line 13: 71
 *         line 14: 80
 *         line 16: 88
 *         line 17: 96
 *         line 18: 104
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0     105     0  this   Lz/learn/StringExample;
 *            19      86     1  data   [C
 *            28      77     2   str   Ljava/lang/String;
 *            46      59     3   cde   Ljava/lang/String;
 *            80      25     4     c   Ljava/lang/String;
 *            96       9     5     d   Ljava/lang/String;
 * }
 * SourceFile: "StringExample.java"
 * **/