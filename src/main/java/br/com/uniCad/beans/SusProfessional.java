package br.com.uniCad.beans;

import java.util.Date;

public class SusProfessional extends User{
	private AtendimentUnity atendimentUnity;
	private String crm;
	public AtendimentUnity getAtendimentUnity() {
		return atendimentUnity;
	}
	public void setAtendimentUnity(AtendimentUnity atendimentUnity) {
		this.atendimentUnity = atendimentUnity;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public SusProfessional(int id, String completeName, String telephone, Date birthDate, Address address, Login login,
			AtendimentUnity atendimentUnity, String crm) {
		super(id, completeName, telephone, birthDate, address, login);
		this.atendimentUnity = atendimentUnity;
		this.crm = crm;
	}
	public SusProfessional(AtendimentUnity atendimentUnity, String crm) {
		super();
		this.atendimentUnity = atendimentUnity;
		this.crm = crm;
	}
	public SusProfessional() {
		super();
	}
}
