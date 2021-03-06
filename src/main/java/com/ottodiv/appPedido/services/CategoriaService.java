package com.ottodiv.appPedido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ottodiv.appPedido.domain.Categoria;
import com.ottodiv.appPedido.repositories.CaregoriaRepository;
import com.ottodiv.appPedido.services.exceptions.DateIntegrityException;
import com.ottodiv.appPedido.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CaregoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		 //return obj.orElse(null);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrato! id: " +id+", Tipo: " +Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);	
		}catch (DataIntegrityViolationException e) {
			throw new DateIntegrityException("Não é possível excluir uma categoria que possui produtos.");
		}
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
}
