package base;

/**
 * Tipos de contenido para el email
 */
public enum TipoContenido {

  TEXTO("01"), PLANTILLA("02");

  private String codigo;

  private TipoContenido(String codigo) {
    this.codigo = codigo;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

}
