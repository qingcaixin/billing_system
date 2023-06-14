package com.gdxt.config;

import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * @Author WangXin
 * @Date 2023/6/14 15:45
 */
@Component
public class ScheduledTask {

    @Scheduled(cron ="*/1 * * * * ?")
    public void testTask(){
        System.out.println("hello");
    }
}
