package com.biblio.dto;

import java.io.Serializable;

import com.biblio.biblio.domain.Livros;

public class LivroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String  titulo;
	private String  autor;
	private String  editora;
	private String  resenha;
	private Integer nota;
	private Double  preco;

	
	public LivroDTO() {
	}

	public LivroDTO(Livros obj) {
		id = obj.getId();
		titulo = obj.getTitulo();
		autor = obj.getAutor();
		editora = obj.getEditora();
		resenha = obj.getEditora();
		nota = obj.getNota();
		preco = obj.getPreco();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getEditora() {
		return editora;
	}


	public void setEditora(String editora) {
		this.editora = editora;
	}


	public String getResenha() {
		return resenha;
	}


	public void setResenha(String resenha) {
		this.resenha = resenha;
	}


	public Integer getNota() {
		return nota;
	}


	public void setNota(Integer nota) {
		this.nota = nota;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
}


