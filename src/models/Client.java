package models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

public class Client {

  HttpClient client;

  public Client() throws IOException {
    client = HttpClient.newHttpClient();
  }

  public String get(String url) {
    HttpRequest request = genGetRequest(url);
    return sendRequest(request);
  }

  public HttpRequest genGetRequest(String url) {
    HttpRequest request = HttpRequest
      .newBuilder()
      .uri(URI.create(url))
      .GET()
      .build();
    return request;
  }

  public String post(String url, String body, String... args) {
    HttpRequest request = genPostRequest(url, body, args);
    return sendRequest(request);
  }

  public HttpRequest genPostRequest(String url, String body, String... args) {
    List<String> headers = new ArrayList<>();
    headers.add("Content-Type");
    headers.add("application/json");

    if (args.length > 0) {
      headers.add("Authorization");
      headers.add("Bearer " + args[0]);
    }

    HttpRequest request = HttpRequest
      .newBuilder()
      .uri(URI.create(url))
      .POST(HttpRequest.BodyPublishers.noBody())
      .build();
    return request;
  }

  public String sendRequest(HttpRequest request) {
    String result = "";
    try {
      result = trySendRequest(request);
    } catch (InterruptedException e) {
      System.err.println("Hiba, megszakitas tortent!");
      System.err.println(e);
    } catch (IOException e) {
      System.err.println("Hiba tortent az atvitel soran!");
      System.err.println(e);
    }
    return result;
  }

  public String trySendRequest(HttpRequest request)
    throws IOException, InterruptedException {
    HttpResponse<String> response = client.send(
      request,
      BodyHandlers.ofString()
    );
    return response.body();
  }
}
