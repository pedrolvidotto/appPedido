package com.ottodiv.appPedido.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottodiv.appPedido.domain.Categoria;
import com.ottodiv.appPedido.repositories.CaregoriaRepository;
import com.ottodiv.appPedido.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CaregoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		 //return obj.orElse(null);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrato! id: " +id+", Tipo: " +Categoria.class.getName()));
	}
	
}
