package demo007newdatetimeapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.junit.Test;

public class Demo01 {

    /**
     * 旧版日期时间API存在的问题
     */
    @Test
    public void test01() {
        // 1、设计很差，在java.util和java.sql的包中都有日期类，java.util.Date同时包含日期和时间，而java.sql.Date仅包含日期，此外用于格式化和解析的类在java.text包中定义
        Date now = new Date(1985, 12, 31);
        System.out.println(now); // Sun Jan 31 00:00:00 CST 3886

        // 2、非线程安全：java.util.Date是非线程安全的，所有的日期类都是可变的，这是Java日期类最大的问题之一
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    Date date = sdf.parse("2020-01-07");
                    System.out.println("date = " + date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        // 3、时区处理麻烦：日期类并不提供国际化，没有时区支持，因此Java引入了java.util.Calendar和java.util.TimeZone类，但他们同样存在上述所有问题

    }

    @Test
    public void test02() {
        // 1、获取当前日期
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd 21:00:00");
        String todayStr = dft.format(today);
        LocalDateTime yesterday = today.minusDays(1);
        String yesterdayStr = dft.format(yesterday);
        System.out.println("todayStr = " + todayStr);
        System.out.println("yesterdayStr = " + yesterdayStr);
        System.out.println("" + today.getDayOfWeek().name());
        
    }
}
