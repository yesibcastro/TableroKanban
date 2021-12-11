package com.tablero.kanban.tareass.dao;

public class RequestTarea {

	private String nombreTarea;
	private String tipoTarea;
	private String descripcionTarea;
	private String usuario;

	public RequestTarea() {
		super();

	}

	public RequestTarea(String nombreTarea, String tipoTarea, String descripcionTarea, String usuario) {
		super();
		this.nombreTarea = nombreTarea;
		this.tipoTarea = tipoTarea;
		this.descripcionTarea = descripcionTarea;
		this.usuario = usuario;
	}

	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}

	public String getTipoTarea() {
		return tipoTarea;
	}

	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	public String getDescripcionTarea() {
		return descripcionTarea;
	}

	public void setDescripcionTarea(String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
