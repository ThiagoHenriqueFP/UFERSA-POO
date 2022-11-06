package br.edu.ufersa.pizzaria.model.entities;

public class Additionals {
    private String name;
    private double value;
    private int id;

    public void Additionals(){
        this.name = "Franchesco";
        this.value = 1.00000000;
    }

    public void setName(String name){
        if(!name.isEmpty() && name != null){ //Se nome está vazio e diferente de "" será adotado nome escrito
            this.name = name;
        }else{
            System.out.println("Nome para o ADICIONAL é invalido...");
        }
    }

    public String getName(){return this.name;}

    public void setValue(double value){
        if(value > 0 && value != 0){ //Se valor maior que 0 e diferente de 0 será adotado valor digitado
            this.value = value;
        }else{
            System.out.println("Valor digitado para o ADICIONAL é invalido...");
        }
    }

    public double getValue(){return this.value;}

    public void Additionals(String name, double value){
        setName(name);
        setValue(value);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}





}
