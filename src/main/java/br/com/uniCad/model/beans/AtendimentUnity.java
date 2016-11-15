package br.com.uniCad.model.beans;

import br.com.uniCad.constants.Constants;
import br.com.uniCad.constants.Constants.AtendimentUnityType;

public class AtendimentUnity extends AbstractBean {
	private Address address;
	private String name;
	private String  unityType;
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
	
	public AtendimentUnity(int id, Address address, String name, String type) {
		super(id);
		this.address = address;
		this.name = name;
		this.unityType = type;
	}
	public AtendimentUnity(Address address, String name, String type) {
		super();
		this.address = address;
		this.name = name;
		this.unityType = type;
	}
	public AtendimentUnity() {
		super();
	}
}
