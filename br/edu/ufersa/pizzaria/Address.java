package edu.ufersa.pizzaria;

class Address {
	private String street;
	private String neighborhood;
	private String number;
	private String references;

	public Address(){
		setStreet(street);
		setNeighborhood(neighborhood);
		setNumber(number);
		setReferences(references);
	}
		
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		if (street != null)
			if (street != "")
				this.street = street;
		
		this.street = "some street";
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		if (neighborhood != null)
			if (neighborhood != "")
				this.neighborhood = neighborhood;
		
		this.neighborhood = "some neighborhood";
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		if (number != null)
			if (number != "")
				this.number = number;
		
		this.number = "some number";
	}
	public String getReferences() {
		return references;
	}
	public void setReferences(String references) {
		if (references != null)
			if (references != "")
				this.references = references;
		
		this.references = "some references";
	}
	
}