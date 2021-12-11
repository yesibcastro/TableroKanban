package com.tablero.kanban.usuarios.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tablero.kanban.usuarios.dao.RequestLogin;
import com.tablero.kanban.usuarios.dao.ResponseGenerico;
import com.tablero.kanban.usuarios.entity.Usuario;
import com.tablero.kanban.usuarios.services.UsuarioService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping("/login")
	public ResponseEntity<ResponseGenerico> login(@RequestBody RequestLogin login) {
		ResponseGenerico respuesta = new ResponseGenerico();
		Optional<Usuario> op = service.findById(login.getUsuario());

		if (!op.isPresent()) {

			respuesta.setCod("02");
			respuesta.setDesc("Usuario o contraseña no existe");
			return ResponseEntity.ok(respuesta);
		} else if (!(op.get().getContrasena().toString().contentEquals(login.getContrasena()))) {
			respuesta.setCod("03");
			respuesta.setDesc("Usuario o contraseña no existe");
			return ResponseEntity.ok(respuesta);
		}

		respuesta.setCod("01");
		respuesta.setDesc("Usuario existe");
		return ResponseEntity.ok(respuesta);

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseGenerico> crearEmpleado(@RequestBody Usuario usuario) {

		ResponseGenerico respuesta = service.save(usuario);

		return ResponseEntity.ok(respuesta);
	}
}
