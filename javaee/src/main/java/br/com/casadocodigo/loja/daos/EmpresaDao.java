package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import org.hibernate.jpa.QueryHints;

import br.com.casadocodigo.loja.models.Empresa;

@Stateful
public class EmpresaDao {

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager manager;
    	
    @Transactional
	public void salvar(Empresa empresa){
		    manager.persist(empresa);
		}

    public List<Empresa> listar() {
    	 String jpql = "select distinct(e) from Empresa e";
  
    	 return manager.createQuery(jpql, Empresa.class).getResultList();
    }

    public Empresa buscarPorId(Integer id) {
    	
    	return manager.find(Empresa.class, id);
    }
}