package velocity.examples;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import velocity.data.DataHelloWorld;
import velocity.pojo.HelloWorldTemplate;
import base.Constante;
import base.Plantilla;
import base.util.MapFromBeanUtil;

public class HelloWorld implements Constante {

  public static void main(String[] args) {

    VelocityEngine engine = new VelocityEngine();

    // engine.init();

    Template template = engine.getTemplate(Plantilla.HELLO_WORLD.getClassPathWithFileName());

    HelloWorldTemplate dataTemplate = DataHelloWorld.getData();

    VelocityContext context = new VelocityContext(MapFromBeanUtil.convertir(dataTemplate));

    StringWriter writer = new StringWriter();

    template.merge(context, writer);

    System.out.println(writer.toString());

  }
}
