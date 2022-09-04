package edu.ufersa.pizzaria;
class Client{
	private String name;
	private int cpf;
	Address address = new Address(); // only default
	
	// Constructors - Default 
	public Client() {
		setName("");
	}
	
	// Constructors - With name
	public Client(String name) {
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	public int getCPF() {
		return cpf;
	}
	
	public void setCPF(int cpf) {
		if (cpf == 0) {
			this.cpf = 00000000000;
		}else {
			this.cpf = cpf;				
		}
	}
	
	public void setName(String name) {
		if(name != null && name != "") {
				this.name = name;
		} else {			
			this.name = "Franchesco";
		}
	}
	
	
}