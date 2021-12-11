package com.tablero.kanban.usuarios.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tablero.kanban.usuarios.dao.ResponseGenerico;
import com.tablero.kanban.usuarios.entity.Usuario;
import com.tablero.kanban.usuarios.repository.UsuarioRepository;



@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(String usuario) {
		return repository.findById(usuario);
	}

	@Override
	public ResponseGenerico save(Usuario usuario) {

		ResponseGenerico respuesta = null;
		String validaUsuario = validarUsuario(usuario.getUsuario());

		if (validaUsuario.contentEquals("02")) {
			repository.save(usuario);
			respuesta = new ResponseGenerico("01", "Registro insertado correctamente");
		} else {
			respuesta = new ResponseGenerico("02", "El usuario ya se encuentra en uso");
		}

		return respuesta;

	}

	public String validarUsuario(String usuario) {
		String respuesta;
		Optional<Usuario> op = findById(usuario);
		if (!op.isPresent()) {

			respuesta = "02";

		} else {

			respuesta = "01";

		}
		return respuesta;
	}

}
