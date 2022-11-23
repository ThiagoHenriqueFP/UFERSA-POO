package br.edu.ufersa.pizzaria.model.entities;

import br.edu.ufersa.pizzaria.api.dto.OrderDTO;
import br.edu.ufersa.pizzaria.model.service.OrdersService;

public class Orders {
    //Atributos
    private String client;
    private String pizza;
    private String additional;
    private String size;
    private String state;
    private String date;
    private double price;
    private int storageId;
    private int id;
    
    private static OrdersService orderService = new OrdersService();
    
    public static Orders convertDTO(OrderDTO o) {
    	Orders oo = new Orders();
    	oo.setSize(o.getSize());
    	oo.setState(o.getState());
    	oo.setPrice(o.getPrice());
    	oo.setClient(o.getClientName());
    	oo.setAdditional(o.getAddiName());
    	oo.setPizza(o.getPizzaType());
    	oo.setDate(o.getDate());
    	oo.setId(orderService.getBDId(oo));
    	oo.setStorageId(orderService.getStorageId(oo));
    	return oo;
    }
    
    //MÃ©todos Getter e Setter
    public void setSize(String size) {
        switch(size){
            case "P":
            case "p": this.size = size;
                    break;
            case "M":
            case "m": this.size = size;
                    break;
            case "G":
            case "g": this.size = size;
                    break;
            default: System.out.println("size inválido");
                    break;
        }    
    }
    public void setState(String state) {
        if(state!=null) {
        	this.state = state;
        }
        else {
        	this.state = null;
        }
    }
    public void setClient(String client) {
        if(client != null) {
        	this.client = client;
        }
        else {
        	this.client = null;
        }
    }
    public void setPizza(String pizza) {
        if(pizza != null) {
        	this.pizza = pizza;
        }
        else {
        	this.pizza = null;
        }
    }
    public void setAdditional(String additional) {
        if(additional != null) {
        	this.additional = additional;
        }
        else {
        	this.additional = null;
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
    public void setPrice(double p) {
    	if(p>0) {
    		this.price = p;
    	}
    }
    public void setStorageId(int sId) {
    	this.storageId = sId;
    }

    public String getSize() {
        return size;
    }
    public String getState() {
        return state;
    }
    public String getPizza() {
        return pizza;
    }
    public String getAdditional() {
        return additional;
    }
    public String getClient() {
        return client;
    }
    public int getId() {
    	return id;
    }
    public String getDate() {
		return date;
	}
    public double getPrice() {
    	return price;
    }
    public int getStorageId() {
    	return storageId;
    }
    public void setId(int id) {
    	this.id = id;
    }
}
