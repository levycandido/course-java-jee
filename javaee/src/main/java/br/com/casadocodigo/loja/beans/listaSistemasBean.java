package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.SistemaDao;
import br.com.casadocodigo.loja.models.Sistema;

@ManagedBean
@ViewScoped

	public class listaSistemasBean {
	
	  @Inject
      private SistemaDao dao;

	    private List<Sistema> sistemas = new ArrayList<>();

	    public List<Sistema> getSistemas() {
	    	this.sistemas = dao.listar();

	         return sistemas;

	    }

	}