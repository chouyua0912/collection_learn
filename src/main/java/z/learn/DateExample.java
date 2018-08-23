package z.learn;

import java.util.Date;
import java.util.TimeZone;

class DateExample {

    void example() {
        Date d1 = new Date();
        Date d2 = new Date(d1.getTime() + 10 * 1000);   // 时间记录的是　UTC 1970开始的时间　epoch时间，不受时区和夏令时影响
        System.out.println(d1);     // toString方法会根据
        System.out.println(d2);
        System.out.println(d1.compareTo(d2));

        System.out.println("d1 time: " + d1.getTime());
    }

    void example1() {
        System.out.println("原时间 " + new Date());
        TimeZone time = TimeZone.getTimeZone("ETC/GMT-8");
        TimeZone.setDefault(time);
        System.out.println("修改后时间 " + new Date());
    }
}