package com.tablero.kanban.tareass.entity;


import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TAREAS")
public class Tarea {

	@Id
	private String nombreTarea;
	private String tipoTarea;
	private String descripcionTarea;
	
	@ManyToOne(optional = false)
	@JoinColumn(foreignKey = @ForeignKey(name ="Fk_tarea_usuario"))
	private Usuario idUsuario;

	public Tarea() {
		super();
	}

	public Tarea(String nombreTarea, String tipoTarea, String descripcionTarea, Usuario idUsuario) {
		super();
		this.nombreTarea = nombreTarea;
		this.tipoTarea = tipoTarea;
		this.descripcionTarea = descripcionTarea;
		this.idUsuario = idUsuario;
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

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
}
