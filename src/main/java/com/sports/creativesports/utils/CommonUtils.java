package com.sports.creativesports.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.ZoneId;
import java.util.Date;

public class CommonUtils {

  public static void main(String[] args) {

    hasBirthday(new Date());

  }

  public static boolean hasBirthday(Date datetoConvert) {

    LocalDate dateOfBirth = convertToLocalDateViaInstant(datetoConvert);

    MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
    MonthDay currentMonthDay = MonthDay.from(LocalDate.now());

    if (currentMonthDay.equals(birthday)) {
      System.out.println("Yes!!");
    } else {
      System.out.println("Sorry, today is not your birthday");
    }
    return true;
  }

  public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }
}