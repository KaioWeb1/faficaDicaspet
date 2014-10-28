package com.dicaspet.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.*;

import com.dicaspet.entidade.EmailE;

public class EmailUtils {
	 
	 private static final String HOSTNAME = "smtp.gmail.com";
	 private static final String USERNAME = "givaniltonricardo";
	 private static final String PASSWORD = "12332112";
	 private static final String EMAILORIGEM = "givaniltonricardo@gmail.com";
	 
	 public static Email conectaEmail() throws EmailException {
	 Email email = new SimpleEmail();
	 email.setHostName(HOSTNAME);
	 email.setSmtpPort(587);
	 email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
	 email.setTLS(true);
	 email.setFrom(EMAILORIGEM);
	 return email;
	 }
	 
	 public static void enviaEmail(EmailE mensagem) throws EmailException {
	 Email email = new SimpleEmail();
	 email = conectaEmail();
	 email.setSubject(mensagem.getTitulo());
	 email.setMsg(mensagem.getMensagem()+"\n"+mensagem.getDestino());
	 email.addTo("givaniltonricardo@gmail.com");
	 String resposta = email.send();
	 
	 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
			 "E-mail enviado com sucesso!", "E-mail enviado com sucesso!");

		FacesContext.getCurrentInstance().addMessage(null, message);
		
	 }
	}