package br.com.casadocodigo.loja.beans;

import java.io.IOException;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.primefaces.event.RowEditEvent;

import br.com.casadocodigo.loja.daos.MotivoDao;
import br.com.casadocodigo.loja.models.Empresa;
import br.com.casadocodigo.loja.models.Motivo;

@ManagedBean
@ViewScoped
	public class MotivoBean {
	
	  @Inject
      private MotivoDao dao;
	  
	  @Inject
		private FacesContext context;

		private Motivo motivo = new Motivo();
		
		private String teste;
		

		
		public String getTeste() {
			return teste;
		}

		public void setTeste(String teste) {
			this.teste = teste;
		}

		public Motivo getMotivo() {
			return motivo;
		}

		public void setMotivo(Motivo motivo) {
			this.motivo = motivo;
		}


		@Transactional
		public String salvar() throws IOException {
			System.out.println("chamou o salvar do Motivo. " + teste);

			dao.salvar(motivo);
			// código novo aqui
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));

			//return "/livros/lista?faces-redirect=true";
			return "/index?faces-redirect=true";
		}
		
		 public void onRowEdit(RowEditEvent event) {
			 System.out.println("entrou no edit");
		        FacesMessage msg = new FacesMessage("Car Edited");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		    }

	}