package demo008ioreleaseresource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;

/**
 * 释放资源
 */
public class Demo01 {

    @Test
    public void testJDK6() throws Exception {
        FileInputStream fileInputStream = null;
        try {
            // 1、建立程序与文件的数据通道
            fileInputStream = new FileInputStream("C:/workspace/logs/a.txt");
            // 2、创建字节数组缓冲区
            byte[] buf = new byte[1024];
            int length = 0;
            // 3、读取数据，并且输出
            while ((length = fileInputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、关闭资源
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testJDK7() throws Exception {
        // 需要释放资源的流，填写在try()中
        // 注意：初始化流对象的代码一定要写在try()内部中
        try ( // 1、建立程序与文件的数据通道
                FileInputStream fileInputStream = new FileInputStream("C:/workspace/logs/a.txt");) {
            // 2、创建字节数组缓冲区
            byte[] buf = new byte[1024];
            int length = 0;
            // 3、读取数据，并且输出
            while ((length = fileInputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJDK9() throws Exception {
        // 1、建立程序与文件的数据通道
        FileInputStream fileInputStream = new FileInputStream("C:/workspace/logs/a.txt");
        try (fileInputStream) {
            // 2、创建字节数组缓冲区
            byte[] buf = new byte[1024];
            int length = 0;
            // 3、读取数据，并且输出
            while ((length = fileInputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
