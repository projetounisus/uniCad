package br.com.uniCad.model.beans;

public class CurrentMedicStatus extends AbstractBean {
	private String bloodType;
	private String allergies;
	private String currentTreatment;
	private float height;
	private float weight;
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getCurrentTreatment() {
		return currentTreatment;
	}
	public void setCurrentTreatment(String currentTreatment) {
		this.currentTreatment = currentTreatment;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public CurrentMedicStatus(int id, String bloodType, String allergies, String currentTreatment, float height,
			float weight) {
		super(id);
		this.bloodType = bloodType;
		this.allergies = allergies;
		this.currentTreatment = currentTreatment;
		this.height = height;
		this.weight = weight;
	}
	public CurrentMedicStatus(String bloodType, String allergies, String currentTreatment, float height, float weight) {
		super();
		this.bloodType = bloodType;
		this.allergies = allergies;
		this.currentTreatment = currentTreatment;
		this.height = height;
		this.weight = weight;
	}
	public CurrentMedicStatus() {
		super();
	}	
}
