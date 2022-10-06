package br.edu.ufersa.pizzaria.model.entities;

public class Storage{
    //Atributos
    private String item; //CHAVE
    private int quantity;

    //Metodos Get e Set
    public void setItem(String item) {
        if(!item.isEmpty()){
            this.item = item;
        }
        else{
            System.out.println("Por favor insira um item válido!");
        }
    }
    public void setQuantity(int quantity) {
        if(quantity > 0){
            this.quantity = quantity;
        }
        else{
            System.out.println("Por favor insira uma quantidade válida!");
        }
    }

    public String getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }

}