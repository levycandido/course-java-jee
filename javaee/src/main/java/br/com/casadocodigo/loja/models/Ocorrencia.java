package br.com.casadocodigo.loja.models;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
@Cacheable
public class Ocorrencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date dataInicio;
	private Date dataFim;
	private String chamado;
	private char indisponibilidade;
	@ManyToOne
	(fetch =  FetchType.EAGER)
	private Sistema sistema = new Sistema();
	
	private String descricao;
	
	private String atuacao;
	@ManyToOne
	( fetch =  FetchType.EAGER)
	private Motivo motivo = new Motivo();
	

	@Override
	public String toString() {
		return "Ocorrencia [id=" + id + ", chamado=" + chamado	+ ", indisponibilidade=" + indisponibilidade + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}


	public Date getDataFim() {
		return dataFim;
	}


	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}


	public String getChamado() {
		return chamado;
	}


	public void setChamado(String chamado) {
		this.chamado = chamado;
	}


	public char getIndisponibilidade() {
		return indisponibilidade;
	}


	public void setIndisponibilidade(char indisponibilidade) {
		this.indisponibilidade = indisponibilidade;
	}


	public Sistema getSistema() {
		return sistema;
	}


	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getAtuacao() {
		return atuacao;
	}


	public void setAtuacao(String atuacao) {
		this.atuacao = atuacao;
	}


	public Motivo getMotivo() {
		return motivo;
	}


	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}
	
	
 }