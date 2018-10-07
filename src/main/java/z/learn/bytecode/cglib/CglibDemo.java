package z.learn.bytecode.cglib;

/**
 * 通过CallbackFilter来控制匹配到方法上的代理
 * NoOp不会为对应的方法加上代理的代码
 * FixedValue替换被代理的方法的值返回固定的值
 */
public class CglibDemo {

    public static void main(String[] args) {
        BizClass bizClass = Interceptor.newInstance(BizClass.class);
        bizClass.sayHello("OK.");
        System.out.println("--------------dash---------------");
        bizClass.sayNothing(5);     // 会拦截所有的方法
        System.out.println("--------------dash---------------");
        bizClass.echo("check if proxied..");
    }
}
