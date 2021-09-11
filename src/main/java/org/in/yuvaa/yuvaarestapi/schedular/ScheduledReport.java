package org.in.yuvaa.yuvaarestapi.schedular;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledReport {

    @Scheduled(fixedRate = 100000)
    public void scheduledTask(){
        System.out.println("Hey there, It's working - Good Job!");
    }
}
