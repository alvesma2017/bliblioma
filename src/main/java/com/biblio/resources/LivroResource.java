package com.biblio.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblio.biblio.domain.Livros;
import com.biblio.biblio.services.LivroServices;

import com.biblio.dto.LivroDTO;
import com.biblio.resources.utils.URL;


@RestController
@RequestMapping(value="/livros")
public class LivroResource {
	 
	@Autowired
	private LivroServices service;
	
		@RequestMapping (value= "/{id}", method=RequestMethod.GET)
		public ResponseEntity<Livros> find(@PathVariable Integer id) {
			Livros obj = service.find(id);
			return ResponseEntity.ok().body(obj);
		
		 } 
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<Page<LivroDTO>> findPage(
				@RequestParam(value="titulo", defaultValue="") String titulo, 
				@RequestParam(value="categorias", defaultValue="") String categorias, 
				@RequestParam(value="page", defaultValue="0") Integer page, 
				@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
				@RequestParam(value="orderBy", defaultValue="titulo") String orderBy, 
				@RequestParam(value="direction", defaultValue="ASC") String direction) {
			String nomeDecoded = URL.decodeParam(titulo);
			List<Integer> ids = URL.decodeIntList(categorias);
			Page<Livros> list = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
			Page<LivroDTO> listDto = list.map(obj -> new LivroDTO(obj));  
			return ResponseEntity.ok().body(listDto);
		}
}