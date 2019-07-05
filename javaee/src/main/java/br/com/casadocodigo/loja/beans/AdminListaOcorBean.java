package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import br.com.casadocodigo.loja.daos.MotivoDao;
import br.com.casadocodigo.loja.models.Motivo;

@ManagedBean
@ViewScoped
	public class AdminListaOcorBean {
	
	  @Inject
      private MotivoDao dao;

	    private List<Motivo> motivos = new ArrayList<>();

		public List<Motivo> getMotivos() {
			
			motivos = dao.listar();
			return motivos;
		}

		public void setMotivos(List<Motivo> motivos) {
			this.motivos = motivos;
		}
	    
		 public void onRowEdit(RowEditEvent event) {
			 System.out.println("entrou no edit");
		        FacesMessage msg = new FacesMessage("Motivo atualizado com sucesso.");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		    }

	  
	}
