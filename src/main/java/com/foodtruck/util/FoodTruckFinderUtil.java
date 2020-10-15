package com.foodtruck.util;

import com.foodtruck.model.FoodTruck;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FoodTruckFinderUtil {

  public static boolean isFoodTruckListEmpty(final List<FoodTruck> foodTruckList) {
    return foodTruckList == null || foodTruckList.size() == 0;
  }

  public static List<FoodTruck> sortFoodTruckListByName(List<FoodTruck> foodTruckList) {
    Collections.sort(foodTruckList, Comparator.comparing(FoodTruck::getApplicant));
    return foodTruckList;
  }

  public static List<FoodTruck> filterByTime(List<FoodTruck> foodTruckList,
      DateTimeFormatter dateTimeFormatter, LocalDateTime localDateTime) {
    foodTruckList = foodTruckList.stream().filter(
        foodTruck -> isCurrentTimeInFoodTruckTimingRange(foodTruck, dateTimeFormatter,
            localDateTime))
        .collect(Collectors.toList());
    return foodTruckList;
  }

  public static boolean isCurrentTimeInFoodTruckTimingRange(FoodTruck foodTruck,
      DateTimeFormatter dateTimeFormatter, LocalDateTime localDateTime) {
    return LocalTime.parse(foodTruck.getStart24(), dateTimeFormatter)
        .isBefore(localDateTime.toLocalTime()) && LocalTime.parse(foodTruck
        .getEnd24(), dateTimeFormatter).isAfter(localDateTime.toLocalTime());
  }

  public static String getDayOfWeek(LocalDateTime localDateTime) {
    int dayOfWeek = localDateTime.getDayOfWeek().getValue();
    dayOfWeek = dayOfWeek >= 7 ? dayOfWeek % 7 : dayOfWeek;
    return String.valueOf(dayOfWeek);
  }
}
