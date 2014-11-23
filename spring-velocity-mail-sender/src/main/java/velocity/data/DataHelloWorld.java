package velocity.data;

import velocity.pojo.HelloWorldTemplate;

public class DataHelloWorld {

  private HelloWorldTemplate dataTemplate;

  public HelloWorldTemplate getData() {

    dataTemplate = new HelloWorldTemplate();
    dataTemplate.setName("Alex");

    return dataTemplate;
  }
}
