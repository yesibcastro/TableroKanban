package com.tablero.kanban.tareass.dao;

public class RequestActualizarTarea {

	private String tipoTarea;
	private String nombreTarea;
	
	public RequestActualizarTarea() {
		super();
	}

	public RequestActualizarTarea(String tipoTarea, String nombreTarea) {
		super();
		this.tipoTarea = tipoTarea;
		this.nombreTarea = nombreTarea;
	}

	public String getTipoTarea() {
		return tipoTarea;
	}

	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}
	
	
	
}
