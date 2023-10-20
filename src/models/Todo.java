package models;

public class Todo {

  private Integer id;
  private String title;
  private boolean completed;
  private int userId;

  public Todo(int id, String title, boolean completed, int userId) {
    this.id = id;
    this.title = title;
    this.completed = completed;
    this.userId = userId;
  }

  public Todo(String title, boolean completed, int userId) {
    this.title = title;
    this.completed = completed;
    this.userId = userId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
