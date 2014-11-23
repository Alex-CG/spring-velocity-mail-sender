package velocity.data;

import velocity.pojo.HelloWorldTemplate;

public class DataHelloWorld {

  private static HelloWorldTemplate dataTemplate;

  public static HelloWorldTemplate getData() {

    dataTemplate = new HelloWorldTemplate();
    dataTemplate.setName("Alex");

    return dataTemplate;
  }
}
