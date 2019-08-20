package com.ottodiv.appPedido;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ottodiv.appPedido.domain.Categoria;
import com.ottodiv.appPedido.repositories.CaregoriaRepository;
import com.ottodiv.appPedido.resources.CategoriaResource;

@SpringBootApplication
public class AppPedidoApplication implements CommandLineRunner{

	@Autowired
	private CaregoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AppPedidoApplication.class, args);
	}

	
	@Override
	public void run(String...arg) throws Exception{
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2) );
	}
}
