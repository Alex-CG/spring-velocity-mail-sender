package velocity.data;

import java.util.ArrayList;
import java.util.List;

import model.Cargo;
import model.Persona;
import velocity.pojo.ProyMembersTemplate;

public class DataProyectMembers {

  private ProyMembersTemplate dataTemplate;

  public ProyMembersTemplate getData() {

    dataTemplate = new ProyMembersTemplate();

    // Creando cargos
    List<Cargo> cargos = new ArrayList<>();

    Cargo pm = new Cargo();
    pm.setNombre("Project Manager");
    cargos.add(pm);

    Cargo dba = new Cargo();
    dba.setNombre("Database Administrator");
    cargos.add(dba);

    Cargo qa = new Cargo();
    qa.setNombre("Quality Assurance Engineer");
    cargos.add(qa);

    Cargo se = new Cargo();
    se.setNombre("Software Engineer");
    cargos.add(se);

    // Creando trabajadores
    List<Persona> personas = new ArrayList<>();

    // PM
    Persona ppm = new Persona();
    ppm.setCargo(pm);
    ppm.setNombres("Juan");
    ppm.setApellidos("Vargas Vargas");
    ppm.setEmailAddress("j.vargas@team.com");
    personas.add(ppm);

    // DBA
    Persona pdba = new Persona();
    pdba.setCargo(dba);
    pdba.setNombres("David");
    pdba.setApellidos("Rivera Bustios");
    pdba.setEmailAddress("d.rivera@team.com");
    personas.add(pdba);

    // QAs
    Persona pqa1 = new Persona();
    pqa1.setCargo(qa);
    pqa1.setNombres("Johan");
    pqa1.setApellidos("Morales Flores");
    pqa1.setEmailAddress("j.morales@team.com");
    personas.add(pqa1);

    Persona pqa2 = new Persona();
    pqa2.setCargo(qa);
    pqa2.setNombres("Andrea");
    pqa2.setApellidos("Gonzales Trujillo");
    pqa2.setEmailAddress("a.gonzales@team.com");
    personas.add(pqa2);

    // SEs
    Persona se1 = new Persona();
    se1.setCargo(se);
    se1.setNombres("Daniel");
    se1.setApellidos("Santiago Suarez");
    se1.setEmailAddress("d.santiago@team.com");
    personas.add(se1);

    Persona se2 = new Persona();
    se2.setCargo(se);
    se2.setNombres("Alonso");
    se2.setApellidos("Medina Torres");
    se2.setEmailAddress("a.medina@team.com");
    personas.add(se2);

    Persona se3 = new Persona();
    se3.setCargo(se);
    se3.setNombres("Marco");
    se3.setApellidos("Polo Polo");
    se3.setEmailAddress("m.polo@team.com");
    personas.add(se3);

    dataTemplate.setTitulo("Miembros del Proyecto");
    dataTemplate.setSubtitulo("La siguiente lista detalla los trabajadores agrupados por cargos :");
    dataTemplate.setPersonas(personas);

    return dataTemplate;
  }

}
