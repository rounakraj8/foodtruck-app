package com.foodtruck.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodtruck.exceptions.UnmarshallingException;
import com.foodtruck.model.FoodTruck;
import java.util.List;

public class FoodTruckMapper {

  private final ObjectMapper objectMapper;

  public FoodTruckMapper() {
    objectMapper = new ObjectMapper();
  }

  public List<FoodTruck> getFoodTruckList(final String jsonStr) {
    try {
      return objectMapper.readValue(jsonStr, new TypeReference<List<FoodTruck>>() {
      });
    } catch (Exception e) {
      throw new UnmarshallingException(jsonStr);
    }
  }
}