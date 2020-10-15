package com.oracle.foodtruck.service;

import com.oracle.foodtruck.client.Client;
import com.oracle.foodtruck.client.HttpClientImpl;
import com.oracle.foodtruck.constants.URLConstants;
import com.oracle.foodtruck.mapper.FoodTruckMapper;
import com.oracle.foodtruck.model.FoodTruck;
import com.oracle.foodtruck.util.FoodTruckDisplayUtil;
import com.oracle.foodtruck.util.FoodTruckFinderUtil;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FoodTruckFinderService {

  private final LocalDateTime localDateTime;
  private final FoodTruckMapper foodTruckMapper;
  private final DateTimeFormatter dateTimeFormatter;
  private final Client client;

  public FoodTruckFinderService(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
    this.foodTruckMapper = new FoodTruckMapper();
    this.dateTimeFormatter = DateTimeFormatter.ofPattern("kk:mm");
    this.client = new HttpClientImpl();
  }

  /**
   * This method finds all Food Trucks available at the current given time
   */
  public void findFoodTrucksNow() {
    String jsonStrResponse = getStringResponse();
    List<FoodTruck> foodTruckList = foodTruckMapper.getFoodTruckList(jsonStrResponse);
    if (FoodTruckFinderUtil.isFoodTruckListEmpty(foodTruckList)) {
      System.out.println("No list to display!");
      return;
    }
    FoodTruckFinderUtil.filterByTime(foodTruckList, dateTimeFormatter, localDateTime);
    FoodTruckFinderUtil.sortFoodTruckListByName(foodTruckList);
    FoodTruckDisplayUtil.display(foodTruckList);
  }

  private String getStringResponse() {
    return client
        .getStringResponse(URLConstants.BASE_URL + URLConstants.DAY_ORDER_REQUEST_PARAM,
            FoodTruckFinderUtil.getDayOfWeek(localDateTime));
  }

}
