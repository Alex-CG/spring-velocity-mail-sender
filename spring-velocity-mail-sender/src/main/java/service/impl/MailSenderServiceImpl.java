package service.impl;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import service.MailSenderService;
import service.request.RequestEmail;
import service.response.ResponseEmail;
import service.util.ServiceCodes;
import base.TipoContenido;
import base.util.MapFromBeanUtil;

/**
 * Servicio de envio de e-mail
 */
public class MailSenderServiceImpl implements MailSenderService {

  private JavaMailSender sender;
  private VelocityEngine velocityEngine;

  public MailSenderServiceImpl(final JavaMailSender sender, final VelocityEngine velocityEngine) {
    this.sender = sender;
    this.velocityEngine = velocityEngine;
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

        String contenido = request.getTextoContenido();

        if (TipoContenido.PLANTILLA.getCodigo().equals(request.getTipoContenido())) {

          String rutaPlantilla = request.getRutaPlanilla();

          contenido = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, rutaPlantilla,
              MapFromBeanUtil.convertir(request.getObjetoContenido()));

        }

        helper.setText(contenido);

      }
    };

    sender.send(prepare);
    enviado = ServiceCodes.ENVIADO;
    response.setEnviado(enviado);
    return response;
  }
}
