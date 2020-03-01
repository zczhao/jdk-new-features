package demo007newdatetimeapi;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import org.junit.Test;

public class Demo02 {
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
        System.out.println("相差秒：" + duration.toSeconds());
        System.out.println("相差毫秒：" + duration.toNanos());
    }
    
      @Test
    public void testLocaDateTime02() {
        LocalDateTime now = LocalDateTime.now();
        
        // 增加或减去时间
        // plusXxx()：增加指定的时间
        System.out.println(now.plusYears(1));
        System.out.println(now.plus(1, ChronoUnit.YEARS));
        
        // minusXxx()：减去指定的时间
        System.out.println(now.minusMonths(1));
        System.out.println(now.minus(1,ChronoUnit.MONTHS));
    }
}
