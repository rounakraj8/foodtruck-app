package com.oracle.foodtruck.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.foodtruck.model.FoodTruck;
import java.util.List;

public class FoodTruckMapper {

  private final ObjectMapper objectMapper;

  public FoodTruckMapper() {
    objectMapper = new ObjectMapper();
  }

  public List<FoodTruck> getFoodTruckList(String jsonStr) {
    try {
      return objectMapper.readValue(jsonStr, new TypeReference<>() {
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}