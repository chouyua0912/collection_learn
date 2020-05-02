package z.learn.lang;

import java.io.File;

/**
 * 关键的系统调用方法都会去先检查SecurityPolicy然后看代码是否违背了策略设置
 * https://nicky-chen.github.io/2018/07/13/java-securitymanager/
 * https://docs.oracle.com/javase/1.5.0/docs/guide/security/PolicyFiles.html
 * https://www.ibm.com/developerworks/cn/java/j-lo-javasecurity/
 * https://yq.aliyun.com/articles/57223?&utm_source=qq
 */
public class SecurityManagerDemo {

    static class MySM extends SecurityManager {
        public void checkExit(int status) {
            throw new SecurityException("no exit");
        }

    }

    public static void main(String[] args) {
        MySM sm = new MySM();
        System.out.println(System.getSecurityManager());
        System.setSecurityManager(sm);  // 注释掉测一下
        System.exit(0);
    }
}
