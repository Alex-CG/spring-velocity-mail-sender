package loader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.MailSenderService;

/**
 * Responsable de iniciar la carga de spring
 */
public class SpringContextLoader {

  private static ApplicationContext context = new ClassPathXmlApplicationContext(
      "context/appcontext-mail.xml");

  public static MailSenderService getMailSenderService() {
    return (MailSenderService) SpringContextLoader.context.getBean("mailService");
  }

}
