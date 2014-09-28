package response;

/**
 * Clase response basica que devuelve el servicio de mail
 */
public class ResponseEmail {

  private boolean enviado;

  public boolean isEnviado() {
    return enviado;
  }

  public void setEnviado(boolean enviado) {
    this.enviado = enviado;
  }

}
