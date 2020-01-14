package com.ottodiv.appPedido.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottodiv.appPedido.domain.Pedido;
import com.ottodiv.appPedido.repositories.PedidoRepository;
import com.ottodiv.appPedido.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		 //return obj.orElse(null);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrato! id: " +id+", Tipo: " +Pedido.class.getName()));
	}
	
}
