package com.dicaspet.repositorio;

import java.util.Date;
import java.util.List;

import com.dicaspet.dao.Dao;
import com.dicaspet.entidade.Animal;
import com.dicaspet.entidade.Servico;
import com.dicaspet.entidade.Usuario;
import com.dicaspet.util.Constants;

public class RepositorioUsuario {

	private Dao dao;
	
	public RepositorioUsuario(){
		if(dao == null){
			dao = Dao.getInstance();
		}
	}
	
	public void inserir(Usuario novo){
		
		dao.salvarObjeto(novo);
	}
	
	public void atualizar(Usuario atual){
		dao.atualizarObjeto(atual);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar(){
		return (List<Usuario>) dao.criarQuery("FROM usuario WHERE status <> '" + Constants.INATIVO + "'");
	}
	
	@SuppressWarnings("unchecked")
	public List<Animal> meusPets(Usuario u){
		return (List<Animal>) dao.criarQuery("FROM animal WHERE id_usuario = "+u.getUsu_id()+" and status = 'A'");
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarPorPontuacao(){
		return (List<Usuario>) dao.criarQuery("FROM usuario order by pontuacao desc");
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarNome(String nome){
		return (List<Usuario>) dao.buscarPorLikeIgnoreCase("nome", nome, Usuario.class);
	}
	
	
	public void remover(Usuario del){
		del.setUsu_status(Constants.INATIVO);
		dao.atualizarObjeto(del);
	}
	
	
	public boolean existeLogin(String email){
		Usuario retorno = (Usuario) dao.buscarPorChaveUnicaString(Usuario.class, email, "email");
		if(retorno != null&&!retorno.getUsu_email().equals("")){
			return true;
		}
		else{
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarData(Date inicio, Date fim){
		return (List<Usuario>) dao.buscarData("data_cadastro", inicio, fim, Usuario.class);
	}
	
	public Usuario buscarUsuario(Long id){
		Usuario usuario = (Usuario) dao.buscarPorId(Usuario.class, id);
		return usuario;
	}
	
	public Usuario logar(String email, String senha){
		@SuppressWarnings("unchecked")
		List<Usuario> lista = (List<Usuario>)dao.criarQuery("FROM usuario where email LIKE '"+ email +"' AND senha LIKE '"+ senha +"'  AND status <> '" + Constants.INATIVO + "'");
		if(!lista.isEmpty()){
			return lista.get(0);
		}
		else{
			return null;
		} 
	}

	@SuppressWarnings("unchecked")
	public List<Servico> meusServicos(Usuario u) {
		// TODO Auto-generated method stub
		System.out.println(u.getUsu_nome()+"--------------+++++++++++++++++++++");
		return (List<Servico>) dao.criarQuery("FROM servico WHERE id_prt_srv = "+u.getUsu_id()+" and status <> 'I'");
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarPrestador() {
		// TODO Auto-generated method stub
	return (List<Usuario>) dao.criarQuery("FROM usuario WHERE status <> '" + Constants.INATIVO + "' and nivel_acesso = 'prestador'");
	}

}
