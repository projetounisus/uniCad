package br.com.uniCad.model.beans;

import java.util.List;

public class GroupAtendimentUnity extends AbstractBean{
	private String name;
	private List<AtendimentUnity> unities;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<AtendimentUnity> getUnities() {
		return unities;
	}
	public void setUnities(List<AtendimentUnity> unities) {
		this.unities = unities;
	}
	public GroupAtendimentUnity(int id, String name, List<AtendimentUnity> unities) {
		super(id);
		this.name = name;
		this.unities = unities;
	}
	public GroupAtendimentUnity(String name, List<AtendimentUnity> unities) {
		super();
		this.name = name;
		this.unities = unities;
	}
	public GroupAtendimentUnity() {
		super();
	}
}
