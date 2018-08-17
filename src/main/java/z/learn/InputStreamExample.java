package z.learn;

import java.io.*;
import java.net.URL;

public class InputStreamExample {

    public void example() {
        URL url = this.getClass().getResource("/test.txt");
        InputStream stream = null;
        try {
            stream = new FileInputStream(url.getFile());

            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            System.out.println("Hello: " + (char) stream.read());       // I                对于同一个InputStream构造的输入对象，共享的读取位置
            bufferedReader.mark(10);
            System.out.println(bufferedReader.readLine());              // 'm text file.  读取的字符超过了mark，则mark会失效，调用reset会抛异常

            bufferedReader.reset();
            System.out.println(bufferedReader.readLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != stream) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
