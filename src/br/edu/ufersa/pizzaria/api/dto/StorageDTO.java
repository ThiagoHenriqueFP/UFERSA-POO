package br.edu.ufersa.pizzaria.api.dto;

public class StorageDTO {
	//Atributos
    private String item; //CHAVE
    private int quantity;
    private int id;

    //Metodos Get e Set
    public void setItem(String item) {
        if(!item.isEmpty()){
            this.item = item;
        }
        else{
            this.item = null;
        }
    }
    public void setQuantity(int quantity) {
        if(quantity > 0){
            this.quantity = quantity;
        }
        else{
            this.quantity = 0;
        }
    }

    public String getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int cod) {
		  if(cod > 0){
	            this.id = cod;
	        }
	        else{
	            this.id = 0;
	        }
	}
}
