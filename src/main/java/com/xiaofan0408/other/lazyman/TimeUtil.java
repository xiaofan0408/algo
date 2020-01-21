package com.xiaofan0408.other.lazyman;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xuzefan  2020/1/21 17:43
 */
public class TimeUtil {

    private final static ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(2);

    public static ScheduledFuture run(Runnable runnable, long time, TimeUnit timeUnit){
        return scheduledExecutorService.schedule(runnable,time,timeUnit);
    }

    public static void shutDown(){
        // 结束线程池
        scheduledExecutorService.shutdown();
        // 是否完成
        try {
            scheduledExecutorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println("延时任务中断");
        }
    }
}
