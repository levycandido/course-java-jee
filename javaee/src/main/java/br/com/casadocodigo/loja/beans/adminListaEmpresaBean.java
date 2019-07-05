package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.EmpresaDao;
import br.com.casadocodigo.loja.models.Empresa;
import br.com.casadocodigo.loja.models.Livro;

@Model
	public class adminListaEmpresaBean {
	
	  @Inject
      private EmpresaDao dao;

	    private List<Empresa> empresas = new ArrayList<>();

	    public List<Empresa> getEmpresas() {
	    	this.empresas = dao.listar();

	         return empresas;

	    }

	}