package br.edu.ufersa.pizzaria.model.entities;

import br.edu.ufersa.pizzaria.api.dto.PizzaTypeDTO;

public class PizzasType {
    //Atributos
    private String type; //CHAVE
    private String size;
    private double value;
    private int id;
    
    public static PizzasType convertDTO(PizzaTypeDTO p) {
    	PizzasType pi = new PizzasType();
    	pi.setType(p.getType());
    	pi.setSize(p.getSize());
    	pi.setValue(p.getValue());
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
    public void setSize(String size) {
    	if(size != null) {
    		this.size = size;
    	}
    	else {
    		this.size = null;
    	}
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
	
	public void setId(int id) {
		this.id = id;
	}
}
