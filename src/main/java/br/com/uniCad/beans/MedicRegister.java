package br.com.uniCad.beans;

import java.util.Date;

public class MedicRegister extends AbstractBean{
	private Address registerLocal;
	private Date beginDate;
	private Date endDate;
	private String description;
	private AtendimentUnity atendimentUnity;
	private Pacient pacient;
	private SusProfessional responsible;
	public Address getRegisterLocal() {
		return registerLocal;
	}
	public void setRegisterLocal(Address registerLocal) {
		this.registerLocal = registerLocal;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AtendimentUnity getAtendimentUnity() {
		return atendimentUnity;
	}
	public void setAtendimentUnity(AtendimentUnity atendimentUnity) {
		this.atendimentUnity = atendimentUnity;
	}
	public Pacient getPacient() {
		return pacient;
	}
	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}
	public SusProfessional getResponsible() {
		return responsible;
	}
	public void setResponsible(SusProfessional responsible) {
		this.responsible = responsible;
	}
	public MedicRegister(int id, Address registerLocal, Date beginDate, Date endDate, String description,
			AtendimentUnity atendimentUnity, Pacient pacient, SusProfessional responsible) {
		super(id);
		this.registerLocal = registerLocal;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.description = description;
		this.atendimentUnity = atendimentUnity;
		this.pacient = pacient;
		this.responsible = responsible;
	}
	public MedicRegister(Address registerLocal, Date beginDate, Date endDate, String description,
			AtendimentUnity atendimentUnity, Pacient pacient, SusProfessional responsible) {
		super();
		this.registerLocal = registerLocal;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.description = description;
		this.atendimentUnity = atendimentUnity;
		this.pacient = pacient;
		this.responsible = responsible;
	}
	public MedicRegister() {
		super();
	}
}
