package com.ottodiv.appPedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ottodiv.appPedido.domain.Categoria;

@Repository
public interface CaregoriaRepository extends JpaRepository<Categoria, Integer>{

}
