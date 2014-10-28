package com.dicaspet.MB;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.dicaspet.entidade.Servico;
import com.dicaspet.entidade.Usuario;
import com.dicaspet.entidade.UsuarioServico;
import com.dicaspet.entidade.UsuarioServicoPK;
import com.dicaspet.fachada.Fachada;
import com.dicaspet.util.Constants;
import com.dicaspet.util.FacesContextUtil;


@ManagedBean(name="usuarioServicoMB")
@SessionScoped
public class UsuarioServicoMB implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7266504413062992988L;

	private UsuarioServico servico;
	private UsuarioServico usuario;
	private Usuario usuarioLogado;
	private Fachada fachada;

	private transient List<UsuarioServico>servicosDoPrestador = new ArrayList<UsuarioServico>();
	
	private Date dateAgendamento;
	private Servico servicoAtual;
	private UsuarioServico usuarioSelecionado;
	private List<UsuarioServico>usuariosSelecionados;
	private UsuarioServico servicoSelecionado;
	private List<UsuarioServico>servicosSelecionados;

	public UsuarioServicoMB() {
		fachada = Fachada.getInstance();
		servico = new UsuarioServico();
		servicoAtual = (Servico) FacesContextUtil.getSessionAttribute("servico");
		usuarioLogado = (Usuario) FacesContextUtil.getSessionAttribute("usuario");
		usuario = new UsuarioServico();

		
	}
	
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
 
	public UsuarioServico getUsuarioServico() {
		return usuario;
	}

	public void setUsuarioServico(UsuarioServico usuario) {
		this.usuario = usuario;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public List<UsuarioServico> getListarPorServico(Servico u) {
	
		return fachada.controladorUsuarioServico().listarPorServico(u);
	}


	public String cadastrar() {
		
		fachada.controladorUsuarioServico().cadastrar(usuario);
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso.","UsuarioServico cadastrado com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, message);

		
		return "index?faces-redirect=true";

	}
	
		public UsuarioServico getUsuarioServicoSelecionado() {
			return usuarioSelecionado;
		}


		public void setUsuarioServicoSelecionado(UsuarioServico usuarioSelecionado) {
			this.usuarioSelecionado = usuarioSelecionado;
		}


		public List<UsuarioServico> getUsuarioServicosSelecionados() {
			return usuariosSelecionados;
		}


		public void setUsuarioServicosSelecionados(List<UsuarioServico> usuariosSelecionados) {
			this.usuariosSelecionados = usuariosSelecionados;
		}
		
		
		public void editarUsuarioServicoRedirect(UsuarioServico usuario) throws IOException {

			this.usuario = usuario;

			FacesContext.getCurrentInstance().getExternalContext().redirect("/fafica.dicaspet/admin/editar-usuario.xhtml");

		}
		public void editar() {

			
			fachada.controladorUsuarioServico().atualizar(usuario);
			FacesMessage message = new FacesMessage(
					"Editado com Sucesso!", "O usuario  foi editado com sucesso.");

			FacesContext.getCurrentInstance().addMessage(null, message);
			usuario = new UsuarioServico();
		}
		
		


		public UsuarioServico getServicoSelecionado() {
			return servicoSelecionado;
		}


		public void setServicoSelecionado(UsuarioServico servicoSelecionado) {
			this.servicoSelecionado = servicoSelecionado;
		}


		public List<UsuarioServico> getServicosSelecionados() {
			return servicosSelecionados;
		}


		public void setServicosSelecionados(List<UsuarioServico> servicosSelecionados) {
			this.servicosSelecionados = servicosSelecionados;
		}
		
		public void confirmarAgendamento(UsuarioServico s){
			
			s.setStatus_servico_confirmacao("Confirmado");
			
			fachada.controladorUsuarioServico().atualizar(s);
			
			servicoSelecionado = new UsuarioServico();
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Confirmado com Sucesso!",
					"O serviço  foi confirmado com sucesso.");

			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
		public void agendarServico(){
			

			UsuarioServicoPK pk = new UsuarioServicoPK();
			
			pk.setUsuario(usuarioLogado);
			pk.setServico(servicoAtual);
			servico.setPk(pk);
		    servico.setData_agendamento(dateAgendamento);
			servico.setStatus_servico_confirmacao(Constants.Pendente);
			servico.setPtsv_id(servicoAtual.getSrv_id_prtsrv().getUsu_id());
			
			fachada.controladorUsuarioServico().cadastrar(servico);
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Agendado com Sucesso!",
					"O serviço foi agendado com sucesso.");

			FacesContext.getCurrentInstance().addMessage(null, message);
			
			
		}

		public UsuarioServico getServico() {
			return servico;
		}

		public void setServico(UsuarioServico servico) {
			this.servico = servico;
		}

		public UsuarioServico getUsuario() {
			return usuario;
		}

		public void setUsuario(UsuarioServico usuario) {
			this.usuario = usuario;
		}

		public Usuario getUsuarioLogado() {
			return usuarioLogado;
		}

		public void setUsuarioLogado(Usuario usuarioLogado) {
			this.usuarioLogado = usuarioLogado;
		}

		public Servico getServicoAtual() {
			return servicoAtual;
		}

		public void setServicoAtual(Servico servicoAtual) {
			this.servicoAtual = servicoAtual;
		}

		public UsuarioServico getUsuarioSelecionado() {
			return usuarioSelecionado;
		}

		public void setUsuarioSelecionado(UsuarioServico usuarioSelecionado) {
			this.usuarioSelecionado = usuarioSelecionado;
		}

		public List<UsuarioServico> getUsuariosSelecionados() {
			return usuariosSelecionados;
		}

		public void setUsuariosSelecionados(List<UsuarioServico> usuariosSelecionados) {
			this.usuariosSelecionados = usuariosSelecionados;
		}

		public Date getDateAgendamento() {
			return dateAgendamento;
		}

		public void setDateAgendamento(Date dateAgendamento) {
			this.dateAgendamento = dateAgendamento;
		}
		

		public List<UsuarioServico> getServicosDoPrestador() {
			usuarioLogado = (Usuario) FacesContextUtil.getSessionAttribute("usuario");
			servicosDoPrestador = Fachada.getInstance().controladorUsuarioServico().listarPorUsuario(usuarioLogado); 
			System.out.println(servicosDoPrestador.size()+"--------------------------------------------------------------------");

			for (UsuarioServico usuarioServico : servicosDoPrestador) {
				System.out.println(usuarioServico.getStatus_servico_confirmacao() +"-------"+usuarioServico.getPk().getServico().getSrv_descricao());
			}
			return servicosDoPrestador;
		}

}
