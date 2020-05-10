package z.learn.lang;

import javax.naming.NameNotFoundException;

public class DataTypeDemo {

    public static void main(String[] args) {
        String str = Integer.toString(123);
        String str2 = String.valueOf(123);
        System.out.println(str);
        System.out.println(str2);

        int[] hello1 = {1, 2, 3, 4};
        int[] hello2 = new int[4];              // 会被初始化成0，int型数值的默认值
        int[] hello3 = new int[]{1, 2, 3, 4};
        // int[] hello4 = new int[4]{1,2,3,4};  语法不正确
        Integer[] hello5 = new Integer[4];      // 默认值null，初始化了一个指针数组，默认值都是null refvar类型的数组

        // 数据类型的负值比正值的最大值绝对值大1，,short -128~127，对最小的负值取绝对值的时候会移除
        int count = 0;
        int start = Integer.MAX_VALUE - 10;
        for (int i = start; i <= Integer.MAX_VALUE; i++) {      // 永远为真，会导致溢出，不能用<=进行判断
            count++;
            System.out.println("i=" + i + ", count=" + count);
            if (count > 20) {
                System.out.println("overflow..");
                break;
            }
        }

        count = 0;
        for (float flt = (float) 20000000; flt < 20000050; flt++) {     // 浮点数不能做精确的比较，会导致无限循环或者循环根本不会执行之类的问题
            System.out.println("flt = " + flt + ", count = " + count);
            if (count++ > 100)
                break;
        }
        float f1 = 0.00001f;
        float f2 = 0.001f;
        if (Math.abs(f1 - f2) < 1e-6f) {            // 不能直接用==来比较两个浮点数是否相等，要用compare或者绝对值小域一个范围来比较
            System.out.println("less than");
        } else {
            System.out.println("bigger than");
        }

        if (10 == Double.NaN) {
            System.out.println("never will be executed, NaN跟任何数字比较都会返回false");
        } else if (!Double.isNaN(10d)) {
            System.out.println("executed, NaN跟任何数字比较都会返回false，除了!=会返回true");
        }
    }
}
