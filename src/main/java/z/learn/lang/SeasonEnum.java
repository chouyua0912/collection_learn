package z.learn.lang;

/**
 * 枚举类
 */
public enum SeasonEnum {
    SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);
    int code;

    SeasonEnum(int code) {
        this.code = code;
    }
}
/**
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang$ javap -v -p SeasonEnum.class
 * Classfile /home/z/IdeaProjects/collectionlearn/target/classes/z/learn/lang/SeasonEnum.class
 *   Last modified Sep 22, 2018; size 1146 bytes
 *   MD5 checksum 9ee685160f19bd6925ac0fc47fadc69f
 *   Compiled from "SeasonEnum.java"
 * public final class z.learn.lang.SeasonEnum extends java.lang.Enum<z.learn.lang.SeasonEnum>       编译器使enum类继承于Enum抽象类
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_FINAL, ACC_SUPER, ACC_ENUM
 * Constant pool:
 *    #1 = Fieldref           #4.#46         // z/learn/lang/SeasonEnum.$VALUES:[Lz/learn/lang/SeasonEnum;
 *    #2 = Methodref          #47.#48        // "[Lz/learn/lang/SeasonEnum;".clone:()Ljava/lang/Object;
 *    #3 = Class              #26            // "[Lz/learn/lang/SeasonEnum;"
 *    #4 = Class              #49            // z/learn/lang/SeasonEnum
 *    #5 = Methodref          #17.#50        // java/lang/Enum.valueOf:(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;
 *    #6 = Methodref          #17.#51        // java/lang/Enum."<init>":(Ljava/lang/String;I)V
 *    #7 = Fieldref           #4.#52         // z/learn/lang/SeasonEnum.code:I
 *    #8 = String             #18            // SPRING
 *    #9 = Methodref          #4.#53         // z/learn/lang/SeasonEnum."<init>":(Ljava/lang/String;II)V
 *   #10 = Fieldref           #4.#54         // z/learn/lang/SeasonEnum.SPRING:Lz/learn/lang/SeasonEnum;
 *   #11 = String             #20            // SUMMER
 *   #12 = Fieldref           #4.#55         // z/learn/lang/SeasonEnum.SUMMER:Lz/learn/lang/SeasonEnum;
 *   #13 = String             #21            // AUTUMN
 *   #14 = Fieldref           #4.#56         // z/learn/lang/SeasonEnum.AUTUMN:Lz/learn/lang/SeasonEnum;
 *   #15 = String             #22            // WINTER
 *   #16 = Fieldref           #4.#57         // z/learn/lang/SeasonEnum.WINTER:Lz/learn/lang/SeasonEnum;
 *   #17 = Class              #58            // java/lang/Enum
 *   #18 = Utf8               SPRING
 *   #19 = Utf8               Lz/learn/lang/SeasonEnum;
 *   #20 = Utf8               SUMMER
 *   #21 = Utf8               AUTUMN
 *   #22 = Utf8               WINTER
 *   #23 = Utf8               code
 *   #24 = Utf8               I
 *   #25 = Utf8               $VALUES
 *   #26 = Utf8               [Lz/learn/lang/SeasonEnum;
 *   #27 = Utf8               values
 *   #28 = Utf8               ()[Lz/learn/lang/SeasonEnum;
 *   #29 = Utf8               Code
 *   #30 = Utf8               LineNumberTable
 *   #31 = Utf8               valueOf
 *   #32 = Utf8               (Ljava/lang/String;)Lz/learn/lang/SeasonEnum;
 *   #33 = Utf8               LocalVariableTable
 *   #34 = Utf8               name
 *   #35 = Utf8               Ljava/lang/String;
 *   #36 = Utf8               <init>
 *   #37 = Utf8               (Ljava/lang/String;II)V
 *   #38 = Utf8               this
 *   #39 = Utf8               Signature
 *   #40 = Utf8               (I)V
 *   #41 = Utf8               <clinit>
 *   #42 = Utf8               ()V
 *   #43 = Utf8               Ljava/lang/Enum<Lz/learn/lang/SeasonEnum;>;
 *   #44 = Utf8               SourceFile
 *   #45 = Utf8               SeasonEnum.java
 *   #46 = NameAndType        #25:#26        // $VALUES:[Lz/learn/lang/SeasonEnum;
 *   #47 = Class              #26            // "[Lz/learn/lang/SeasonEnum;"
 *   #48 = NameAndType        #59:#60        // clone:()Ljava/lang/Object;
 *   #49 = Utf8               z/learn/lang/SeasonEnum
 *   #50 = NameAndType        #31:#61        // valueOf:(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;
 *   #51 = NameAndType        #36:#62        // "<init>":(Ljava/lang/String;I)V
 *   #52 = NameAndType        #23:#24        // code:I
 *   #53 = NameAndType        #36:#37        // "<init>":(Ljava/lang/String;II)V
 *   #54 = NameAndType        #18:#19        // SPRING:Lz/learn/lang/SeasonEnum;
 *   #55 = NameAndType        #20:#19        // SUMMER:Lz/learn/lang/SeasonEnum;
 *   #56 = NameAndType        #21:#19        // AUTUMN:Lz/learn/lang/SeasonEnum;
 *   #57 = NameAndType        #22:#19        // WINTER:Lz/learn/lang/SeasonEnum;
 *   #58 = Utf8               java/lang/Enum
 *   #59 = Utf8               clone
 *   #60 = Utf8               ()Ljava/lang/Object;
 *   #61 = Utf8               (Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;
 *   #62 = Utf8               (Ljava/lang/String;I)V
 * {
 *   public static final z.learn.lang.SeasonEnum SPRING;        并将枚举值定义为常量
 *     descriptor: Lz/learn/lang/SeasonEnum;
 *     flags: ACC_PUBLIC, ACC_STATIC, ACC_FINAL, ACC_ENUM
 *
 *   public static final z.learn.lang.SeasonEnum SUMMER;
 *     descriptor: Lz/learn/lang/SeasonEnum;
 *     flags: ACC_PUBLIC, ACC_STATIC, ACC_FINAL, ACC_ENUM
 *
 *   public static final z.learn.lang.SeasonEnum AUTUMN;
 *     descriptor: Lz/learn/lang/SeasonEnum;
 *     flags: ACC_PUBLIC, ACC_STATIC, ACC_FINAL, ACC_ENUM
 *
 *   public static final z.learn.lang.SeasonEnum WINTER;
 *     descriptor: Lz/learn/lang/SeasonEnum;
 *     flags: ACC_PUBLIC, ACC_STATIC, ACC_FINAL, ACC_ENUM
 *
 *   int code;
 *     descriptor: I
 *     flags:
 *
 *   private static final z.learn.lang.SeasonEnum[] $VALUES;
 *     descriptor: [Lz/learn/lang/SeasonEnum;
 *     flags: ACC_PRIVATE, ACC_STATIC, ACC_FINAL, ACC_SYNTHETIC
 *
 *   public static z.learn.lang.SeasonEnum[] values();
 *     descriptor: ()[Lz/learn/lang/SeasonEnum;
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=1, locals=0, args_size=0
 *          0: getstatic     #1                  // Field $VALUES:[Lz/learn/lang/SeasonEnum;
 *          3: invokevirtual #2                  // Method "[Lz/learn/lang/SeasonEnum;".clone:()Ljava/lang/Object;
 *          6: checkcast     #3                  // class "[Lz/learn/lang/SeasonEnum;"
 *          9: areturn
 *       LineNumberTable:
 *         line 6: 0
 *
 *   public static z.learn.lang.SeasonEnum valueOf(java.lang.String);
 *     descriptor: (Ljava/lang/String;)Lz/learn/lang/SeasonEnum;
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: ldc           #4                  // class z/learn/lang/SeasonEnum
 *          2: aload_0
 *          3: invokestatic  #5                  // Method java/lang/Enum.valueOf:(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;
 *          6: checkcast     #4                  // class z/learn/lang/SeasonEnum
 *          9: areturn
 *       LineNumberTable:
 *         line 6: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      10     0  name   Ljava/lang/String;
 *
 *   private z.learn.lang.SeasonEnum(int);
 *     descriptor: (Ljava/lang/String;II)V
 *     flags: ACC_PRIVATE
 *     Code:
 *       stack=3, locals=4, args_size=4
 *          0: aload_0
 *          1: aload_1
 *          2: iload_2
 *          3: invokespecial #6                  // Method java/lang/Enum."<init>":(Ljava/lang/String;I)V
 *          6: aload_0
 *          7: iload_3
 *          8: putfield      #7                  // Field code:I
 *         11: return
 *       LineNumberTable:
 *         line 10: 0
 *         line 11: 6
 *         line 12: 11
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      12     0  this   Lz/learn/lang/SeasonEnum;
 *             0      12     3  code   I
 *     Signature: #40                          // (I)V
 *
 *   static {};
 *     descriptor: ()V                              静态构造函数?
 *     flags: ACC_STATIC
 *     Code:
 *       stack=5, locals=0, args_size=0
 *          0: new           #4                  // class z/learn/lang/SeasonEnum
 *          3: dup
 *          4: ldc           #8                  // String SPRING
 *          6: iconst_0                             load the int value 0 onto the stack
 *          7: iconst_1                             load the int value 1 onto the stack
 *          8: invokespecial #9                  // Method "<init>":(Ljava/lang/String;II)V
 *         11: putstatic     #10                 // Field SPRING:Lz/learn/lang/SeasonEnum;
 *         14: new           #4                  // class z/learn/lang/SeasonEnum
 *         17: dup
 *         18: ldc           #11                 // String SUMMER
 *         20: iconst_1
 *         21: iconst_2
 *         22: invokespecial #9                  // Method "<init>":(Ljava/lang/String;II)V
 *         25: putstatic     #12                 // Field SUMMER:Lz/learn/lang/SeasonEnum;
 *         28: new           #4                  // class z/learn/lang/SeasonEnum
 *         31: dup
 *         32: ldc           #13                 // String AUTUMN
 *         34: iconst_2
 *         35: iconst_3
 *         36: invokespecial #9                  // Method "<init>":(Ljava/lang/String;II)V
 *         39: putstatic     #14                 // Field AUTUMN:Lz/learn/lang/SeasonEnum;
 *         42: new           #4                  // class z/learn/lang/SeasonEnum
 *         45: dup
 *         46: ldc           #15                 // String WINTER
 *         48: iconst_3
 *         49: iconst_4
 *         50: invokespecial #9                  // Method "<init>":(Ljava/lang/String;II)V
 *         53: putstatic     #16                 // Field WINTER:Lz/learn/lang/SeasonEnum;
 *         56: iconst_4
 *         57: anewarray     #4                  // class z/learn/lang/SeasonEnum
 *         60: dup
 *         61: iconst_0
 *         62: getstatic     #10                 // Field SPRING:Lz/learn/lang/SeasonEnum;
 *         65: aastore
 *         66: dup
 *         67: iconst_1
 *         68: getstatic     #12                 // Field SUMMER:Lz/learn/lang/SeasonEnum;
 *         71: aastore
 *         72: dup
 *         73: iconst_2
 *         74: getstatic     #14                 // Field AUTUMN:Lz/learn/lang/SeasonEnum;
 *         77: aastore
 *         78: dup
 *         79: iconst_3
 *         80: getstatic     #16                 // Field WINTER:Lz/learn/lang/SeasonEnum;
 *         83: aastore
 *         84: putstatic     #1                  // Field $VALUES:[Lz/learn/lang/SeasonEnum;
 *         87: return
 *       LineNumberTable:
 *         line 7: 0
 *         line 6: 56
 * }
 * Signature: #43                          // Ljava/lang/Enum<Lz/learn/lang/SeasonEnum;>;
 * SourceFile: "SeasonEnum.java"
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn/lang$
 */