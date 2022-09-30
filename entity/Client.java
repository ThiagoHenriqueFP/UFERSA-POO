package edu.ufersa.pizzaria;
class Client{
	private String name;
	private String cpf;
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
	
	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cpf) {
		if (cpf.isEmpty() || cpf == null) {
			this.cpf = "000.000.000-00";
		}else {
			this.cpf = cpf;				
		}
	}
	
	public void setName(String name) {
		if(name != null) {
			if (name!="")
				this.name = name;
		} else {			
			this.name = "Franchesco";
		}
	}
	
	
}