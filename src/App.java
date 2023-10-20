import controllers.TodoController;
// import models.Todo;

public class App {

  public static void main(String[] args) throws Exception {
    // new TodoController().index();
    // new TodoController().create();
    // new TodoController().update(
    //   new Todo(1, "Uj szoveg alkalmazasa", false, 1)
    // );
    new TodoController().delete(1);
  }
}
