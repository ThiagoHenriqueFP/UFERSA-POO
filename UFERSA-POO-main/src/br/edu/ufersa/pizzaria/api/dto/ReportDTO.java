package br.edu.ufersa.pizzaria.api.dto;

public class ReportDTO {
	
	//CLASSE FEITA PARA CRIAR O RELÁTORIO
	
	private String clientName;
	private String pizzaType;
	private String additionalName;
	private String size;
	private String state;
	private String date;
	private int pizzaQnt;
	private int addiQnt;
	private double price;
	
	public void setClientName(OrderDTO name) {
		if(name.getClientName() != null) {
			this.clientName = name.getClientName();
		}
		else {
			this.clientName = null;
		}
	}
	public void setPizzaType(OrderDTO pizza) {
		if(pizza.getPizzaType() != null) {
			this.pizzaType = pizza.getPizzaType();
		}
		else {
			this.pizzaType = null;
		}
	}
	public void setAddiName(OrderDTO addi) {
		if(addi.getAddiName()!=null) {
			this.additionalName = addi.getAddiName();
		}
		else {
			this.additionalName = null;
		}
	}
	public void setSize(OrderDTO size) {
		if(size.getSize()!=null) {
			this.size = size.getSize();
		}
		else {
			this.size = null;
		}
	}
	public void setState(OrderDTO state) {
		if(state.getState()!=null) {
			this.state = state.getState();
		}
		else {
			this.state = null;
		}
	}
	public void setPrice(OrderDTO price) {
		if(price.getPrice() > 0.0) {
			this.price = price.getPrice();
		}
	}
	public void setDate(OrderDTO date) {
		if(date.getDate()!=null) {
			this.date = date.getDate();
		}
		else {
			this.date = null;
		}
	}
	public void setPiQuantity(StorageDTO quantity) {
        if(quantity.getQuantity() > 0){
            this.pizzaQnt = quantity.getQuantity();
        }
    }
	public void setAddiQuantity(StorageDTO quantity) {
		if(quantity.getQuantity() > 0){
            this.addiQnt = quantity.getQuantity();
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
	public int getPiQuantity() {
        return pizzaQnt;
    }
	public int getAddiQuantity() {
		return addiQnt;
	}
}
