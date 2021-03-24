package com.biblio.biblio.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.biblio.biblio.domain.Categoria;
import com.biblio.biblio.domain.Livros;

@Repository
public interface LivroRepository extends JpaRepository <Livros, Integer> {
	
	//@Transactional(readOnly=true)
	//@Query("SELECT DISTINCT obj FROM Livros obj INNER JOIN obj.categorias cat WHERE obj.titulo LIKE %:nome% AND cat IN :categorias")
	Page<Livros> findDistinctByTituloContainingAndCategoriasIn(String titulo, List<Categoria> categorias, Pageable pageRequest);
	
	//@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest

}
