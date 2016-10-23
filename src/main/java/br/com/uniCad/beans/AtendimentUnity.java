package br.com.uniCad.beans;

import br.com.uniCad.constants.Constants;
import br.com.uniCad.constants.Constants.AtendimentUnityType;

public class AtendimentUnity extends AbstractBean {
	private Address address;
	private String name;
	private AtendimentUnityType type;
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
	public Constants.AtendimentUnityType getType() {
		return type;
	}
	public void setType(Constants.AtendimentUnityType type) {
		this.type = type;
	}
	
	public AtendimentUnity(int id, Address address, String name, AtendimentUnityType type) {
		super(id);
		this.address = address;
		this.name = name;
		this.type = type;
	}
	public AtendimentUnity(Address address, String name, AtendimentUnityType type) {
		super();
		this.address = address;
		this.name = name;
		this.type = type;
	}
	public AtendimentUnity() {
		super();
	}
}
