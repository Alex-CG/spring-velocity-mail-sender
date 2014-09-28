package run;

import loader.SpringContextLoader;
import model.Persona;
import request.RequestEmail;
import response.ResponseEmail;
import service.MailSenderService;

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
    request.setRemitente(remitente);
    request.setDestinatario(destinatario);
    request.setContenido("I am testing an mail sender with spring.");

    iniciandoEnvioMail();

    ResponseEmail response = senderService.enviarCorreo(request);

    finDeEnvioMail(response.isEnviado());
  }

  private static void iniciandoEnvioMail() {
    System.out.println("Iniciando el envio de mail ... ");
  }

  private static void finDeEnvioMail(final boolean enviado) {
    System.out.println(enviado ? "Envio de e-mail exitoso. " : "Envio de e-mail fallido.");
  }

}
