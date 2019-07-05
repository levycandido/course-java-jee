package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.MotivoDao;
import br.com.casadocodigo.loja.models.Motivo;

@Model
	public class adminListaLivrosBean {
	
	  @Inject
      private MotivoDao dao;

	    private List<Motivo> motivos = new ArrayList<>();

	    public List<Motivo> getMotivo() {
	    	this.motivos = dao.listar();
	    	
	         return motivos;

	    }

	}
