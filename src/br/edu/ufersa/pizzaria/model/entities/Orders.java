package br.edu.ufersa.pizzaria.model.entities;

class Orders {
    //Atributos
    Client cliente;
    PizzasType pizza;
    Additionals adicional;
    String tamanho;
    String estado;

    //Método Construtor
    public Orders(){}
    public Orders(Client cliente, PizzasType pizza, Additionals adicional, String tam, String estado){
        this.setCliente(cliente);
        this.setPizza(pizza);
        this.setAdicional(adicional);
        this.setTamanho(tam);
        this.setEstado(estado);
    }

    //Métodos Getter e Setter
    public void setTamanho(String tamanho) {
        switch(tamanho){
            case "P":
            case "p": this.tamanho = tamanho;
                    break;
            case "M":
            case "m": this.tamanho = tamanho;
                    break;
            case "G":
            case "g": this.tamanho = tamanho;
                    break;
            default: System.out.println("Tamanho inválido");
                    break;
        }    
    }
    public void setEstado(String estado) {
        switch(estado){
            case "Preparando": this.estado = estado;
                            break;
            case "Pronto": this.estado = estado;
                            break;
            case "Saiu para entrega": this.estado = estado;
                            break;
            case "Entregue": this.estado = estado;
                            break;
            case "Cancelado": this.estado = estado;
                            break;
            default: System.out.println("Estado inválido");
                            break;
        }
    }
    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }
    public void setPizza(PizzasType pizza) {
        this.pizza = pizza;
    }
    public void setAdicional(Additionals adicional) {
        this.adicional = adicional;
    }

    public String getTamanho() {
        return tamanho;
    }
    public String getEstado() {
        return estado;
    }
    public PizzasType getPizza() {
        return pizza;
    }
    public Additionals getAdicional() {
        return adicional;
    }
    public Client getCliente() {
        return cliente;
    }

    //Métodos
    public void cadastrarPedido(Client cliente, PizzasType pizza, Additionals adicional, String tam, String estado){
        this.setCliente(cliente);
        this.setPizza(pizza);
        this.setAdicional(adicional);
        this.setTamanho(tam);
        this.setEstado(estado);
    }
    public void editarPedido(PizzasType pizza, Additionals adicional, String tam, String estado){
        this.setPizza(pizza);
        this.setAdicional(adicional);
        this.setTamanho(tam);
        this.setEstado(estado);
    }
    public void cancelarPedido(Client cliente, PizzasType pizza, Additionals adicional, String tam, String estado){
        this.setCliente(null);
        this.setPizza(null);
        this.setAdicional(null);
        this.setTamanho(null);
        this.setEstado("Cancelado");
    }
}
