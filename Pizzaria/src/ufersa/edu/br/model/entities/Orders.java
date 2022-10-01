package ufersa.edu.br.model.entities;

class Orders {
    //Atributos
    Client cliente;
    Pizzas pizza;
    Adicionais adicional;
    String tamanho;
    String estado;

    //Método Construtor
    public Orders(){}
    public Orders(Client cliente, Pizzas pizza, Adicionais adicional, String tam, String estado){
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
    public void setPizza(Pizzas pizza) {
        this.pizza = pizza;
    }
    public void setAdicional(Adicionais adicional) {
        this.adicional = adicional;
    }

    public String getTamanho() {
        return tamanho;
    }
    public String getEstado() {
        return estado;
    }
    public Pizzas getPizza() {
        return pizza;
    }
    public Adicionais getAdicional() {
        return adicional;
    }
    public Client getCliente() {
        return cliente;
    }

    //Métodos
    public void cadastrarPedido(Client cliente, Pizzas pizza, Adicionais adicional, String tam, String estado){
        this.setCliente(cliente);
        this.setPizza(pizza);
        this.setAdicional(adicional);
        this.setTamanho(tam);
        this.setEstado(estado);
    }
    public void editarPedido(Pizzas pizza, Adicionais adicional, String tam, String estado){
        this.setPizza(pizza);
        this.setAdicional(adicional);
        this.setTamanho(tam);
        this.setEstado(estado);
    }
    public void cancelarPedido(Client cliente, Pizzas pizza, Adicionais adicional, String tam, String estado){
        this.setCliente(null);
        this.setPizza(null);
        this.setAdicional(null);
        this.setTamanho(null);
        this.setEstado("Cancelado");
    }
}
