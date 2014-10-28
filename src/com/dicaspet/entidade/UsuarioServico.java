package com.dicaspet.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity(name = "usuario_servico")
@AssociationOverrides({
		@AssociationOverride(name = "pk.usuario", joinColumns = @JoinColumn(name = "usu_id")),
		@AssociationOverride(name = "pk.servico", joinColumns = @JoinColumn(name = "srv_id")) })
public class UsuarioServico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5192533028108574177L;

	
	@EmbeddedId
	private UsuarioServicoPK pk = new UsuarioServicoPK();

	@Column(name = "status_servico_confirmacao")
	private String status_servico_confirmacao;
	
	@Column(name = "ptsv_id")
	private Long ptsv_id;

	@Column(name = "data_agendamento")
	private Date data_agendamento;

	public UsuarioServicoPK getPk() {
		return pk;
	}

	public void setPk(UsuarioServicoPK pk) {
		this.pk = pk;
	}

	 public boolean equals(Object o) {
		 if (this == o)
		 return true;
		 if (o == null || getClass() != o.getClass())
		 return false;
		 
		 UsuarioServico that = (UsuarioServico) o;
		 
		 if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null)
		 return false;
		 
		 return true;
		 }
	 
	 @Transient
	 public Usuario getUsuario() {
	 return this.getPk().getUsuario();
	 }
	 
	 @Transient
	 public Servico getServico() {
	 return this.getPk().getServico();
	 }
	 
	 public int hashCode() {
		 return (getPk() != null ? getPk().hashCode() : 0);
		 }

	public String getStatus_servico_confirmacao() {
		return status_servico_confirmacao;
	}

	public void setStatus_servico_confirmacao(String status_servico_confirmacao) {
		this.status_servico_confirmacao = status_servico_confirmacao;
	}

	public Date getData_agendamento() {
		return data_agendamento;
	}

	public void setData_agendamento(Date data_agendamento) {
		this.data_agendamento = data_agendamento;
	}

	public Long getPtsv_id() {
		return ptsv_id;
	}

	public void setPtsv_id(Long ptsv_id) {
		this.ptsv_id = ptsv_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
