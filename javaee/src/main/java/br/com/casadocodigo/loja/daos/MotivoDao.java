package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.models.Motivo;

@Stateful
public class MotivoDao {

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager manager;
    

    @Transactional
	public void salvar(Motivo motivo){
		    manager.persist(motivo);
		}

    public List<Motivo> listar() {
    	 String jpql = "select distinct(s) from Motivo s";
  
    	 return manager.createQuery(jpql, Motivo.class).getResultList();
    }

   
    public Motivo buscarPorId(Integer id) {
    	
    	return manager.find(Motivo.class, id);
    	

    }
}