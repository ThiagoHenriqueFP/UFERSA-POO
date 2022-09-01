class Storage{
    //Atributos
    private String item;
    private int quantity;

    //Método Construtor
    public Storage(){}
    public Storage(String item, int quantity){
        this.setItem(item);
        this.setQuantity(quantity);
    }

    //Métodos
    public void editarItemdoEstoque(String it, int qtd){
        this.setItem(it);
        this.setQuantity(qtd);
    }
    public void excluirItemdoEstoque(){
        this.setItem(null);
        this.setQuantity(0);
    }

    //Métodos Get e Set
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