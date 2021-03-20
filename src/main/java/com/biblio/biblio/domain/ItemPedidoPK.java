package com.biblio.biblio.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="livro_id")
	private Livros livro;
	
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Livros getLivro() {
		return livro;
	}
	public void setLivro(Livros livro) {
		this.livro = livro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoPK other = (ItemPedidoPK) obj;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		return true;
	}
	
	
}
