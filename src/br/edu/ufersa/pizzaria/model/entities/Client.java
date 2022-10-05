package br.edu.ufersa.pizzaria.model.entities;

public class Client{
	private String name;
	private String cpf; //CHAVE
	private Address address;
	
	public String getName() {
		return name;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cpf) {
		if (cpf != null) {
			this.cpf = cpf;
		}else {
			this.cpf = null;				
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
	
	public void setAddress(Address address) {
		if(address != null) {
			this.address = address;
		}
		else {
			this.address = null;
		}
	}
	public Address getAddress() {
		return address;
	}
	
}