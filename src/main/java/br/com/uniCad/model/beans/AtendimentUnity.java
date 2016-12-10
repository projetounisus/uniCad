package br.com.uniCad.model.beans;

import java.util.List;

import br.com.uniCad.constants.Constants;
import br.com.uniCad.constants.Constants.AtendimentUnityType;

public class AtendimentUnity extends AbstractBean {
	private Address address;
	private String name;
	private String unityType;
	private List<Professional> medics;
	public List<Professional> getMedics() {
		return medics;
	}
	public void setMedics(List<Professional> profissionals) {
		this.medics = profissionals;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnityType() {
		return unityType;
	}
	public void setUnityType(String type) {
		this.unityType = type;
	}
	
	public AtendimentUnity(int id, Address address, String name, String type, List<Professional> medics) {
		super(id);
		this.address = address;
		this.name = name;
		this.unityType = type;
		this.medics = medics;
	}
	public AtendimentUnity(Address address, String name, String type, List<Professional> medics) {
		super();
		this.address = address;
		this.name = name;
		this.unityType = type;
		this.medics = medics;
	}
	public AtendimentUnity() {
		super();
	}
}
