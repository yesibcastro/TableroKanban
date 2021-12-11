package com.tablero.kanban.tareass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tablero.kanban.tareass.dao.RequestActualizarTarea;
import com.tablero.kanban.tareass.dao.RequestDelete;
import com.tablero.kanban.tareass.dao.RequestTarea;
import com.tablero.kanban.tareass.dao.RequestUsuarioTarea;
import com.tablero.kanban.tareass.dao.ResponseGenerico;
import com.tablero.kanban.tareass.entity.Tarea;
import com.tablero.kanban.tareass.services.TareaService;


@RestController
@RequestMapping("/tarea")
public class TareaController {

	@Autowired
	private TareaService service;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseGenerico> crearTarea(@RequestBody RequestTarea tarea) {

		ResponseGenerico respuesta = service.save(tarea);

		return ResponseEntity.ok(respuesta);
	}

	@RequestMapping(value = "/obtenerTareas", method = RequestMethod.POST)
	public ResponseEntity<List<Tarea>> obtenerTarea() {

		return ResponseEntity.ok(service.findAll());
	}

	@RequestMapping(value = "/obtenerTareasUsuarios", method = RequestMethod.POST)
	public ResponseEntity<List<Tarea>> obtenerTareaUsuario(@RequestBody RequestUsuarioTarea tarea) {

		return ResponseEntity.ok(service.findTarea(tarea.getUsuario()));
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<ResponseGenerico> actualizarTarea(@RequestBody RequestActualizarTarea tarea) {
		ResponseGenerico respuesta;
		int actualiza = service.setTipoTarea(tarea.getTipoTarea(), tarea.getNombreTarea());

		if (actualiza == 1) {
			respuesta = new ResponseGenerico("01", "Registro Actualizado Correctamente");
		} else {

			respuesta = new ResponseGenerico("02", "No se ha podido actualizar el registro");
		}

		return ResponseEntity.ok(respuesta);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<ResponseGenerico> eliminarTarea(@RequestBody RequestDelete tarea) {
		ResponseGenerico respuesta;
		service.deleteById(tarea.getNombreTarea());

		respuesta = new ResponseGenerico("01", "Registro Eliminado Correctamente");

		return ResponseEntity.ok(respuesta);
	}

}
