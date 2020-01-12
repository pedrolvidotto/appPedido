package com.ottodiv.appPedido.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottodiv.appPedido.domain.Cliente;
import com.ottodiv.appPedido.repositories.ClienteRepository;
import com.ottodiv.appPedido.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		 //return obj.orElse(null);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrato! id: " +id+", Tipo: " +Cliente.class.getName()));
	}
	
}
