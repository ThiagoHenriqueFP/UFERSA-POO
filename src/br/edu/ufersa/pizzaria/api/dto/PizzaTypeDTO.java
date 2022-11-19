package br.edu.ufersa.pizzaria.api.dto;

public class PizzaTypeDTO {
	//Atributos
    private String type;
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

    public String getType() {
        return type;
    }
    public double getValue() {
        return value;
    }
}