package com.teleconsultation.Service.Component;

import com.teleconsultation.Service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ContinuousTask {

    @Autowired
    private QueueService queueService;

    @Async
    @Scheduled(cron = "* * * * * *")
    public void runContinuously() {
        queueService.setMeeting();
    }
}
