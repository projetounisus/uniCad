package br.com.uniCad.beans;

import java.util.Date;

public class Pacient extends User{
	private String cns;
	private CurrentMedicStatus currentMedicStatus;

	public CurrentMedicStatus getCurrentMedicStatus() {
		return currentMedicStatus;
	}

	public void setCurrentMedicStatus(CurrentMedicStatus currentMedicStatus) {
		this.currentMedicStatus = currentMedicStatus;
	}

	public String getCns() {
		return cns;
	}

	public void setCns(String cns) {
		this.cns = cns;
	}

	public Pacient(int id, String completeName, String telephone, Date birthDate, Address address, Login login,
			String cns, CurrentMedicStatus currentMedicStatus) {
		super(id, completeName, telephone, birthDate, address, login);
		this.cns = cns;
		this.currentMedicStatus = currentMedicStatus;
	}

	public Pacient(String cns) {
		super();
		this.cns = cns;
	}

	public Pacient() {
		super();
	}
	
}
