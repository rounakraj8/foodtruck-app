package com.foodtruck.util;

import com.foodtruck.model.FoodTruck;
import java.util.List;
import java.util.Scanner;

public class FoodTruckDisplayUtil {

  private static final int SPACE_BETWEEN_NAME_AND_ADDRESS = 80;

  public static void display(List<FoodTruck> foodTrucks) {
    int totalSize = foodTrucks.size();
    System.out.println("\nTotal Food Truck(s) found: " + totalSize + "\n");
    for (int j = 1; j <= foodTrucks.size(); j++) {
      FoodTruck foodTruck = foodTrucks.get(j - 1);
      displayColumnHeaders(j);
      displayRow(foodTruck);
      displayMessageAndWaitForUserInput(totalSize, j);
    }
  }

  private static void displayMessageAndWaitForUserInput(int totalSize, int index) {
    if (index % 10 == 0) {
      int input = 0;
      System.out
          .println("\n" + "(" + index + "/" + totalSize + ")"
              + "\t>>>>>>>\t\tPress '1' to continue or '0' to exit ...");
      while (input != 1) {
        input = new Scanner(System.in).nextInt();
        if (input == 0) {
          System.exit(1);
        }
      }
    }
  }

  private static void displayRow(FoodTruck foodTruck) {
    System.out.println(
        String.format("%-" + SPACE_BETWEEN_NAME_AND_ADDRESS + "s", foodTruck.getApplicant())
            + foodTruck.getLocation());
  }

  private static void displayColumnHeaders(int j) {
    if (j % 10 == 1) {
      System.out.println(String.format("%10s", "Name") + String
          .format("%" + SPACE_BETWEEN_NAME_AND_ADDRESS + "s", "Address") + "\n");
    }
  }

}
