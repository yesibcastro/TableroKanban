package com.tablero.kanban.tareass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tablero.kanban.tareass.entity.Tarea;




public interface TareaRepository extends CrudRepository<Tarea, String> {

	@Query ("select l from Tarea l where l.idUsuario.usuario = :usuario")
	List<Tarea> findTarea(@Param("usuario") String usuario);
	
	@Transactional
	@Modifying
	@Query("update Tarea set tipoTarea = :tipoTarea where nombreTarea = :nombreTarea")
	int setTipoTarea(@Param("tipoTarea") String tipoTarea, @Param("nombreTarea") String nombreTarea);
}
