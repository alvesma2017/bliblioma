package com.biblio.biblio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblio.biblio.domain.Cliente;
import com.biblio.biblio.repositories.ClienteRepository;
import com.biblio.biblio.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteServices {
	

	@Autowired
	private ClienteRepository repo;
	

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		
		
	}
		
		
	}

