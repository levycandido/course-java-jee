package br.com.casadocodigo.loja.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import br.com.casadocodigo.loja.beans.PagamentoGateway;
import br.com.casadocodigo.loja.daos.CompraDao;
import br.com.casadocodigo.loja.models.Usuario;

@SessionScoped
@Named
public class CarrinhoCompras implements Serializable {

	@Inject
	private CompraDao compraDao;

	private static final long serialVersionUID = 513384120723633752L;
	private Set<CarrinhoItem> itens = new HashSet<>();
	
	

	public Set<CarrinhoItem> getItens() {
		return itens;
	}

	public void setItens(Set<CarrinhoItem> itens) {
		this.itens = itens;
	}

	public void add(CarrinhoItem item) {
		itens.add(item);
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (CarrinhoItem carrinhoItem : itens) {
			total = total
					.add(carrinhoItem.getLivro().getPreco().multiply(new BigDecimal(carrinhoItem.getQuantidade())));
		}
		return total;
	}

	public BigDecimal getTotal(CarrinhoItem item) {
		return item.getLivro().getPreco().multiply(new BigDecimal(item.getQuantidade()));
	}

	public void remover(CarrinhoItem item) {
		this.itens.remove(item);
	}

	public Integer getQuantidadeTotal() {
		return itens.stream().mapToInt(item -> item.getQuantidade()).sum();
	}

	public void finalizar(Compra compra) {
		
		
	    compra.setItens(toJson());
	    compra.setTotal(getTotal());
	    compraDao.salvar(compra);
	    
	    
	    
	}



	public String pagar() {
		Pagamento pagamento = new Pagamento(getTotal());
	    String target = "http://book-payment.herokuapp.com/payment";
	    Client client = ClientBuilder.newClient();
	    return client.target(target).request().post(Entity.json(pagamento), String.class);
		
	}


	public String toJson() {
		JsonArrayBuilder builder = Json.createArrayBuilder();
		for (CarrinhoItem item : itens) {
			builder.add(Json.createObjectBuilder().add("titulo", item.getLivro().getTitulo())
					.add("preco", item.getLivro().getPreco()).add("quantidade", item.getQuantidade())
					.add("total", getTotal(item)));
		}

		String json = builder.build().toString();
		System.out.println(json);

		return json;
	}

}