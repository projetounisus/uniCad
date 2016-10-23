package br.com.uniCad.beans;

public class Pacient extends AbstractBean{
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

	public Pacient(int id, String cns) {
		super(id);
		this.cns = cns;
	}

	public Pacient(String cns) {
		super();
		this.cns = cns;
	}

	public Pacient() {
		super();
	}
	
}
