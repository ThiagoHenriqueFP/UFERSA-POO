package br.edu.ufersa.pizzaria.model.entities;

public class PizzasType {
    //Atributos
    private String type; //CHAVE
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
