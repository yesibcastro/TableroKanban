package com.tablero.kanban.tareass.dao;

public class RequestDelete {

	private String nombreTarea;

	public RequestDelete() {
		super();
	}

	public RequestDelete(String nombreTarea) {
		super();
		this.nombreTarea = nombreTarea;
	}

	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}
	
	
}
