package br.com.casadocodigo.loja.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.EmpresaDao;
import br.com.casadocodigo.loja.models.Empresa;

@Model
	public class EmpresaBean {
	
	  @Inject
      private EmpresaDao dao;
	  
	  @Inject
		private FacesContext context;

		private Empresa empresa = new Empresa();


	       
	    public Empresa getEmpresa() {
			return empresa;
		}

	    public void setSistema(Empresa empresa) {
			this.empresa = empresa;
		}


		@Transactional
		public String salvar() throws IOException {
			System.out.println("chamou o salvar do Sistema.");

			dao.salvar(empresa);
			// código novo aqui
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));

			//return "/livros/lista?faces-redirect=true";
			return "/index?faces-redirect=true";
		}

	}