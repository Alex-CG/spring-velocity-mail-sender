package velocity.examples;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import velocity.data.DataProyectMembers;
import velocity.pojo.ProyMembersTemplate;
import base.Constante;
import base.util.MapFromBeanUtil;

public class MiembrosProyecto implements Constante {

  public static void main(String[] args) {

    VelocityEngine engine = new VelocityEngine();

//    engine.init();

    Template template = engine.getTemplate(CLASSPATH_TEMPLATES + "project-members.template");

    final ProyMembersTemplate dataTemplate = new DataProyectMembers().getData();

    VelocityContext context = new VelocityContext(MapFromBeanUtil.convertir(dataTemplate));

    StringWriter writer = new StringWriter();

    template.merge(context, writer);

    System.out.println(writer.toString());

  }

}
