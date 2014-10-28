package com.dicaspet.fachada;

import java.io.Serializable;

import com.dicaspet.controlador.ControladorAnimal;
import com.dicaspet.controlador.ControladorMensagem;
import com.dicaspet.controlador.ControladorServico;
import com.dicaspet.controlador.ControladorUsuario;
import com.dicaspet.controlador.ControladorUsuarioServico;
import com.dicaspet.repositorio.RepositorioAnimal;
import com.dicaspet.repositorio.RepositorioMensagem;
import com.dicaspet.repositorio.RepositorioServico;
import com.dicaspet.repositorio.RepositorioUsuario;
import com.dicaspet.repositorio.RepositorioUsuarioServico;


public class Fachada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Fachada instancia;	
	private ControladorUsuario controlUsuario;
    private ControladorAnimal controlAnimal;
    private ControladorMensagem controlMensagem;
    private ControladorServico controlServico;
    private ControladorUsuarioServico controlUsuarioServico;
   
	
	private Fachada(){
		inicializar();
	}
	
	private void inicializar(){
		
		RepositorioUsuario repUsuario = new RepositorioUsuario();
		controlUsuario = new ControladorUsuario(repUsuario);
		
		RepositorioAnimal repAnimal= new RepositorioAnimal();
		controlAnimal = new ControladorAnimal(repAnimal);
		
		RepositorioMensagem repMensagem = new RepositorioMensagem();
		controlMensagem = new ControladorMensagem(repMensagem);
		
		RepositorioServico repServico = new RepositorioServico();
		controlServico = new ControladorServico(repServico);
		
		RepositorioUsuarioServico repUsuarioServico = new RepositorioUsuarioServico();
		controlUsuarioServico = new ControladorUsuarioServico(repUsuarioServico);

	}
	
	public static Fachada getInstance(){
		
		if(instancia == null){
			instancia = new Fachada();
		}
		return instancia;
	}
	
	
	public ControladorUsuario controladorUsuario(){
		return controlUsuario;
	}
	
	public ControladorAnimal controladorAnimal(){
		return controlAnimal;
		
	}
	
	public ControladorMensagem controladorMensagem(){
		return controlMensagem;
		
	}
	
	public ControladorServico controladorServico(){
		return controlServico;
		
	}
	
	public ControladorUsuarioServico controladorUsuarioServico(){
		return controlUsuarioServico;
	}
		
}