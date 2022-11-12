package br.edu.ufersa.pizzaria.api.dto;

public class OrderDTO {
	private String clientName;
	private String pizzaType;
	private String additionalName;
	private String size;
	private String state;
	private String edit;
	
	public OrderDTO(String name,String pizza,String addi,String size,String state,String edit) {
		this.setClientName(name);
		this.setPizzaType(pizza);
		this.setAddiName(addi);
		this.setSize(size);
		this.setState(state);
	}
	
	public void setClientName(String name) {
		this.clientName = name;
	}
	public void setPizzaType(String pizza) {
		this.pizzaType = pizza;
	}
	public void setAddiName(String addi) {
		this.additionalName = addi;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setEdit(String edit) {
		this.edit = edit;
	}
	
	public String getClientName() {
		return clientName;
	}
	public String getPizzaType() {
		return pizzaType;
	}
	public String getAddiName() {
		return additionalName;
	}
	public String getSize() {
		return size;
	}
	public String getState() {
		return state;
	}
	public String getEdit() {
		return edit;
	}
}
