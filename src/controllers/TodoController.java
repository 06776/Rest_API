package controllers;

import java.io.IOException;
import java.util.Properties;
import models.Client;
import models.Prop;

public class TodoController {

  String host;
  String endpoint;
  Properties prop;
  Client client;

  public TodoController() throws IOException {
    this.client = new Client();
    prop = new Prop().getProp();
    this.host = this.prop.getProperty("host");
    this.endpoint = this.prop.getProperty("endpoint");
  }

  public void index() {
    String url = this.host + this.endpoint;
    String res = client.get(url);
    System.out.println(res); //view(s)-ban kell lennie hivatalosan
  }

  public void create() {
    String url = this.host + this.endpoint;
    String body =
      "{\"userId\": 1," +
      "\title\":\"Uj szoveg alkalmazasa\"," +
      "\"completed\": false" +
      "}";
    String res = client.post(url, body);
    System.out.println(res);
  }

  //github.com/oktat/empclient

  public void update() {}

  public void delete() {}
}
