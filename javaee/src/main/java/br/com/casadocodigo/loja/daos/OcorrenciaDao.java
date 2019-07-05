package br.com.casadocodigo.loja.daos;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.jpa.QueryHints;

import br.com.casadocodigo.loja.filtros.FiltroOcorrencias;
import br.com.casadocodigo.loja.models.Livro;
import br.com.casadocodigo.loja.models.Ocorrencia;

@Stateful
public class OcorrenciaDao {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;

	@Transactional
	public void salvar(Ocorrencia ocorrencia) {
		manager.persist(ocorrencia);
	}

	public List<Ocorrencia> listar() {
		String jpql = "select distinct(o) from Ocorrencia o"
				  + " join fetch l.sitema";  
		;

		return manager.createQuery(jpql, Ocorrencia.class).getResultList();
	}

	public Ocorrencia buscarPorId(Integer id) {

		return manager.find(Ocorrencia.class, id);

	}

	@SuppressWarnings("unchecked")
	public List<Ocorrencia> buscarPorDatas(FiltroOcorrencias filtroOcorrencias) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select distinct(o) from Ocorrencia o "
		  + " join fetch o.sistema ");  

		if (filtroOcorrencias.getDataInicio() != null && filtroOcorrencias.getDataFim() != null) {
			jpql.append("where o.dataInicio >= :dataInicio AND o.dataFim <= :dataFim ");

		}
		jpql.append(" order by o.dataInicio ");

		Query consulta = manager.createQuery(jpql.toString());
		
		if (filtroOcorrencias.getDataInicio() != null && filtroOcorrencias.getDataFim() != null) {
			consulta.setParameter("dataInicio", filtroOcorrencias.getDataInicio());
			consulta.setParameter("dataFim", filtroOcorrencias.getDataFim());
		}
		return consulta.getResultList();
	}
}