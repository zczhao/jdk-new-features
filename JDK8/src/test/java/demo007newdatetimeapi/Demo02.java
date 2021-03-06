package demo007newdatetimeapi;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Demo02 {

    /**
     * <pre>
     * {@link  java.time.LocalTime}：表示时间，包含时分秒，格式为：10:25:56.686
     * </pre>
     */
    @Test
    public void testLocaTime() {
        LocalTime now = LocalTime.now();
        System.out.println("now = " + now);

        LocalTime localTime = LocalTime.of(10, 26, 59);
        System.out.println("localTime = " + localTime);
        System.out.println("hour = " + localTime.getHour());
        System.out.println("minute = " + localTime.getMinute());
        System.out.println("second = " + localTime.getSecond());
        System.out.println("nano = " + localTime.getNano());

    }

    /**
     * <pre>
     *   {@link  java.time.LocalDate}：表示日期，包含年月日，格式为：2020-01-06
     * </pre>
     */
    @Test
    public void testLocalDate() {
        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);

        LocalDate localDate = LocalDate.of(2020, 1, 24);
        System.out.println("localDate = " + localDate);
        System.out.println("year = " + localDate.getYear());
        System.out.println("month = " + localDate.getMonthValue());
        System.out.println("day = " + localDate.getDayOfMonth());
    }

    /**
     * <pre>
     *  跳转到指定类
     *      {@link  java.time.LocalDateTime}：表示日期时间，包含年月日，时分秒，格式为：2020-01-06T16:38:54.750
     *  跳转到指定方法
     *      @see Demo02#testLocaDateTime()
     * </pre>
     */
    @Test
    public void testLocaDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        LocalDateTime localDateTime = LocalDateTime.of(2020, 1, 24, 23, 59, 59);
        System.out.println("localDateTime = " + localDateTime);
        
        System.out.println("year = " + localDateTime.get(ChronoField.YEAR));// 年 结果：2020
        System.out.println("year = " + localDateTime.getYear());// 年 结果：2020
        
        Month month = localDateTime.getMonth(); // 月
        System.out.println("month = " + month); // 结果：JANUARY
        System.out.println("month = " + localDateTime.get(ChronoField.MONTH_OF_YEAR));// 结果：1
        System.out.println("month = " + localDateTime.getMonthValue());// 结果：1
 
        System.out.println("day = " + localDateTime.getDayOfMonth()); // 日 结果：24
        
        DayOfWeek week = localDateTime.getDayOfWeek(); // 星期
        System.out.println("week = " + week); // 结果：FRIDAY
        System.out.println("week = " + localDateTime.get(ChronoField.DAY_OF_WEEK)); // 结果：5
        
        System.out.println("hour = " + localDateTime.getHour()); // 时 结果：23
        System.out.println("minute = " + localDateTime.getMinute()); // 分 结果：59
        System.out.println("second = " + localDateTime.getSecond()); // 秒 结果：29
        System.out.println("nano = " + localDateTime.getNano()); // 纳秒 结果：0
    }

    /**
     * 日期加减
     */
    @Test
    public void testCalc() {
        LocalDateTime now = LocalDateTime.now();
        // 修改时间，修改后返回新的时间对象
        LocalDateTime dateTime = now.withYear(2200);
        System.out.println("修改后的年份: " + dateTime);

        System.out.println("当前时间："+now);
        LocalDateTime plusTime = now.plusMonths(1).plusDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
        System.out.println("增加1月1天1小时1分钟1秒时间后：" + plusTime);
        LocalDateTime minusTime = now.minusMonths(2);
        System.out.println("减少2个月时间后：" + minusTime);

        // 增加或减去时间
        // plusXxx()：增加指定的时间
        
        System.out.println(now.plusYears(2));
        
        // minusXxx()：减去指定的时间
        System.out.println(now.minusYears(2));
    }

    @Test
    public void testLocaDateTime03() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(2020, 1, 24, 23, 59, 59);

        // 比较时间
        System.out.println(now.isAfter(localDateTime));
        System.out.println(now.isBefore(localDateTime));
        System.out.println(now.isEqual(localDateTime));
    }

    /**
     * <pre>
     * {@link  java.time.format.DateTimeFormatter}：日期格式化类
     * </pre>
     */
    @Test
    public void testDateTimeFormatter() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);

        // 格式化
        // JDK自带的时间格式
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ISO_LOCAL_TIME));

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("格式化后：" + dtf2.format(now));
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // 解析
        LocalDateTime parseDateTime = LocalDateTime.parse("2018-08-08 10:54:49", dtf2);
        System.out.println("字符串解析：" + parseDateTime);

        // 线程安全的格式化器
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                LocalDateTime parseDateTime2 = LocalDateTime.parse("2018-08-08 10:54:49", dtf2);
                System.out.println("parseDateTime2 = " + parseDateTime2);
            }).start();
        }

    }

    /**
     * <pre>
     * {@link  java.time.Instant}：时间戳，表示一个特定的时间瞬间
     * </pre>
     */
    @Test
    public void testInstant() {
        // Instant内部保存了秒和纳秒，一般不是给用户使用的，而是方便程序员做一些统计的
        Instant now = Instant.now();
        System.out.println("now = " + now);

        Instant plus = now.plusSeconds(20);
        System.out.println("plus = " + plus);

        Instant minus = now.minusSeconds(20);
        System.out.println("minus = " + minus);

        // 获取从1970年1月1日 00:00:00的秒
        // 毫秒
        System.out.println(now.getEpochSecond());
        // 纳秒
        System.out.println(now.getNano());

        System.out.println(now.toEpochMilli());
        System.out.println(System.currentTimeMillis());

        Instant instant = Instant.ofEpochMilli(5);
        System.out.println(instant);
    }

    /**
     * <pre>
     * {@link  java.time.Duration}：用于计算2个时间(LocalTime，时分秒)的距离
     * </pre>
     */
    @Test
    public void testDuration() {
        LocalTime now = LocalTime.now();
        LocalTime fj = LocalTime.of(10, 15, 25);
        Duration duration = Duration.between(fj, now);
        System.out.println("相差天：" + duration.toDays());
        System.out.println("相差小时：" + duration.toHours());
        System.out.println("相差分钟：" + duration.toMinutes());
        //System.out.println("相差秒：" + duration.toSeconds()); // JDK9 改为public可调用
        System.out.println("相差毫秒：" + duration.toNanos());

        String startTimeStr = "2020-03-01 08:00:00";
        String endTimeStr = "2020-03-02 08:00:00";
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, dft);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, dft);
        long hours = ChronoUnit.HOURS.between(startTime, endTime); // 时
        long minutes = ChronoUnit.MINUTES.between(startTime, endTime);// 分
        long seconds = ChronoUnit.SECONDS.between(startTime, endTime); // 秒
        System.out.println("相差小时" + hours);
        System.out.println("相差分钟" + minutes);
        System.out.println("相差秒" + seconds);

        System.out.println();

        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime yesterday = nowDateTime.minusDays(1);
        hours = yesterday.until(nowDateTime, ChronoUnit.HOURS);
        minutes = yesterday.until(nowDateTime, ChronoUnit.MINUTES);
        seconds = yesterday.until(nowDateTime, ChronoUnit.SECONDS);
        System.out.println("相差小时" + hours);
        System.out.println("相差分钟" + minutes);
        System.out.println("相差秒" + seconds);

    }

    /**
     * <pre>
     * {@link  java.time.Period}：用于计算2个日期(LocalDate，年月日)的距离
     * </pre>
     */
    @Test
    public void testPeriod() {
        LocalDate now = LocalDate.now();
        LocalDate fj = LocalDate.of(1991, 3, 1);
        Period period = Period.between(fj, now);
        System.out.println("相差年：" + period.getYears());
        System.out.println("相差月：" + period.getMonths());
        System.out.println("相差日：" + period.getDays());
    }

    /**
     * <pre>
     * {@link  java.time.temporal.TemporalAdjuster}：时间校正器
     * </pre>
     */
    @Test
    public void testTemporalAdjuster() {
        LocalDateTime now = LocalDateTime.now();

        // 得到下个月的第一天
        TemporalAdjuster firstWeekDayOfNextMonth = temporal -> {
            LocalDateTime dateTime = (LocalDateTime) temporal;
            LocalDateTime nextMonth = dateTime.plusMonths(1).withDayOfMonth(1);
            System.out.println("nextMonth = " + nextMonth);
            return nextMonth;
        };

        LocalDateTime nextMonth = now.with(firstWeekDayOfNextMonth);
        System.out.println("nextMonth = " + nextMonth);
    }

    /**
     * <pre>
     * {@link  java.time.temporal.TemporalAdjusters}：该类通过静态方法提供了大量的常用TemporalAdjuster的实现
     * </pre>
     */
    @Test
    public void testTemporalAdjusters() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);
        // 第一天
        LocalDateTime firstDay = now.withDayOfMonth(1);
        System.out.println("本月第一天：" + firstDay);
        // 当天最后一秒
        LocalDateTime lastSecondOfDay = now.withHour(23).withMinute(59).withSecond(59);
        System.out.println("当天最后一秒：" + lastSecondOfDay);
        // 最后一天
        LocalDateTime lastDay = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月最后一天:" + lastDay);
        // 下一年的第一天
        LocalDateTime firstDayOfNextYear = now.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println("下一年的第一天:" + firstDayOfNextYear);
        // 是否闰年
        System.out.println("今年是否闰年：" + Year.isLeap(now.getYear()));
    }

    /**
     * <pre>
     * {@link  java.time.ZonedDateTime}：包含时区的时间
     * LocalDate、LocalTime、LocalDateTime：不带时区的日期时间类
     * ZonedDate、ZonedTime、ZonedDateTime：带时区的日期时间类
     * 其中每个时区都对应着ID、ID的格式为“区域/城市”例如：Asia/Shanghai等
     * ZoneId：该类中包含了所有的时区信息。
     * </pre>
     */
    @Test
    public void testZonedDateTime() {
        // 获取所有时区的ID
        // ZoneId.getAvailableZoneIds().forEach(System.out::println);

        // 创建世界标准时间
        ZonedDateTime zonedDateTimeFromClock = ZonedDateTime.now(Clock.systemUTC());
        System.out.println("zonedDateTimeFromClock = " + zonedDateTimeFromClock);

        // 中国使用的东八区的时区
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        // 创建一个带有时区的ZonedDateTime
        ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("Africa/Nairobi"));
        System.out.println("zonedDateTimeFromZone = " + zonedDateTimeFromZone);
        
        // 修改时区
        // withZoneSameInstant：即更改时区，也更改时间
        ZonedDateTime withZoneSameInstant = zonedDateTimeFromZone.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
        System.out.println("withZoneSameInstant = " + withZoneSameInstant);
        
        // withZoneSameLocal：只改时区，不更改时间
        ZonedDateTime withZoneSameLocal = zonedDateTimeFromZone.withZoneSameLocal(ZoneId.of("Asia/Shanghai"));
        System.out.println("withZoneSameLocal = " + withZoneSameLocal);
    }

    /**
     * 日期转换
     */
    @Test
    public void testConvertTimes() {
        LocalDateTime parseTime = LocalDateTime.parse("2019-10-01T22:22:22.222");
        System.out.println("字符串时间转换：" + parseTime);

        LocalDate formatted = LocalDate.parse("20190101", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("字符串时间转换-指定格式：" + formatted);

        // Date 转换成 LocalDateTime
        Date date = new Date();
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("Date 转换成 LocalDateTime：" + LocalDateTime.ofInstant(date.toInstant(), zoneId));

        // LocalDateTime 转换成 Date
        LocalDateTime localDateTime = LocalDateTime.now();
        Date toDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("LocalDateTime 转换成 Date：" + toDate);

        // 当前时间转时间戳
        long epochMilli = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("当前时间转时间戳：" + epochMilli);
        // 时间戳转换成时间
        LocalDateTime epochMilliTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault());
        System.out.println("时间戳转换成时间：" + epochMilliTime);
    }
}
