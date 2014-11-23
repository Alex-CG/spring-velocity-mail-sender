package service.request;

/**
 * Clase request basica para peticion del servicio de mail
 */
public class RequestEmail {

  private String remitente;
  private String destinatario;
  private String asunto;
  private String contenido;

  public String getRemitente() {
    return remitente;
  }

  public void setRemitente(String remitente) {
    this.remitente = remitente;
  }

  public String getDestinatario() {
    return destinatario;
  }

  public void setDestinatario(String destinatario) {
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
