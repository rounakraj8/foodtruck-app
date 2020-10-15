package com.foodtruck.client;

import com.foodtruck.exceptions.ConnectionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class HttpClientImpl implements Client {

  private static final String GET = "GET";

  /**
   * Pass the URL and request-param and get the response as String.class
   * @param uri
   * @param requestParam
   * @return
   */

  @Override
  public String getStringResponse(final String uri, final String requestParam) {
    String urlWithParam = String.format(uri, requestParam);
    try {
      URL url = new URL(urlWithParam);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod(GET);
      return getStringResponseFromConnection(conn);
    } catch (IOException e) {
      throw new ConnectionException(uri);
    }
  }

  /**
   * Method to convert InputStream into String.class
   * @param conn
   * @return
   * @throws IOException
   */

  private String getStringResponseFromConnection(HttpURLConnection conn) throws IOException {
    return new BufferedReader(new InputStreamReader(conn.getInputStream())).lines()
        .collect(Collectors.joining("\n"));
  }
}
