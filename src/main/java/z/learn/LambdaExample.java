package z.learn;

import java.util.Arrays;
import java.util.List;

/**
 * lambda生成函数
 *
 * https://www.jianshu.com/p/d74e92f93752
 *
 * invokeinterface：用以调用接口方法，在运行时搜索一个实现了这个接口方法的对象，找出适合的方法进行调用。（Invoke interface method）
 * invokedynamic： JDK1.7新加入的一个虚拟机指令，相比于之前的四条指令，他们的分派逻辑都是固化在JVM内部，而invokedynamic则用于处理新的方法分派：它允许应用级别的代码来确定执行哪一个方法调用，只有在调用要执行的时候，才会进行这种判断,从而达到动态语言的支持。(Invoke dynamic method)
 *
 * invokespecial：指令用于调用一些需要特殊处理的实例方法，包括实例初始化方法、私有方法和父类方法。（Invoke instance method; special handling for superclass, private, and instance initialization method invocations ）
 *
 * Compiled from "LambdaExample.java"
 * public class z.learn.LambdaExample {
 *   public z.learn.LambdaExample();                            构造函数（编译器自动添加）
 *   public void example();                                     用户定义的函数
 *   private static void lambda$example$0(java.lang.String);    生成的lambda函数（编译器自动生成） lambda$方法名$序号
 * }
 *
 */
public class LambdaExample {

    public void example() {
        List<String> strs = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff");
        strs.forEach(s -> System.out.println(s));
    }
}
/**
 * invokedynamic #10,  0                    可以看到 inDy 指向一个类型为 CONSTANT_InvokeDynamic_info 的常量项 #10，另外 0 是预留参数，暂时没有作用。
 *
 * 符号常量池
 * #10 = InvokeDynamic      #0:#49         // #0:accept:()Ljava/util/function/Consumer;    #0 表示在 Bootstrap methods 表中的索引：
 *                                            #49 则是一个 CONSTANT_NameAndType_info，表示方法名和方法类型（返回值和参数列表），这个会作为参数传递给 BSM。
 * #49 = NameAndType        #64:#65        // accept:()Ljava/util/function/Consumer;
 *
 * BootstrapMethods:
 *   0: #45 invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
 *
 * #45 = MethodHandle       #6:#61         // invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
 *
 * Compiled from "LambdaExample.java"
 * public class z.learn.LambdaExample {
 *   public z.learn.LambdaExample();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public void example();
 *     Code:
 *        0: bipush        6
 *        2: anewarray     #2                  // class java/lang/String
 *        5: dup
 *        6: iconst_0
 *        7: ldc           #3                  // String aaa
 *        9: aastore
 *       10: dup
 *       11: iconst_1
 *       12: ldc           #4                  // String bbb
 *       14: aastore
 *       15: dup
 *       16: iconst_2
 *       17: ldc           #5                  // String ccc
 *       19: aastore
 *       20: dup
 *       21: iconst_3
 *       22: ldc           #6                  // String ddd
 *       24: aastore
 *       25: dup
 *       26: iconst_4
 *       27: ldc           #7                  // String eee
 *       29: aastore
 *       30: dup
 *       31: iconst_5
 *       32: ldc           #8                  // String fff
 *       34: aastore
 *       35: invokestatic  #9                  // Method java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
 *       38: astore_1
 *       39: aload_1                           //  0 代表预留参数，暂时还没有使用
 *       40: invokedynamic #10,  0             // InvokeDynamic #0:accept:()Ljava/util/function/Consumer;       运行时动态解析出调用点限定符号引用的方法
 *       45: invokeinterface #11,  2           // InterfaceMethod java/util/List.forEach:(Ljava/util/function/Consumer;)V
 *       50: return
 *
 *   private static void lambda$example$0(java.lang.String);
 *     Code:
 *        0: getstatic     #12                 // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: aload_0                           // 在非静态方法中，aload_0 表示对this的操作，在static 方法中，aload_0表示对方法的第一参数的操作。  https://blog.csdn.net/DViewer/article/details/51138148
 *        4: invokevirtual #13                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        7: return
 * }
 */