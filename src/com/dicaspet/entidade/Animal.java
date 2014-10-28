package com.dicaspet.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "animal")
public class Animal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long ani_id;

	@Column(name = "nome", length = 200, nullable = true)
	private String ani_nome;
	
	@Column(name = "foto", length = 200, nullable = true)
	private String ani_foto;
	
	@Column(name = "status", length = 200, nullable = true)
	private String ani_status;

	@Column(name = "raca", length = 50, nullable = false)
	private String ani_raca;

	@Column(name = "especie", length = 50, nullable = false)
	private String ani_especie;

	@Column(name = "idade", nullable = true)
	private double ani_idade;
	
	@Column(name = "peso", nullable = true)
	private double ani_peso;
	
	@Column(name = "porte", length = 50, nullable = false)
	private String ani_porte;
	
	@Column(name = "sexo", length = 50, nullable = true)
	private String ani_sexo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nasc", nullable = true)
	private Date ani_dt_nasc;
	
	@Column(name="nivel_exercicio", nullable=true)
	private String ani_nivel_exercicio;
	
	@Column(name="tamanho_pelo",nullable=true)
	private String ani_tamanho_pelo;
	
	@Column(name="status_animal",nullable=true)
	private String ani_status_animal;
	
	@Column(name="qtd_inic_alimento", nullable=true)
	private double ani_qtdInicAlimento;
	
	@Column(name="qtd_fim_alimento", nullable=true)
	private double ani_qtdFimAlimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.MERGE)
	@JoinColumn(name = "id_usuario")
	private Usuario ani_id_usu;

	public Long getAni_id() {
		return ani_id;
	}
	
	public String getAni_id_string() {
		return Long.toString(ani_id);
	}

	public void setAni_id(Long ani_id) {
		this.ani_id = ani_id;
	}

	public String getAni_nome() {
		return ani_nome;
	}

	public void setAni_nome(String ani_nome) {
		this.ani_nome = ani_nome;
	}

	public String getAni_status() {
		return ani_status;
	}

	public void setAni_status(String ani_status) {
		this.ani_status = ani_status;
	}

	public String getAni_raca() {
		return ani_raca;
	}

	public void setAni_raca(String ani_raca) {
		this.ani_raca = ani_raca;
	}

	public String getAni_especie() {
		return ani_especie;
	}

	public void setAni_especie(String ani_especie) {
		this.ani_especie = ani_especie;
	}

	public double getAni_idade() {
		return ani_idade;
	}

	public void setAni_idade(double ani_idade) {
		this.ani_idade = ani_idade;
	}

	public double getAni_peso() {
		return ani_peso;
	}

	public void setAni_peso(double ani_peso) {
		this.ani_peso = ani_peso;
	}

	public String getAni_porte() {
		return ani_porte;
	}

	public void setAni_porte(String ani_porte) {
		this.ani_porte = ani_porte;
	}

	public String getAni_sexo() {
		return ani_sexo;
	}

	public void setAni_sexo(String ani_sexo) {
		this.ani_sexo = ani_sexo;
	}

	public Date getAni_dt_nasc() {
		return ani_dt_nasc;
	}

	public void setAni_dt_nasc(Date ani_dt_nasc) {
		this.ani_dt_nasc = ani_dt_nasc;
	}

	public String getAni_nivel_exercicio() {
		return ani_nivel_exercicio;
	}

	public void setAni_nivel_exercicio(String ani_nivel_exercicio) {
		this.ani_nivel_exercicio = ani_nivel_exercicio;
	}

	public String getAni_tamanho_pelo() {
		return ani_tamanho_pelo;
	}

	public void setAni_tamanho_pelo(String ani_tamanho_pelo) {
		this.ani_tamanho_pelo = ani_tamanho_pelo;
	}


	public double getAni_qtdInicAlimento() {
		return ani_qtdInicAlimento;
	}

	public void setAni_qtdInicAlimento(double ani_qtdInicAlimento) {
		this.ani_qtdInicAlimento = ani_qtdInicAlimento;
	}

	public double getAni_qtdFimAlimento() {
		return ani_qtdFimAlimento;
	}

	public void setAni_qtdFimAlimento(double ani_qtdFimAlimento) {
		this.ani_qtdFimAlimento = ani_qtdFimAlimento;
	}

	public Usuario getAni_id_usu() {
		return ani_id_usu;
	}

	public void setAni_id_usu(Usuario ani_id_usu) {
		this.ani_id_usu = ani_id_usu;
	}

	public void setAni_id(long ani_id) {
		this.ani_id = ani_id;
	}

	public String isAni_status_animal() {
		return ani_status_animal;
	}

	public void setAni_status_animal(String ani_status_animal) {
		this.ani_status_animal = ani_status_animal;
	}

	public String getAni_foto() {
		System.out.println("/home/nito/fotos/"+ani_foto+"   -------------------------------------------------------------------------");
		return ani_foto;
	}

	public void setAni_foto(String ani_foto) {
		this.ani_foto = ani_foto;
	}

	public String getAni_status_animal() {
		return ani_status_animal;
	}
	





}
