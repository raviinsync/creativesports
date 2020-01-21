package com.sports.creativesports.scheduledtasks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sports.creativesports.players.PlayerRepository;
import com.sports.creativesports.players.Players;
import com.sports.creativesports.utils.CommonUtils;
import com.sports.creativesports.utils.WhatsappSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BirthdayTimer {

  private static final Logger log = LoggerFactory.getLogger(BirthdayTimer.class);

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  @Autowired
  private PlayerRepository playerRepository;

  // currently scheduler configured for 2 minutes
  @Scheduled(cron ="0 0/1 * * * ?")
  public void sendWhatsappMessage() {

    /*
    1. User Pojo retrieval--retrieving every user that matches date and Month with current Date and Month.
    2. Initiate a message to be sent.
    3. For each user call the WhatsappSender.sendMessage

*/
    List<Players> allPlayers = playerRepository.findAll();

    for(Players eachPlayer: allPlayers){

      CommonUtils.hasBirthday(eachPlayer.getBirthDate());

      System.out.println(eachPlayer.getFirstName());
    }

    WhatsappSender.sendMessage("+14155238886", "+919535632642", "Happy Birthday Ravi!..you did it finally!");
    //WhatsappSender.sendMessage("+14155238886", "+919945832692","Happy Birthday Sachin!..you saw it finally!");

    log.info("The time is now {}", dateFormat.format(new Date()));
  }




}