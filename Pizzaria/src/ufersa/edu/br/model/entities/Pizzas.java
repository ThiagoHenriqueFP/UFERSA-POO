package ufersa.edu.br.model.entities;

class Pizzas {
    //Atributos
    private String tipo;
    private double valor;
    
    //Método Construtor
    public Pizzas(){}
    public Pizzas(String tipo, double valor){
        this.setTipo(tipo);
        this.setValor(valor);
    }

    //Métodos Getter e Setter
    public void setTipo(String tipo) {
        if(!tipo.isEmpty()){
            this.tipo = tipo;
        }else{
            System.out.println("Insira um tipo de pizza, por favor!");
        }
    }
    public void setValor(double valor) {
        if(valor > 0){
            this.valor = valor;
        }
        else{
            System.out.println("Insira um valor válido!");
        }
    }

    public String getTipo() {
        return tipo;
    }
    public double getValor() {
        return valor;
    }

    //Métodos
    public void cadastrarPizza(String c){
        this.setTipo(c);
    }
    public void editarPizza(String c, double v){
        if((this.getTipo() != c) && (v > 0)){
            this.setTipo(c);
            this.setValor(v);
        }else{
            System.out.println("Inserções inválidas");
        }
    }
    public void excluirPizza(){
        this.setTipo(null);
        this.setValor(0.0);
    }
}
