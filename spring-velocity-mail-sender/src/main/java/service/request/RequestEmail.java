package service.request;

import base.TipoContenido;

/**
 * Clase request basica para peticion del servicio de mail
 */
public class RequestEmail {

  private String remitente;
  private String destinatario;
  private String asunto;
  private String textoContenido;
  private String rutaPlanilla;
  private Object objetoContenido;
  private String tipoContenido = TipoContenido.TEXTO.getCodigo();

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

  public String getTextoContenido() {
    return textoContenido;
  }

  public void setTextoContenido(final String textoContenido) {
    this.textoContenido = textoContenido;
  }

  public String getTipoContenido() {
    return tipoContenido;
  }

  public void setTipoContenido(final String tipoContenido) {
    this.tipoContenido = tipoContenido;
  }

  public Object getObjetoContenido() {
    return objetoContenido;
  }

  public void setObjetoContenido(final Object objetoContenido) {
    this.objetoContenido = objetoContenido;
  }

  public String getRutaPlanilla() {
    return rutaPlanilla;
  }

  public void setRutaPlanilla(final String rutaPlanilla) {
    this.rutaPlanilla = rutaPlanilla;
  }

}
