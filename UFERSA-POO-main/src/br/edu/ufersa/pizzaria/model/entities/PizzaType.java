package br.edu.ufersa.pizzaria.model.entities;

import br.edu.ufersa.pizzaria.api.dto.PizzaTypeDTO;
import br.edu.ufersa.pizzaria.model.service.PizzaTypeService;

public class PizzaType {
    //Atributos
    private String type;
    private double value;
    private int storageId;
    private int id; //KEY
    
    private static PizzaTypeService pizzaService = new PizzaTypeService();
    
    public static PizzaType convertDTO(PizzaTypeDTO p) {
    	PizzaType pi = new PizzaType();
    	pi.setType(p.getType());
    	pi.setValue(p.getValue());
    	pi.setId(pizzaService.getBDId(pi));
    	pi.setStorageId(pizzaService.getStorageId(pi));
    	return pi;
    }

    //Métodos Getter e Setter
    public void setType(String type) {
        if(type != null){
            this.type = type;
        }else{
            this.type = null;;
        }
    }
    public void setValue(double value) {
        if(value > 0){
            this.value = value;
        }
        else{
            this.value = 0.0;
        }
    }
    public void setStorageId(int s) {
    	this.storageId = s;
    }

    public String getType() {
        return type;
    }
    
    public double getValue() {
        return value;
    }
    
	public int getId() {
		return id;
	}
	
	public int getStorageId() {
		return storageId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
