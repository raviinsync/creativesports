package com.sports.creativesports.scheduledtasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

  private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  @Scheduled(cron ="0 0/2 * * * ?")
  public static void sendWhatsappMessage() {
    WhatsappSender.sendMessage("+14155238886", "+919535632642","Happy Birthday Ravi!..you did it finally!");
    //WhatsappSender.sendMessage("+14155238886", "+919945832692","Happy Birthday Sachin!..you saw it finally!");

    log.info("The time is now {}", dateFormat.format(new Date()));
  }




}