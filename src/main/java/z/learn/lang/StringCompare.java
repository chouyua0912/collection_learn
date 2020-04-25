package z.learn.lang;

public class StringCompare {

    public static void main(String[] args) {
        String s = "123456";
        String s1 = "123456";
        String s2 = "123" + "456";
        String s3 = "456";
        String s4 = "123" + s3;
        System.out.println(s == s1);
        System.out.println(s == s2);
        System.out.println(s == s4);
    }
}
/**
 * z@z:~/IdeaProjects/javabasis/target/classes/z/learn/lang$ javap -v -p StringCompare.class
 Classfile /home/z/IdeaProjects/javabasis/target/classes/z/learn/lang/StringCompare.class
 Last modified Apr 25, 2020; size 1083 bytes
 MD5 checksum 4b8241673575f8fbbad70e509245d956
 Compiled from "StringCompare.java"
 public class z.learn.lang.StringCompare
 minor version: 0
 major version: 52
 flags: ACC_PUBLIC, ACC_SUPER
 Constant pool:
 #1 = Methodref          #12.#36        // java/lang/Object."<init>":()V
 #2 = String             #37            // 123456
 #3 = String             #38            // 456
 #4 = Class              #39            // java/lang/StringBuilder
 #5 = Methodref          #4.#36         // java/lang/StringBuilder."<init>":()V
 #6 = String             #40            // 123
 #7 = Methodref          #4.#41         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 #8 = Methodref          #4.#42         // java/lang/StringBuilder.toString:()Ljava/lang/String;
 #9 = Fieldref           #43.#44        // java/lang/System.out:Ljava/io/PrintStream;
 #10 = Methodref          #45.#46        // java/io/PrintStream.println:(Z)V
 #11 = Class              #47            // z/learn/lang/StringCompare
 #12 = Class              #48            // java/lang/Object
 #13 = Utf8               <init>
 #14 = Utf8               ()V
 #15 = Utf8               Code
 #16 = Utf8               LineNumberTable
 #17 = Utf8               LocalVariableTable
 #18 = Utf8               this
 #19 = Utf8               Lz/learn/lang/StringCompare;
 #20 = Utf8               main
 #21 = Utf8               ([Ljava/lang/String;)V
 #22 = Utf8               args
 #23 = Utf8               [Ljava/lang/String;
 #24 = Utf8               s
 #25 = Utf8               Ljava/lang/String;
 #26 = Utf8               s1
 #27 = Utf8               s2
 #28 = Utf8               s3
 #29 = Utf8               s4
 #30 = Utf8               StackMapTable
 #31 = Class              #23            // "[Ljava/lang/String;"
 #32 = Class              #49            // java/lang/String
 #33 = Class              #50            // java/io/PrintStream
 #34 = Utf8               SourceFile
 #35 = Utf8               StringCompare.java
 #36 = NameAndType        #13:#14        // "<init>":()V
 #37 = Utf8               123456
 #38 = Utf8               456
 #39 = Utf8               java/lang/StringBuilder
 #40 = Utf8               123
 #41 = NameAndType        #51:#52        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 #42 = NameAndType        #53:#54        // toString:()Ljava/lang/String;
 #43 = Class              #55            // java/lang/System
 #44 = NameAndType        #56:#57        // out:Ljava/io/PrintStream;
 #45 = Class              #50            // java/io/PrintStream
 #46 = NameAndType        #58:#59        // println:(Z)V
 #47 = Utf8               z/learn/lang/StringCompare
 #48 = Utf8               java/lang/Object
 #49 = Utf8               java/lang/String
 #50 = Utf8               java/io/PrintStream
 #51 = Utf8               append
 #52 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
 #53 = Utf8               toString
 #54 = Utf8               ()Ljava/lang/String;
 #55 = Utf8               java/lang/System
 #56 = Utf8               out
 #57 = Utf8               Ljava/io/PrintStream;
 #58 = Utf8               println
 #59 = Utf8               (Z)V
 {
 public z.learn.lang.StringCompare();
 descriptor: ()V
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
 0       5     0  this   Lz/learn/lang/StringCompare;

 public static void main(java.lang.String[]);
 descriptor: ([Ljava/lang/String;)V
 flags: ACC_PUBLIC, ACC_STATIC
 Code:
 stack=3, locals=6, args_size=1
 0: ldc           #2                  // String 123456
 2: astore_1
 3: ldc           #2                  // String 123456
 5: astore_2
 6: ldc           #2                  // String 123456
 8: astore_3
 9: ldc           #3                  // String 456
 11: astore        4
 13: new           #4                  // class java/lang/StringBuilder
 16: dup
 17: invokespecial #5                  // Method java/lang/StringBuilder."<init>":()V
 20: ldc           #6                  // String 123
 22: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 25: aload         4
 27: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 30: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 33: astore        5
 35: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
 38: aload_1
 39: aload_2
 40: if_acmpne     47
 43: iconst_1
 44: goto          48
 47: iconst_0
 48: invokevirtual #10                 // Method java/io/PrintStream.println:(Z)V
 51: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
 54: aload_1
 55: aload_3
 56: if_acmpne     63
 59: iconst_1
 60: goto          64
 63: iconst_0
 64: invokevirtual #10                 // Method java/io/PrintStream.println:(Z)V
 67: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
 70: aload_1
 71: aload         5
 73: if_acmpne     80
 76: iconst_1
 77: goto          81
 80: iconst_0
 81: invokevirtual #10                 // Method java/io/PrintStream.println:(Z)V
 84: return
 LineNumberTable:
 line 6: 0
 line 7: 3
 line 8: 6
 line 9: 9
 line 10: 13
 line 11: 35
 line 12: 51
 line 13: 67
 line 14: 84
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 0      85     0  args   [Ljava/lang/String;
 3      82     1     s   Ljava/lang/String;
 6      79     2    s1   Ljava/lang/String;
 9      76     3    s2   Ljava/lang/String;
 13      72     4    s3   Ljava/lang/String;
 35      50     5    s4   Ljava/lang/String;
 StackMapTable: number_of_entries = 6
 frame_type = 255   full_frame
          offset_delta = 47
                  locals = [ class "[Ljava/lang/String;", class java/lang/String, class java/lang/String, class java/lang/String, class java/lang/String, class java/lang/String ]
        stack = [ class java/io/PrintStream ]
        frame_type = 255
        offset_delta = 0
        locals = [ class "[Ljava/lang/String;", class java/lang/String, class java/lang/String, class java/lang/String, class java/lang/String, class java/lang/String ]
        stack = [ class java/io/PrintStream, int ]
        frame_type = 78
        stack = [ class java/io/PrintStream ]
        frame_type = 255
        offset_delta = 0
        locals = [ class "[Ljava/lang/String;", class java/lang/String, class java/lang/String, class java/lang/String, class java/lang/String, class java/lang/String ]
        stack = [ class java/io/PrintStream, int ]
        frame_type = 79
        stack = [ class java/io/PrintStream ]
        frame_type = 255
        offset_delta = 0
        locals = [ class "[Ljava/lang/String;", class java/lang/String, class java/lang/String, class java/lang/String, class java/lang/String, class java/lang/String ]
        stack = [ class java/io/PrintStream, int ]
        }
        SourceFile: "StringCompare.java"
        *
 *
 *
 */
