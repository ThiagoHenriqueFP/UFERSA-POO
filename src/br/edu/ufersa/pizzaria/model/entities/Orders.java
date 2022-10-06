package br.edu.ufersa.pizzaria.model.entities;

public class Orders {
    //Atributos
    private Client client;
    private PizzasType pizza;
    private Additionals additional;
    private String size;
    private String state;
    private int id;

    //Métodos Getter e Setter
    public void setSize(String size) {
        switch(size){
            case "P":
            case "p": this.size = size;
                    break;
            case "M":
            case "m": this.size = size;
                    break;
            case "G":
            case "g": this.size = size;
                    break;
            default: System.out.println("size inválido");
                    break;
        }    
    }
    public void setState(String state) {
        switch(state){
            case "Preparando": this.state = state;
                            break;
            case "Pronto": this.state = state;
                            break;
            case "Saiu para entrega": this.state = state;
                            break;
            case "Entregue": this.state = state;
                            break;
            case "Cancelado": this.state = state;
                            break;
            default: System.out.println("state inválido");
                            break;
        }
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public void setPizza(PizzasType pizza) {
        this.pizza = pizza;
    }
    public void setAdditional(Additionals additional) {
        this.additional = additional;
    }

    public String getSize() {
        return size;
    }
    public String getState() {
        return state;
    }
    public PizzasType getPizza() {
        return pizza;
    }
    public Additionals getAdditional() {
        return additional;
    }
    public Client getClient() {
        return client;
    }
    public int getId() {
    	return id;
    }
}
