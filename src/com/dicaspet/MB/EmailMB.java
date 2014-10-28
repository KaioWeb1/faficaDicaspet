package com.dicaspet.MB;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.EmailException;

import com.dicaspet.entidade.EmailE;
import com.dicaspet.util.EmailUtils;

@ManagedBean(name="emailMB")
@RequestScoped
public class EmailMB {
	 
	 private EmailE mensagem = new EmailE();
	 
	
	 
	 public void limpaCampos() {
	 mensagem = new EmailE();
	 }
	 
	 public void enviaEmail() {
	 try {
	 EmailUtils.enviaEmail(mensagem);
	 } catch (EmailException ex) {
	 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! Occoreu um erro ao enviar a mensagem.", "Erro"));
	 Logger.getLogger(EmailMB.class.getName()).log(Level.SEVERE, null, ex);
	 }
	 }

	public EmailE getMensagem() {
		return mensagem;
	}

	public void setMensagem(EmailE mensagem) {
		this.mensagem = mensagem;
	}
	 

	 
	}