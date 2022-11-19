package br.edu.ufersa.pizzaria.api.dto;

public class OrderDTO {
	private String clientName;
	private String pizzaType;
	private String additionalName;
	private String size;
	private String state;
	private String date;
	private double price;
	
	public OrderDTO() {
		
	}
	
	public OrderDTO(String name,String pizza,String addi,String size,String state, String date, double price) {
		this.setClientName(name);
		this.setPizzaType(pizza);
		this.setAddiName(addi);
		this.setSize(size);
		this.setState(state);
		this.setDate(date);
		this.setPrice(price);
	}
	
	public void setClientName(String name) {
		if(name!=null) {
			this.clientName = name;
		}
		else {
			this.clientName = name;
		}
	}
	public void setPizzaType(String pizza) {
		if(pizza!=null) {
			this.pizzaType = pizza;
		}
		else {
			this.pizzaType = pizza;
		}
	}
	public void setAddiName(String addi) {
		if(addi!=null) {
			this.additionalName = addi;
		}
		else {
			this.additionalName = addi;
		}
	}
	public void setSize(String size) {
		if(size!=null) {
			this.size = size;
		}
		else {
			this.size = size;
		}
	}
	public void setState(String state) {
		if(state!=null) {
			this.state = state;
		}
		else {
			this.state = state;
		}
	}
	public void setPrice(double price) {
		if(price > 0.0) {
			this.price = price;
		}
	}
	public void setDate(String date) {
		if(date!=null) {
			this.date = date;
		}
		else {
			this.date = null;
		}
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
	public String getDate() {
		return date;
	}
	public double getPrice() {
		return price;
	}
}
