package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.TesteDao;
import br.com.casadocodigo.loja.models.Teste;

@ManagedBean
@ViewScoped
	public class ListaTestesBean {
	
	  @Inject
      private TesteDao dao;

	    private List<Teste> testes = new ArrayList<>();

	    public List<Teste> getTestes() {
	    	this.testes = dao.listar();

	         return testes;

	    }

	}