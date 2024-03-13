package com.sena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.modelo.Publicacion;

public interface InicioRepository extends JpaRepository<Publicacion, Integer> {

	List<Publicacion> findByTipoLugar(String tipoLugar);

	@Query("SELECT COUNT p FROM publicacion WHERE tipo_lugar = 'CASAS'")

	public List<Publicacion> findAll(String contador);

}
