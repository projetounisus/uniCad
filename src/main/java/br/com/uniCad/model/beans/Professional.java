package br.com.uniCad.model.beans;

import java.util.Date;

public class Professional extends User{
	private AtendimentUnity atendimentUnity;
	public AtendimentUnity getAtendimentUnity() {
		return atendimentUnity;
	}
	public void setAtendimentUnity(AtendimentUnity atendimentUnity) {
		this.atendimentUnity = atendimentUnity;
	}
	public Professional(int id, String completeName, String telephone, Date birthDate, Address address, Login login,
			AtendimentUnity atendimentUnity, String genre) {
		super(id, completeName, telephone, birthDate, address, login, genre);
		this.atendimentUnity = atendimentUnity;
	}
	public Professional(AtendimentUnity atendimentUnity) {
		super();
		this.atendimentUnity = atendimentUnity;
	}
	public Professional() {
		super();
	}
}
