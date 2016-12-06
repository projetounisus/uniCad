package br.com.uniCad.model.beans;

public class AtendimentyUnityGroup extends AbstractBean{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AtendimentyUnityGroup(String name) {
		super();
		this.name = name;
	}

	public AtendimentyUnityGroup(int id, String name) {
		super(id);
		this.name = name;
	}

	public AtendimentyUnityGroup() {
		super();
	}
}
