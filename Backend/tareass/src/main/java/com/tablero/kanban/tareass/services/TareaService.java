package com.tablero.kanban.tareass.services;


import java.util.List;
import java.util.Optional;

import com.tablero.kanban.tareass.dao.RequestTarea;
import com.tablero.kanban.tareass.dao.ResponseGenerico;
import com.tablero.kanban.tareass.entity.Tarea;



public interface TareaService {

	
	public ResponseGenerico save(RequestTarea tarea);
	
	public List<Tarea> findAll();

	public List<Tarea> findTarea(String usuario);
	
	public Optional<Tarea> findById(String nombreTarea);
	
	public int setTipoTarea(String tipoTarea, String nombreTarea); 
	
	public void deleteById(String id);
}
