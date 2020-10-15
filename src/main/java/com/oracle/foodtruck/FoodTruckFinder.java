package com.oracle.foodtruck;

import com.oracle.foodtruck.service.FoodTruckFinderService;
import com.oracle.foodtruck.service.FoodTruckFinderServiceImpl;
import java.time.LocalDateTime;

public class FoodTruckFinder {

  public static void main(String[] args) {
    System.out.println("Welcome to the FoodTruck App!\n\n");
    FoodTruckFinderService foodTruckFinderService = new FoodTruckFinderServiceImpl(
        LocalDateTime.now());
    foodTruckFinderService.findFoodTrucksNow();
  }
}
