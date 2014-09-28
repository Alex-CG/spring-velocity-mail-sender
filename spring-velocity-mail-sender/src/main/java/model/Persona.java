package model;

/**
 * Entidad base
 */
public class Persona implements EmailAddress {

  private String nombres;
  private String apellidos;
  private String email;

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  @Override
  public String getEmailAddress() {
    return email;
  }

  @Override
  public void setEmailAddress(String email) {
    this.email = email;
  }

}
