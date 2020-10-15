package com.foodtruck.util;

import com.foodtruck.model.FoodTruck;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FoodTruckFinderUtil {

  private static final DateTimeFormatter TIME_FORMAT_24_HRS = DateTimeFormatter.ofPattern("kk:mm");

  /**
   * Method to sort List<FoodTruck> by getApplicant
   *
   * @param foodTruckList
   * @return
   */

  public static List<FoodTruck> sortFoodTruckListByName(List<FoodTruck> foodTruckList) {
    Collections.sort(foodTruckList, Comparator.comparing(FoodTruck::getApplicant));
    return foodTruckList;
  }

  /**
   * Method to filter by time range
   *
   * @param foodTruckList
   * @param localDateTime
   * @return
   */

  public static List<FoodTruck> filterByTime(List<FoodTruck> foodTruckList,
      LocalDateTime localDateTime) {
    return foodTruckList.stream().filter(
        foodTruck -> isCurrentTimeInFoodTruckTimingRange(foodTruck, TIME_FORMAT_24_HRS,
            localDateTime))
        .collect(Collectors.toList());
  }

  public static boolean isCurrentTimeInFoodTruckTimingRange(FoodTruck foodTruck,
      DateTimeFormatter dateTimeFormatter, LocalDateTime localDateTime) {
    try {
      return LocalTime.parse(foodTruck.getStart24(), dateTimeFormatter)
          .isBefore(localDateTime.toLocalTime()) && LocalTime.parse(foodTruck
          .getEnd24(), dateTimeFormatter).isAfter(localDateTime.toLocalTime());
    } catch (DateTimeParseException e) {
      System.out.println("Error while parsing date: " + foodTruck);
      return false;
    }
  }

  /**
   * Method to get day of the week, by default we get 7 for Sunday but in API data, we get 0 for
   * Sunday
   *
   * @param localDateTime
   * @return
   */

  public static String getDayOfWeek(LocalDateTime localDateTime) {
    int dayOfWeek = localDateTime.getDayOfWeek().getValue();
    dayOfWeek = dayOfWeek >= 7 ? dayOfWeek % 7 : dayOfWeek;
    return String.valueOf(dayOfWeek);
  }
}
