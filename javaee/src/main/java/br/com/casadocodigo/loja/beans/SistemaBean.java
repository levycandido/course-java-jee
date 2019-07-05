package br.com.casadocodigo.loja.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.SistemaDao;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Livro;
import br.com.casadocodigo.loja.models.Sistema;

@Model
	public class SistemaBean {
	
	  @Inject
      private SistemaDao dao;
	  
	  @Inject
		private FacesContext context;

		private Sistema sistema = new Sistema();



	    public Sistema getSistema() {
			return sistema;
		}



		public void setSistema(Sistema sistema) {
			this.sistema = sistema;
		}



		@Transactional
		public String salvar() throws IOException {
			System.out.println("chamou o salvar do Sistema.");

			dao.salvar(sistema);
			// código novo aqui
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));

			//return "/livros/lista?faces-redirect=true";
			return "/index?faces-redirect=true";
		}

	}