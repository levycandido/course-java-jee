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

import br.com.casadocodigo.loja.models.Livro;
import br.com.casadocodigo.loja.models.Sistema;

@Stateful
public class SistemaDao {

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager manager;
    

	
    @Transactional
	public void salvar(Sistema sistema){
		    manager.persist(sistema);
		}

    public List<Sistema> listar() {
    	 String jpql = "select distinct(s) from Sistema s";
  
    	 return manager.createQuery(jpql, Sistema.class).getResultList();
    }

   
    public Sistema buscarPorId(Integer id) {
    	
    	return manager.find(Sistema.class, id);
    	

    }
}