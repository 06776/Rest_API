package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Prop {
  
  Properties prop;

  public Prop() throws IOException {
    prop = new Properties();
    this.readConfig();
  }

  public void readConfig() throws IOException {
    try {
      tryReadConfig();
    } catch (FileNotFoundException e) {
      System.err.println("Hiba, a File nem talalhato!");
      System.err.println(e);
    } catch (IOException e) {
      System.err.println("Hiba tortent az atvitel soran!");
      System.err.println(e);
    }
  }

  private void tryReadConfig() throws IOException {
    InputStream stream = new FileInputStream("jclient.config");
    prop.load(stream);
  }

  public Properties getProp() {
    return this.prop;
  }
}
