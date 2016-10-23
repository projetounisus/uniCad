package br.com.uniCad.beans;

public abstract class AbstractBean {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public AbstractBean(int id) {
		this.id = id;
	}
	public AbstractBean() {
		super();
	}
}
