package com.tablero.kanban.usuarios.services;

import java.util.Optional;

import com.tablero.kanban.usuarios.dao.ResponseGenerico;
import com.tablero.kanban.usuarios.entity.Usuario;



public interface UsuarioService {

	public Optional<Usuario> findById(String usuario);
	
	public ResponseGenerico save(Usuario usuario);
}

