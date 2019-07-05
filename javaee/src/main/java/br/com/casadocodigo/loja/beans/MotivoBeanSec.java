package br.com.casadocodigo.loja.beans;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.inject.Stereotype;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.hibernate.annotations.Target;
import org.primefaces.event.RowEditEvent;

import br.com.casadocodigo.loja.daos.OcorrenciaDao;
import br.com.casadocodigo.loja.filtros.FiltroOcorrencias;
import br.com.casadocodigo.loja.models.Ocorrencia;


@ManagedBean
@ViewScoped

public class MotivoBeanSec {
	
	  @Inject
      private OcorrenciaDao dao;
	  
	  @Inject
		private FacesContext context;
	  
       
		private List<Ocorrencia> ocorrencias = new ArrayList<>();
		
		private FiltroOcorrencias filtro = new FiltroOcorrencias();
		
		public FiltroOcorrencias getFiltro() {
			return filtro;
		}

		public void setFsiltro(FiltroOcorrencias filtro) {
			this.filtro = filtro;
		}

		@Transactional
		public List<Ocorrencia> getOcorrencias() {
			
			//this.ocorrencias = dao.listar();
			this.ocorrencias = dao.buscarPorDatas(filtro);
			
			return ocorrencias;
		}

		public void setOcorrencias(List<Ocorrencia> ocorrencias) {
			this.ocorrencias = ocorrencias;
		}

		@Transactional
		public List<Ocorrencia> salvar() throws IOException {
			System.out.println("chamou o salvar do Sistema. " );

			this.ocorrencias = dao.buscarPorDatas(filtro);
	       
			return ocorrencias;

			
		}
		
		 public void onRowEdit(RowEditEvent event) {
			 System.out.println("entrou no edit");
		        FacesMessage msg = new FacesMessage("Ocorrencia atualizada com sucesso!");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		    }


	}