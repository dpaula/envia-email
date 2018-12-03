/**
 * 
 */
package br.lima.enviaEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

/**
 * @author user
 *
 */
@Service
public class EmailService {

	public void enviar(String nome, String emailConvidado) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("fernando.dpaula@gmail.com", "pedro__0"));
			email.setSSLOnConnect(true);

			email.setFrom("fernando.dpaula@gmail.com");
			email.setSubject("Você foi convidado pelo ListaVIP");
			email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
			email.addTo(emailConvidado);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
