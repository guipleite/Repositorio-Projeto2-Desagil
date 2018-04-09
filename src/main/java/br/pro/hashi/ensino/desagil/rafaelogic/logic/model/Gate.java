package br.pro.hashi.ensino.desagil.rafaelogic.logic.model;

public abstract class Gate implements Emitter, Receiver {
	private String name;
	public int size; 
	
	protected Gate(String name) {
		this.name = name;
		this.size = 2;
	}

	public int getSize() {
		return size;
	}
	
	public String toString() {
		return name;
	}

}
