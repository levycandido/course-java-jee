package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.OcorrenciaDao;
import br.com.casadocodigo.loja.filtros.FiltroOcorrencias;
import br.com.casadocodigo.loja.models.Ocorrencia;

@Model
	public class ListaOcorrenciasBean {
	
	  @Inject
      private OcorrenciaDao dao;
	  
	  @Inject
			private FacesContext context;

	private List<Ocorrencia> ocorrencias = new ArrayList<>();
	private  FiltroOcorrencias  filtroOcorrencias ;
	
	private String teste;
	

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	public List<Ocorrencia> getOcorrencias() {
		
		if (filtroOcorrencias == null ) {
			filtroOcorrencias = new FiltroOcorrencias();
		}
	    	//this.ocorrencias = dao.listar();
		this.ocorrencias = dao.buscarPorDatas(filtroOcorrencias);
	         return ocorrencias;

	    }

	    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}


		public List<Ocorrencia> Filtrar() {
	    	
			   System.out.println("entrou no filtro - antes");
			   
	  //  	  this.ocorrencias = dao.buscarPorDatas(filtroOcorrencias);
	    	 
			   System.out.println("entrou no filtro - depois");
	    	 return ocorrencias;
	    	

	    }

		public FiltroOcorrencias getFiltroOcorrencias() {
			return filtroOcorrencias;
		}

		public void setFiltroOcorrencias(FiltroOcorrencias filtroOcorrencias) {
			this.filtroOcorrencias = filtroOcorrencias;
		}
	   
		
	   
	}