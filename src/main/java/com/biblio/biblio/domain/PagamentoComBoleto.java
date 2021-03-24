package com.biblio.biblio.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.biblio.biblio.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("pagamentoComBoleto")
public class PagamentoComBoleto extends Pagamento {
	
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date vencimento;
	@JsonFormat(pattern="dd/MM/yyyy")
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
