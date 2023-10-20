package controllers;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Properties;
import models.Client;
import models.Prop;
import models.Todo;

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
    System.out.println(res);
  }

  public void create() {
    String url = this.host + this.endpoint;
    String body =
      "{\"userId\": 1," +
      "\title\":\"Uj szoveg alkalmazasa\"," +
      "\"completed\": false" +
      "}";
    System.out.println(body);
    String res = client.post(url, body);
    System.out.println(res);
  }

  //github.com/oktat/empclient

  public void update(Todo todo) {
    String url = this.host + this.endpoint + "/" + todo.getId().toString();
    Gson gson = new Gson();
    String body = gson.toJson(todo);
    System.out.println(body);
    client.put(url, body);
  }

  public void delete(Integer id) {
    String url = this.host + this.endpoint + "/" + id;
    client.delete(url);
  }
}
