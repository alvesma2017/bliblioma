package com.biblio.biblio.domain;

import javax.persistence.Entity;

import com.biblio.biblio.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numeroparcelas;

	public PagamentoComCartao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroparcelas) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		
		this.numeroparcelas = numeroparcelas;
	}

	public Integer getNumeroparcelas() {
		return numeroparcelas;
	}

	public void setNumeroparcelas(Integer numeroparcelas) {
		this.numeroparcelas = numeroparcelas;
	}
	
	

}
