package run;

import loader.SpringContextLoader;
import model.Persona;
import service.MailSenderService;
import service.request.RequestEmail;
import service.response.ResponseEmail;
import service.util.ServiceCodes;

public class RunMailSender {

  private static Persona remitente;
  private static Persona destinatario;
  private static MailSenderService senderService;

  static {
    // Creando data de prueba
    remitente = new Persona();
    remitente.setNombres("Alex Jorge");
    remitente.setApellidos("Contreras Granados");
    remitente.setEmailAddress("alex-cg@gmail.com");

    destinatario = new Persona();
    destinatario.setNombres("r2d2");
    destinatario.setApellidos("c3p0");
    destinatario.setEmailAddress("r2d2_c3p0@gmail.com");

    senderService = SpringContextLoader.getMailSenderService();
  }

  public static void main(String[] args) {
    RequestEmail request = new RequestEmail();
    request.setAsunto("Test application.");
    request.setRemitente(remitente.getEmailAddress());
    request.setDestinatario(destinatario.getEmailAddress());
    request.setContenido("I am testing a mail sender with spring.");

    iniciandoEnvioMail();

    ResponseEmail response = senderService.enviarCorreo(request);

    finDeEnvioMail(response.getEnviado());
  }

  private static void iniciandoEnvioMail() {
    System.out.println("Iniciando el envio de mail ... ");
  }

  private static void finDeEnvioMail(final String enviado) {
    System.out.println(ServiceCodes.ENVIADO.equals(enviado) ? "Envio de e-mail exitoso. "
        : "Envio de e-mail fallido.");
  }

}
