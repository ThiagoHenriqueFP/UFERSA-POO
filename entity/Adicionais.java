package edu.ufersa.pizzaria;

public class Adicionais {
    private String name;
    private double value;

    public Adicionais(){
        this.name = "Franchesco";
        this.value = 1.00000000;
    }

    void setName(String name){
        if(!name.isEmpty() && name != ""){ //Se nome está vazio e diferente de "" será adotado nome escrito
            this.name = name;
        }else{
            System.out.println("Nome para o ADICIONAL é invalido...");
        }
    }

    String getName(){return this.name;}

    void setValor(double value){
        if(value > 0 && value != 0){ //Se valor maior que 0 e diferente de 0 será adotado valor digitado
            this.value = value;
        }else{
            System.out.println("Valor digitado para o ADICIONAL é invalido...");
        }
    }

    double getValue(){return this.value;}

    public Adicionais(String name, double value){
        setName(name);
        setValor(value);
    }



}
