package com.example.banktransactions.scheduler;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {
    public void scheduleApiImport(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String strDate = dateFormat.format(new Date());

        System.out.println(
                "Cron job Scheduler: Job running at - "
                        + strDate);
    }
}
