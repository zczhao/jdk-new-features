package demo007newdatetimeapi;

import java.time.Duration;
import java.time.LocalTime;
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
}
