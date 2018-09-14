package z.learn.reflect;

import java.util.Date;

public class PrinterWithDate implements Printer {
    @Override
    public void print(String msg) {
        System.out.println(new Date() + " " + msg);
    }
}
