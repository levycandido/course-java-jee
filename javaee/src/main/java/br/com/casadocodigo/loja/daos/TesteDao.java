package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.models.Teste;

@Stateful
public class TesteDao {

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager manager;
    

    @Transactional
	public void salvar(Teste teste){
		    manager.persist(teste);
		}

    public List<Teste> listar() {
    	 String jpql = "select distinct(s) from Teste s";
  
    	 return manager.createQuery(jpql, Teste.class).getResultList();
    }

   
    public Teste buscarPorId(Integer id) {
    	
    	return manager.find(Teste.class, id);
    	

    }
}