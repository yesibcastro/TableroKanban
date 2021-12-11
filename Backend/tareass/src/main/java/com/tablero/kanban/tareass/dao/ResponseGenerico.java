package com.tablero.kanban.tareass.dao;

public class ResponseGenerico {

	private String cod;
	private String desc;
	
	
	public ResponseGenerico() {
		super();
	}
	
	
	public ResponseGenerico(String cod, String desc) {
		super();
		this.cod = cod;
		this.desc = desc;
	}


	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
