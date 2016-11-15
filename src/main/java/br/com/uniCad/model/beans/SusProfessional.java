package br.com.uniCad.model.beans;

import java.util.Date;

public class SusProfessional extends User{
	private AtendimentUnity atendimentUnity;
	public AtendimentUnity getAtendimentUnity() {
		return atendimentUnity;
	}
	public void setAtendimentUnity(AtendimentUnity atendimentUnity) {
		this.atendimentUnity = atendimentUnity;
	}
	public SusProfessional(int id, String completeName, String telephone, Date birthDate, Address address, Login login,
			AtendimentUnity atendimentUnity) {
		super(id, completeName, telephone, birthDate, address, login);
		this.atendimentUnity = atendimentUnity;
	}
	public SusProfessional(AtendimentUnity atendimentUnity) {
		super();
		this.atendimentUnity = atendimentUnity;
	}
	public SusProfessional() {
		super();
	}
}
