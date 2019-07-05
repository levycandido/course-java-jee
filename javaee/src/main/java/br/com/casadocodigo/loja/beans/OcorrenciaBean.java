package br.com.casadocodigo.loja.beans;

import java.io.IOException;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.primefaces.event.RowEditEvent;

import br.com.casadocodigo.loja.daos.OcorrenciaDao;
import br.com.casadocodigo.loja.models.Ocorrencia;

@Model
@ViewScoped
	public class OcorrenciaBean {
	
	  @Inject
      private OcorrenciaDao dao;
	  
	  @Inject
		private FacesContext context;

		private Ocorrencia ocorrencia = new Ocorrencia();

		public Ocorrencia getOcorrencia() {
			return ocorrencia;
		}



		public void setOcorrencia(Ocorrencia ocorrencia) {
			this.ocorrencia = ocorrencia;
		}



		@Transactional
		public void salvar() throws IOException {
			System.out.println("chamou o salvar do Ocorrencia.");

			dao.salvar(ocorrencia);
			// código novo aqui
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));

			//return "/livros/lista?faces-redirect=true";
			//return "/index?faces-redirect=true";
		}
		
		 public void onRowEdit(RowEditEvent event) {
			 System.out.println("entrou no edit");
		        FacesMessage msg = new FacesMessage("Car Edited");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		    }

	}