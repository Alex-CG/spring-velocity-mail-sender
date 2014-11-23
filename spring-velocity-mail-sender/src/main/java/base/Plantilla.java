package base;

public enum Plantilla {

  PROYECT_MEMBERS("project-members"), HELLO_WORLD("hello-world");

  private final String CLASSPATH = "/src/main/resources/";
  private final String PATH_TEMPLATES = "templates/";
  private final String EXTENSION = ".template";

  private String name;

  private Plantilla(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String getFileName() {
    return name.concat(EXTENSION);
  }

  public String getPathWithFileName() {
    return PATH_TEMPLATES.concat(name).concat(EXTENSION);
  }

  public String getClassPathWithFileName() {
    return CLASSPATH.concat(PATH_TEMPLATES).concat(name).concat(EXTENSION);
  }

}
