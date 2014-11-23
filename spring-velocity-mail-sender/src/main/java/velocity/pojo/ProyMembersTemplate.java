package velocity.pojo;

import java.util.List;

import model.Persona;

public class ProyMembersTemplate {

  private String titulo;
  private String subtitulo;
  private List<Persona> personas;
  
  public String getTitulo() {
    return titulo;
  }
  
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  
  public String getSubtitulo() {
    return subtitulo;
  }
  
  public void setSubtitulo(String subtitulo) {
    this.subtitulo = subtitulo;
  }

  public List<Persona> getPersonas() {
    return personas;
  }
  
  public void setPersonas(List<Persona> personas) {
    this.personas = personas;
  }
}
