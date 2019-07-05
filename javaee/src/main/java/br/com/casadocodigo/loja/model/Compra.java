package br.com.casadocodigo.loja.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import br.com.casadocodigo.loja.models.Usuario;

@Entity
public class Compra {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Usuario usuario;
	
	private String uuid;
    
	private BigDecimal total;
	
	
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@PrePersist
	public void createUUID() {
	    this.uuid = UUID.randomUUID().toString();
	}
	
    public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	private String itens;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        this.itens = itens;
    }
}