package com.tablero.kanban.tareass.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tablero.kanban.tareass.dao.RequestTarea;
import com.tablero.kanban.tareass.dao.ResponseGenerico;
import com.tablero.kanban.tareass.entity.Tarea;
import com.tablero.kanban.tareass.entity.Usuario;
import com.tablero.kanban.tareass.repository.TareaRepository;
import com.tablero.kanban.tareass.repository.UsuarioRepository;

@Service
public class TareaServiceImpl implements TareaService {

	@Autowired
	private TareaRepository repository;

	@Autowired
	private UsuarioRepository repositoryUsuario;

	@Override
	public ResponseGenerico save(RequestTarea tarea) {

		ResponseGenerico respuesta = null;
		Tarea insertarTarea = null;
		Usuario validaUsuario = obtenerUsuario(tarea.getUsuario());

		if (validaUsuario != null) {

			String validaTarea = validarTarea(tarea.getNombreTarea());

			if (validaTarea.contentEquals("02")) {
				insertarTarea = new Tarea(tarea.getNombreTarea(), tarea.getTipoTarea(), tarea.getDescripcionTarea(),
						validaUsuario);
				repository.save(insertarTarea);
				respuesta = new ResponseGenerico("01", "Registro insertado correctamente");
			} else {
				respuesta = new ResponseGenerico("02", "La Tarea ya se encuentra en uso");
			}

		} else {
			respuesta = new ResponseGenerico("02", "El no existe en la BD");
		}

		return respuesta;

	}

	public Usuario obtenerUsuario(String idUsuario) {
		Usuario respuestaUsuario = null;
		
		Optional<Usuario> op = repositoryUsuario.findById(idUsuario);
		if (!op.isPresent()) {

			respuestaUsuario = null;

		} else {

			respuestaUsuario = op.get();
		}
		return respuestaUsuario;
	}

	@Override
	public List<Tarea> findAll() {
		return (List<Tarea>) repository.findAll();
	}

	@Override
	public List<Tarea> findTarea(String usuario) {

		return repository.findTarea(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Tarea> findById(String nombreTarea) {
		return repository.findById(nombreTarea);
	}

	public String validarTarea(String nombreTarea) {
		String respuesta;
		Optional<Tarea> op = findById(nombreTarea);
		if (!op.isPresent()) {

			respuesta = "02";

		} else {

			respuesta = "01";

		}
		return respuesta;
	}

	@Override
	public int setTipoTarea(String tipoTarea, String nombreTarea) {
		return repository.setTipoTarea(tipoTarea, nombreTarea);
	}

	@Override
	public void deleteById(String id) {
		
		repository.deleteById(id);
	}

}
