package com.sena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.modelo.Publicacion;


public interface InicioRepository extends JpaRepository<Publicacion, Integer> {

	List<Publicacion> findByTipoLugar(String TipoLugar);




}
