package service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import request.RequestEmail;
import response.ResponseEmail;

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
    boolean enviado;
    final String from = request.getRemitente().getEmailAddress();
    final String to = request.getDestinatario().getEmailAddress();

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
    enviado = true;
    response.setEnviado(enviado);
    return response;
  }

}
