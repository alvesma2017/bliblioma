package com.biblio.biblio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.biblio.biblio.domain.ItemPedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository <ItemPedido, Integer> {

}
