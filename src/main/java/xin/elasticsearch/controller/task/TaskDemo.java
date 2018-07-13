package xin.elasticsearch.controller.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@SuppressWarnings("ALL")

public class TaskDemo {
    @Scheduled(cron="0/5 * *  * * ? ")
    public void testTask(){
        System.out.println("定时任务执行了");
    }
}
