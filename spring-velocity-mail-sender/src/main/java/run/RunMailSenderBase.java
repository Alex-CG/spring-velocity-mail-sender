package run;

import service.util.ServiceCodes;
public class RunMailSenderBase {

  protected static void iniciandoEnvioMail() {
    System.out.println("Iniciando el envio de mail ... ");
  }

  protected static void finDeEnvioMail(final String enviado) {
    System.out.println(ServiceCodes.ENVIADO.equals(enviado) ? "Envio de e-mail exitoso. "
        : "Envio de e-mail fallido.");
  }

}
