package concurrent.ThreadPool;


import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author cutiewang
 * @date 2020/4/3 10:42
 * 使用ScheduledThreadPool 实现每周四18:00:00自动执行任务
 */
public class test2 {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        long period = 1000 * 60 * 60 * 24 * 7;
        LocalDateTime time = now.withHour(18).withMinute(0).withSecond(0).withNano(0).with(DayOfWeek.THURSDAY);
        if(now.compareTo(time)>0){
            time = time.plusWeeks(1);
        }
        long initialDelay = Duration.between(now,time).toMillis();
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(() -> {
            System.out.println("start...");
        }, initialDelay, period, TimeUnit.MILLISECONDS);
    }
}
