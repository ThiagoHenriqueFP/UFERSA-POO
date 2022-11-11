package br.edu.ufersa.pizzaria.model.entities;

import br.edu.ufersa.pizzaria.api.dto.StorageDTO;

public class Storage{
    //Atributos
    private String item; //CHAVE
    private int quantity;
    private int cod;
    
    public static Storage convertDTO(StorageDTO s) {
    	Storage st = new Storage();
    	st.setItem(s.getItem());
    	st.setQuantity(s.getQuantity());
    	return st;
    }
    
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

	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		  if(cod > 0){
	            this.cod = cod;
	        }
	        else{
	            this.cod = 0;
	        }
	}
}