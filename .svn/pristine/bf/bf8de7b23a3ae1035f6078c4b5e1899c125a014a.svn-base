package com.dicaspet.controlador;

import java.util.List;

import com.dicaspet.entidade.Servico;
import com.dicaspet.entidade.Usuario;
import com.dicaspet.entidade.UsuarioServico;
import com.dicaspet.repositorio.RepositorioUsuarioServico;

public class ControladorUsuarioServico {

	private RepositorioUsuarioServico rep;

	public ControladorUsuarioServico(RepositorioUsuarioServico rep) {
		this.rep = rep;
	}

	
	public void cadastrar(UsuarioServico novo) {
	
		rep.inserir(novo);
	}
	

	

	public void atualizar(UsuarioServico atual) {

		rep.atualizar(atual);
	}

//	public void remover(UsuarioServico deletado) {
//		rep.remover(deletado);
//	}

	public List<UsuarioServico> listarPorServico(Servico u) {
		return rep.listarPorServico(u);
	}
	
	
	public List<UsuarioServico> listarPorUsuario(Usuario u){
	
		return rep.listarPorUsuario(u);
	}

	public List<UsuarioServico> buscaNome(String nome) {
		return rep.buscarNome(nome);
	}

}
