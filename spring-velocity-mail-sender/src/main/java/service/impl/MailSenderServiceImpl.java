package service.impl;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import service.MailSenderService;
import service.request.RequestEmail;
import service.response.ResponseEmail;
import service.util.ServiceCodes;

/**
 * Servicio de envio de e-mail
 */
public class MailSenderServiceImpl implements MailSenderService {

  private JavaMailSender sender;

  public MailSenderServiceImpl(final JavaMailSender sender) {
    this.sender = sender;
  }

  @Override
  public ResponseEmail enviarCorreo(final RequestEmail request) {
    final ResponseEmail response = new ResponseEmail();
    String enviado;
    final String from = request.getRemitente();
    // TODO alex.contreras iterar si hay varios destinatarios
    final String to = request.getDestinatario();

    final MimeMessagePreparator prepare = new MimeMessagePreparator() {

      @Override
      public void prepare(final MimeMessage mimeMessage) throws Exception {
        final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(to);
        helper.setFrom(from);
        helper.setSubject(request.getAsunto());
        helper.setText(request.getContenido());
      }
    };

    sender.send(prepare);
    enviado = ServiceCodes.ENVIADO;
    response.setEnviado(enviado);
    return response;
  }

}
