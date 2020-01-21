package com.sports.creativesports.scheduledtasks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sports.creativesports.players.PlayerRepository;
import com.sports.creativesports.players.Players;
import com.sports.creativesports.utils.CommonUtils;
import com.sports.creativesports.utils.WhatsAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BirthdayTimer {

  private static final Logger log = LoggerFactory.getLogger(BirthdayTimer.class);

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  private static String BIRTHDAY_MESSAGE=",Creative Sports Academy wishes you a beautiful day with good health and happiness forever. Happy birthday!";

  @Autowired
  private PlayerRepository playerRepository;

  // currently scheduler configured for 2 minutes
  @Scheduled(cron ="0 0/2 * * * ?")
  public void sendWhatsappMessage() {

    /*
    1. User Pojo retrieval--retrieving every user that matches date and Month with current Date and Month.
    2. Initiate a message to be sent.
    3. For each user call the WhatsappSender.sendMessage

*/
    List<Players> allPlayers = playerRepository.findAll();

    for(Players eachPlayer: allPlayers){

      Boolean hasBirthDay= CommonUtils.hasBirthday(eachPlayer.getBirthDate());

      if(hasBirthDay){
        WhatsAppService.sendMessage("+14155238886", eachPlayer.getMobile(), "Hi " + eachPlayer.getFirstName() + " " + eachPlayer.getLastName() + BIRTHDAY_MESSAGE);
      }
      System.out.println(eachPlayer.getFirstName());
    }

    //WhatsappSender.sendMessage("+14155238886", "+919945832692","Happy Birthday Sachin!..you saw it finally!");

    log.info("The time is now {}", dateFormat.format(new Date()));
  }




}