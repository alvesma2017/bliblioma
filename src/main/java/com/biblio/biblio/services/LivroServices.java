package com.biblio.biblio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.biblio.biblio.domain.Categoria;
import com.biblio.biblio.domain.Livros;
import com.biblio.biblio.repositories.CategoriaRepository;
import com.biblio.biblio.repositories.LivroRepository;
import com.biblio.biblio.services.exceptions.ObjectNotFoundException;


@Service
public class LivroServices {
	

	@Autowired
	private LivroRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Livros find(Integer id) {
		Optional<Livros> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livros.class.getName()));
		
		
	}
	public Page<Livros> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);	
	}
	
	}

