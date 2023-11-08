package com.infocrust.eis.mega.quartzschedulers.schedulers;

import com.infocrust.eis.mega.quartzschedulers.jobs.EmailNotification;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;
import java.util.random.RandomGenerator;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.DateBuilder.evenMinuteDate;

@Component
public class EmailScheduler {

    @Autowired
    public Scheduler scheduler;
    public void schedule() {
        try {

            int randomNumber = RandomGenerator.getDefault().nextInt()+10;

            JobDetail emailJobDetails = JobBuilder.newJob(EmailNotification.class)
                    .withDescription("Email Notification Job")
                    .withIdentity("Job"+randomNumber, "JobNotifications")
                    .storeDurably(true)
                    .build();

            Trigger dailyTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("DailyTrigger"+randomNumber, "TriggerNotifications")
                    .withDescription("Every 3 minutes Trigger for Emails ")
                    .withPriority(10)
                    .withSchedule(cronSchedule("0 0/2 * * * ?")) // fire every 20 seconds
                    .build();

//            Trigger dailyTrigger = new CronTriggerImpl();
//            dailyTrigger


            scheduler.scheduleJob(emailJobDetails, dailyTrigger);
            scheduler.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
