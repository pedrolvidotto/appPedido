package com.ottodiv.appPedido.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottodiv.appPedido.domain.Categoria;
import com.ottodiv.appPedido.repositories.CaregoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CaregoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
