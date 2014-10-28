package com.dicaspet.controlador;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dicaspet.entidade.Animal;
import com.dicaspet.entidade.Servico;
import com.dicaspet.entidade.Usuario;
import com.dicaspet.repositorio.RepositorioUsuario;
import com.dicaspet.util.Constants;

public class ControladorUsuario {

	private RepositorioUsuario rep;

	public ControladorUsuario(RepositorioUsuario rep) {
		this.rep = rep;
	}

	public void reporAlimento(){
		
		
		
	}
	public void cadastrar(Usuario novo) {
		MessageDigest md;
		String senha = novo.getUsu_senha();
		String retornaSenha = null;

		try {
			md = MessageDigest.getInstance("SHA");
			md.update(senha.getBytes());
			BigInteger hash = new BigInteger(1, md.digest());
			retornaSenha = hash.toString(16);
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();

		}
		novo.setUsu_status(Constants.ATIVO);
	
		novo.setData_cadastro(new Date());
		novo.setUsu_senha(retornaSenha);
		rep.inserir(novo);
	}
	
	public Usuario logar(String email, String senha){
		
		MessageDigest md;
		String senhan = senha;
		String retornaSenha = null;

		try {
			md = MessageDigest.getInstance("SHA");
			md.update(senhan.getBytes());
			BigInteger hash = new BigInteger(1, md.digest());
			retornaSenha = hash.toString(16);
		
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		Usuario usuario = rep.logar(email, retornaSenha);
		return usuario;
		}
	

	public void atualizar(Usuario atual) {

		MessageDigest md;
		String senha = atual.getUsu_senha();
		String retornaSenha = null;

		try {
			md = MessageDigest.getInstance("SHA");
			md.update(senha.getBytes());
			BigInteger hash = new BigInteger(1, md.digest());
			retornaSenha = hash.toString(16);
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();

		}
		atual.setUsu_status(Constants.ATIVO);
	
		atual.setUsu_senha(retornaSenha);
		rep.atualizar(atual);
	}

	public void remover(Usuario deletado) {
		rep.remover(deletado);
	}

	public List<Usuario> listar() {
		return rep.listar();
	}
	
	public List<Usuario> listarPorPontuacaoResumida(){
		List<Usuario> usuarios=new ArrayList<Usuario>();
		List<Usuario> usus = rep.listarPorPontuacao();
		
		if(!usus.isEmpty()){
			for (int i = 0; i <3; i++) {
				usuarios.add(usus.get(i));
			}
		}
		return usuarios;
	}
	
	public List<Usuario> listarPorPontuacao(){
	
		return rep.listarPorPontuacao();
	}
	
	public List<Usuario> listarPrestador(){
		
		return rep.listarPrestador();
	}

	public List<Usuario> buscaNome(String nome) {
		return rep.buscarNome(nome);
	}

	public boolean existeLogin(String login) {
		return rep.existeLogin(login);
	}

	public List<Usuario> buscarData(Date inicio, Date fim) {
		return rep.buscarData(inicio, fim);
	}

	public Usuario buscarUsuario(Long id) {
		return rep.buscarUsuario(id);
		
	}
	
	public List<Animal> buscarAnimais(Usuario u){
		
		return rep.meusPets(u);
	}
	
	public List<Servico> meusServicos(Usuario u){
		
		return rep.meusServicos(u);
	}

}
