package br.edu.ufersa.pizzaria.model.entities;

import br.edu.ufersa.pizzaria.api.dto.StorageDTO;
import br.edu.ufersa.pizzaria.model.service.StorageService;

public class Storage {
    // Atributos
    private String item;
    private int quantity;
    private double value;
    private int id; //KEY
    
    private static StorageService storageService = new StorageService();
    
    public static Storage convertDTO(StorageDTO s) {
        Storage st = new Storage();
        st.setItem(s.getItem());
        st.setQuantity(s.getQuantity());
        st.setValue(s.getValue());
        st.setId(storageService.getBDId(st));
        return st;
    }

    // Metodos Get e Set
    public void setItem(String item) {
        if (!item.isEmpty()) {
            this.item = item;
        } else {
            this.item = null;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }
    }
    
    public void setValue(double v) {
    	if(v>0) {
    		this.value = v;
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
    
    public double getValue() {
		return value;
	}

    public void setId(int id) {
        this.id = id;
    }

}