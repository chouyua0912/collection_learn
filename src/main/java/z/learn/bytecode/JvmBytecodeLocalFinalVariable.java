package z.learn.bytecode;

public class JvmBytecodeLocalFinalVariable {
    private static String s1 = "123";           // 变量s1是通过静态代码段初始化的
    static final String s2 = "123";

    public static void main(String[] args) {
        String s3 = "123";                      // 局部变量表是分配在栈帧上的
        final String s4 = "123";
        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s1 == s3);
    }
}
/**
 z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn$ javap -v JvmBytecodeLocalFinalVariable.class
 Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/JvmBytecodeLocalFinalVariable.class
 Last modified Sep 19, 2018; size 954 bytes
 MD5 checksum b57f8c980092b3f77ca5f1cefdfb1e7e
 Compiled from "JvmBytecodeLocalFinalVariable.java"
 public class z.learn.JvmBytecodeLocalFinalVariable
 minor version: 0
 major version: 52
 flags: ACC_PUBLIC, ACC_SUPER
 Constant pool:                         常量表
 #1 = Methodref          #7.#32         // java/lang/Object."<init>":()V
 #2 = String             #33            // 123
 #3 = Fieldref           #34.#35        // java/lang/System.out:Ljava/io/PrintStream;
 #4 = Fieldref           #5.#36         // z/learn/JvmBytecodeLocalFinalVariable.s1:Ljava/lang/String;
 #5 = Class              #37            // z/learn/JvmBytecodeLocalFinalVariable
 #6 = Methodref          #38.#39        // java/io/PrintStream.println:(Z)V
 #7 = Class              #40            // java/lang/Object
 #8 = Utf8               s1
 #9 = Utf8               Ljava/lang/String;
 #10 = Utf8               s2
 #11 = Utf8               ConstantValue
 #12 = Utf8               <init>
 #13 = Utf8               ()V
 #14 = Utf8               Code
 #15 = Utf8               LineNumberTable
 #16 = Utf8               LocalVariableTable
 #17 = Utf8               this
 #18 = Utf8               Lz/learn/JvmBytecodeLocalFinalVariable;
 #19 = Utf8               main
 #20 = Utf8               ([Ljava/lang/String;)V
 #21 = Utf8               args
 #22 = Utf8               [Ljava/lang/String;
 #23 = Utf8               s3
 #24 = Utf8               s4
 #25 = Utf8               StackMapTable
 #26 = Class              #22            // "[Ljava/lang/String;"
 #27 = Class              #41            // java/lang/String
 #28 = Class              #42            // java/io/PrintStream
 #29 = Utf8               <clinit>
 #30 = Utf8               SourceFile
 #31 = Utf8               JvmBytecodeLocalFinalVariable.java
 #32 = NameAndType        #12:#13        // "<init>":()V
 #33 = Utf8               123
 #34 = Class              #43            // java/lang/System
 #35 = NameAndType        #44:#45        // out:Ljava/io/PrintStream;
 #36 = NameAndType        #8:#9          // s1:Ljava/lang/String;
 #37 = Utf8               z/learn/JvmBytecodeLocalFinalVariable
 #38 = Class              #42            // java/io/PrintStream
 #39 = NameAndType        #46:#47        // println:(Z)V
 #40 = Utf8               java/lang/Object
 #41 = Utf8               java/lang/String
 #42 = Utf8               java/io/PrintStream
 #43 = Utf8               java/lang/System
 #44 = Utf8               out
 #45 = Utf8               Ljava/io/PrintStream;
 #46 = Utf8               println
 #47 = Utf8               (Z)V
 {
 static final java.lang.String s2;
 descriptor: Ljava/lang/String;
 flags: ACC_STATIC, ACC_FINAL
 ConstantValue: String 123

 public z.learn.JvmBytecodeLocalFinalVariable();
 descriptor: ()V                                                构造函数
 flags: ACC_PUBLIC
 Code:
 stack=1, locals=1, args_size=1
 0: aload_0
 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 4: return
 LineNumberTable:
 line 3: 0
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 0       5     0  this   Lz/learn/JvmBytecodeLocalFinalVariable;

 public static void main(java.lang.String[]);                   主函数main
 descriptor: ([Ljava/lang/String;)V
 flags: ACC_PUBLIC, ACC_STATIC
 Code:
 stack=3, locals=3, args_size=1
 0: ldc           #2                  // String 123
 2: astore_1
 3: ldc           #2                  // String 123
 5: astore_2
 6: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
 9: getstatic     #4                  // Field s1:Ljava/lang/String;
 12: ldc           #2                  // String 123
 14: if_acmpne     21
 17: iconst_1
 18: goto          22
 21: iconst_0
 22: invokevirtual #6                  // Method java/io/PrintStream.println:(Z)V
 25: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
 28: aload_1
 29: ldc           #2                  // String 123
 31: if_acmpne     38
 34: iconst_1
 35: goto          39
 38: iconst_0
 39: invokevirtual #6                  // Method java/io/PrintStream.println:(Z)V
 42: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
 45: getstatic     #4                  // Field s1:Ljava/lang/String;
 48: aload_1
 49: if_acmpne     56
 52: iconst_1
 53: goto          57
 56: iconst_0
 57: invokevirtual #6                  // Method java/io/PrintStream.println:(Z)V
 60: return
 LineNumberTable:
 line 8: 0
 line 9: 3
 line 10: 6
 line 11: 25
 line 12: 42
 line 13: 60
 LocalVariableTable:                                    局部变量表
 Start  Length  Slot  Name   Signature
 0      61     0  args   [Ljava/lang/String;
 3      58     1    s3   Ljava/lang/String;
 6      55     2    s4   Ljava/lang/String;             final类型变量也会记录到局部变量表里面
 StackMapTable: number_of_entries = 6                   JDK1.6新增,供类型检查验证器使用
        frame_type = 255                // full_frame
            offset_delta = 21
            locals = [ class "[Ljava/lang/String;", class java/lang/String, class java/lang/String ]
            stack = [ class java/io/PrintStream ]
        frame_type = 255                // full_frame
            offset_delta = 0
            locals = [ class "[Ljava/lang/String;", class java/lang/String, class java/lang/String ]
            stack = [ class java/io/PrintStream, int ]
        frame_type = 79                 // same_locals_1_stack_item //
            stack = [ class java/io/PrintStream ]
        frame_type = 255                // full_frame //
            offset_delta = 0
            locals = [ class "[Ljava/lang/String;", class java/lang/String, class java/lang/String ]
            stack = [ class java/io/PrintStream, int ]
        frame_type = 80                 // same_locals_1_stack_item //
            stack = [ class java/io/PrintStream ]
            frame_type = 255            // full_frame //
            offset_delta = 0
            locals = [ class "[Ljava/lang/String;", class java/lang/String, class java/lang/String ]
            stack = [ class java/io/PrintStream, int ]

static {};                                              静态代码块 static里面对 static变量进行初始化
        descriptor: ()V
        flags: ACC_STATIC
        Code:
        stack=1, locals=0, args_size=0
        0: ldc           #2                  // String 123
        2: putstatic     #4                  // Field s1:Ljava/lang/String;
        5: return
        LineNumberTable:
        line 4: 0
        }
        SourceFile: "JvmBytecodeLocalFinalVariable.java"
 */
