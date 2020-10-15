package com.foodtruck.exceptions;

public class UnmarshallingException extends RuntimeException {

  private static final String ERROR_MSG = "Error while unmarshalling: %s";

  public UnmarshallingException(String jsonStr) {
    super(String.format(ERROR_MSG, jsonStr));
  }

}
