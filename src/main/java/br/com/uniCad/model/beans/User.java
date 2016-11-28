package br.com.uniCad.model.beans;

import java.util.Date;

public class User extends AbstractBean{
	private String completeName;
	private String telephone;
	private Date birthDate;
	private Address address;
	private Login login;
	private String genre;
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCompleteName() {
		return completeName;
	}
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public User(int id, String completeName, String telephone, Date birthDate, Address address, Login login, String genre) {
		super(id);
		this.completeName = completeName;
		this.telephone = telephone;
		this.birthDate = birthDate;
		this.address = address;
		this.login = login;
		this.genre = genre;
	}
	public User(String completeName, String telephone, Date birthDate, Address address, Login login, String genre) {
		super();
		this.completeName = completeName;
		this.telephone = telephone;
		this.birthDate = birthDate;
		this.address = address;
		this.login = login;
		this.genre = genre;
	}
	public User() {
		super();
	}
}
