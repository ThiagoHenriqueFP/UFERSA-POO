package br.edu.ufersa.pizzaria.api.dto;

public class PizzaTypeDTO {
	//Atributos
    private String type; //CHAVE
    private String size;
    private double value;

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
    public String getSize() {
    	return size;
    }
}