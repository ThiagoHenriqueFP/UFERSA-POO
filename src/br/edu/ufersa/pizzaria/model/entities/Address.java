package br.edu.ufersa.pizzaria.model.entities;

public class Address {
	private String street;
	private String district;
	private String number;
	private String references;
	private int id; //CHAVE
	
	public int getId() {
		return id;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		if (street != null) {
			if (street != "")
				this.street = street;
		} else {
			this.street = null;
		}
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		if (district != null) {
			if (district != "")
				this.district = district;
		} else {			
			this.district = null;
		}
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		if (number != null) {
			if (number != "")
				this.number = number;
		} else {
			this.number = null;
		}
	}
	public String getReferences() {
		return references;
	}
	public void setReferences(String references) {
		if (references != null) {
			if (references != "")
				this.references = references;
		} else {
			this.references = null;
		}
	}
	
}