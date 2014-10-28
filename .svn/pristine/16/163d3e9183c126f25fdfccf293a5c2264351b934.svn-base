package com.dicaspet.repositorio;

import java.util.List;

import com.dicaspet.dao.Dao;
import com.dicaspet.entidade.Servico;
import com.dicaspet.entidade.Usuario;
import com.dicaspet.entidade.UsuarioServico;

public class RepositorioUsuarioServico {

	private Dao dao;
	
	public RepositorioUsuarioServico(){
		if(dao == null){
			dao = Dao.getInstance();
		}
	}
	
	public void inserir(UsuarioServico novo){
		
		dao.salvarObjeto(novo);
	}
	
	public void atualizar(UsuarioServico atual){
		dao.atualizarObjeto(atual);
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioServico> listarPorUsuario(Usuario u){
		return (List<UsuarioServico>) dao.criarQuery("FROM usuario_servico WHERE ptsv_id = '" + u.getUsu_id() + "'");
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioServico> listarPorServico(Servico u){
		return (List<UsuarioServico>) dao.criarQuery("FROM usuario_servico WHERE srv_id = '" + u.getSrv_id() + "'");
	}

	
	@SuppressWarnings("unchecked")
	public List<UsuarioServico> buscarNome(String nome){
		return (List<UsuarioServico>) dao.buscarPorLikeIgnoreCase("nome", nome, UsuarioServico.class);
	}
	
	


}
