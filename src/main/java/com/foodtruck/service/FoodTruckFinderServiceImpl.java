package com.foodtruck.service;

import com.foodtruck.client.Client;
import com.foodtruck.client.HttpClientImpl;
import com.foodtruck.constants.URLConstants;
import com.foodtruck.mapper.FoodTruckMapper;
import com.foodtruck.model.FoodTruck;
import com.foodtruck.util.FoodTruckDisplayUtil;
import com.foodtruck.util.FoodTruckFinderUtil;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FoodTruckFinderServiceImpl implements FoodTruckFinderService {

  private final LocalDateTime localDateTime;
  private final FoodTruckMapper foodTruckMapper;
  private final DateTimeFormatter dateTimeFormatter;
  private final Client client;

  public FoodTruckFinderServiceImpl(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
    this.foodTruckMapper = new FoodTruckMapper();
    this.dateTimeFormatter = DateTimeFormatter.ofPattern("kk:mm");
    this.client = new HttpClientImpl();
  }

  /**
   * This method finds all Food Trucks available at the current given time
   */
  @Override
  public void findFoodTrucksNow() {
    System.out.println("Finding the Food trucks at: " + localDateTime.toLocalTime());
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
