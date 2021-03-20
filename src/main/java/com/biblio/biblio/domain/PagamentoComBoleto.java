package com.biblio.biblio.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.biblio.biblio.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	
	private static final long serialVersionUID = 1L;

	private Date vencimento;
	private Date datapagamento;
	


	public PagamentoComBoleto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date vencimento, Date datapagamento) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		
	this.datapagamento = datapagamento;
	this.vencimento = vencimento;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Date getDatapagamento() {
		return datapagamento;
	}

	public void setDatapagamento(Date datapagamento) {
		this.datapagamento = datapagamento;
	}
	
	
}
