package com.sports.creativesports.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import java.net.URI;
import java.util.Arrays;

public class WhatsAppService {
  // Find your Account Sid and Token at twilio.com/console
  // DANGER! This is insecure. See http://twil.io/secure
  public static final String ACCOUNT_SID = "AC4fe5c4f015feaf3252dd257ec3dcd933";
  public static final String AUTH_TOKEN = "3812ebd7160900ea39ef55c368fa6394";

 public static void main(String[] args) {
    //WhatsappSender.sendMessage("+14155238886", "+919901954686","Happy 4th Marriage Anniversary Vinay and Bindu!..Let god Bless you with health and wealth");
  }

  public static void sendMessage(String from, String to, String body) {

    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new com.twilio.type.PhoneNumber("whatsapp:" + to),
                                      //new com.twilio.type.PhoneNumber("whatsapp:+919535632642"),
                                      new com.twilio.type.PhoneNumber("whatsapp:"+from), body).setMediaUrl(
        Arrays.asList(URI.create("https://images.unsplash.com/photo-1545093149-618ce3bcf49d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80")))
        .create();

    System.out.println(message.getSid());

  }
}


