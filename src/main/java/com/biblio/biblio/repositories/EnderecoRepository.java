package com.biblio.biblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.biblio.biblio.domain.Endereco;




@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Integer> {

}
