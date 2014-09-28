package request;

import model.EmailAddress;

/**
 * Clase request basica para peticion del servicio de mail
 */
public class RequestEmail {

  private EmailAddress remitente;
  private EmailAddress destinatario;
  private String asunto;
  private String contenido;

  public EmailAddress getRemitente() {
    return remitente;
  }

  public void setRemitente(EmailAddress remitente) {
    this.remitente = remitente;
  }

  public EmailAddress getDestinatario() {
    return destinatario;
  }

  public void setDestinatario(EmailAddress destinatario) {
    this.destinatario = destinatario;
  }

  public String getAsunto() {
    return asunto;
  }

  public void setAsunto(String asunto) {
    this.asunto = asunto;
  }

  public String getContenido() {
    return contenido;
  }

  public void setContenido(final String contenido) {
    this.contenido = contenido;
  }

}
