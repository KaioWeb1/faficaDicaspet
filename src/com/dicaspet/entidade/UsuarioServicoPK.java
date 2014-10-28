package com.dicaspet.entidade;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class UsuarioServicoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4902508129493330133L;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	 private Usuario usuario;
	 @ManyToOne(fetch = FetchType.EAGER, optional = false)
	 private Servico servico;
	 
	 public boolean equals(Object o) {
		 if (this == o)
		 return true;
		 if (o == null || getClass() != o.getClass())
		 return false;
		 if (!(o instanceof UsuarioServicoPK))
		 return false;
		 
		 UsuarioServicoPK that = (UsuarioServicoPK) o;
		 
		 if (this.usuario != null ? !this.usuario.equals(that.usuario) : that.usuario != null)
		 return false;
		 if (this.servico != null ? !this.servico.equals(that.servico) : that.servico != null)
		 return false;
		 
		 return true;
		 }
	 
	 public int hashCode() {
		 int result;
		 result = (this.usuario != null ? this.usuario.hashCode() : 0);
		 result = 31 * result + (this.servico != null ? this.servico.hashCode() : 0);
		 return result;
		 }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
}
