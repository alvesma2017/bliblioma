package com.biblio.biblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.biblio.biblio.domain.Livros;

@Repository
public interface LivroRepository extends JpaRepository <Livros, Integer> {

}
