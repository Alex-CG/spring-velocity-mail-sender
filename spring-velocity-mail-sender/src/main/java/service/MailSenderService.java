package service;

import request.RequestEmail;
import response.ResponseEmail;

/**
 * Interface para el servicio de mail
 */
public interface MailSenderService {

  /**
   * metodo generico para envio de mail
   * 
   * @param request
   * @return response
   */
  ResponseEmail enviarCorreo(RequestEmail request);

}
