package com.biblio.biblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.biblio.biblio.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

}
