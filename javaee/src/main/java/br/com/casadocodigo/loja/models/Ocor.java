

	package br.com.casadocodigo.loja.models;

	import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

	@Entity
	public class Ocor {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;

		@ManyToOne
		//(cascade=CascadeType.ALL,fetch =  FetchType.LAZY)
		private Teste teste = new Teste();
		
		public Teste getTeste() {
			return teste;
		}

		public void setTeste(Teste teste) {
			this.teste = teste;
		}

		private String descricao;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
	}
	









