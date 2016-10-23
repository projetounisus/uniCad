package br.com.uniCad.beans;

public class Address extends AbstractBean {
	private String country;
	private String uf;
	private String city;
	private String neighborhood;
	private String street;
	private int number;
	private String adtionalInfo;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getAdtionalInfo() {
		return adtionalInfo;
	}
	public void setAdtionalInfo(String adtionalInfo) {
		this.adtionalInfo = adtionalInfo;
	}
	
	public Address(int id, String country, String uf, String city, String neighborhood, String street, int number,
			String adtionalInfo) {
		super(id);
		this.country = country;
		this.uf = uf;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
		this.number = number;
		this.adtionalInfo = adtionalInfo;
	}
	public Address(String country, String uf, String city, String neighborhood, String street, int number,
			String adtionalInfo) {
		super();
		this.country = country;
		this.uf = uf;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
		this.number = number;
		this.adtionalInfo = adtionalInfo;
	}
	public Address() {
		super();
	}
}
