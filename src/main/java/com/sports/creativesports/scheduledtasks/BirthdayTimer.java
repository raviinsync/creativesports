package com.sports.creativesports.scheduledtasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sports.creativesports.utils.WhatsappSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BirthdayTimer {

  private static final Logger log = LoggerFactory.getLogger(BirthdayTimer.class);

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  // currently scheduler configured for 2 minutes
  @Scheduled(cron ="0 0/2 * * * ?")
  public static void sendWhatsappMessage() {

    /*
    1. User Pojo retrieval--retrieving every user that matches date and Month with current Date and Month.
    2. Initiate a message to be sent.
    3. For each user call the WhatsappSender.sendMessage

*/
    WhatsappSender.sendMessage("+14155238886", "+919535632642", "Happy Birthday Ravi!..you did it finally!");
    //WhatsappSender.sendMessage("+14155238886", "+919945832692","Happy Birthday Sachin!..you saw it finally!");

    log.info("The time is now {}", dateFormat.format(new Date()));
  }




}