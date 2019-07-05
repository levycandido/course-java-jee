package br.com.casadocodigo.loja.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

@Model
public class livroDetalheBean {

    @Inject
    private LivroDao dao;
    
    public LivroDao getDao() {
		return dao;
	}

	public void setDao(LivroDao dao) {
		this.dao = dao;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private Livro livro;
    private Integer id;

    public void carregarDetalhe() {
    	 this.livro = dao.buscarPorId(id);
    	 System.out.println("#{livroDetalheBean.carregarDetalhe()}");
    }

}