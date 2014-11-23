package run;

import loader.SpringContextLoader;
import model.Persona;
import service.MailSenderService;
import service.request.RequestEmail;
import service.response.ResponseEmail;
import velocity.data.DataProyectMembers;
import base.Plantilla;
import base.TipoContenido;

public class RunMailSenderWithTemplate extends RunMailSenderBase {

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
    request.setAsunto("Test application with template.");
    request.setRemitente(remitente.getEmailAddress());
    request.setDestinatario(destinatario.getEmailAddress());

    request.setTipoContenido(TipoContenido.PLANTILLA.getCodigo());
    request.setObjetoContenido(DataProyectMembers.getData());
    request.setRutaPlanilla(Plantilla.PROYECT_MEMBERS.getPathWithFileName());

    iniciandoEnvioMail();

    ResponseEmail response = senderService.enviarCorreo(request);

    finDeEnvioMail(response.getEnviado());
  }

}
