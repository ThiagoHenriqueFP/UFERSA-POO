package edu.ufersa.pizzaria;
class PizzaType{
	private String name;
	private float value;
	
	public String getName() {
		return name;
	}
	public float getValue() {
		return value;
	}
	public void setName(String name) {
		if (name != "" || name != null) this.name = name;
		else this.name = "Some Type";
	}
	public void setValue(float value) {
		if (value >= 0) this.value = value;
		else this.value = 5.00f;
	}
	
	
}