package br.edu.ufersa.pizzaria.model.entities;

public class Additionals {
    private String name;
    private double value;
    private int id;

    public void setName(String name){
        if(!name.isEmpty() && name != null){ //Se nome está vazio e diferente de "" será adotado nome escrito
            this.name = name;
        }else{
            this.name = null;
        }
    }

    public String getName(){return name;}

    public void setValue(double value){
        if(value > 0 && value != 0){ //Se valor maior que 0 e diferente de 0 será adotado valor digitado
            this.value = value;
        }else{
            this.value = 0;
        }
    }

    public double getValue(){return value;}
    
    public int getId() {return id;}
    
    public void setId(int id) {
		this.id = id;
	}
}

