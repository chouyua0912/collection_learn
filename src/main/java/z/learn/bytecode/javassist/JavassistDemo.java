package z.learn.bytecode.javassist;

import javassist.*;

/**
 * Javassist示例
 */
public class JavassistDemo {

    public void example() {
        ClassPool pool = ClassPool.getDefault();
        try {
            // CtClass cc = pool.get("SaySomething.class.getName()");     会导致连接错误,此处会被类加载器直接加载,导致不能重新加载相同的类
            CtClass cc = pool.get("z.learn.bytecode.javassist.SaySomething");
            CtMethod mm = cc.getDeclaredMethod("sayHello");
            mm.insertBefore("System.out.println(\"abcddd\");");     // 方法前面插入方法
            mm.insertBefore("System.out.println(\"abcddd \"+$1);");

            Class clazz = cc.toClass();
            SaySomething say = (SaySomething) clazz.newInstance();
            say.sayHello("test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
