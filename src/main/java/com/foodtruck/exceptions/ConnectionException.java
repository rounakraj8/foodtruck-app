package com.foodtruck.exceptions;

public class ConnectionException extends RuntimeException {

  private static final String ERROR_MSG = "Error while calling %s:";

  public ConnectionException(String uri) {
    super(String.format(ERROR_MSG, uri));
  }

}
