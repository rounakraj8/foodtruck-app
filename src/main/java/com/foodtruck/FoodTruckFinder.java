package com.foodtruck;

import com.foodtruck.service.FoodTruckFinderService;
import com.foodtruck.service.FoodTruckFinderServiceImpl;
import java.time.LocalDateTime;

public class FoodTruckFinder {

  /**
   * Entrypoint of the application. Calls findFoodTrucksNow of FoodTruckFinderService
   * @param args
   */
  public static void main(String[] args) {
    FoodTruckFinderService foodTruckFinderService = new FoodTruckFinderServiceImpl(
        LocalDateTime.now());
    foodTruckFinderService.findFoodTrucksNow();
  }
}
